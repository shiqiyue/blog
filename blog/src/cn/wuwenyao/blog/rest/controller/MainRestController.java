package cn.wuwenyao.blog.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.wuwenyao.blog.rest.controller.dto.rep.RepBaseDTO;
import cn.wuwenyao.blog.rest.controller.dto.rep.ResultCode;

@RestController
@RequestMapping("rest/main")
public class MainRestController {

	@RequestMapping()
	public RepBaseDTO main(){
		System.out.println("rest main");
		RepBaseDTO repDTO = new RepBaseDTO();
		repDTO.setCode(ResultCode.SUCCESS);
		repDTO.setMes("你好中国");
		return repDTO;
	}
}
