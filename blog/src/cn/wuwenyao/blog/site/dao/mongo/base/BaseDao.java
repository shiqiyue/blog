package cn.wuwenyao.blog.site.dao.mongo.base;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public abstract interface BaseDao<T> extends MongoRepository<T, BigInteger> {

	@Query("{?0:?1}")
	public List<T> findByAttribute(String key, Object value);
}
