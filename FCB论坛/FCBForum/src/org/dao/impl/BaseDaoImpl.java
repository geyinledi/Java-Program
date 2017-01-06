package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.IBaseDao;
import org.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
  
/**
 * 
 * 实现基础DAO接口的DAO基础类,所有的DAO都要继承该类
 * @author songjun
 * @version 1.0
 */

public class BaseDaoImpl implements IBaseDao {

	/**
	 *  在hibernateSession工厂中取得session连接对象
	 */
	public Session getSession() {
		 return HibernateSessionFactory.getSession();
	}

	/**
	 * 关闭session对象
	 */
	public void closeSession() {
		HibernateSessionFactory.closeSession();

	}

	/**
	 * 插入数据
	 * @param po  Object 存放表数据的对象，需要在子类中指定具体的业务类
	 * @throws HibernateException  插入数据时发生的异常
	 * @return Object 返回插入成功后的业务对象
	 */
	public Object insert(Object po) {
		Session session = getSession();
		try {		
			Transaction tran = session.beginTransaction();
			session.save(po);
			//session.flush();
			tran.commit();
			return po;
		} catch (HibernateException ex) {
			throw ex;
		}finally{
			session.close();
		}
	}

	/**
	 * 更新数据
	 */
	public void renew(Object po) {
		Session session = getSession();
		try {
			Transaction tran = session.beginTransaction();
			session.update(po); // 记录不存在时,update也不会出错
			tran.commit();
		} catch (HibernateException ex) {
			throw ex;
		}
		try {
			//session.flush();
			session.close();
		} catch (HibernateException ex1) {
			throw ex1;
		}
	}

	/**
	 * 删除一条数据；注意，大批量删除时，这个接口效率较低，因为它先查询一条记录，再删除一条记录,
	 * @param businessClass Class 业务对象的class
	 * @param id  String 主键
	 */
	public void delete(Class businessClass, java.io.Serializable id) {
		Session session = getSession();
		Object obj = null;
		Transaction tran = session.beginTransaction();
		try {
			obj = session.get(businessClass, id);
		} catch (HibernateException ex) {
			throw ex;
		}
		if (obj != null) {
			try {
				session.delete(obj);
				tran.commit();
			} catch (HibernateException ex1) {
				throw ex1;
			}
		}
		try {
			//session.flush();
			session.close();
		} catch (HibernateException ex2) {
			throw ex2;
		}
	}

	public void delete(Object obj) {
		Session session = getSession();
		try {
			Transaction tran = session.beginTransaction();
			session.delete(obj);
			//session.flush();
			tran.commit();
			session.close();
		} catch (HibernateException ex2) {
			throw ex2;
		}finally{
			this.closeSession();
		}
	}

	/**
	 * 查询一组记录
	 * @param hsql String HSQL语句
	 * @return List 一组结果对象
	 * @throws Exception
	 */
	public List search(String hsql) {
		Session session = getSession();
		List alist = null;
		try {
			alist = session.createQuery(hsql).list();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return alist;
	}

	/**
	 * 查询一条特定的记录
	 * @param businessClass  Class 业务对象的class
	 * @param id  SerialObject 主键,串行化对象
	 * @return Object 业务对象
	 */
	public Object search(Class businessClass, java.io.Serializable id) {
		Session session = getSession();
		try {
			return session.load(businessClass, id); // 记录不存在时,会抛出ObjectNotFoundException
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		}finally{
			this.closeSession();
		}
	}

	/*
	 * 保存或更新
	 */
	public void saveObject(Object o) {
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(o);
		tran.commit();
		this.closeSession();
	}

	/**
	 * 按id查
	 */
	public Object getObject(Class clazz, Serializable id) {
		Session session = this.getSession();
		Object o = session.get(clazz, id);
		this.closeSession();
		return o;
	}

	/**
	 * 查所有的
	 */
	public List getObjects(Class clazz) {
		Session session = this.getSession();
		List alist = session.createQuery("from " + clazz.getName()).list();
		this.closeSession();
		return alist;
	}
	
	/**
	 * 分页查询
	 * @param session
	 * @param sqlString
	 * @param pageInfo
	 * @return list
	 */
	public static List getPage(Session session, String sqlString, final PageInfo pageInfo) {
		if (pageInfo != null) {		
			Query query = session.createQuery("select count(*) " + sqlString);//查询总记录数sql
			Number count = (Number) query.uniqueResult();
			pageInfo.setItemCount(count.intValue());//返回总记录数
		}	
		Query query = session.createQuery(sqlString);
		if (pageInfo != null) {
			query.setFirstResult(pageInfo.getFirstResult());//第几条记录开始
			if (pageInfo.getMaxResults() != -1) {			
				query.setMaxResults(pageInfo.getMaxResults());//每页最大记录数
			}
		}
		return query.list();
	}

	public static void main(String[] args) {
		//BaseDaoImpl dao = new BaseDaoImpl();
	}
}
