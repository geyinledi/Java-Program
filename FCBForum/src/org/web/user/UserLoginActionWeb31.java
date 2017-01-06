package org.web.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.dao.UserDao;
import org.dao.impl.UserDaoImpl;
import org.model.User;
import org.web.interceptor.AuthenticationInterceptor;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginActionWeb31 extends ActionSupport implements SessionAware{

	//ʵ����UserDao
	UserDao dao = new UserDaoImpl();
	
	private String username;
	
	private String password;
	
	private Map session;
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
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	public void validate(){
		if("".equals(username)||this.username==null){
			this.addFieldError("username",getText("username����"));
		}
		if("".equals(password)||this.password==null){
			this.addFieldError("password",getText("password����"));
		}
		
	}

	public String execute()throws Exception{
		
		//�ж�һ���û����û���������
		User user = dao.isValidUser(username, password);		
		if(user!=null){
			session.put(AuthenticationInterceptor.USER_SESSION_KEY, user);
			return SUCCESS;	
		}else{
			addActionError("�û��������벻ƥ�䣡");
			return INPUT;
		}		
	}
}

