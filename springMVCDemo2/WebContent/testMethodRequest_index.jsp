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
		
		测试@RequestMapping的method参数
		之前我们所写的 @RequestMapping("/testRequestMappingOfClass")其实是这样的 @@RequestMapping(vakue="/testRequestMappingOfClass")
		而@RequestMapping注解还有其他参数,诸于method、params、heads
		这个jsp页面测试的就是method参数
		method参数是指定请求方式,常用的有get和post
	--%>
	
	<!-- 这个请求方法是get,能够请求到处理器吗？ -->
	<a href="testMethodRequest/method1">测试@RequestMapping注解的method参数,这个超链接是get请求</a>
	
	
	<!-- 这个请求方式是post,能够请求到处理器吗？ -->
	<form action="testMethodRequest/method1" method="post">
		<input type="submit" value="提交" />
	</form>
	
	<%-- 
		
		最后经过测试,因为Controller TestMethodRequest中注解指定了method=RequestMethod.POST
		所以只有post请求才能达到该处理器
		所以这个例子中只有表单才能被处理器处理
		
	--%>
	

</body>
</html>