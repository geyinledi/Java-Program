<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		�����б�
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<%@ include file="/common/header2.jsp"%>
<body>
	<table width="80%" border="1" align="center">
		<tr bgcolor="#00CCFF">
			<td colspan="3" align="right">
				<A href="adminindexWeb31.jsp">
					��ҳ
				</A>
				&nbsp;
				<A href="<s:url action="admin/AdminLogout"/>">
					ע����¼
				</A>
				&nbsp;
			</td>
		</tr>
		<tr align="center">
			<td colspan="3">
				�������
			</td>
		</tr>
		<tr align="center" bgcolor="#00CCFF">
			<td width="50%">
				���±���
			</td>
			<td width="36%">
				����
			</td>
			<td width="14%">
				ɾ��
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
					ɾ��
				</a>
			</td>
		</tr>
		</s:iterator>
		<tr align="center">
			<td colspan="3">
				<form  action="">
					<input type="text" name="title" size="15" maxlength="50">
					<input type="submit" name="Submit" value="�ύ">
					<input type="reset" name="Submit2" value="����">
				</form>
			</td>
		</tr>
	</table>
	<%@ include file="/common/footer.jsp"%>
</body>

