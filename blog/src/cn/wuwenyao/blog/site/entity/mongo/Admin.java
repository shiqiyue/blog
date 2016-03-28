package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import javax.persistence.Convert;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.converter.PermissionStringConverter;

/***
 * 管理员
 * @author 文尧
 *
 */
@Document
public class Admin extends User {

	@Convert(converter = PermissionStringConverter.class)
	private List<Permission> permissions;

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
