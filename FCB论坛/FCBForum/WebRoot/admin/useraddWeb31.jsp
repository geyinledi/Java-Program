<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		注册用户
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header2.jsp"%>
	<table width="68%" border="0" align="center">
		<tr align="center">
			<td>
				<A href="javascript:history.go(-1);">
					返回上一页
				</A>
			</td>
		</tr>
	</table>
	<s:form action="Useradd">
		<table width="72%" border="1" align="center">
			<tr>
				<td width="21%">
					用户名:
				</td>
				<td width="79%">
					<INPUT class=input2 maxLength=20 name=username>
					&nbsp;*&nbsp;（由英文字母、数字、汉字和下划线&quot;_&quot;组成）
				</td>
			</tr>
			<tr>
				<td>
					密码:
				</td>
				<td>
					<INPUT class=input2 type=password maxLength=16 name=password>
					&nbsp;*&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					确认密码:
				</td>
				<td>
					<INPUT class=input2 type=password maxLength=16 name=password2>
					&nbsp;*&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					性别：
				</td>
				<td>
					<input name="sex" type="radio" value="1">
					男
					<input name="sex" type="radio" value="0" checked>
					女
				</td>
			</tr>
			<tr>
				<td>
					电子邮箱：
				</td>
				<td>
					<INPUT class=input2 maxLength=40 name=email>
					&nbsp;*&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					ICQ：
				</td>
				<td>
					<INPUT class=input2 maxLength=40 name=icq>
				</td>
			</tr>
			<tr>
				<td>
					签名档：
				</td>
				<td>
					<TEXTAREA class=input2 name=signature rows=10 cols=50></TEXTAREA>
				</td>
			</tr>
			<tr>
				<td>
					<s:submit name="submit"></s:submit>
				</td>
				<td>
					<s:reset></s:reset>
				</td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>
