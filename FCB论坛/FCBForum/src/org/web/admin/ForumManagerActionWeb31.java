package org.web.admin;

import java.util.List;

import org.dao.IForumDao;
import org.dao.UserDao;
import org.dao.impl.ForumDaoImpl;
import org.dao.impl.UserDaoImpl;
import org.model.Forum;
import org.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class ForumManagerActionWeb31 extends ActionSupport {
	
	//ʵ����dao
	IForumDao dao = new ForumDaoImpl();
	
	UserDao userDao = new UserDaoImpl();
	
	private Forum forum;
	
	public List<Forum> forums;
	
	public List<User> users;
	
	public String forumname;
	
	public int id;
	
	//������̳
	public String save()throws Exception{
		Forum forum = new Forum();
		forum.setForumname(forumname);
		dao.insert(forum);
		return SUCCESS;
	}
	
	//��̳�б�
	public String list()throws Exception{
		forums = dao.getAll();
		return "list";
	}
	
	//�༭��̳
	public String edit()throws Exception{
		forum = dao.getByID(id);
		//�����б��е�������Ա
		users = userDao.getAll(User.class);
		return "edit";
	}
    
	//ɾ����̳
	public String del()throws Exception{
		dao.delete(id);
		return SUCCESS;
	}
	
	public String update()throws Exception{
		dao.update(forum);
		return SUCCESS;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
