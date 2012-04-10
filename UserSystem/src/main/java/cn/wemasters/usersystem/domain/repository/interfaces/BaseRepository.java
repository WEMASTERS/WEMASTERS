package cn.wemasters.usersystem.domain.repository.interfaces;

import java.util.List;

public interface BaseRepository<T> {
	
	public Long save(T obj);
	
	public T get(Long id);
	
	public T load(Long id);
	
	public void update(T obj);
	
	public void merge(T obj);
	
	public void delete(Long id);
	
	public void delete(T obj);
	
	public List<T> loadAll();

}
