package cn.wuwenyao.blog.site.converter;


import org.springframework.stereotype.Component;

import cn.wuwenyao.blog.site.entity.mongo.Permission;

@Component
public class StringPermissionConverter implements org.springframework.core.convert.converter.Converter<String, Permission> {

	@Override
	public Permission convert(String source) {
		return Permission.findPermission(source);
	}


	

}
