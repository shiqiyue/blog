package cn.wuwenyao.blog.site.dao.mongo.base;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springside.modules.persistence.SearchFilter;

public class MongoSeachParse {

	public static Query parse(Map<String, Object> SeachMap, Query query) {
		Map<String, SearchFilter> filters = SearchFilter.parse(SeachMap);
		for (Entry<String, SearchFilter> s : filters.entrySet()) {
			SearchFilter filter = s.getValue();
			switch (filter.operator) {
			case EQ:
				query.addCriteria(Criteria.where(filter.fieldName).is(filter.value));
				break;
			case GT:
				query.addCriteria(Criteria.where(filter.fieldName).gt(filter.value));
				break;
			case GTE:
				query.addCriteria(Criteria.where(filter.fieldName).gte(filter.value));
				break;
			case LIKE:
				query.addCriteria(Criteria.where(filter.fieldName).regex("/." + filter.value + ".*/"));
			case LT:
				query.addCriteria(Criteria.where(filter.fieldName).lt(filter.value));
				break;
			case LTE:
				query.addCriteria(Criteria.where(filter.fieldName).lte(filter.value));
				break;
			default:
				break;
			}
		}
		return query;
	}
}
