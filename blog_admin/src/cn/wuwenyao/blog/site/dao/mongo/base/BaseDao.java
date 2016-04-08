package cn.wuwenyao.blog.site.dao.mongo.base;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public  interface BaseDao<T, ID extends Serializable> extends MongoRepository<T, ID> {

	public List<T> findByAttribute(String key, Object value);
	
	public T findUniqueAttribute(String key, Object value);
	
	public String getCollectionName();
	
	public Page<T> findAll(Map<String,Object> searchMap, Pageable pageable);
}
