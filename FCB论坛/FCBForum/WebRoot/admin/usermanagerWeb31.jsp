<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		用户管理
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header2.jsp"%>
	<div align="center">
		<table width="80%" border="1" align="center">
			<tr align="right">
				<td colspan="4">
					<A href="adminindexWeb31.jsp">
						管理员菜单&nbsp;
					</A>
					<A href="useraddWeb31.jsp">
						新增用户&nbsp;
					</A>
					<A href="<s:url action="admin/AdminLogout"/>">
						注销登录&nbsp;
					</A>
				</td>
			</tr>
			<tr align="center">
				<td colspan="4">
					用户管理
				</td>
			</tr>
			<tr align="center" bgcolor="#0099CC">
				<td width="25%">
					用户名
				</td>
				<td width="25%">
					级别
				</td>
				<td width="25%">
					编辑
				</td>
				<td width="25%">
					删除
				</td>
			</tr>
			<s:iterator value="dtolist">
			<tr align="center">
				<td>
					<s:property value="username"/>
				</td>
				<td>
					<s:property value="gradeName"/>
				</td>
				<td>
					<a href="<s:url action="Useredit" ><s:param name="username" value="username"/></s:url>">
						编辑
					</a>
				</td>
				<td>
					<a href="<s:url action="Userdel" ><s:param name="username" value="username"/></s:url>">
						删除
					</a>
				</td>
			</tr>
			</s:iterator>
			<tr bgcolor="#0099CC">
				<td colspan="4">
					<s:form action="/admin/Usersearch.action">
						请输入您要搜索的用户名：
						<input type="text" name="username" size="15" maxlength="50">
						<input type="submit" name="Submit" value="提交">
					</s:form>
				</td>
			</tr>
		</table>
	</div>
		<%@ include file="/common/footer.jsp"%>
</body>

