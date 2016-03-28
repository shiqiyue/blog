package cn.wuwenyao.blog.site.entity.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.collect.Maps;

/***
 * 权限
 * 
 * @author 文尧
 *
 */
public class Permission implements GrantedAuthority {
	/** 博客管理权限 */
	public static Permission BLOG_MANAGE = registerPermission("blog");
	/** 用户管理权限 */
	public static Permission USER_MANAGE = registerPermission("user");
	/** 系统信息管理权限 */
	public static Permission SYSINFO_MANAGE = registerPermission("sysinfo");

	private static Map<String, Permission> permissionMap;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163774768979458236L;

	private String authority;

	private Permission() {
		// TODO Auto-generated constructor stub
	}

	private static Permission registerPermission(String authority) {
		Permission permission = new Permission();
		permission.setAuthority(authority);
		if (permissionMap == null){
			permissionMap = Maps.newHashMap();
		}
		permissionMap.put(authority, permission);
		return permission;
	}

	public static Permission findPermission(String authority) {
		return permissionMap.get(authority);
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	private void setAuthority(String authority) {
		this.authority = authority;
	}

}
