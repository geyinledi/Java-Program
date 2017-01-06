<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		管理选项页面
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header2.jsp"%>
	<div align="center">
		<h2>
			<a href="<s:url action='Userlist'/>">用户管理</a>
		</h2>
		<h2>
			<a href="<s:url  action="Forumlist"/>">论坛管理</a>
		</h2>
		<h2>
			<a href="<s:url  action="Topiclist"/>">主题管理</a>
		</h2>
	</div>
	<%@ include file="/common/footer.jsp"%>
</body>
