package cn.wuwenyao.blog.site.service;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wuwenyao.blog.site.dao.mongo.LeaveMessageDao;
import cn.wuwenyao.blog.site.entity.mongo.Blog;
import cn.wuwenyao.blog.site.entity.mongo.LeaveMessage;

@Service
public class LeaveMessageService {
	private static Logger log = LoggerFactory.getLogger(LeaveMessageService.class);

	@Autowired
	private LeaveMessageDao leaveMessageDao;

	public LeaveMessage findLeaveMessageById(BigInteger id) {
		log.debug("find leaveMessage by id {}", id);
		return leaveMessageDao.findOne(id);
	}

	public void addLeaveMessage(LeaveMessage leaveMessage) {
		log.debug("add leave message : {}", leaveMessage);
		leaveMessage = leaveMessageDao.save(leaveMessage);
		Assert.notNull(leaveMessage);
	}

	public void updateLeaveMessage(LeaveMessage leaveMessage) {
		log.debug("update leaveMessage : {}", leaveMessage);
		leaveMessage = leaveMessageDao.save(leaveMessage);
		Assert.notNull(leaveMessage);
	}

	public Page<LeaveMessage> pageLeaveMessage(Pageable pageable) {
		log.debug("page leaveMessage : {}", pageable);
		return leaveMessageDao.findAll(pageable);
	}
	
	public Page<LeaveMessage> pageLeaveMessage(Blog blog, Pageable pageable){
		log.debug("page leaveMessage ,pageinfo: {},blog:{}", pageable, blog);
		return leaveMessageDao.findByBlog(blog, pageable);
	}
}
