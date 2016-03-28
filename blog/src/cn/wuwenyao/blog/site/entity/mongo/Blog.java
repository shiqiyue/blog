package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractAuditDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 博客
 * @author 文尧
 *
 */
@Document
public class Blog extends AbstractAuditDocument {

	@DBRef
	private User user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LeaveMessage> getLeaveMessages() {
		return leaveMessages;
	}

	public void setLeaveMessages(List<LeaveMessage> leaveMessages) {
		this.leaveMessages = leaveMessages;
	}

}
