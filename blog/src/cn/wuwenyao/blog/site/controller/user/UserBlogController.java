package cn.wuwenyao.blog.site.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.service.BlogService;

@Controller
@RequestMapping("/user/blog")
public class UserBlogController {
	@Autowired
	private BlogService blogService;
	

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listPage(@AuthenticationPrincipal User user,
			Pageable pageable,
			Model model){
		Page<Blog> blogs = blogService.pageBlog(pageable);
		model.addAttribute("blogs", blogs);
		return "user/blog/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addBlogPage(@AuthenticationPrincipal User user){
		return "user/blog/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO addBlog(@AuthenticationPrincipal User user,
			@Valid Blog blog, BindingResult bindingResult){
		RepBaseDTO repDTO = new RepBaseDTO();
		if (bindingResult.hasErrors()){
			repDTO.setCode(ResultCode.COMMON_FAIL);
			repDTO.setMes(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return repDTO;
		}
		blog.setBlogger((Blogger) user);
		blogService.addBlog(blog);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加博客成功");
		return repDTO;
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editBlogPage(@AuthenticationPrincipal User user,
			@PathVariable Blog blog,
			Model model){
		if (blog == null){
			return "redirect:/error?info=该博客不存在";
		}
		if (!blog.getBlogger().equals(user)){
			return "redirect:/error?info=没权限修改该博客";
		}
		model.addAttribute("blog", blog);
		return "user/blog/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO editBlog(@AuthenticationPrincipal User user,
			@Valid Blog blog, BindingResult bindingResult){
		RepBaseDTO repDTO = new RepBaseDTO();
		if (bindingResult.hasErrors()){
			repDTO.setCode(ResultCode.COMMON_FAIL);
			repDTO.setMes(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return repDTO;
		}
		if (!blog.getBlogger().equals(user)){
			repDTO.setCode(ResultCode.COMMON_FAIL);
			repDTO.setMes("没权限修改该博客");
			return repDTO;
		}
		blogService.updateBlog(blog);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加博客成功");
		return repDTO;
	}
}
