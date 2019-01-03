<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>测试 方法参数为POJO对象</h1>
	<form action="testPojo/method1" method="post" >
		
		Username: <input type="text" name="username" /><br/>
		Password: <input type="password" name="password" /><br/>
		Email: <input type="text" name="email" /><br/>
		Age: <input type="text" name="age" /><br/>
		
		<!-- 级联属性: Address类中的属性 -->
		Province: <input type="text" name="address.province" /><br/>
		City: <input type="text" name="address.city" /><br/>
				
		<input type="submit" value="提交" />
		
	</form>
	

</body>
</html>