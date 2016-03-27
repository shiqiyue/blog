package cn.wuwenyao.blog.anontation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ControllerAdvice;

/***
 * 备注这是一个rest controller advice
 * @author 文尧
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ControllerAdvice
public @interface RestControllerAdvice
{
    String value() default "";
}
