package com.zw.weixin.service;

import java.util.List;

import com.zw.weixin.base.BaseDao;

/**
 * 
 * @author martin_zou 2016年8月24日
 *
 * @param <T>
 * @see BaseDao
 */
public interface DaoSupport<T> {
	
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 通过ID获取实体
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * 通过id数组获取实体列表
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
}
