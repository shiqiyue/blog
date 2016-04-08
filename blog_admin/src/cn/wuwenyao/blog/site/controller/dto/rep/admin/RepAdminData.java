package cn.wuwenyao.blog.site.controller.dto.rep.admin;

import java.util.List;

import cn.wuwenyao.blog.site.controller.dto.rep.RepData;
import cn.wuwenyao.blog.site.entity.mongo.Admin;

public class RepAdminData extends RepData {

	private List<Admin> admin;

	public RepAdminData() {
		// TODO Auto-generated constructor stub
	}
	
	public RepAdminData(List<Admin> admin) {
		this.admin = admin;
	}
	
	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

}
