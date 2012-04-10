package cn.wemasters.usersystem.domain.repository.impls.hibernate;

import java.util.List;

import org.hibernate.Query;

import cn.wemasters.usersystem.domain.entity.Account;
import cn.wemasters.usersystem.domain.repository.interfaces.AccountRepository;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Account>
		implements AccountRepository {

	@SuppressWarnings("unchecked")
	@Override
	public Account getAccountIdPasswordByEmailAddress(String emailAddress) {
		String hql = "select id, encryptedPassword from Account where emailAddress = ?";
		Query query = getHibernateSession().createQuery(hql);
		query.setParameter(0, emailAddress);
		return generateIdPassword(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account getAccountIdPasswordByMobilePhoneNumber(
			String mobilePhoneNumber) {
		String hql = "select id, encryptedPassword from Account where mobilePhoneNumber = ?";
		Query query = getHibernateSession().createQuery(hql);
		query.setParameter(0, mobilePhoneNumber);
		return generateIdPassword(query.list());
	}

	@Override
	public int countAccountByEmailAddress(String emailAddress) {
		String hql = "select count(*) from Account where emailAddress = ?";
		Query query = getHibernateSession().createQuery(hql);
		query.setParameter(0, emailAddress);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public int countAccountByMobilePhoneNumber(String mobilePhoneNumber) {
		String hql = "select count(*) from Account where mobilePhoneNumber = ?";
		Query query = getHibernateSession().createQuery(hql);
		query.setParameter(0, mobilePhoneNumber);
		return ((Long) query.uniqueResult()).intValue();
	}

	private Account generateIdPassword(List<Object[]> results) {
		if (results != null && results.size() == 1) {
			Account account = new Account();
			account.setId((Long) results.get(0)[0]);
			account.setEncryptedPassword((String) results.get(0)[1]);
			return account;
		} else {
			return null;
		}
	}

}
