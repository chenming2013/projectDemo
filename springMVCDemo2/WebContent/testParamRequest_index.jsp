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
		
		测试@RequestMapping的param参数
		配合handler.param.TestParamRequest.java、paramRequest/* 一起看
	--%>
	<h1>注：method1()方法中只要求有username参数,并没有对username的值做限定</h1>
	
	<a href="testParamRequest/method1?">不包含参数username</a><br/>
	<a href="testParamRequest/method1?username">包含参数username</a><br/>
	<a href="testParamRequest/method1?username=chenming">包含参数username,且指定username=chenming</a><br/>
	
	
	<br/><br/>

	
	<h1>注：method2()方法中要求username=test</h1>

	<a href="testParamRequest/method2?">不包含参数username</a><br/>
	<a href="testParamRequest/method2?username">包含参数username</a><br/>
	<a href="testParamRequest/method2?username=chenming">包含参数username,且指定username=chenming</a><br/>
	<a href="testParamRequest/method2?username=test">包含参数username,且指定username=test</a><br/>
	
	
	<br/><br/>
		

	<h1>注：method3()方法中要求有两个参数username,age,且username=test</h1>

	<a href="testParamRequest/method3">一个参数也不包含</a><br/>
	<a href="testParamRequest/method3?username">包含一个参数username,但username为空值</a><br/>
	<a href="testParamRequest/method3?username=chenming">包含参数username,且指定username=chenming</a><br/>
	<a href="testParamRequest/method3?username=test">包含参数username,且指定username=test</a><br/>
	<a href="testParamRequest/method3?username=test&age">包含两个参数username,age,且指定username=test</a><br/>


	<br/><br/>
	
	
	<h1>注：method4()方法中要求有两个参数username,age,且username=test,且指定headers</h1>

	<a href="testParamRequest/method4">一个参数也不包含</a><br/>
	<a href="testParamRequest/method4?username">包含一个参数username,但username为空值</a><br/>
	<a href="testParamRequest/method4?username=chenming">包含参数username,且指定username=chenming</a><br/>
	<a href="testParamRequest/method4?username=test">包含参数username,且指定username=test</a><br/>
	<a href="testParamRequest/method4?username=test&age">包含两个参数username,age,且指定username=test</a><br/>
	<a href="testParamRequest/method4?username=test&age">包含两个参数username,age,且指定username=test</a><br/>
		
</body>
</html>