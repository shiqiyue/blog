package cn.wuwenyao.blog.site.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.entity.mongo.Blog;
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
	
	@RequestMapping("add")
	@ResponseBody
	public boolean add(){
		Blog blog = new Blog();
		blog.setAbout("dasdasd");
		blog.setContext("dsadas");
		blog.setTitle("dsadasd");
		return blogService.addBlog(blog);
	}
}
