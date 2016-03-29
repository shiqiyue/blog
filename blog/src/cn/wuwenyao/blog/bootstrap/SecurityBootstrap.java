package cn.wuwenyao.blog.bootstrap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(3)
public class SecurityBootstrap extends AbstractSecurityWebApplicationInitializer
{
    private static final Logger log = LoggerFactory.getLogger(SecurityBootstrap.class);

    protected boolean enableHttpSessionEventPublisher()
    {
        log.info("Executing security bootstrap.");

        return true;
    }

	

	
    
    
}
