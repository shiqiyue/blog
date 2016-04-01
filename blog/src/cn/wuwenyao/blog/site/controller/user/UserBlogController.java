package cn.wuwenyao.blog.site.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.mapper.BeanMapper;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.controller.dto.req.ReqBlogDTO;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;
import cn.wuwenyao.blog.site.entity.mongo.LeaveMessage;
import cn.wuwenyao.blog.site.entity.mongo.User;
import cn.wuwenyao.blog.site.service.BlogService;
import cn.wuwenyao.blog.site.service.LeaveMessageService;

@Controller
@RequestMapping("/user/blog")
public class UserBlogController {
	@Autowired
	private BlogService blogService;
	
	private LeaveMessageService leaveMessageService;
	

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listPage(@AuthenticationPrincipal Blogger blogger,
			@PageableDefault Pageable pageable,
			Model model){
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		Page<Blog> blogs = blogService.pageUserBlog(blogger, pageable);
		model.addAttribute("blogs", blogs);
		return "user/blog/list";
	}
	
	@RequestMapping(value="detail/{id}", method = RequestMethod.GET)
	public String detailPage(
			@PathVariable Blog blog,
			@Qualifier("mes") @PageableDefault Pageable pageable,
			Model model){
		//博客
		model.addAttribute("blog", blog);
		//留言
		Page<LeaveMessage> leaveMessages = leaveMessageService.pageLeaveMessage(blog, pageable);
		model.addAttribute("leaveMessages", leaveMessages);
		return "user/blog/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addBlogPage(@AuthenticationPrincipal User user,
			Model model){
		
		return "user/blog/addOrUpdate";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO addBlog(
			@Valid ReqBlogDTO blog, BindingResult bindingResult){
		RepBaseDTO repDTO = new RepBaseDTO();
		if (bindingResult.hasErrors()){
			repDTO.setCode(ResultCode.COMMON_FAIL);
			repDTO.setMes(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return repDTO;
		}
		blogService.addBlog(bulidBlogForAddBlog(blog));
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("添加博客成功");
		return repDTO;
	}
	
	public Blog bulidBlogForAddBlog(ReqBlogDTO blogDTO){
		Blog blog = new Blog();
		blog.setBriefIntro(blogDTO.getBriefIntro());
		blog.setContext(blogDTO.getContext());
		blog.setTitle(blogDTO.getTitle());
		blog.setKeywords(Lists.newArrayList(blogDTO.getKeywords().split("\\s")));
		return blog;
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editBlogPage(@AuthenticationPrincipal User user,
			@PathVariable(value="id") Blog blog,
			Model model){
		if (blog == null){
			return "redirect:/error?info=该博客不存在";
		}
		if (!blog.getBlogger().equals(user)){
			return "redirect:/error?info=没权限修改该博客";
		}
		model.addAttribute("blog", blog);
		return "user/blog/addOrUpdate";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public RepBaseDTO editBlog(@AuthenticationPrincipal User user,
			@PathVariable(value="id") Blog blog,
			@Valid ReqBlogDTO blogDTO, BindingResult bindingResult){
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
		blog = bulidBlogForEditBlog(blogDTO, blog);
		blogService.updateBlog(blog);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("修改博客成功");
		return repDTO;
	}
	
	public Blog bulidBlogForEditBlog(ReqBlogDTO blogDTO, Blog blog){
		blog.setBriefIntro(blogDTO.getBriefIntro());
		blog.setContext(blogDTO.getContext());
		blog.setTitle(blogDTO.getTitle());
		blog.setKeywords(Lists.newArrayList(blogDTO.getKeywords().split("\\s")));
		return blog;
	}
}
