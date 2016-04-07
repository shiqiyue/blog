package cn.wuwenyao.blog.algo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPasswordAlgo implements IPasswordAlgo {
	private static final SecureRandom RANDOM;
	private static final int HASHING_ROUNDS = 10;
	private static BCryptPasswordAlgo instance = new BCryptPasswordAlgo();

	static {
		try {
			RANDOM = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}

	private BCryptPasswordAlgo() {
	}

	public static BCryptPasswordAlgo getInstance() {
		return instance;
	}

	@Override
	public boolean checkPassword(String plain, String hashed) {
		return BCrypt.checkpw(plain, hashed);
	}

	@Override
	public String encrptPassword(String password) {
		if (password != null && password.length() > 0) {
			String salt = BCrypt.gensalt(HASHING_ROUNDS, RANDOM);
			return BCrypt.hashpw(password, salt);
		}
		return null;
	}
}
