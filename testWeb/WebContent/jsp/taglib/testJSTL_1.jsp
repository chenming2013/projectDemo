<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试JSTL标签</title>
</head>
<body>
	<% 
	String[] books = {"Struts2","Hibernate","Spring","SpringMVC","Mybatis","Ajax","JSON","Javascript","Jquery","EasyUI","Bootstrap","Vue"};
	%>
	
	<c:forEach items="<%=books %>" var="item">
		${item }
	</c:forEach>
</body>
</html>