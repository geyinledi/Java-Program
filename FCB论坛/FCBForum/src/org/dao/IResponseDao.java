package org.dao;

import java.util.Date;
import java.util.List;

import org.model.Response;

public interface IResponseDao {
	
	public List<Response> getByTopic(int topicID);
	
	public int getResCountByTopicID(int topicID);
	
	public Date getLastTime(int topicID);
	
	public void save(Response response);
	
}
