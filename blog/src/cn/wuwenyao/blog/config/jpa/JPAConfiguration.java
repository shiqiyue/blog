package cn.wuwenyao.blog.config.jpa;

import java.util.Hashtable;
import java.util.Map;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;

import org.hibernate.cache.redis.SingletonRedisRegionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.LOWEST_PRECEDENCE)
@EnableJpaRepositories(basePackages = "${package.jpa.dao}", entityManagerFactoryRef = "entityManagerFactoryBean", transactionManagerRef = "jpaTransactionManager")
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@ImportResource(locations = "classPath:/config/datasource.xml")
public class JPAConfiguration {
	@Autowired
	private ApplicationContext applicationContext;
	@Value("${package.jpa.entity}")
	public  String entityPackage;

	/***
	 * spring jpa 实体管理工厂
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		Map<String, Object> properties = new Hashtable<>();
		properties.put("javax.persistence.schema-generation.database.action", "none");

		properties.put(Environment.USE_SECOND_LEVEL_CACHE, false);
		properties.put(Environment.CACHE_REGION_FACTORY, SingletonRedisRegionFactory.class.getName());
		properties.put(Environment.CACHE_REGION_PREFIX, "hibernate");

		// optional setting for second level cache statistics
		properties.put(Environment.GENERATE_STATISTICS, "true");
		properties.put(Environment.USE_STRUCTURED_CACHE, "true");

		// configuration for Redis that used by hibernate
		properties.put(Environment.CACHE_PROVIDER_CONFIG, "db/hibernate-redis.properties");
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setDataSource(applicationContext.getBean(org.apache.tomcat.jdbc.pool.DataSource.class));
		factory.setPackagesToScan(entityPackage);
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		factory.setJpaPropertyMap(properties);
		return factory;
	}

	/***
	 * spring jpa 事务管理
	 * 
	 * @return
	 */
	@Bean
	public PlatformTransactionManager jpaTransactionManager() {
		return new JpaTransactionManager(this.entityManagerFactoryBean().getObject());
	}

}
