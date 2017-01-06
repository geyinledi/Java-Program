<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		论坛主页
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header.jsp"%>
	<s:form action="IndexBBS">
	<table width="97%" border="1" align="center">
		<tr align="left">
			<td colspan="4">
				<table width="97%" border="0" align="center">
					<tr>
						<td>
							欢迎你访问论坛：FCB足球论坛
							
						</td>
						<td align="right">
							<A href="<s:url action="user/UserLogout"/>">
								注销登录&nbsp;
							</A>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr align="center" bgcolor="#009999">
			<td colspan="4">
				FCB BBS
			</td>
		</tr>
		<tr align="center">
			<td width="19%">
				论坛
			</td>
			<td width="10%">
				主题数
			</td>
			<td width="59%">
				论坛最新帖子
			</td>
			<td width="15%">
				版主
			</td>
		</tr>
		
	    <s:iterator value="forums">
		<tr align="center">
			<td width="25%">
				<A href="<s:url action="user/TopiclistByForum"><s:param name="id" value="id"/></s:url>" target=_self>
				   <s:property value="forumname"/>	
				</A>
			</td>
			<td width="10%" align="center">
				  <s:property value="topicCount" />	
			</td>
			<td width="59%">
				
			   <s:property value="newTopic"/>	
								
			   <FONT color=#9a0112></FONT>			
			</td>
			<td width="9%" align="center">
				<s:property value="manager"/>
			</td>
		</tr>
	  </s:iterator>		 
	</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>
