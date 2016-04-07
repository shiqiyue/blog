package blog;

import org.springframework.security.crypto.bcrypt.BCrypt;

import cn.wuwenyao.blog.algo.BCryptPasswordAlgo;

public class TestBCrpt {

	public static void main(String[] args) {
		String pass = "123456";
		String hashedPass = BCryptPasswordAlgo.getInstance().encrptPassword(pass);
		System.out.println(hashedPass);
		System.out.println(BCrypt.checkpw(pass, hashedPass));
	}
}
