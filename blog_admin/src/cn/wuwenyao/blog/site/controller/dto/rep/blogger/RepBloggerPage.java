package cn.wuwenyao.blog.site.controller.dto.rep.blogger;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.google.common.collect.Lists;

import cn.wuwenyao.blog.site.controller.dto.rep.RepData;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

public class RepBloggerPage extends RepData{

	private int page;
	
	private int size;
	
	private long total;
	
	private List<RepBloggerData> data;
	
	public RepBloggerPage() {
		// TODO Auto-generated constructor stub
	}
	
	public RepBloggerPage(Page<Blogger> page) {
		setData(page.getContent().stream().map(RepBloggerData::new).collect(Collectors.toList()));
		setPage(page.getNumber());
		setSize(page.getSize());
		setTotal(page.getTotalElements());
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<RepBloggerData> getData() {
		return data;
	}

	public void setData(List<RepBloggerData> data) {
		this.data = data;
	}
	
	
}
