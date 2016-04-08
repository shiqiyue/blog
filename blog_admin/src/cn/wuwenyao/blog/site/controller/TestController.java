package cn.wuwenyao.blog.site.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.controller.dto.rep.admin.RepAdminData;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Permission;
import cn.wuwenyao.blog.site.entity.mongo.UserInfo;
import cn.wuwenyao.blog.site.service.AdminService;
import cn.wuwenyao.blog.site.service.BloggerService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private BloggerService bloggerService;
	
	@RequestMapping("addAdmin")
	@ResponseBody
	public RepBaseDTO addAdmin(){
		RepBaseDTO repDTO = new RepBaseDTO();
		
		Admin admin = new Admin();
		UserInfo userInfo = new UserInfo();
		userInfo.setName("吴文尧2");
		List<Permission> permissions = Lists.newArrayList(Permission.BLOG_MANAGE,Permission.SYSINFO_MANAGE,Permission.USER_MANAGE);
		admin.setUsername("wuwenyao2");
		admin.setPassword("password");
		admin.setUserInfo(userInfo);
		admin.setPermissions(permissions);
		adminService.addAdmin(admin);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加成功");
		return repDTO;
	}
	
	@RequestMapping("getname")
	public void getname(){
		System.out.println(bloggerService.getCollectionName());
	}
	
	@RequestMapping("empty")
	@ResponseBody
	public List<Admin> empty(@PageableDefault Pageable pageable){
		RepBaseDTO repDTO = new RepBaseDTO();
		Map<String, Object> o = Maps.newHashMap();
		o.put("EQ_username", "wuwenyao");
		o.put("EQ_userInfo.name", "吴文尧");
		List<Admin> admins = adminService.page(pageable, o).getContent();
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("succ");
		repDTO.setData(new RepAdminData(admins));
		return admins;
		
	}
}
