package cn.wuwenyao.blog.site.controller.user;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.entity.mongo.User;

@Controller
@RequestMapping("/user/blog")
public class UserBlogController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listPage(@AuthenticationPrincipal User user,
			Pageable pageable){
		return "user/blog/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addBlogPage(@AuthenticationPrincipal User user){
		return "user/blog/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO addBlog(@AuthenticationPrincipal User user){
		RepBaseDTO repDTO = new RepBaseDTO();
		return repDTO;
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editBlogPage(@AuthenticationPrincipal User user){
		return "user/blog/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO editBlog(@AuthenticationPrincipal User user){
		RepBaseDTO repDTO = new RepBaseDTO();
		return repDTO;
	}
}
