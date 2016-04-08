package cn.wuwenyao.blog.site.dao.mongo;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.wuwenyao.blog.site.dao.mongo.base.BaseDao;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.LeaveMessage;


/***
 * dao of {@link LeaveMessage}
 * @author 文尧
 *
 */
public interface LeaveMessageDao extends BaseDao<LeaveMessage, BigInteger>{

	Page<LeaveMessage> findByBlog(Blog blog, Pageable pageable);
}
