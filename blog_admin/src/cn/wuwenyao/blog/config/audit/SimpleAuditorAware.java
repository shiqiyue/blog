package cn.wuwenyao.blog.config.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.wuwenyao.blog.site.entity.mongo.User;

public class SimpleAuditorAware implements AuditorAware<User>{

	@Override
	public User getCurrentAuditor() {
		// TODO Auto-generated method stub
		return (User) SecurityContextHolder.getContext().getAuthentication();
	}

}
