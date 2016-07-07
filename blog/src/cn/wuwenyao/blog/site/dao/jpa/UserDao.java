package cn.wuwenyao.blog.site.dao.jpa;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import cn.wuwenyao.blog.site.dao.jpa.base.BaseDao;
import cn.wuwenyao.blog.site.entity.jpa.User;

/***
 * dao of {@link User}
 * 
 * @author 文尧
 *
 */
public interface UserDao extends BaseDao<User>{

	@Procedure(name = "in_only_test")
	void inOnlyTest(@Param("inParam1") Integer inParam1);

	@Procedure(name = "in_and_out_test")
	Integer inAndOutTest(@Param("inParam1") Integer inParam1);

}
