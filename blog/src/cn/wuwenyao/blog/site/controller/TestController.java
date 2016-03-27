package cn.wuwenyao.blog.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.enums.Permission;
import cn.wuwenyao.blog.site.service.AdminService;
import cn.wuwenyao.blog.site.service.BlogService;
import cn.wuwenyao.blog.site.service.UserService;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping("user/add")
	@ResponseBody
	public RepBaseDTO addUser(){
		RepBaseDTO repDTO = new RepBaseDTO();
		User user = new User();
		user.setUsername("dasdad");
		
		userService.addUser(user);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加用户成功");
		return repDTO;
	}
	
	@RequestMapping("admin/add")
	@ResponseBody
	public RepBaseDTO addAdmin(){
		RepBaseDTO repDTO = new RepBaseDTO();
		Admin admin = new Admin();
		admin.setPassword("dasd");
		List<Permission> permissons = Lists.newArrayList();
		permissons.add(Permission.BLOG);
		permissons.add(Permission.SYSINFO);
		admin.setPermissions(permissons);
		adminService.addAdmin(admin);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加管理员成功");
		return repDTO;
	}
	
	
	
	
}
