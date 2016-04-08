package cn.wuwenyao.blog.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO loginPost() {
		RepBaseDTO repDTO = new RepBaseDTO();
		return repDTO;
	}
}
