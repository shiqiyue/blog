package cn.wuwenyao.blog.site.dao.mongo;

import cn.wuwenyao.blog.site.dao.mongo.base.BaseDao;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

/***
 * dao of {@link Admin}
 * @author 文尧
 *
 */
public interface AdminDao extends BaseDao<Admin>{
	public Admin findByUsername(String username);

}
