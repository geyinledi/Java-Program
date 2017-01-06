package org.dao;

import java.util.List;

import org.model.Topic;

public interface ITopicDao {
	
	public List<Topic> getAll();
	
	public void intert(Topic topic);
	
	public List<Topic> getByForum(int forumID);
	
	public void delete(Integer id);
}
