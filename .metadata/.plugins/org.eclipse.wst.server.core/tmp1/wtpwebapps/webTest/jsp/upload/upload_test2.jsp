<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试上传</title>
</head>
<body>
	<form action="/webTest/servlet/uploadServlet2" method="post" enctype="multipart/form-data">
		Username: <input type="text" name="username" /><br/>
		Password: <input type="password" name="password" /><br/>
			File: <input type="file" name="file1" /><br/>
		<input type="submit" value="提交" />
	</form>
</body>
</html>