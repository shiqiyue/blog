package cn.wuwenyao.blog.site.entity.mongo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 用户信息
 * @author 文尧
 *
 */
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7117032439195784025L;

	@NotBlank
	private String name;

	private Map<String, Object> attributes = new HashMap<String, Object>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}

}
