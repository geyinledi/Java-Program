package org.web.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.model.User;
import org.web.interceptor.AuthenticationInterceptor;

import com.opensymphony.xwork2.ActionSupport;

public class UserLogoutActionWeb31 extends ActionSupport implements SessionAware{
	
	private Map session;
	
	public String execute()throws Exception{
		
		//从session取出登陆用户
		User user =(User)session.get(AuthenticationInterceptor.USER_SESSION_KEY);		
		if(user!=null){
			//从session删除用户
			session.remove(AuthenticationInterceptor.USER_SESSION_KEY);
			addActionError("已注销");
		}
		return INPUT;	
	}
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}

