package cn.wuwenyao.blog.site.controller.dto.req;

import cn.wuwenyao.blog.site.validator.Email;
import cn.wuwenyao.blog.site.validator.NotBlank;

public class ReqTestDTO {

	@NotBlank(message = "用户名不能为空")
	private String username;

	@Email(message = "邮箱格式错误")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
