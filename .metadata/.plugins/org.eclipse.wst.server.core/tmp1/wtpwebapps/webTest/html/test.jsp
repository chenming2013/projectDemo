<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>测试百度富文本编辑器</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<!-- 配置文件 -->
	<script type="text/javascript" src="../js/ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../js/ueditor/ueditor.all.js"></script>
	
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<textarea id="content" name="content" style="height: 80%"></textarea>
	<a href="https://www.baidu.com/" class="a1">保存</a>
	<script type="text/javascript">
		//实例化编辑器	
		var ue = UE.getEditor("content");

		$(document).ready(function(){
			//当点击的时候判断富文本编辑器总共内容是否为空
			$(".a1").click(function(){
				var flag = false;
				 ue.ready(function(){
					 var txt = ue.getContentTxt();
					 alert("编译后: "+txt);
					 if(ue.hasContents())
					 {
						 alert("txt: "+txt);
						 alert("txt!=null");
						 alert("内容不为空");
						 flag = true;
					 }else{
						 alert("txt=null");
						 alert("内容为空");
						flag = false;
					 }
				 })
				 return flag;
			});
			
		});
			
	</script>
</body>
</html>