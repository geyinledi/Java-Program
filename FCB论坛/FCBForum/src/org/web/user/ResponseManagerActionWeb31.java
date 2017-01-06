package org.web.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.dao.IResponseDao;
import org.dao.impl.ResponseDaoImpl;
import org.dto.ResponseDto;
import org.model.Response;
import org.model.User;
import org.web.interceptor.AuthenticationInterceptor;

import com.opensymphony.xwork2.ActionSupport;

public class ResponseManagerActionWeb31 extends ActionSupport implements SessionAware{
	
	//ʵ����IResponseDao
	IResponseDao dao = new ResponseDaoImpl();
	
	private List<ResponseDto> list;
	
	private Map sessionMap;
	
	private int topicid;
	
	private String title;
	
	private String content;
	
	private String author;
	
	private Date submittime;
	
	private int id;

	
	public String list()throws Exception{
		ResponseDto dto = new ResponseDto();
		List<ResponseDto> dtolist = new ArrayList<ResponseDto>();
		//ת��dtolist
		dto.convert(dao.getByTopic(id), dtolist);
		list = dtolist;
		return "list";
	}
	
	//ת���ظ�ҳ
	public String add()throws Exception{
		//��request��ȡtopicid���������ڱ����»���ʱ����topicid
		HttpServletRequest request = ServletActionContext.getRequest();		
		topicid = Integer.parseInt(request.getParameter("id"));
		return "add";
	}

	/**
	 *����ظ�
	 * @return
	 * @throws Exception
	 */
	public String save()throws Exception{
		Response response = new Response();
		response.setContent(content);
		response.setSubmittime(new Date());
		response.setTitle(title);
		response.setTopicid(topicid);
		//ȡ��session�ĵ�½�û�����
		User user = (User)sessionMap.get(AuthenticationInterceptor.USER_SESSION_KEY);
		response.setAuthor(user.getUsername());
		dao.save(response);
		return SUCCESS;
	}
	public List<ResponseDto> getList() {
		return list;
	}

	public void setList(List<ResponseDto> list) {
		this.list = list;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Map session) {
		this.sessionMap = session;		
	}

}
