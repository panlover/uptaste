package cn.uptaste.common.dataaccess;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class BaseDao extends HibernateDaoSupport {

    @Autowired
    public void injectSessionFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

	/**
     * 保存对象
	 * @param entity
	 */
	public void save(Object entity) {
		getHibernateTemplate().save(entity);
	}

	/**
     * 删除对象
	 * @param entity
	 */
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

    /**
     * 删除对象
     * @param clazz
     * @param id
     */
    public void delete(Class clazz,Serializable id){
        getHibernateTemplate().delete(getHibernateTemplate().get(clazz,id));
    }
	/**
     * 通过锁的方式删除实体
	 * @param entity
	 * @param lockMode
	 */
	public void delete(Object entity, LockMode lockMode) {
		getHibernateTemplate().delete(entity, lockMode);
	}

	/**
     * 删除集合中的对象
	 * @param entities
	 */
	public void deleteAll(Collection<?> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	/**
     * 保存或者删除
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
     * 更新实体
	 * @param entity
	 */
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	/**
     * 更新实体
	 * @param entity
	 * @param lockMode
	 */
	public void update(Object entity, LockMode lockMode) {
		getHibernateTemplate().update(entity, lockMode);
	}

	/**
     * 更新
	 * @param queryString
	 */
	public int update(String queryString) {
		return getHibernateTemplate().bulkUpdate(queryString);
	}

	/**
     * 更新（只有一个参数）
	 * @param queryString
	 * @param value
	 * @return
	 */
	public int update(String queryString, Object value) {
		return getHibernateTemplate().bulkUpdate(queryString, value);
	}

	/**
     * 更新，多个参数
	 * @param queryString
	 * @param values
	 * @return
	 */
	public int update(String queryString, Object... values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

	/**
     * 获取对象
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/**
     * 获取对象
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @param lockMode
	 * @return
	 */
	public <T> T get(Class<T> clazz, Serializable id, LockMode lockMode) {
		return getHibernateTemplate().get(clazz, id, lockMode);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @return
	 */
	public List<?> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<?> find(final String queryString, final int firstResult, final int maxResult) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {

			@Override
			public List<?> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
				return query.list();
			}
		});
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @return
	 */
	public List<?> find(String queryString, Object... values) {
		return getHibernateTemplate().find(queryString, values);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @return
	 */
	public List<?> find(final String queryString, final Object[] values, final int firstResult, final int maxResults) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(queryString);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				return query.list();
			}
		});
	}

	/**
     * 获取对象列表
	 * @param criteria
	 * @return
	 */
	public List<?> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/**
     * 获取对象列表
	 * @param criteria
	 * @return
	 */
	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @param paramName
	 * @param value
	 * @return
	 */
	public List<?> findByNamedParam(String queryString, String paramName, Object value) {
		return findByNamedParam(queryString, new String[] { paramName }, new Object[] { value });
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @param paramName
	 * @param value
	 * @return
	 */
	public List<?> findByNamedParam(String queryString, String paramName, Object value, int firstResult, int maxResults) {
		return findByNamedParam(queryString, new String[] { paramName }, new Object[] { value }, firstResult, maxResults);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @param paramNames
	 * @param values
	 * @return
	 */
	public List<?> findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	/**
     * 获取对象列表
	 * @param queryString
	 * @param paramNames
	 * @param values
	 * @return
	 */
	public List<?> findByNamedParam(final String queryString, final String[] paramNames, final Object[] values, final int firstResult, final int maxResults) {
		if (paramNames.length != values.length) {
			throw new IllegalArgumentException("params and values does not have same count");
		}
		return getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {

			@Override
			public List<?> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}
				return query.list();
			}
		});
	}

	/**
     * 获取对象列表
	 * @param queryObject
	 * @param paramName
	 * @param value
	 * @throws org.hibernate.HibernateException
	 */
	protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value) throws HibernateException {
		if (value instanceof Collection) {
			queryObject.setParameterList(paramName, (Collection) value);
		} else if (value instanceof Object[]) {
			queryObject.setParameterList(paramName, (Object[]) value);
		} else {
			queryObject.setParameter(paramName, value);
		}
	}
}
