package cn.wuwenyao.blog.site.controller;


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
}
