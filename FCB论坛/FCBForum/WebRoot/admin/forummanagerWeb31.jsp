<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		论坛列表
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<%@ include file="/common/header2.jsp"%>
<body>
	<table width="80%" border="1" align="center">
		<tr align="center" bgcolor="#00CCFF">
			<td width="33%">
				<a href="../admin/forumcreateWeb31.jsp">
					新增论坛
				</a>
			</td>
			<td width="34%">
				<A href="adminindexWeb31.jsp">
					首页&nbsp;
				</A>
			</td>
			<td width="33%">
				<A href="<s:url action="admin/AdminLogout"/>">
					注销登录&nbsp;
				</A>
			</td>
		</tr>
		<tr align="center">
			<td colspan="3">
				论坛管理
			</td>
		</tr>
		<tr align="center" bgcolor="#00CCFF">
			<td>
				论坛名
			</td>
			<td>
				更改论坛信息
			</td>
			<td>
				删除论坛
			</td>
		</tr>
		<s:iterator value='forums'>
		<tr align="center">
			<td>
				<s:property value="forumname"/>
			</td>
			<td>
				<a href="<s:url action='admin/Forumedit'><s:param name="id" value="id"/></s:url>">编辑</a>
			</td>
			<td>
				<a href="<s:url action='admin/Forumdel'><s:param name="id" value="id"/></s:url>">删除</a>
			</td>
		</tr>
		</s:iterator>
	</table>
	<%@ include file="/common/footer.jsp"%>
</body>

