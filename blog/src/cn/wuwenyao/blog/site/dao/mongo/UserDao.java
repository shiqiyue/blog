package cn.wuwenyao.blog.site.dao.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import cn.wuwenyao.blog.site.dao.mongo.base.BaseDao;
import cn.wuwenyao.blog.site.entity.mongo.User;

/***
 * dao of {@link User}
 * 
 * @author 文尧
 *
 */
public interface UserDao extends BaseDao<User> {

	@Query("{?0:?1}")
	public List<User> findByAttribute(String key, Object value);
}
