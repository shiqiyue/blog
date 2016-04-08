package cn.wuwenyao.blog.site.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.dao.mongo.AdminDao;
import cn.wuwenyao.blog.site.entity.mongo.Admin;

@Service
public class AdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminDao adminDao;

	public void addAdmin(Admin admin) {
		log.debug("save admin");
		admin.setPassword(BCryptPasswordAlgo.getInstance().encrptPassword(admin.getPassword()));
		admin = adminDao.save(admin);
		Assert.notNull(admin, "admin save fail");
	}
	
	public List<Admin> findAll(){
		return adminDao.findAll();
	}
	
	public List<Admin> findByAttribute(String key, Object value){
		return adminDao.findByAttribute(key, value);
	}
	
	public Page<Admin> page(Pageable pageable, Map<String, Object> searchParams){
		return adminDao.findAll(searchParams, pageable);
	}

}
