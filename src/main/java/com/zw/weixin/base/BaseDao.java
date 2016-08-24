package com.zw.weixin.base;

import java.util.List;

/**
 * 
 * @author martin_zou 2016年8月24日
 * 
 */
public interface BaseDao<T> {

	void save(T entity);

	void delete(Long id);

	void update(T entity);

	T getById(Long id);

	List<T> getByIds(Long[] ids);

	List<T> findAll();
	
}
