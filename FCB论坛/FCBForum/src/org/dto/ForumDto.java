package org.dto;

import java.util.List;

import org.dao.IForumDao;
import org.dao.impl.ForumDaoImpl;
import org.model.Forum;

/**
 * 为论坛添加新属性Dto
 * @author Administrator
 *
 */
public class ForumDto extends Forum{
	
	private int topicCount;
	
	private String newTopic;

	/**
	 * 将forum转成dto
	 * @param forum
	 * @param dto
	 */
	public void convert(Forum forum,ForumDto dto){
		dto.setForumname(forum.getForumname());
		dto.setId(forum.getId());
		dto.setManager(forum.getManager());
		IForumDao dao = new ForumDaoImpl();
		//通过dao将最新话题及话题数转出来
		dto.setNewTopic(dao.getLastTopic(forum.getId()));
		dto.setTopicCount(dao.getTopicCount(forum.getId()));
	}

	/**
	 * 将list中的forum转成dto
	 * @param list
	 * @param dtolist
	 */
	public void convert(List<Forum> list,List<ForumDto> dtolist){
		for(int i=0;i<list.size();i++){
			ForumDto dto = new ForumDto();
			this.convert(list.get(i), dto);
			dtolist.add(dto);
		}
	}
	
	public int getTopicCount() {
		return topicCount;
	}
	
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public String getNewTopic() {
		return newTopic;
	}

	public void setNewTopic(String newTopic) {
		this.newTopic = newTopic;
	}

}
