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
		
		注意:
			testRequestMappingOfMethod/method1  最前面的一定不能有 /,否则就无法请求到Controller
		
	--%>
	<a href="method1">测试@RequestMapping注解用在方法上(类上没有该注解),调用method1()...</a>

</body>
</html>