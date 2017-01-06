package org.web.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.dao.UserDao;
import org.dao.impl.UserDaoImpl;
import org.model.User;
import org.web.interceptor.AuthenticationInterceptor;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginActionWeb31 extends ActionSupport implements SessionAware{
	
	//实例化UserDao
	UserDao dao = new UserDaoImpl();
	
	private String username;
	
	private String password;
	
	private Map session;
	
	public String execute()throws Exception{
		
		//判断用户是否管理员
		User user = dao.isValidAdmin(username, password);		
		if(user!=null){
			session.put(AuthenticationInterceptor.USER_SESSION_KEY, user);
			return SUCCESS;	
		}else{
			addActionError("你没有管理员权限");
			return INPUT;
		}		
	}

	public void  execute1()  
    {  	
		System.out.println("execute1");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("debug");
		//设置返回内容类型
		response.setContentType("text/xml;charset=UTF-8");
		System.out.println("debug");
		//禁止IE缓存
		response.setHeader("Cache-Control", "no-cache");
		System.out.println("debug");
		try {
			//response.getWriter().print("success");
			if (!(dao.isValidAdmin(username, password) == null)){
				response.getWriter().print("welcome");
				System.out.println("debug3");
			}else{
				response.getWriter().print("error");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("debug4");
		}
		System.out.println("debug2");
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
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}
