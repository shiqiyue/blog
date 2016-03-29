package cn.wuwenyao.blog.site.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@RequestMapping("main")
	@ResponseBody
	public String main(){
		return "main";
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public String logOut(HttpServletRequest request) throws ServletException{
		
		request.logout();
		return "推出成功";
	}
}
