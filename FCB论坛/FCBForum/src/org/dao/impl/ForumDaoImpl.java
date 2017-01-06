package org.dao.impl;

import java.util.List;

import org.dao.IForumDao;
import org.model.Forum;
import org.model.Topic;

public class ForumDaoImpl extends BaseDaoImpl implements IForumDao{

	public Forum getByID(Integer id) {
		Forum forum = (Forum)super.getObject(Forum.class, id);
		return forum;
	}

	public void insert(Forum forum) {
		super.insert(forum);		
	}

	public void update(Forum forum) {
		super.renew(forum);
		
	}
	
	public List<Forum> getAll(){
		List<Forum> list = super.getObjects(Forum.class);
		return list;
	}

	public String getLastTopic(int forumID) {
		List<Topic> list = super.search("from Topic where forumid="+forumID+" order by id desc");
		if(list!=null&&list.size()>0){
			return list.get(0).getTitle();
		}
		return "Œﬁª∞Ã‚";
	}

	public int getTopicCount(int forumID) {
		List list = super.search("from Topic where forumid="+forumID);
		return list.size();
	}
	
	public void delete(Integer id){
		super.delete(Forum.class, id);
	}

}
