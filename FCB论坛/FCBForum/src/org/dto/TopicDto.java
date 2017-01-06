package org.dto;

import java.util.Date;
import java.util.List;

import org.dao.IResponseDao;
import org.dao.impl.ResponseDaoImpl;
import org.model.Topic;

/**
 * 扩展自基本对象，增加新属性
 * @author songjun
 *
 */
public class TopicDto extends Topic{
	
	private int resCount;
	
	private Date lastTime;
	
	/**
	 * 将对象转成dto，添加新属性
	 * @param topic
	 */
	public void convertDto(Topic topic,TopicDto dto){
		//将topic的属性拷到dto
		dto.setTitle(topic.getTitle());
		dto.setAuthor(topic.getAuthor());
		dto.setContent(topic.getContent());
		dto.setForumid(topic.getForumid());
		dto.setId(topic.getId());
		dto.setSubmittime(topic.getSubmittime());
		IResponseDao dao = new ResponseDaoImpl();
		//通过dao查出最后回复时间及回复数
		dto.setLastTime(dao.getLastTime(topic.getId()));
		dto.setResCount(dao.getResCountByTopicID(topic.getId()));		
	}
    
	/**
	 * 将整个list的对象转成dto的list
	 * @param list
	 */
	public void covertDto(List<Topic> list,List<TopicDto> dtolist){	
		for(int i=0;i<list.size();i++){
			TopicDto dto = new TopicDto();
			//将list中的topic转成dto
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
