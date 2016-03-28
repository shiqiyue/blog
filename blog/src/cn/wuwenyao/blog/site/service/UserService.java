package cn.wuwenyao.blog.site.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.dao.mongo.UserDao;
import cn.wuwenyao.blog.site.entity.mongo.User;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		log.debug("save user");
		user.setPassword(BCryptPasswordAlgo.getInstance().encrptPassword(user.getPassword()));
		user = userDao.save(user);
		Assert.notNull(user, "user save fail");
	}

	public List<User> findUserByKeyAndValue(String key, Object value) {
		return userDao.findByAttribute(key, value);
	}
}
