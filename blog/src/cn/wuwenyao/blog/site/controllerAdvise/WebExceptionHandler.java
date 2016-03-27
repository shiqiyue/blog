package cn.wuwenyao.blog.site.controllerAdvise;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {

	private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public String constraintViolationException(ConstraintViolationException e) {
		return "ConstraintViolationException";
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(RuntimeException e) {
		log.error("error", e);
		return "RuntimeException";
	}
}
