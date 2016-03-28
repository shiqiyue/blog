package cn.wuwenyao.blog.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;
import cn.wuwenyao.blog.site.entity.mongo.Permission;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.entity.mongo.UserInfo;
import cn.wuwenyao.blog.site.service.AdminService;
import cn.wuwenyao.blog.site.service.BlogService;
import cn.wuwenyao.blog.site.service.BloggerService;
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

	@Autowired
	private BloggerService bloggerService;

	@RequestMapping("user/add")
	@ResponseBody
	public RepBaseDTO addUser() {
		RepBaseDTO repDTO = new RepBaseDTO();
		User user = new User();
		user.setUsername("dsadasdafdf");
		UserInfo userInfo = new UserInfo();
		userInfo.setName("wuwendfdfyao");
		user.setUserInfo(userInfo);
		List<Blog> blogs = blogService.findAll();
		userService.addUser(user);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加用户成功");
		return repDTO;
	}

	@RequestMapping("user/find")
	@ResponseBody
	public User findUser() {
		return userService.findUserByKeyAndValue("username", "dsadasdafdf").get(0);
	}

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
		
		return adminService.findAll();
	}

	@RequestMapping("blog/add")
	@ResponseBody
	public RepBaseDTO addBlog() {
		RepBaseDTO repDTO = new RepBaseDTO();
		List<User> user = userService.findUserByKeyAndValue("username", "dasdad");
		Blog blog = new Blog();
		blog.setTitle("dad");
		blog.setUser(user.get(0));
		blogService.addBlog(blog);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加博客成功");
		return repDTO;
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
