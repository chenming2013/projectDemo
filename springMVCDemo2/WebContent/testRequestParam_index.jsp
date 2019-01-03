<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>测试 @RequestMapping 注解用在类上</title>
</head>
<body>

	<%-- 
		
		测试 @RequestParam 接收请求参数
		required属性: 该参数是否是必须的,true为必须的; false不为必须,意味可要可不要
			
	--%>
	
	<a href="testRequestParam/method1?id=1&name=chenming">测试 @RequestParam,两个参数都有 </a>

	
	<br/><br/>
	<a href="testRequestParam/method1?name=chenming">测试 @RequestParam,传递一个参数 </a>
	
	
	<br/><br/>
	<a href="testRequestParam/method2?name=chenmming">测试 @RequestParam, method2()方法接收的是int类型的参数,需要配置defaultValue参数</a>	
	
	
	
	
	
	
	
</body>
</html>