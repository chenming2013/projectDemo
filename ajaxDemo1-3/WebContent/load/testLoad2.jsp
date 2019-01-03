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
			//url+selector是只选择部分元素
			//下面的url的意思是在div中加载 h2 下面的 a元素
			var url = this.href + " h2 a";
			//加上time,防止浏览器缓存
			var data = {"time":new Date()};
			
			//任何一个HTML节点都可以使用load()方法来加载Ajax,结果将直接插入这个HTML节点中
			$(content).load(url,data);
			
			return false;
		})
		
	})
</script>
</head>
<body>

	<!--  
		这是测试 AJax 的 load() 方法,但只需加载目标HTML的部分元素
	-->
	
	<ul>
		<li><a href="files/andy.html">Andy</a></li>
		<li><a href="files/richard.html">Richard</a></li>
		<li><a href="files/jeremy.html">Jeremy</a></li>
	</ul>
	<div id="content"></div>

</body>
</html>