package cn.wuwenyao.blog.site.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;
import cn.wuwenyao.blog.site.entity.mongo.Permission;
import cn.wuwenyao.blog.site.entity.mongo.UserInfo;
import cn.wuwenyao.blog.site.service.AdminService;
import cn.wuwenyao.blog.site.service.BlogService;
import cn.wuwenyao.blog.site.service.BloggerService;

@Controller
@RequestMapping("test")
public class TestController {

	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private AdminService adminService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private BloggerService bloggerService;


	@RequestMapping("admin/add")
	@ResponseBody
	public RepBaseDTO addAdmin() {
		RepBaseDTO repDTO = new RepBaseDTO();
		Admin admin = new Admin();
		UserInfo userInfo = new UserInfo();
		userInfo.setName("dasdsad");
		admin.setUsername("www");
		admin.setPassword("dasd");
		admin.setUserInfo(userInfo);
		List<Permission> permissons = Lists.newArrayList();
		permissons.add(Permission.BLOG_MANAGE);
		permissons.add(Permission.SYSINFO_MANAGE);
		admin.setPermissions(permissons);
		adminService.addAdmin(admin);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加管理员成功");
		return repDTO;
	}
	
	@RequestMapping("admin/find")
	@ResponseBody
	public List<Admin> findAllAdmin() {
		
		return adminService.findByAttribute("username", "www");
	}
	
	
	

	@RequestMapping("blogger/add")
	@ResponseBody
	public RepBaseDTO addBlogger() {
		RepBaseDTO repDTO = new RepBaseDTO();
		Blogger blogger = new Blogger();
		UserInfo userInfo = new UserInfo();
		userInfo.setName("无闻药");
		blogger.setUserInfo(userInfo);
		blogger.setPassword(BCryptPasswordAlgo.getInstance().encrptPassword("dasdasd"));
		blogger.setUsername("gg simida");
		bloggerService.addBlogger(blogger);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加博主成功");
		return repDTO;
	}

}
