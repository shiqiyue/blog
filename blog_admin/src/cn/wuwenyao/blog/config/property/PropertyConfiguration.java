package cn.wuwenyao.blog.config.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import cn.wuwenyao.blog.site.constants.PropertyProvider;

@Configuration
public class PropertyConfiguration {
	@Autowired
	private Environment environment;
	
	static{
	}

	/***
	 * 初始化propertyProvider
	 * 
	 * @return
	 */
	@Bean
	public PropertyProvider propertyProvider() {
		PropertyProvider propertyProvider = new PropertyProvider();
		propertyProvider.setHostName(environment.getProperty("server.host_name"));
		return propertyProvider;

	}

}
