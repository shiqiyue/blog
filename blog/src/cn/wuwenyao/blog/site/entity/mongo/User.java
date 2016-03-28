package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 用户
 * @author 文尧
 *
 */
@Document
public class User extends AbstractDocument {

	@Indexed(unique = true)
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String salt;

	@NotNull
	private UserInfo userInfo;

	@DBRef
	private List<Blog> blogs;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}
