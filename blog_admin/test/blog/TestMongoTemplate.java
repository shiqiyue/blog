package blog;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import cn.wuwenyao.blog.site.entity.mongo.Admin;

public class TestMongoTemplate {
	MongoTemplate mongoTemplate;

	@Before
	public void init() throws UnknownHostException {
		mongoTemplate = new MongoTemplate(new MongoClient(), "test");
	}

	@Test
	@Ignore
	public void testAdd() {
		for (int i = 0; i < 100; i++) {
			DD dd = new DD();
			dd.setA(i);
			dd.setB("b" + i);
			dd.setC(i);
			dd.setD(new Date());
			mongoTemplate.save(dd);
			mongoTemplate.save(dd);
		}
		System.out.println(mongoTemplate.count(new Query(), DD.class));
	}

	@Test
	@Ignore
	public void testSimpleFind() throws UnknownHostException {

		List<Admin> admins = mongoTemplate.find(new Query(), Admin.class);
		for (Admin admin : admins) {
			System.out.println(admin.getUsername());
		}
	}

	@Test
	@Ignore
	public void testFind2() {
		WriteResult writeResult = mongoTemplate.updateMulti(new Query(), new Update().inc("a", 2), "cc");
		System.out.println(writeResult);
	}

	@Test
	@Ignore
	public void testAdd2() {
		for (int i = 0; i < 100; i++) {
			DD dd = new DD();
			dd.setA(i);
			dd.setB("b" + i);
			dd.setC(i);
			dd.setD(new Date());
			mongoTemplate.save(dd);
			mongoTemplate.save(dd);
		}
		System.out.println(mongoTemplate.count(new Query(), DD.class));
	}

	@Test
	@Ignore
	public void testMapReduce() {
		MapReduceResults<RValue> r = mongoTemplate.mapReduce("dD",
				"function  (){emit(this.b,this.a);emit(this.b,this.c);}",
				"function (key,values){var result = 0;for (var i=0;i<values.length;i++){result+=values[i];}return result;}",
				RValue.class);
		for (RValue valueObject : r) {
			System.out.println(valueObject);
		}
	}

	@Test
	public void testAggregate() {

	}

}
