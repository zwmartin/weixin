package com.zw.weixin.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author martin_zou 2016年8月24日
 * 
 * @param <T>
 */
@Deprecated
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public BaseDaoImpl() {
		// 使用反射获取T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); //获取当前new的对象的泛型化的父类类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println("clazz ---> " + clazz);
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object entity = getById(id);
		getSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if(id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if(ids == null || ids.length == 0) {
			return Collections.emptyList();
		}
		return getSession().createQuery( //
				"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)") //
				.setParameterList("ids", ids) //
				.list();
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery( //
				"FROM " + clazz.getSimpleName()) //
				.list();
	}

}
