package cn.wuwenyao.blog.site.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import cn.wuwenyao.blog.site.entity.mongo.Permission;

@Component
public class PermissionStringConverter implements org.springframework.core.convert.converter.Converter<Permission, String> {


	@Override
	public String convert(Permission source) {
		// TODO Auto-generated method stub
		return source.getAuthority();
	}

}
