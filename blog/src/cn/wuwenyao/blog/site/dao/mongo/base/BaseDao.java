package cn.wuwenyao.blog.site.dao.mongo.base;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public abstract interface BaseDao<T> extends MongoRepository<T, BigInteger> {

}
