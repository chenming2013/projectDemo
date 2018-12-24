<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试word转html</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	function viewOnline(){
		var url = '/testPOI/WordToHTMLServlet';
		$.post(url,{
			
		},function(result){
			//console.log(result);
			if(result && result.success){
				console.log("hello");
				var a = document.createElement('a');
				a.href = 'http://www.baidu.com';
				a.click();
			}
		},'json');
	}
</script>
</head>
<body>
	<a onclick="viewOnline()">在线预览</a>
</body>
</html>