package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 用户
 * @author 文尧
 *
 */
public class User extends AbstractDocument {

	@Indexed(unique = true)
	@NotBlank
	private String username;

	@NotNull
	private String password;

	
	@NotNull
	@Valid
	private UserInfo userInfo;

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	

}
