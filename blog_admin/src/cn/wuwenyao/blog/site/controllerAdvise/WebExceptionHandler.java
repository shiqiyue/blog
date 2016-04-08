package cn.wuwenyao.blog.site.controllerAdvise;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.wuwenyao.blog.site.controller.dto.rep.ResultCode;
import cn.wuwenyao.blog.util.ajax.AjaxUtils;

@ControllerAdvice
public class WebExceptionHandler {

	private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView constraintViolationException(WebRequest request, ConstraintViolationException e) {
		ModelAndView modelAndView = new ModelAndView();
		if (AjaxUtils.isAjaxRequest(request) || AjaxUtils.isAjaxUploadRequest(request)) {
			modelAndView.setView(new MappingJackson2JsonView());
			modelAndView.addObject("code", ResultCode.COMMON_FAIL.ordinal());
			modelAndView.addObject("mes", e.getMessage());
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/error?info="+e.getMessage());
		return modelAndView;
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeExceptionHandler(WebRequest request, RuntimeException e) {
		ModelAndView modelAndView = new ModelAndView();
		if (AjaxUtils.isAjaxRequest(request) || AjaxUtils.isAjaxUploadRequest(request)) {
			modelAndView.setView(new MappingJackson2JsonView());
			modelAndView.addObject("code", ResultCode.COMMON_FAIL.ordinal());
			modelAndView.addObject("mes", e.getMessage());
			return modelAndView;
		}
		log.error(e.getMessage());
		modelAndView.setViewName("redirect:/error?info="+e.getMessage());
		return modelAndView;
	}
}
