<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		�û���¼
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header.jsp"%>
	<s:actionerror/>
	<s:form action="UserLogin" >
			<h3 align="center">FCB������̳����ӭ�㣡</h3>
			<table border="0" cellspacing="2" cellpadding="2" width="25%" align="center">
				<tr>
					<td width="60%" colspan="2">
						<s:textfield name="username" key="username"/>
					</td>
				</tr>
				<tr>
					<td width="60%" colspan="2">
						<s:password name="password" key="password"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit name="submit" align="center" value="��¼" theme="simple"></s:submit>
						<s:reset align="center" value="����" theme="simple"></s:reset>
					</td>					
				</tr>
				<tr>
					<td width="60%" colspan="2">
						<A href="registrationWeb31.jsp" theme="simple">
							ע��
						</A>
					</td>
				</tr>
			</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>
