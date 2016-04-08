package cn.wuwenyao.blog.site.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Maps;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.site.controller.dto.rep.blogger.RepBloggerPage;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;
import cn.wuwenyao.blog.site.service.BloggerService;

@Controller
@RequestMapping("/manage/blogger")
public class BloggerManageController {

	@Autowired
	private BloggerService bloggerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() {

		return "manage/user/list";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RepBaseDTO listData(
			@PageableDefault Pageable page,
			String username,
			String name) {
		RepBaseDTO repDTO = new RepBaseDTO();
		Map<String, Object> searchParams = Maps.newHashMap();
		if (StringUtils.isNotBlank(username)){
			searchParams.put("LIKE_username", username);
		}
		if (StringUtils.isNotBlank(name)){
			searchParams.put("LIKE_userInfo.name", name);
		}
		Page<Blogger> bloggerPage = bloggerService.page(page, searchParams);
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("succ");
		repDTO.setData(new RepBloggerPage(bloggerPage));
		return repDTO;
	}
}
