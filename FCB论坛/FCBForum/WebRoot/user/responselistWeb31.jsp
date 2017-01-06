<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<base href="<%=basePath%>">
	<title>
		帖子列表
	</title>
	<link rel="stylesheet" type="text/css" href="css/screen.css"/>
</head>

<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
	<%@ include file="/common/header.jsp"%>
	<table width="97%" border="1" align="center">
		<tr>
			<td colspan="2">
				<table width="97%" border="0" align="center">
					<tr>
						<td>
							欢迎你访问论坛：FCB足球论坛
						</td>
						<td align="right">
							<A href="<s:url action='user/IndexBBS'/>">
								首页
							</A>&nbsp;
							<A href="<s:url action="user/UserLogout"/>">
								注销登录
							</A>&nbsp;
							<A href="<s:url action='user/Responseadd'></s:url>">
								回复主题
							</A>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<table width="100%" border="0" bordercolor="#FFFFCC">
					<s:iterator value="list">
					<tr bgcolor="#3366CC">
						<td width="22%">
							作者：<s:property value="author"/>
						</td>
						<td width="78%">
							标题：<s:property value="title"/>
					  </td>
					</tr>					
					<tr bgcolor="#CCCCCC">
						<td>						
							等级：<s:property value="gradeName"/>
							<BR>
							发表时间:<s:property value="submittime"/>
					    </td>
						<td>
							<s:property value="content"/>
					    </td>
				    </tr>
				    </s:iterator>
			  </table>
			</td>
		</tr>
	
</table>
	<%@ include file="/common/footer.jsp"%>
</body>

