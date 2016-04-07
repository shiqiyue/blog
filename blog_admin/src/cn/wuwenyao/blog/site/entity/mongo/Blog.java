package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
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
	@CreatedBy
	@DBRef
	private Blogger blogger;
	@DBRef
	private List<LeaveMessage> leaveMessages;

	@NotBlank(message="标题不能为空")
	private String title;
	@NotBlank(message="简介不能为空")
	private String briefIntro;
	@NotBlank(message="内容不能为空")
	private String context;
	@NotNull(message="关键字不能为空")
	@Size(min=1, message="关键字不能为空")
	private List<String> keywords;

	private int visitnum;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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

	public int getVisitnum() {
		return visitnum;
	}

	public void setVisitnum(int visitnum) {
		this.visitnum = visitnum;
	}

	public void incrementVisitNum() {
		visitnum += 1;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

}
