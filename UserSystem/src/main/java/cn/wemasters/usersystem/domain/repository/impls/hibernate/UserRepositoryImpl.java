package cn.wemasters.usersystem.domain.repository.impls.hibernate;

import org.hibernate.Query;

import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.domain.repository.interfaces.UserRepository;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository{

	@Override
	public User getUserByAccountId(Long accountId) {
		String hql = "from User where account.id = ?";
		Query query = getHibernateSession().createQuery(hql);
		query.setParameter(0, accountId);
		return (User) query.uniqueResult();
	}
	
}
