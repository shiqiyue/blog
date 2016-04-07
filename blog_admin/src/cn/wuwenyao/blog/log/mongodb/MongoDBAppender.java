package cn.wuwenyao.blog.log.mongodb;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

import com.mongodb.BasicDBObject;

/***
 * 
 * @author 文尧
 *
 */
public class MongoDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

	private MongoDBConnectionSource connectionSource = null;

	@Override
	protected void append(ILoggingEvent eventObject) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		BasicDBObject logEntry = new BasicDBObject();
		logEntry.append("username", MDC.get("username"));
		logEntry.append("remoteAddr", request.getRemoteAddr());
		logEntry.append("message", eventObject.getFormattedMessage());
		logEntry.append("logger", eventObject.getLoggerName());
		//logEntry.append("thread", eventObject.getThreadName());
		logEntry.append("timestamp", new Date(eventObject.getTimeStamp()));
		logEntry.append("level", eventObject.getLevel().toString());
		connectionSource.getDBCollection().insert(logEntry);
	}

	public void setConnectionSource(MongoDBConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
	}

}