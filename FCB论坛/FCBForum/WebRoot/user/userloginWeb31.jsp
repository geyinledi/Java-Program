<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		ÓÃ»§µÇÂ¼
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header.jsp"%>
	<s:actionerror/>
	<s:form action="UserLogin" >
			<h3 align="center">FCB×ãÇòÂÛÌ³£¬»¶Ó­Äã£¡</h3>
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
						<s:submit name="submit" align="center" value="µÇÂ¼" theme="simple"></s:submit>
						<s:reset align="center" value="ÖØÖÃ" theme="simple"></s:reset>
					</td>					
				</tr>
				<tr>
					<td width="60%" colspan="2">
						<A href="registrationWeb31.jsp" theme="simple">
							×¢²á
						</A>
					</td>
				</tr>
			</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>
