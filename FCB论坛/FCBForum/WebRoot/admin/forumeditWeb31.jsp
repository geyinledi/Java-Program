<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		编辑论坛
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<%@ include file="/common/header2.jsp"%>
<body>
	<s:form  action="Forumupdate">
		<s:hidden name="forum.id"/>
		<table width="60%" border="2" align="center" cellpadding="1" cellspacing="1">
			<tr >
			   
				<td align="right" colspan="2" >
					<A href="adminindexWeb31.jsp">
						首页
					</A>
					&nbsp;
					<A href="adminlogoff.do">
						注销登录
					</A>
					
				</td>
			</tr>
			<tr>
			    <td align="left" width="30%" colspan="2" >
				  修改论坛信息	
				</td>			
			</tr>
			<tr>
			  <td align="left" width="10%">
		      </td>
			  <td align="left" width="90%">
		         <s:textfield name="forum.forumname" label="论坛"/>	
		      </td>	     
		    </tr>
			<tr>
				<td align="center" colspan="2">							
						版主：
						<select name=manager size=1>
							<option value=""></option>
							
						</select>						
						
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<INPUT class=buttonface type=submit value=" 确 定 ">
				    <INPUT class=buttonface type=reset value=" 清 除 ">
				</td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>

