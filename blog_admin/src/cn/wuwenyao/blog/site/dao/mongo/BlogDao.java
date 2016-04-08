package cn.wuwenyao.blog.site.dao.mongo;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.wuwenyao.blog.site.dao.mongo.base.BaseDao;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

/***
 * dao of {@link Blog}
 * @author 文尧
 *
 */
public interface BlogDao extends BaseDao<Blog, BigInteger>{

	
	public Page<Blog> findByBlogger(Blogger blogger, Pageable pageable);
}
