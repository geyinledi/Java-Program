<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		��̳��ҳ
	</title>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">

<body>
	<%@ include file="/common/header2.jsp"%>
	<s:form  action="Userupdate">
	 <s:hidden name="user.username"/>
	  <s:hidden name="user.password"/>
	   <s:hidden name="user.sex"/>
	    <s:hidden name="user.email"/>
	     <s:hidden name="user.icq"/>
	      <s:hidden name="user.signature"/>
		<table width="80%" border="1" align="center">
			<tr align="right">
				<td colspan="4">
					<A href="admin/adminindexWeb31.jsp">
						��ҳ&nbsp;
					</A>
					<A href="admin/adminlogoff.do">
						ע����¼&nbsp;
					</A>
				</td>
			</tr>
			<tr align="left">
				<td colspan="4">
					�޸��û�Ȩ��
				</td>
			</tr>
			<tr align="center">
				<td width="26%" align="left">
					�û�����
					<s:property value="user.username"/>
				</td>
				<td width="80%" colspan="" align="left">
					����
					<select size=1 name="user.grade">
						<option value="0">
							��ͨ�û�
						</option>
						<option value="1">
							����
						</option>
						<option value="2">
							����Ա
						</option>
					</select>
				</td>		
			</tr>
			<tr align="center">
				<td colspan="">
					<s:select label="������̳"
                              name="id"
                              list="forums"
                              listKey="id"
                              listValue="forumname"
                              multiple="false"                          
                              required="true"
                              value="%{{id}}"/>
				</td>
			</tr>
			<tr align="center">
				<td colspan="4">
					<INPUT class=buttonface type=submit value=" ȷ �� ">
					&nbsp;
					<INPUT class=buttonface type=reset value=" �� �� ">
				</td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/common/footer.jsp"%>
</body>