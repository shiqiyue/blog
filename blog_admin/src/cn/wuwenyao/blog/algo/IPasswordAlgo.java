package cn.wuwenyao.blog.algo;

public interface IPasswordAlgo {
	/***
	 * 加密密码
	 * @param password
	 * @return
	 */
	public String encrptPassword(String password);
	
	/***
	 * 检测密码是否正确
	 * @param plain 未加密的密码
	 * @param hashed 加密过的密码
	 * @return
	 */
	public boolean checkPassword(String plain, String hashed);
}
