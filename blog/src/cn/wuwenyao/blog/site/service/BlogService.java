package cn.wuwenyao.blog.site.service;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.site.dao.mongo.BlogDao;
import cn.wuwenyao.blog.site.dao.mongo.BloggerDao;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

@Service
public class BlogService {
	private static Logger log = LoggerFactory.getLogger(BlogService.class);

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BloggerDao bloggerDao;

	public Blog findOne(BigInteger id){
		return blogDao.findOne(id);
	}
	
	public void addBlog(Blog blog) {
		blog = blogDao.save(blog);
		Assert.notNull(blog);
	}

	public void updateBlog(Blog blog) {
		blog = blogDao.save(blog);
		Assert.notNull(blog);
	}

	public List<Blog> findAll() {
		return blogDao.findAll();
	}
	
	public Page<Blog> pageBlog(Pageable pageable){
		return blogDao.findAll(pageable);
	}
	
	public Page<Blog> pageUserBlog(Blogger blogger, Pageable pageable){
		return blogDao.findByBlogger(blogger, pageable);
	}

	/***
	 * 返回博客阅读量前五
	 * 
	 * @return
	 */
	public List<Blog> findVisitNumTop5() {
		Pageable pageable = new PageRequest(0, 5, Direction.DESC, "visitnum");
		return blogDao.findAll(pageable).getContent();
	}

	/***
	 * 返回最新更新前五
	 * 
	 * @return
	 */
	public List<Blog> findModifyDateTop5() {
		Pageable pageable = new PageRequest(0, 5, Direction.DESC, "modifyDate");
		return blogDao.findAll(pageable).getContent();
	}

	public Blog visitBlog(BigInteger id) {
		Blog blog = blogDao.findOne(id);
		Assert.notNull(blog);
		blog.incrementVisitNum();
		blog = blogDao.save(blog);
		Assert.notNull(blog);
		return blog;
	}
}
