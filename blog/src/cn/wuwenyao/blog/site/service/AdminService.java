package cn.wuwenyao.blog.site.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.site.dao.mongo.AdminDao;
import cn.wuwenyao.blog.site.entity.mongo.Admin;

@Service
public class AdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminDao adminDao;

	public void addAdmin(Admin admin) {
		log.debug("save admin");
		admin = adminDao.save(admin);
		Assert.notNull(admin, "admin save fail");
	}
}
