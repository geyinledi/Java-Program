<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		新增论坛
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header2.jsp"%>
	<s:form action="Forumsave" namespace="/admin">
		<table width="80%" border="1" align="center">
			<tr>
				<td align="center" bgcolor="#00CCFF">
					新增论坛
				</td>
			</tr>
			<tr>
				<td align="center">
					论坛名：
					<input type="text" name="forumname" size="20" maxlength="50">
					<input type="submit" name="Submit" value="提交">
				</td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>

