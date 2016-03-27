package cn.wuwenyao.blog.site.entity.jpa;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.wuwenyao.blog.site.entity.jpa.base.IdEntity;
import cn.wuwenyao.blog.site.enums.Sex;

/***
 * 用户
 * @author 文尧
 *
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Cacheable(true)
public class User extends IdEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -462409132015864586L;

	private String username;
	
	private String mobileno;
	
	private String password;
	
	private String salt;
	
	private Sex sex;
	
	@CreatedDate
	@Column(name="add_date")
	private Date addDate;
	
	@LastModifiedDate
	@Column(name="modify_date")
	private Date modifyDate;
	
	@Version
	private long version;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	
}
