<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>测试SpringMVC 自定义类型转换</h1>
	<p>
		以User为例,之前写的form都是将每一个User的属性都设成一个 input 输入框,
		当提交表单的时候,将每一个输入框的值都赋给User的属性
	</p>
	<p style="font-color:red">
		然而,如果一个 input 输入框中输入了User的所有属性,那么怎么赋给User的各个属性呢？
	</p>
	
	<form action="testConversionServiceConverter/method1" method="post">
		<p>注: 下面的输入框中输入User的所有属性：</p>
		<p>格式: username-password-email-age</p>
		
		User : <input type="text" name="user"><br/>
		<input type="submit" value="提交" />
	</form>

</body>
</html>