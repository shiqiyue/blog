package cn.wuwenyao.blog.config.mongo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "${package.mongo.dao}")
@EnableMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
@ComponentScan(basePackages = { "${package.mongo.entity}",
		"${package.convertor}" }, useDefaultFilters = false, includeFilters = {
				@ComponentScan.Filter({ Document.class, cn.wuwenyao.blog.anontation.Converter.class }) })
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Value("${mongo.dbname}")
	public String dbName;
	@Value("${mongo.host}")
	public String host;
	@Value("${mongo.port}")
	public int port;

	@Autowired
	private Environment environment;

	@Autowired(required = false)
	private List<Converter<?, ?>> converters;

	@Override
	protected String getDatabaseName() {
		System.out.println("host:" + host);
		return environment.getProperty("mongo.dbname");
	}

	@Override
	public Mongo mongo() throws Exception {
		System.out.println(environment.getProperty("mongo.port", Integer.class));
		return new MongoClient(environment.getProperty("mongo.host"),
				environment.getProperty("mongo.port", Integer.class));
	}

	/***
	 * 添加自定义类型转化器
	 */
	@Override
	public CustomConversions customConversions() {
		if (converters == null){
			converters = Collections.emptyList();
		}
		return new CustomConversions(converters);
	}

}