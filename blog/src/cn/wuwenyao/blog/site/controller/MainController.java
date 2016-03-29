package cn.wuwenyao.blog.site.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.rest.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.rest.controller.dto.rep.ResultCode;

@Controller
@RequestMapping("/")
public class MainController {
	private static Logger log = LoggerFactory.getLogger(MainController.class);

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody public User main(HttpServletRequest
	 * httpRequest, @AuthenticationPrincipal User user) { return user; }
	 */

	@RequestMapping("/")
	public String main(@AuthenticationPrincipal User user) {
		
		return "main";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO login(String username, String password, HttpServletRequest request) {
		RepBaseDTO repDTO = new RepBaseDTO();
		try {
			request.login(username, password);
		} catch (ServletException e) {
			repDTO.setCode(ResultCode.COMMON_FAIL);
			repDTO.setMes("登录失败");
			log.error("login fail", e);
		}
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("登录成功");
		return repDTO;
	}

	@RequestMapping(value = "logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpServletRequest request) {
		try {
			request.logout();
		} catch (ServletException e) {
			log.error("logout fail", e);
			return "error/logoutfail";
		}
		return "main";

	}

}
