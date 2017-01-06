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
	
	<!--<link rel="stylesheet" type="text/css" href="myStyleClass.css">-->
	

  </head>
  
  <frameset rows="100%">
		<!--<frame name="top" src="" noresize>-->
		<frameset cols="15%,85%">
			<frame name="left" src="admin/adminleftWeb31.jsp"> 
			<frame name="main" src="admin/usermanagerWeb31.jsp">
		</frameset> 
	</frameset>
</html>
