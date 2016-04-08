package cn.wuwenyao.blog.site.dao.mongo;

import java.math.BigInteger;

import cn.wuwenyao.blog.site.dao.mongo.base.BaseDao;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

/***
 * dao of {@link Blogger}
 * @author 文尧
 *
 */
public interface BloggerDao extends BaseDao<Blogger, BigInteger>, MyDao{

	public Blogger findByUsername(String username);
}
