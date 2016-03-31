package cn.wuwenyao.blog.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import cn.wuwenyao.blog.config.audit.SimpleAuditorAware;
import cn.wuwenyao.blog.config.audit.SimpleDateTimeProvider;
import cn.wuwenyao.blog.config.cache.CacheConfiguration;
import cn.wuwenyao.blog.config.mongo.MongoConfiguration;
import cn.wuwenyao.blog.config.property.PropertyConfiguration;
import cn.wuwenyao.blog.config.redis.RedisConfiguration;
import cn.wuwenyao.blog.config.security.SecurityConfiguration;
import cn.wuwenyao.blog.config.session.SessionConfiguration;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.util.beanmapper.CustomObjectMapper;

/***
 * 根上下文配置
 * 
 * @author 文尧
 *
 */
@Configuration
@EnableScheduling
@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.HIGHEST_PRECEDENCE)
@ComponentScan(basePackages = "${package.site}", excludeFilters = @ComponentScan.Filter({ Controller.class,
		ControllerAdvice.class }))
@Import(value = { /* JPAConfiguration.class, */ MongoConfiguration.class, CacheConfiguration.class,
		RedisConfiguration.class, SecurityConfiguration.class, SessionConfiguration.class,
		PropertyConfiguration.class })
@PropertySources(value = { @PropertySource("classpath:/application.properties"),
		@PropertySource("classpath:/db/mongo.properties"), @PropertySource("classpath:/db/redis.properties") })
public class RootContextConfiguration implements AsyncConfigurer, SchedulingConfigurer {
	private static final Logger log = LoggerFactory.getLogger(RootContextConfiguration.class);
	private static final Logger schedulingLogger = LoggerFactory.getLogger("scheduling");
	private static final Logger asyncLogger = LoggerFactory.getLogger("async");
	@Value("${package.site}")
	public String webBasePackage;

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * 实体验证
	 * 
	 * @return
	 */
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		return validator;
	}

	/***
	 * 
	 * @return
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new CustomObjectMapper();
		objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
		return objectMapper;
	}

	/***
	 * xml实体支持
	 * 
	 * @return
	 *//*
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(new String[] { webBasePackage });
		return marshaller;
	}*/

	/***
	 * 任务的线程池
	 * 
	 * @return
	 */
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		log.info("Setting up thread pool task scheduler with 20 threads.");
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(20);
		scheduler.setThreadNamePrefix("task-");
		scheduler.setAwaitTerminationSeconds(60);
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.setErrorHandler(t -> schedulingLogger.error("Unknown error occurred while executing task.", t));
		scheduler.setRejectedExecutionHandler(
				(r, e) -> schedulingLogger.error("Execution of task {} was rejected for unknown reasons.", r));
		return scheduler;
	}

	/***
	 * 异步任务的执行器
	 */
	@Override
	public Executor getAsyncExecutor() {
		Executor executor = this.taskScheduler();
		log.info("Configuring asynchronous method executor {}.", executor);
		return executor;
	}

	/***
	 * 定时任务的执行器
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar registrar) {
		TaskScheduler scheduler = this.taskScheduler();
		log.info("Configuring scheduled method executor {}.", scheduler);
		registrar.setTaskScheduler(scheduler);
	}

	/***
	 * 异步执行错误处理
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return new AsyncUncaughtExceptionHandler() {

			@Override
			public void handleUncaughtException(Throwable ex, Method method, Object... params) {
				asyncLogger.error(ex.getMessage());

			}
		};
	}

	@Bean
	public DateTimeProvider dateTimeProvider() {
		return new SimpleDateTimeProvider();
	}
	
	@Bean
	public AuditorAware<User> auditorAware(){
		return new SimpleAuditorAware();
	}

}
