package cn.wuwenyao.blog.bootstrap;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;


@Order(200)
public class SitemeshBootstrap implements WebApplicationInitializer {
	private static final Logger log = LoggerFactory.getLogger(SitemeshBootstrap.class);

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		log.info("excute Sitemesh Bootstrap");
		// sitemesh装饰器的过滤器
		FilterRegistration.Dynamic sitemeshFilter = container.addFilter("sitemeshFilter", new ConfigurableSiteMeshFilter());
		sitemeshFilter.addMappingForUrlPatterns(null, false, "/*");

	}

}
