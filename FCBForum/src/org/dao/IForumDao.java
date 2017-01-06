package org.dao;

import java.util.List;

import org.model.Forum;

public interface IForumDao {
	
	public void insert(Forum forum);
	
	public void update(Forum forum);
	
	public Forum getByID(Integer id);
	
	public List<Forum> getAll();
	
	public int getTopicCount(int forumID);
	
	public String getLastTopic(int forumID);
	
	public void delete(Integer id);

}
