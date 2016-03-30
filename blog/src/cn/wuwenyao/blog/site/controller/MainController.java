package cn.wuwenyao.blog.site.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.rest.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.rest.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.service.BlogService;

@Controller
@RequestMapping("/")
public class MainController {
	private static Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private BlogService blogService;


	@RequestMapping("/")
	public String main(Model model) {
		List<Blog> modifyDateTop5 = blogService.findModifyDateTop5();
		List<Blog> visitNumTop5 = blogService.findVisitNumTop5();
		model.addAttribute("modifyDateTop5", modifyDateTop5);
		model.addAttribute("visitNumTop5", visitNumTop5);
		return "main";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	

	@RequestMapping(value = "logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpServletRequest request) {
		try {
			request.logout();
		} catch (ServletException e) {
			log.error("logout fail", e);
			return "error/logoutfail";
		}
		return "redirect:/";

	}

}
