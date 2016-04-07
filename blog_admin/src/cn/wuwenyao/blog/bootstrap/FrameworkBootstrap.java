package cn.wuwenyao.blog.bootstrap;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import cn.wuwenyao.blog.config.RestContextConfiguration;
import cn.wuwenyao.blog.config.RootContextConfiguration;
import cn.wuwenyao.blog.config.WebContextConfiguration;
import cn.wuwenyao.blog.site.filter.MyFilter;

/***
 * web应用程序初始化，相当于web.xml
 * 
 * @author 文尧
 *
 */
@Order(1)
public class FrameworkBootstrap implements WebApplicationInitializer {
    private static final Logger log = LoggerFactory.getLogger(FrameworkBootstrap.class);

	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		log.info("excute framework bootstrap");
		//静态资源分配给default servlet处理
		ServletRegistration defaultServlet = container.getServletRegistration("default");
		defaultServlet.addMapping("/static/*","/favicon.ico");
		/********************** listener配置 **************************/

		// 应用程序的根上下文配置
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfiguration.class);
		container.addListener(new ContextLoaderListener(rootContext));

		/********************** servlet配置 **************************/

		
		// web的配置
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebContextConfiguration.class);
		ServletRegistration.Dynamic dispatcher = container.addServlet("springDispatcher",
				new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		// rest的配置
		AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
		restContext.register(RestContextConfiguration.class);
		ServletRegistration.Dynamic restDispatcher = container.addServlet("springRestDispatcher",
				new DispatcherServlet(restContext));
		restDispatcher.setLoadOnStartup(2);
		restDispatcher.addMapping("/rest");

		/********************** filter配置 **************************/
		// 编码格式化过滤器
		FilterRegistration.Dynamic encodingFilter = container.addFilter("encodingFilter",
				new CharacterEncodingFilter("UTF-8", true));
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");

	}
}
