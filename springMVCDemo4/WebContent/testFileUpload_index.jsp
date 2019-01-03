<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>使用MultipartResolver测试文件上传</h1>
	
	<form action="testFileUplad/method1" method="post" enctype="multipart/form-data">
	
		File : <input type="file" name="file" /><br/>
		Desc : <input type="text" name="desc" /><br/>
		<input type="submit" value="上传" />
		
	</form>

</body>
</html>