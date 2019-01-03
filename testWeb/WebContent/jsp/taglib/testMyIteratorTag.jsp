<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chenming.com/tld/myTag" prefix="cm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试自定义标签(迭代标签)</title>
</head>
<body>
	<% 
		String[] books = {"Struts2","Hibernate","Spring","SpringMVC","Mybatis","Ajax","JSON","Javascript","Jquery","EasyUI","Bootstrap","Vue"};
	%>
		
	<cm:iterator items="<%=books %>" name="book">
		${book}
	</cm:iterator>
</body>
</html>