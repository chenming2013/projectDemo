<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>使用Apache Commons组件测试Servlet文件上传(使用DiskFileUpload类进行上传,已过时不建议使用)</title>
</head>
<body>
	<h1>使用Apache Commons组件测试Servlet文件上传(使用DiskFileUpload类进行上传,已过时不建议使用)</h1>
	
	<form method="post" enctype="multipart/form-data" action="/webTest/servlet/uploadServlet1.do">
		作者 ：<input type="text" name="author" /><br/>
		来自 ：<input type="text" name="company" /><br/>
		文件1：<input type="file" name="file1" /><br/>
		文件2：<input type="file" name="file2" /><br/>
		<input type="submit" value="上传" />
	</form>
</body>
</html>