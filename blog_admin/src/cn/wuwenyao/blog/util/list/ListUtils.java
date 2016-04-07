package cn.wuwenyao.blog.util.list;

import java.util.List;

public class ListUtils {

	public static String conbineList(List list, String separator){
		if (list == null || list.isEmpty()){
			return "";
		}
		StringBuffer res = new StringBuffer();
		res.append(list.get(0));
		for (int i=1;i<list.size();i++){
			res.append(list.get(i)).append(separator);
		}
		return res.toString();
	}
}
