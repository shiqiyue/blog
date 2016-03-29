package cn.wuwenyao.blog.site.enums;

/***
 * 性别
 * @author 文尧
 *
 */
public enum Sex {

	male, female, unknow,;

	public String getInfo() {
		switch (this) {
		case male:
			return "男性";
		case female:
			return "女性";
		default:
			return "未知";
		}
	}
}
