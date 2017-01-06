<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>
			主题列表
		</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/screen.css"/>
	</head>

	<body>
	<%@ include file="/common/header.jsp"%>
	<!--

		<table width="94%" border="1" align="center">
			<tr align="left">
				<td colspan="5">
				<table width="97%" border="0" align="center">
						<tr>
							<td>
								欢迎你访问论坛：FCB足球论坛
							</td>
							<td align="right">
								<A href="<s:url action="user/IndexBBS"/>">
									首页
								</A>&nbsp;
								<A href="<s:url action="user/UserLogout"/>">
									注销登录
								</A>&nbsp;
								<A href="<s:url action="user/Topicadd" ><s:param name="forumid" value="forumid"></s:param></s:url>">
									发新话题
								</A>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr align="center" bgcolor="#009999">
				<td colspan="5">t
					
				</td>
			</tr>

	      --><div align="center">
	      		<A href="<s:url action="user/IndexBBS"/>">
					首页
				</A>&nbsp;
				<A href="<s:url action="user/UserLogout"/>">
					注销登录
				</A>&nbsp;
				<A href="<s:url action="user/Topicadd" ><s:param name="forumid" value="forumid"></s:param></s:url>">
					发新话题
				</A>
			<display:table name="topicList"  id="topic" cellspacing="0"  
	            cellpadding="0" pagesize="5" class="table1" requestURI="topicList.action">  
	            <display:column title="话题">
					<A href="user/Responselist.action?id=${topic.id}">${topic.title}</A>
				</display:column>
	            <display:column property="author" title="作者"/>  
	            <display:column property="submittime" title="发布时间" />  
	            <display:column property="resCount" title="回复数" sortable="true"/>  
	            <display:column property="lastTime" title="最后回复时间" />  
	        </display:table>
		</div>

	<%@ include file="/common/footer.jsp"%>
	</body>
</html>
