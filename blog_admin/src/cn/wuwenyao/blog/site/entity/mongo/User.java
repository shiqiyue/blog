package cn.wuwenyao.blog.site.entity.mongo;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 用户
 * @author 文尧
 *
 */
public class User extends AbstractDocument implements UserDetails, Authentication, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8794003268373923049L;
	private static final Logger log = LoggerFactory.getLogger(User.class);

	@Indexed(unique = true)
	@NotBlank
	private String username;

	@NotNull
	private String password;

	
	@NotNull
	@Valid
	private UserInfo userInfo;
	
	@Transient
	private boolean isAuthenticated;

	

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
	public String getName() {
		log.info("auth getName");
		return username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("auth getAuthorities");
		return Lists.newArrayList();
	}

	@Override
	public Object getCredentials() {

		log.info("auth getCredentials");
		return password;
	}

	@Override
	public Object getDetails() {
		log.info("auth getDetails");
		return username;
	}

	@Override
	public Object getPrincipal() {
		log.info("auth getPrincipal");
		return this;
	}

	@Override
	public boolean isAuthenticated() {
		log.info("auth isAuthenticated");
		return isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		log.info("auth setAuthenticated");
		this.isAuthenticated = isAuthenticated;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("isAccountNonExpired");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("isAccountNonLocked");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("isCredentialsNonExpired");
		return true;
	}

	@Override
	public boolean isEnabled() {
		System.out.println("isEnabled");
		return true;
	}
	
	

	

}
