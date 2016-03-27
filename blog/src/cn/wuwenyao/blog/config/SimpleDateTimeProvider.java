package cn.wuwenyao.blog.config;

import java.util.Calendar;

import org.springframework.data.auditing.DateTimeProvider;

/***
 * 简单的datetimeprovider，用于审计生成日期
 * @author 文尧
 *
 */
public class SimpleDateTimeProvider implements DateTimeProvider{

	@Override
	public Calendar getNow() {
		// TODO Auto-generated method stub
		return Calendar.getInstance();
	}

}
