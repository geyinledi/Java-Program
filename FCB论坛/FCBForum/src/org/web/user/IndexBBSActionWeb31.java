package org.web.user;

import java.util.ArrayList;
import java.util.List;

import org.dao.IForumDao;
import org.dao.impl.ForumDaoImpl;
import org.dto.ForumDto;

import com.opensymphony.xwork2.ActionSupport;

public class IndexBBSActionWeb31 extends ActionSupport{
	
	//ʵ����IForumDao
	IForumDao dao = new ForumDaoImpl();
	
	private List<ForumDto> forums;
	
	public String list()throws Exception{	
		ForumDto dto = new ForumDto();
		List <ForumDto> dtolist = new ArrayList<ForumDto>();
		//��list�е�forumת��ForumDto
		dto.convert(dao.getAll(), dtolist);
		forums = dtolist;
		return SUCCESS;
	}

	public List<ForumDto> getForums(){
		return forums;
	}

	public void setForums(List<ForumDto> forums){
		this.forums = forums;
	}

}
