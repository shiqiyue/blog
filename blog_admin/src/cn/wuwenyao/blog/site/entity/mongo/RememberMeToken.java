package cn.wuwenyao.blog.site.entity.mongo;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import cn.wuwenyao.blog.site.entity.mongo.base.AbstractDocument;

/***
 * 用于spring security rememberme token的持久化
 * 
 * @author 文尧
 *
 */
@Document
public class RememberMeToken extends AbstractDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7331859517523100982L;
	private String username;
	@Indexed(unique = true)
	private String series;
	private String tokenValue;
	private Date date;

	public RememberMeToken() {
		// TODO Auto-generated constructor stub
	}
	
	public RememberMeToken(String username, String series, String tokenValue, Date date) {
		this.username = username;
		this.series = series;
		this.tokenValue = tokenValue;
		this.date = date;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getUsername() {
		return username;
	}

	public String getSeries() {
		return series;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
