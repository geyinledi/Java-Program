<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>
		管理员登录
	</title>
	
	 <script type="text/javascript"><!--
		var XHR = false;
		function CreateXHR(){

			try{
				XHR = new ActiveXObject("msxm12.XMLHTTP");
			}catch(e1){
				try{
					XHR = new ActiveXObject("microsoft.XMLHTTP");
				}catch(e2){
					try{
						XHR = new XMLHttpRequest();
					}catch(e3){
						XHR = false;
					}
					
				}
				
			}
		}
		function sendRequest(){
			CreateXHR();
			if(XHR){
				var username = document.getElementById("username").value;
				alert("username："+username);
				var password = document.getElementById("password").value;
				alert("password："+password)
				var uri = "http://127.0.0.1:8080/FCBForum/AdminLoginWeb31.action?username="+username+"&password="
				+password;
				XHR.open("GET", uri, true);
				XHR.onreadystatechange = resultHander;
				XHR.send(null);
			}
		}
		
		function resultHander(){
			if(XHR.readyState == 4){
				if(XHR.status == 200){
					var result = XHR.responseText;
					//alert(result);
					if(XHR.responseText == "welcome"){
						alert("欢迎，登录成功");
						self.location = "./adminframeWeb31.jsp";
					}
					else{
						alert("登录失败，用户名或密码错误");
						self.location = "./adminloginWeb31.jsp";
					}
				}
			}
		}
	--></script>
</head>
<link href="images/myStyleClass.css" rel="stylesheet" type="text/css">
<body>
    
	<%@ include file="/common/header2.jsp"%>
		<center>
		<h3 align="center">管理员登陆</h3>
			用户名：<input type="text" id="username"/><br>
			密码：<input type="text" id="password"/><br>
			<input type="button" value="ok" onclick="sendRequest()"/>
		</center>
	<%@ include file="/common/footer.jsp"%>
</body>
