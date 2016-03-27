package cn.wuwenyao.blog.site.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.site.dao.mongo.BlogDao;
import cn.wuwenyao.blog.site.entity.mongo.Blog;

@Service
public class BlogService {
	private static Logger log = LoggerFactory.getLogger(BlogService.class);

	@Autowired
	private BlogDao blogDao;
	
	public boolean addBlog(Blog blog){
		blog = blogDao.save(blog);
		Assert.notNull(blog);
		return true;
	}
}
