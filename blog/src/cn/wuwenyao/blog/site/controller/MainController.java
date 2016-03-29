package cn.wuwenyao.blog.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.entity.mongo.User;

@Controller
@RequestMapping("/")
public class MainController {
	private static Logger log = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	@ResponseBody
	public User main(HttpServletRequest httpRequest,
			@AuthenticationPrincipal User user) {
		return user;
	}

}
