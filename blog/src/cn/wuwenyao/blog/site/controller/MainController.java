package cn.wuwenyao.blog.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextResource;

import cn.wuwenyao.blog.site.constants.PropertyProvider;

@Controller
@RequestMapping("/")
public class MainController {
	private static Logger log = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String main(HttpServletRequest httpRequest) {
		return "main";
	}

}
