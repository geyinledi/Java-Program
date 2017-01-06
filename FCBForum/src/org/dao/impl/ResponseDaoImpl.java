package org.dao.impl;

import java.util.Date;
import java.util.List;

import org.dao.IResponseDao;
import org.model.Response;

public class ResponseDaoImpl extends BaseDaoImpl implements IResponseDao {
	
	public List<Response> getByTopic(int topicID){
		return super.search("from Response where topicid="+topicID);
	}

	public Date getLastTime(int topicID) {
		List<Response> list = super.search("from Response where topicid="+topicID+" order by id desc");
		if(list!=null&&list.size()>0){
			return  list.get(0).getSubmittime();
		}
		return new Date();
	}

	public int getResCountByTopicID(int topicID) {
		List list = super.search("from Response where topicid="+topicID);
		return list.size();
	}
	
	public void save(Response response){
		super.saveObject(response);
	}

}
