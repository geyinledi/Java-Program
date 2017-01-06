package org.dao.impl;

import java.util.List;

import org.dao.ITopicDao;
import org.model.Topic;

public class TopicDaoImpl extends BaseDaoImpl implements ITopicDao{
	
	public List<Topic> getAll(){
		return super.getObjects(Topic.class);
	}
	
	public void intert(Topic topic){
		super.insert(topic);
	}
	
	public List<Topic> getByForum(int forumID){
		List<Topic> list = super.search("from Topic where forumid="+forumID);
		return list;
	}
	
	public void delete(Integer id){
		super.delete(Topic.class, id);
	}

}
