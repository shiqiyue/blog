package cn.wuwenyao.blog.site.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.dao.mongo.BloggerDao;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

@Service
public class BloggerService {
	private static Logger log = LoggerFactory.getLogger(BloggerService.class);

	@Autowired
	private BloggerDao bloggerDao;

	public void addBlogger(Blogger blogger) {
		//加密
		blogger.setPassword(BCryptPasswordAlgo.getInstance().encrptPassword(blogger.getPassword()));
		blogger = bloggerDao.save(blogger);
		Assert.notNull(blogger);
	}

	public List<Blogger> findAll() {
		return bloggerDao.findAll();
	}
	
	public String getCollectionName(){
		return bloggerDao.getCollectionName();
	}
}
