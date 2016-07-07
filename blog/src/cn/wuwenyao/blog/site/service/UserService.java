package cn.wuwenyao.blog.site.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuwenyao.blog.site.dao.jpa.UserDao;
import cn.wuwenyao.blog.site.service.base.BaseService;

@Service
@Transactional
public class UserService extends BaseService{

	@Autowired
	private UserDao userDao;
	
	public void testProc1(){
		userDao.inOnlyTest(233333);
	}
}
