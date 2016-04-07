package cn.wuwenyao.blog.util.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtils {

	public static Object showSessionAttribute(String name){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession httpSession = request.getSession();
		if (httpSession == null){
			return null;
		}
		Object ret = httpSession.getAttribute(name);
		httpSession.removeAttribute(name);
		return ret;
	
	}
}
