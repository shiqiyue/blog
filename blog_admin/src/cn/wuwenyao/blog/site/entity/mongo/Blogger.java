package cn.wuwenyao.blog.site.entity.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;

/***
 * 博客使用者，博主
 * 
 * @author 文尧
 *
 */
@Document
public class Blogger extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4287680826303540750L;
	
	
}
