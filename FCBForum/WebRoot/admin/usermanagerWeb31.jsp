<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		�û�����
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
						����Ա�˵�&nbsp;
					</A>
					<A href="useraddWeb31.jsp">
						�����û�&nbsp;
					</A>
					<A href="<s:url action="admin/AdminLogout"/>">
						ע����¼&nbsp;
					</A>
				</td>
			</tr>
			<tr align="center">
				<td colspan="4">
					�û�����
				</td>
			</tr>
			<tr align="center" bgcolor="#0099CC">
				<td width="25%">
					�û���
				</td>
				<td width="25%">
					����
				</td>
				<td width="25%">
					�༭
				</td>
				<td width="25%">
					ɾ��
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
						�༭
					</a>
				</td>
				<td>
					<a href="<s:url action="Userdel" ><s:param name="username" value="username"/></s:url>">
						ɾ��
					</a>
				</td>
			</tr>
			</s:iterator>
			<tr bgcolor="#0099CC">
				<td colspan="4">
					<s:form action="/admin/Usersearch.action">
						��������Ҫ�������û�����
						<input type="text" name="username" size="15" maxlength="50">
						<input type="submit" name="Submit" value="�ύ">
					</s:form>
				</td>
			</tr>
		</table>
	</div>
		<%@ include file="/common/footer.jsp"%>
</body>

