package cn.wuwenyao.blog.bootstrap;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@Order(200)
public class SitemeshBootstrap implements WebApplicationInitializer {
	private static final Logger log = LoggerFactory.getLogger(SitemeshBootstrap.class);

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		log.info("excute Sitemesh Bootstrap");
		// sitemesh装饰器的过滤器
		FilterRegistration.Dynamic sitemeshFilter = container.addFilter("sitemeshFilter", new SiteMeshFilter());
		sitemeshFilter.addMappingForUrlPatterns(null, false, "/*");
		;

	}

}
