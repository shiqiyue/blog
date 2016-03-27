package cn.wuwenyao.blog.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wuwenyao.blog.site.entity.mongo.Blog;

@Controller
@RequestMapping("blog")
public class BlogController {

	@RequestMapping
	public String main() {
		return "blog/main";
	}
	
	@RequestMapping("detail/{id}")
	public String detail(@PathVariable("id") Blog blog, Model model){
		model.addAttribute("blog", blog);
		
		return "blog/detail";
	}
}
