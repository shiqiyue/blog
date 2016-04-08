package cn.wuwenyao.blog.site.dao.mongo.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springside.modules.persistence.SearchFilter;

public class BaseDaoImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements BaseDao<T, ID> {

	private MongoEntityInformation<T, ID> metadata;

	private MongoOperations mongoOperations;

	public BaseDaoImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.metadata = metadata;
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<T> findByAttribute(String key, Object value) {
		// TODO Auto-generated method stub
		return mongoOperations.find(new Query(Criteria.where(key).is(value)), metadata.getJavaType());
	}

	@Override
	public T findUniqueAttribute(String key, Object value) {
		// TODO Auto-generated method stub
		return mongoOperations.findOne(new Query(Criteria.where(key).is(value)), metadata.getJavaType());
	}

	@Override
	public String getCollectionName() {
		return mongoOperations.getCollectionName(metadata.getJavaType());
	}

	@Override
	public Page<T> findAll(Map<String, Object> searchMap, Pageable pageable) {
		long count = count();
		Query q = new Query();
		if (searchMap != null && !searchMap.isEmpty()) {
			q = MongoSeachParse.parse(searchMap, q);
		}
		q.with(pageable);
		List<T> content = mongoOperations.find(q, metadata.getJavaType());
		return new PageImpl<>(content, pageable, count);
	}

}
