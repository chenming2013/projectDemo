<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>

	<h1>测试异常</h1>

	<p>
		在 testException_index.jsp 页面中,当我们传递到映射方法的参数为0时,会发生一个 ArithmeticException: /by zero
	</p>
	<p>
		那么为了程序走通,我们就需要捕捉这个异常
	</p>
	
	
	<a href="testException2/method1?i=5">当传递的 i!=0 的时候,程序正常</a>  <br/>

	<a href="testException2/method1?i=0">当传递的 i=0 的时候,程序出异常,但是我们捕获了</a>  <br/>
	
	

</body>
</html>