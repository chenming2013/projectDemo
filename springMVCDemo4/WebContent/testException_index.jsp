<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>测试异常</h1>
	
	<p>当我们传递到映射方法的参数为0时,会发生一个 ArithmeticException: /by zero</p>
	
	
	<a href="testException/method1?i=5">当传递的 i!=0 的时候,程序正常</a>  <br/>

	<a href="testException/method1?i=0">当传递的 i=0 的时候,程序出异常</a>  <br/>
	
	

</body>
</html>