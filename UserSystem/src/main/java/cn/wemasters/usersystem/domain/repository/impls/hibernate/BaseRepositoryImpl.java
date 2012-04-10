package cn.wemasters.usersystem.domain.repository.impls.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wemasters.usersystem.domain.repository.interfaces.BaseRepository;

public class BaseRepositoryImpl<T>  extends HibernateDaoSupport implements BaseRepository<T>{
	
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	@Override
	public Long save(T obj) {
		return (Long)getHibernateTemplate().save(obj);
	}

	@Override
	public T get(Long id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public T load(Long id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	@Override
	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}

	@Override
	public void merge(T obj) {
		getHibernateTemplate().merge(obj);
	}

	@Override
	public void delete(Long id) {
		T obj = this.load(id);
		getHibernateTemplate().delete(obj);
	}

	@Override
	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}

	@Override
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	public Session getHibernateSession() {
		return getSession();
	}

}
