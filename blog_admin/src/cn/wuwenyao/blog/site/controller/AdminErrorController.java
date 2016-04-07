package cn.wuwenyao.blog.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class AdminErrorController {

	@RequestMapping
	public String errorPage(){
		return "/error";
	}
}
