package cn.wuwenyao.blog.site.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

	@RequestMapping("/")
	public String main(){
		return "admin/main";
	}
}
