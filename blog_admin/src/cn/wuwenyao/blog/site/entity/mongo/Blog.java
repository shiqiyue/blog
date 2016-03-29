package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractAuditDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 博客
 * 
 * @author 文尧
 *
 */
@Document
public class Blog extends AbstractAuditDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3147690484901739576L;
	@DBRef
	private Blogger blogger;
	@DBRef
	private List<LeaveMessage> leaveMessages;

	@NotBlank
	private String title;
	@NotBlank
	private String context;
	@NotBlank
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

	

	public List<LeaveMessage> getLeaveMessages() {
		return leaveMessages;
	}

	public void setLeaveMessages(List<LeaveMessage> leaveMessages) {
		this.leaveMessages = leaveMessages;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

}