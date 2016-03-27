package cn.wuwenyao.blog.site.entity.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractAuditDocument;

@Document
public class Blog extends AbstractAuditDocument {

	@DBRef
	private User user;

	private String title;
	private String context;
	private String about;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
