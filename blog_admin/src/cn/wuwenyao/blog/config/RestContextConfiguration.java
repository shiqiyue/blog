package cn.wuwenyao.blog.config;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.wuwenyao.blog.anontation.RestControllerAdvice;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "${package.rest}", useDefaultFilters = false, includeFilters = @ComponentScan.Filter({
		RestController.class, RestControllerAdvice.class }))
@EnableSpringDataWebSupport
public class RestContextConfiguration extends WebMvcConfigurerAdapter {
	private static final Logger log = LoggerFactory.getLogger(RestContextConfiguration.class);

	@Inject
	ApplicationContext applicationContext;
	@Inject
	ObjectMapper objectMapper;
/*	@Inject
	Marshaller marshaller;
	@Inject
	Unmarshaller unmarshaller;*/
	@Inject
	SpringValidatorAdapter validator;

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new SourceHttpMessageConverter<>());

		/*MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		xmlConverter.setSupportedMediaTypes(
				Arrays.asList(new MediaType("application", "xml"), new MediaType("text", "xml")));
		xmlConverter.setMarshaller(this.marshaller);
		xmlConverter.setUnmarshaller(this.unmarshaller);
		converters.add(xmlConverter);
*/
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setSupportedMediaTypes(
				Arrays.asList(new MediaType("application", "json"), new MediaType("text", "json")));
		jsonConverter.setObjectMapper(this.objectMapper);
		converters.add(jsonConverter);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).favorParameter(false).ignoreAcceptHeader(false)
				.defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		Sort defaultSort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
		Pageable defaultPageable = new PageRequest(0, 20, defaultSort);

		SortHandlerMethodArgumentResolver sortResolver = new SortHandlerMethodArgumentResolver();
		sortResolver.setSortParameter("$paging.sort");
		sortResolver.setFallbackSort(defaultSort);

		PageableHandlerMethodArgumentResolver pageableResolver = new PageableHandlerMethodArgumentResolver(
				sortResolver);
		pageableResolver.setMaxPageSize(200);
		pageableResolver.setOneIndexedParameters(true);
		pageableResolver.setPrefix("$paging.");
		pageableResolver.setFallbackPageable(defaultPageable);

		resolvers.add(sortResolver);
		resolvers.add(pageableResolver);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		if (!(registry instanceof FormattingConversionService)) {
			log.warn("Unable to register Spring Data JPA converter.");
			return;
		}

		DomainClassConverter<FormattingConversionService> converter = new DomainClassConverter<>(
				(FormattingConversionService) registry);
		converter.setApplicationContext(this.applicationContext);
	}

	@Override
	public Validator getValidator() {
		return this.validator;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new AcceptHeaderLocaleResolver();
	}
}
