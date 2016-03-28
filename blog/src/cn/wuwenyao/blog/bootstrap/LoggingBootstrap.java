package cn.wuwenyao.blog.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import cn.wuwenyao.blog.site.filter.PostSecurityLoggingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Order(4)
public class LoggingBootstrap implements WebApplicationInitializer {
	private static final Logger log = LoggerFactory.getLogger(LoggingBootstrap.class);

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		log.info("Executing logging bootstrap.");

		FilterRegistration.Dynamic registration = container.addFilter("postSecurityLoggingFilter",
				new PostSecurityLoggingFilter());
		registration.addMappingForUrlPatterns(null, false, "/*");
	}
}
