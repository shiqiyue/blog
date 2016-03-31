package cn.wuwenyao.blog.config.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.RememberMeAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import cn.wuwenyao.blog.site.service.BloggerAuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BloggerAuthenticationService bloggerAuthenticationService;
	
	@Bean
	public MongoRememberMeTokenRepository remembermeTokenRepository(){
		return new MongoRememberMeTokenRepository();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(bloggerAuthenticationService);
	}

	@Override
	public void configure(WebSecurity security) throws Exception {
		security.ignoring().antMatchers("/static/**", "/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
			.antMatchers("/user/**").authenticated()
			.antMatchers("/").permitAll()
			.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").failureUrl("/login?s=error")
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
			.and()
			.rememberMe().rememberMeParameter("rememberme").tokenValiditySeconds(60*60*24)
			.userDetailsService(bloggerAuthenticationService)
			.tokenRepository(remembermeTokenRepository())
			.and()
			.sessionManagement().invalidSessionUrl("/login?s=invalid").maximumSessions(1)
			.expiredUrl("/login?s=expired")
			.and();
	}

}
