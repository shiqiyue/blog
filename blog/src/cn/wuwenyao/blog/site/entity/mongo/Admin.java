package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.enums.Permission;

/***
 * 管理员
 * @author 文尧
 *
 */
@Document
public class Admin extends User {

	private List<Permission> permissions;

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
