package org.dao.impl;

import java.util.List;

import org.dao.UserDao;
import org.model.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	public void saveUser(User user) {
        super.insert(user);
	}
	
	public List<User> getAll(Class clazz){
		return super.getObjects(User.class);
	}
	
	public User getByName(String name){
		User user = (User)super.getObject(User.class, name);
		return user;
	}
	
	public void deleteByName(String name){
		super.delete(User.class, name);
	}
	
	public List<User> findByName(String name){
		List<User> list = super.search("from User where username like '%"+name+"%'");
		return list;
	}

	public void update(User user){
		super.renew(user);
	}
	
	public User isValidAdmin(String username,String password){
		User user = null;
		List<User> list = super.search("from User where grade='2' and username='"+username+"' and password='"+password+"'");
		if(list!=null&&list.size()>0){
			user = list.get(0);
		}
		return user;
	}
	
	public User isValidUser(String username,String password){
		User user =null;
		List<User> list = super.search("from User where username='"+username+"' and password='"+password+"'");
		if(list!=null&&list.size()>0){
			user = list.get(0);
		}
		return user;
		
	}
}
