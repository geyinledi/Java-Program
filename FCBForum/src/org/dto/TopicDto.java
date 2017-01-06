package org.dto;

import java.util.Date;
import java.util.List;

import org.dao.IResponseDao;
import org.dao.impl.ResponseDaoImpl;
import org.model.Topic;

/**
 * ��չ�Ի�����������������
 * @author songjun
 *
 */
public class TopicDto extends Topic{
	
	private int resCount;
	
	private Date lastTime;
	
	/**
	 * ������ת��dto�����������
	 * @param topic
	 */
	public void convertDto(Topic topic,TopicDto dto){
		//��topic�����Կ���dto
		dto.setTitle(topic.getTitle());
		dto.setAuthor(topic.getAuthor());
		dto.setContent(topic.getContent());
		dto.setForumid(topic.getForumid());
		dto.setId(topic.getId());
		dto.setSubmittime(topic.getSubmittime());
		IResponseDao dao = new ResponseDaoImpl();
		//ͨ��dao������ظ�ʱ�估�ظ���
		dto.setLastTime(dao.getLastTime(topic.getId()));
		dto.setResCount(dao.getResCountByTopicID(topic.getId()));		
	}
    
	/**
	 * ������list�Ķ���ת��dto��list
	 * @param list
	 */
	public void covertDto(List<Topic> list,List<TopicDto> dtolist){	
		for(int i=0;i<list.size();i++){
			TopicDto dto = new TopicDto();
			//��list�е�topicת��dto
			this.convertDto(list.get(i), dto);
			dtolist.add(dto);
		}	
	}
	
	public int getResCount() {
		return resCount;
	}

	public void setResCount(int resCount) {
		this.resCount = resCount;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
