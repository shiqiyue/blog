package blog;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestBCrpt {

	public static void main(String[] args) {
		String pass = "123456";
		String salt = BCrypt.gensalt();
		String hashedPass = BCrypt.hashpw(pass, salt);
		System.out.println(BCrypt.checkpw(pass, hashedPass));
	}
}
