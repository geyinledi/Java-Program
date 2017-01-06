package org.web.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.dao.ITopicDao;
import org.dao.impl.TopicDaoImpl;
import org.dto.TopicDto;
import org.model.Topic;
import org.model.User;
import org.web.interceptor.AuthenticationInterceptor;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 实现SessionAware接口获取session
 */
public class TopicManagerActionWeb31  extends ActionSupport implements SessionAware{
	
	//实例化topicDao接口
	ITopicDao dao = new TopicDaoImpl();
	
    private Map sessionMap;
	
	private List<Topic> topics;
	
	private List<TopicDto> topicList;
	
	private Integer forumid;
	
	private Integer id;
	
	private String title;
	
	private String content;
	
	private String author;
	
	private Date submittime;
	
	//查所有话题
	public String list()throws Exception{
		topics = dao.getAll();
		return "list";
	}
	
	//按论坛查找话题
	public String listByForum()throws Exception{
		TopicDto dto = new TopicDto();       	
		List<TopicDto> dtolist = new ArrayList<TopicDto>();
		//将话题list转成dtolist
		dto.covertDto(dao.getByForum(id), dtolist);
		topicList = dtolist;
		return "topic";
	}
	
	//转到添加页
	public String add()throws Exception{
		//从request获取forumid参数，用于保存新话题时存入forumid
		HttpServletRequest request = ServletActionContext.getRequest();		
		forumid = Integer.parseInt(request.getParameter("id"));
		return "add";
	}
	
	//保存话题
	public String save()throws Exception{
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);
		topic.setSubmittime(new Date());
		topic.setForumid(forumid);
		//从session获取用户名字
		User user = (User)sessionMap.get(AuthenticationInterceptor.USER_SESSION_KEY);
		topic.setAuthor(user.getUsername());
		dao.intert(topic);
		return SUCCESS;
	}
	
	//删除话题
	public String del()throws Exception{
		dao.delete(id);
		return "admin";
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Integer getForumid() {
		return forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TopicDto> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicDto> topicList) {
		this.topicList = topicList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getSubmittime() {
		return submittime;
	}

	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}

	public void setSession(Map session) {
		this.sessionMap = session;		
	}

}
