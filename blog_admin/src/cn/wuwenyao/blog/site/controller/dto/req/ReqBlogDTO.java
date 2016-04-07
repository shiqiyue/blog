package cn.wuwenyao.blog.site.controller.dto.req;

import java.math.BigInteger;
import java.util.List;

import cn.wuwenyao.blog.site.validator.NotBlank;

public class ReqBlogDTO {
	private BigInteger id;
	@NotBlank(message = "标题不能为空")
	private String title;
	@NotBlank(message = "简介不能为空")
	private String briefIntro;
	@NotBlank(message = "内容不能为空")
	private String context;
	@NotBlank(message = "关键字不能为空")
	private String keywords;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
