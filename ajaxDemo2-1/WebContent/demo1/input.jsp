<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function()
	{
		document.getElementById("sendButton").addEventListener("click",sendEcho,false);
	}


	//声明的时候根本什么意义都不能表述,因为不知道它的类型
	var xmlHttpRequest;   //定义一个Ajax的核心处理对象
	//一般都会单独定义一个操作函数,这个函数的主要功能是进行XMLHttpRequest对象的实例化
	function createXmlHttpRequest()
	{
		if(window.XMLHttpRequest)  //表示此时的浏览器是非IE浏览器
		{
			xmlHttpRequest = new XMLHttpRequest();  //直接进行对象实例化
		}else
		{
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHttp");
		}
	}
	
	function sendEcho(){
		//取出输入的数据
		var info = document.getElementById("info").value;
		if(info!=null && info!="")
		{
			//创建XMLHttpRequest对象
			var method = "POST";
			var url = "EchoServlet?msg="+info;
			xmlHttpRequest.open(method,url);
			
		}
		document.getElementById("info").value = "";
	}
	
</script>
</head>
<body>
	
	<div id="inputDiv">
		<input type="text" name="info" id="info" />
		<input type="button" id="sendButton" value="发送信息" />
	</div>
	<!-- 后面返回的数据在下面的div中显示 -->
	<div id="echoDiv"></div>
	
</body>
</html>