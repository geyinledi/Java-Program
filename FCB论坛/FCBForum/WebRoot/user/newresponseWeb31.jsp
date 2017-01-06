<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		发表文章
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header.jsp"%>
    <!-- 绑定action：Responseadd -->
	<s:form action="Responseadd">
	 <s:hidden name="topicid"/>
		<table width="68%" border="0" align="center">
			<tr align="center">
				<td>
					<A href="javascript:history.go(-1);">
						返回主题
					</A>
				</td>
			</tr>
		</table>
		<table width="68%" border="1" align="center">
			<tr align="center">
				<td colspan="2">
					发表文章
				</td>
			</tr>
			<tr>
				<td width="15%" align="right">
					标题：
				</td>
				<td width="85%">
					<INPUT class=input2 maxLength=100 size=80 name=title>
				</td>
			</tr>
			<tr>
				<td height="285" align="right">
					内容：
				</td>
				<td>
					<textarea class=input2 name=content rows=20 cols=80></textarea>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<s:submit action="Responsesave" name="submit"></s:submit>
					<s:reset></s:reset>
				</td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>
