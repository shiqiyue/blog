package cn.wuwenyao.blog.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	private static Logger log = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String main(HttpServletRequest httpRequest) {
		return "main";
	}

}
