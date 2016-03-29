package cn.wuwenyao.blog.site.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wuwenyao.blog.site.service.BlogService;

@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/")
	public String main() {
		return "admin/blog/main";
	}
	
	
}
