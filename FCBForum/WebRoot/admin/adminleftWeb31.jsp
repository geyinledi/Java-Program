<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminframeWeb31.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="images/myStyleClass.css">


  </head>
  
  <body>
    <h3>管理员菜单</h3>
    <h4><a href="Userlist.action" target="main" >&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></h4>
    <h4><a href="Forumlist.action" target="main" > &nbsp;&nbsp;&nbsp;&nbsp;论坛管理</a></h4>
    <h4><a href="Topiclist.action" target="main" >&nbsp;&nbsp;&nbsp;&nbsp;主题管理</a></h4>
  </body>
</html>