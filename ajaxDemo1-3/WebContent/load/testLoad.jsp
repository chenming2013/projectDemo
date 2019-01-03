<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试 Ajax的load()方法</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("a").on("click",function(){
			var url = this.href;
			//加上time,防止浏览器缓存
			var data = {"time":new Date()};
			$(content).load(url,data);
			
			return false;
		})
		
	})
</script>
</head>
<body>

	<!--  
		这是测试 AJax 的 load() 方法
	-->
	
	<a href="files/helloAjax.txt">Hello Ajax</a>
	<div id="content"></div>

</body>
</html>