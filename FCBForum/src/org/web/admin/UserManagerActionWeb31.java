package org.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.dao.IForumDao;
import org.dao.UserDao;
import org.dao.impl.ForumDaoImpl;
import org.dao.impl.UserDaoImpl;
import org.dto.UserDto;
import org.model.Forum;
import org.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * �û�����Action
 * @author songjun
 */
@Validation() 
public class UserManagerActionWeb31 extends ActionSupport {

	// �½��û�Dao�Է������ݿ�
	UserDao dao = new UserDaoImpl();
	
	IForumDao forumDao = new ForumDaoImpl();

	private String username;

	private String password;

	private String sex;

	private String email;

	private String icq;
	
	private String signature;

	private String grade;
	
	//��̳ID
	private Integer id;

	private User user;
	
	private List<User> users = new ArrayList<User>();
	
	private List<UserDto> dtolist = new ArrayList<UserDto>();
	
	private List<Forum> forums = new ArrayList<Forum>();
	
	private void addUser() {
		User user = new User();	
		user.setEmail(email);
		user.setGrade("0");
		user.setUsername(username);
		user.setPassword(password);
		user.setSignature(signature);
		user.setSex(sex);
		user.setIcq(icq);
		// �����û�
		dao.saveUser(user);
	}
	// �����û�
	public String add() throws Exception {
		addUser();
		return "add";
	}

	//�����û�
	public String register() throws Exception {
		addUser();
		return "register";
	}
	
	public String del() throws Exception {
		// ������ɾ���û�
		dao.deleteByName(username);
		return SUCCESS;
	}
	
	//�༭�û�
	public String edit()throws Exception{
		user = dao.getByName(username);
		//��̳�б�
		forums = forumDao.getAll();
		return "edit";
	}

	/*
	 * �����û���Ϣ
	 */
	public String update() throws Exception {
		dao.update(user);
		Forum forum = forumDao.getByID(id);
		//���û������µ�froum��
		forum.setManager(user.getUsername());
		forumDao.update(forum);
		return SUCCESS;
	}

	// ȡ������user��list
	public String list() throws Exception {
		UserDto dto = new UserDto();
		//ʹ��dtoת��list
		dto.convert(dao.getAll(User.class), dtolist);
		return "list";

	}
	
	public String search()throws Exception{
		//�������������û�
		users = dao.findByName(username);
		UserDto dto = new UserDto();
		//ʹ��dtoת��list
		dto.convert(users, dtolist);
		return "list";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIcq() {
		return icq;
	}

	public void setIcq(String icq) {
		this.icq = icq;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<UserDto> getDtolist() {
		return dtolist;
	}

	public void setDtolist(List<UserDto> dtolist) {
		this.dtolist = dtolist;
	}

}
