package cn.wuwenyao.blog.site.entity.mongo;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractAuditDocument;
import cn.wuwenyao.blog.site.validator.NotBlank;

/***
 * 留言
 * 
 * @author 文尧
 *
 */
@Document
public class LeaveMessage extends AbstractAuditDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5174633727357783344L;

	/** 属于哪个博客 */
	@DBRef
	@NotNull
	private Blog blog;
	
	/** 留言用户 */
	@DBRef
	@NotNull
	private User user;

	/** 回复哪条留言 */
	@DBRef
	private LeaveMessage replyTo;

	/** 留言内容 */
	@NotBlank
	private String message;

	

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LeaveMessage getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(LeaveMessage replyTo) {
		this.replyTo = replyTo;
	}

}
