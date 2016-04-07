package cn.wuwenyao.blog.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import cn.wuwenyao.blog.config.redis.RedisConfiguration.IntSerializer;

@Configuration
@EnableCaching
public class CacheConfiguration {
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public RedisCacheManager redisCacheManager() {
		RedisTemplate tmpl = new RedisTemplate();
		tmpl.setConnectionFactory(redisConnectionFactory);
		tmpl.setKeySerializer(IntSerializer.INSTANCE);
		tmpl.setValueSerializer(new JdkSerializationRedisSerializer());
		RedisCacheManager cacheMgr = new RedisCacheManager(tmpl);
		return cacheMgr;
	}
}
