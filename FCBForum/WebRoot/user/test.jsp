<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/screen.css"/>
  </head>
  
  <body>
     <%  
            List test = new ArrayList(6);  
              
          
            for(int i = 0 ; i < 6 ; i++){  
                HashMap<String,String> map1 = new HashMap<String,String>();  
                String m = String.valueOf(i);  
                map1.put("id",m);  
                map1.put("name","foolfish"+m+" ");  
                map1.put("email","foolfish.chen@gmail.com ");  
                map1.put("description","Hello Hello ");  
                test.add(map1);  
            }  
              
            request.setAttribute("test", test);  
        %>  
        <div align="center">  
        <display:table name="test"  cellspacing="0"  
            cellpadding="0" pagesize="2" export="true" class="table1">  
            <display:column property="id" title="ID"  sortable="true"/>  
            <display:column property="name" title="Name" />  
            <display:column property="email" title="Email"/>  
            <display:column property="description" title="Comments" />  
        </display:table>  
        </div>  
	
  </body>
</html>
