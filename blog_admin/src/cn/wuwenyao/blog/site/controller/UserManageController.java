package cn.wuwenyao.blog.site.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.wuwenyao.blog.site.controller.dto.rep.RepBaseDTO;

@Controller
@RequestMapping("/manage/user")
public class UserManageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() {

		return "manage/user/list";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RepBaseDTO listData(@PageableDefault Pageable page) {
		RepBaseDTO repDTO = new RepBaseDTO();
		
		return repDTO;
	}
}
