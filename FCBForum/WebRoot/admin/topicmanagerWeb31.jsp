<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		主题列表
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<%@ include file="/common/header2.jsp"%>
<body>
	<table width="80%" border="1" align="center">
		<tr bgcolor="#00CCFF">
			<td colspan="3" align="right">
				<A href="adminindexWeb31.jsp">
					首页
				</A>
				&nbsp;
				<A href="<s:url action="admin/AdminLogout"/>">
					注销登录
				</A>
				&nbsp;
			</td>
		</tr>
		<tr align="center">
			<td colspan="3">
				主题管理
			</td>
		</tr>
		<tr align="center" bgcolor="#00CCFF">
			<td width="50%">
				文章标题
			</td>
			<td width="36%">
				作者
			</td>
			<td width="14%">
				删除
			</td>
		</tr>
	    <s:iterator value="topics">
		<tr align="center">
			<td>
				<s:property value="title"/>
			</td>
			<td>
				<s:property value="author"/>
			</td>
			<td>
				<a href="<s:url action="user/Topicdel"><s:param name="id" value="id"/></s:url>">
					删除
				</a>
			</td>
		</tr>
		</s:iterator>
		<tr align="center">
			<td colspan="3">
				<form  action="">
					<input type="text" name="title" size="15" maxlength="50">
					<input type="submit" name="Submit" value="提交">
					<input type="reset" name="Submit2" value="重置">
				</form>
			</td>
		</tr>
	</table>
	<%@ include file="/common/footer.jsp"%>
</body>

