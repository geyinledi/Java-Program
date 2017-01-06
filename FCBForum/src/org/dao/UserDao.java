package org.dao;

import java.util.List;

import org.model.User;

public interface UserDao {
	
	public void saveUser(User user);
	
	public List<User> getAll(Class clazz);
	
	public User getByName(String name);
	
	public void deleteByName(String name);
	
	public List<User> findByName(String name);
	
	public void update(User user);
	
	public User isValidAdmin(String username,String password);
	
	public User isValidUser(String username,String password);

}
