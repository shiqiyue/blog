package cn.wuwenyao.blog.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Order(2)
public class SessionBootstrap extends AbstractHttpSessionApplicationInitializer{
    private static final Logger log = LoggerFactory.getLogger(SessionBootstrap.class);

	@Override
	protected boolean isAsyncSessionSupported() {
		log.info("excute session bootstrap");
		return super.isAsyncSessionSupported();
	}

	
	
	/***
	 * httpsession 从哪里获取,cookie或者header
	 * @return
	 */
	@Bean
    public HttpSessionStrategy httpSessionStrategy() {
            return new HeaderHttpSessionStrategy(); 
    }

	
	
}
