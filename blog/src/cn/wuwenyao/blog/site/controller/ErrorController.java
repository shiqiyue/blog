package cn.wuwenyao.blog.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

	@RequestMapping
	public String main(String info, Model model){
		model.addAttribute("error", info);
		System.out.println(info);
		return "error";
	}
}
