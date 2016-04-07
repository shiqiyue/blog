package cn.wuwenyao.blog.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

@Configuration
public class RedisConfiguration {
	
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private int port;
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory cf = new JedisConnectionFactory();
		cf.setHostName(host);
		cf.setPort(port);
		cf.afterPropertiesSet();
		return cf;
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate rt = new RedisTemplate();
		rt.setConnectionFactory(redisConnectionFactory());
		return rt;
	}

	public static enum StringSerializer implements RedisSerializer<String> {
		INSTANCE;

		@Override
		public byte[] serialize(String s) throws SerializationException {
			return (null != s ? s.getBytes() : new byte[0]);
		}

		@Override
		public String deserialize(byte[] bytes) throws SerializationException {
			if (bytes.length > 0) {
				return new String(bytes);
			} else {
				return null;
			}
		}
	}

	public static enum LongSerializer implements RedisSerializer<Long> {
		INSTANCE;

		@Override
		public byte[] serialize(Long aLong) throws SerializationException {
			if (null != aLong) {
				return aLong.toString().getBytes();
			} else {
				return new byte[0];
			}
		}

		@Override
		public Long deserialize(byte[] bytes) throws SerializationException {
			if (bytes.length > 0) {
				return Long.parseLong(new String(bytes));
			} else {
				return null;
			}
		}
	}

	public static enum IntSerializer implements RedisSerializer<Integer> {
		INSTANCE;

		@Override
		public byte[] serialize(Integer i) throws SerializationException {
			if (null != i) {
				return i.toString().getBytes();
			} else {
				return new byte[0];
			}
		}

		@Override
		public Integer deserialize(byte[] bytes) throws SerializationException {
			if (bytes.length > 0) {
				return Integer.parseInt(new String(bytes));
			} else {
				return null;
			}
		}
	}
}
