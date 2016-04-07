package cn.wuwenyao.blog.site.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;
import cn.wuwenyao.blog.site.dao.mongo.AdminDao;
import cn.wuwenyao.blog.site.dao.mongo.BloggerDao;
import cn.wuwenyao.blog.site.entity.mongo.Admin;
import cn.wuwenyao.blog.site.entity.mongo.Blogger;

import javax.inject.Inject;
import javax.servlet.http.HttpUtils;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class AdminAuthenticationService implements AuthenticationProvider, UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(AdminAuthenticationService.class);

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean supports(Class<?> c) {
		return c == UsernamePasswordAuthenticationToken.class;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}
		UsernamePasswordAuthenticationToken credentials = (UsernamePasswordAuthenticationToken) authentication;
		String username = credentials.getPrincipal().toString();
		String password = credentials.getCredentials().toString();
		credentials.eraseCredentials();
		Admin admin = adminDao.findByUsername(username);
		if (admin == null){
			throw new AuthenticationServiceException("用户名或者密码错误");
		}
		if (!BCryptPasswordAlgo.getInstance().checkPassword(password, admin.getPassword())) {
			throw new BadCredentialsException("用户名或者密码错误");
		}
		admin.setAuthenticated(true);
		return admin;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return adminDao.findByUsername(username);
	}

}
