package cn.wuwenyao.blog.site.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDaoImpl implements UserDaoCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void inOnlyTest(Integer inParam1) {
		this.em.createNativeQuery("call in_only_test(:inParam1);").setParameter("inParam1", inParam1)
				.executeUpdate();

	}

	@Override
	public Integer inAndOutTest(Integer inParam1) {
		return 222;

	}

}
