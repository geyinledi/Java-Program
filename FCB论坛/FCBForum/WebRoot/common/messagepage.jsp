<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>

<html:html>
<head>
	<title>
		消息页面
	</title>
</head>

<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">

<body>

	<%@ include file="/common/header.jsp"%>

	<center>
	<html:errors />
		<h2>
			<a href="javascript:history.go(-1)">
				返回上一页
			</a>
		</h2>
	</center>
	<%@ include file="/common/footer.jsp"%>
</body>
</html:html>
