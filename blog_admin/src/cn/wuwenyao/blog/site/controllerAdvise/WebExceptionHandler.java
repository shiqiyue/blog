package cn.wuwenyao.blog.site.controllerAdvise;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cn.wuwenyao.blog.util.ajax.AjaxUtils;

@ControllerAdvice
public class WebExceptionHandler {

	private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public String constraintViolationException(WebRequest request, ConstraintViolationException e) {
		if (AjaxUtils.isAjaxRequest(request) || AjaxUtils.isAjaxUploadRequest(request)) {
			return "ajax ConstraintViolationException";
		}
		log.error("error", e);
		return "ConstraintViolationException";
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runtimeExceptionHandler(WebRequest request, RuntimeException e) {
		if (AjaxUtils.isAjaxRequest(request) || AjaxUtils.isAjaxUploadRequest(request)) {
			return "ajax RuntimeException";
		}
		log.error("error", e);
		return "RuntimeException";
	}
}
