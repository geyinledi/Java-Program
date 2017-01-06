package org.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author songjun
 * @version 1.0
 */
public interface IBaseDao {

	public Session getSession();

	public void closeSession();

	public Object insert(Object po);
	
	public void saveObject(Object o);

	public void renew(Object po);

	public void delete(Object obj);

	public void delete(Class businessClass, java.io.Serializable id);

	public List search(String hsql);

	public List getObjects(Class clazz);

	public Object getObject(Class clazz, Serializable id);

	

}
