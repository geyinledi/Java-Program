<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		��̳��ҳ
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
							��ӭ�������̳��FCB������̳
							
						</td>
						<td align="right">
							<A href="<s:url action="user/UserLogout"/>">
								ע����¼&nbsp;
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
				��̳
			</td>
			<td width="10%">
				������
			</td>
			<td width="59%">
				��̳��������
			</td>
			<td width="15%">
				����
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
