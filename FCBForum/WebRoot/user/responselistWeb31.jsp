<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<base href="<%=basePath%>">
	<title>
		�����б�
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
							��ӭ�������̳��FCB������̳
						</td>
						<td align="right">
							<A href="<s:url action='user/IndexBBS'/>">
								��ҳ
							</A>&nbsp;
							<A href="<s:url action="user/UserLogout"/>">
								ע����¼
							</A>&nbsp;
							<A href="<s:url action='user/Responseadd'></s:url>">
								�ظ�����
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
							���ߣ�<s:property value="author"/>
						</td>
						<td width="78%">
							���⣺<s:property value="title"/>
					  </td>
					</tr>					
					<tr bgcolor="#CCCCCC">
						<td>						
							�ȼ���<s:property value="gradeName"/>
							<BR>
							����ʱ��:<s:property value="submittime"/>
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

