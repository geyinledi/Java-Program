<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		��̳�б�
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<%@ include file="/common/header2.jsp"%>
<body>
	<table width="80%" border="1" align="center">
		<tr align="center" bgcolor="#00CCFF">
			<td width="33%">
				<a href="../admin/forumcreateWeb31.jsp">
					������̳
				</a>
			</td>
			<td width="34%">
				<A href="adminindexWeb31.jsp">
					��ҳ&nbsp;
				</A>
			</td>
			<td width="33%">
				<A href="<s:url action="admin/AdminLogout"/>">
					ע����¼&nbsp;
				</A>
			</td>
		</tr>
		<tr align="center">
			<td colspan="3">
				��̳����
			</td>
		</tr>
		<tr align="center" bgcolor="#00CCFF">
			<td>
				��̳��
			</td>
			<td>
				������̳��Ϣ
			</td>
			<td>
				ɾ����̳
			</td>
		</tr>
		<s:iterator value='forums'>
		<tr align="center">
			<td>
				<s:property value="forumname"/>
			</td>
			<td>
				<a href="<s:url action='admin/Forumedit'><s:param name="id" value="id"/></s:url>">�༭</a>
			</td>
			<td>
				<a href="<s:url action='admin/Forumdel'><s:param name="id" value="id"/></s:url>">ɾ��</a>
			</td>
		</tr>
		</s:iterator>
	</table>
	<%@ include file="/common/footer.jsp"%>
</body>

