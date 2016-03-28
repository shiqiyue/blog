package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 * 博客使用者，博主
 * 
 * @author 文尧
 *
 */
@Document
public class Blogger extends User {
	@DBRef
	private List<Blog> blogs;
	
	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
}
