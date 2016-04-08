package cn.wuwenyao.blog.site.controller.dto.rep.blogger;

import java.math.BigInteger;

import cn.wuwenyao.blog.site.entity.mongo.Blogger;

/***
 * 
 * @author 文尧
 *
 */
public class RepBloggerData {

	private BigInteger id;
	
	private String username;
	
	private String name;
	
	public RepBloggerData() {
		// TODO Auto-generated constructor stub
	}
	
	public RepBloggerData(Blogger blogger) {
		setId(blogger.getId());
		setUsername(blogger.getUsername());
		setName(blogger.getUserInfo().getName());
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
