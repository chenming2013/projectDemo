<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>测试以ISO8859-1提交表单</title>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath }/EncodeServlet2">
			name: <input type="text" name="username" />
			<input type="submit" vlaue="提交" />
		</form>
	</body>
</html>