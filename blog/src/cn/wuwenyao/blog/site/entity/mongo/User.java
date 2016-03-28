package cn.wuwenyao.blog.site.entity.mongo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 用户
 * @author 文尧
 *
 */
public class User extends AbstractDocument implements Authentication, Cloneable{

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

	@Override
	@Transient
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	

}
