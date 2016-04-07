package cn.wuwenyao.blog.site.entity.mongo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Convert;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import cn.wuwenyao.blog.site.converter.PermissionStringConverter;

/***
 * 管理员
 * 
 * @author 文尧
 *
 */
@Document
public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 742332056474866726L;
	@Convert(converter = PermissionStringConverter.class)
	private List<Permission> permissions;

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissions;
	}

	
	
	
}
