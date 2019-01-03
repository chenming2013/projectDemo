<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function()
	{
	 	//获取所有的a元素
		var aElements = document.getElementsByTagName("a");
		//循环遍历a元素
		for(var i=0;i<aElements.length;i++)
		{
			//为每一个a元素添加上点击事件
			aElements[i].onclick = function()
			{
				//获取XMLHttpRequest对象
				var request = new XMLHttpRequest();
				
				//准备发送请求的数据
				var method = "GET";
				var url = this.href;
				
				//为发送数据做准备
				request.open(method,url);
				//发送数据
				request.send(null);
				
				//当每次readystate状态改变的时候,触发事件
				request.onreadystatechange = function()
				{
					//判断响应是否完成
					if(request.readyState == 4)
					{
						//判断响应是否可用
						if(request.status==200 || request.status==304 )
						{
							/*
								将超链接请求的内容显示在div区域
								结果为XML格式,所以需要进行XML解析,解析成的最终格式为:
									<h2>
										<a href="mailto:andy@clearleft.com">Andy Budd</a>
									</h2>
									<a href="http://andybudd.com/">http://andybudd.com/</a>
							*/
							
							
							//结果为XML,所以需要使用responseXML来获取
							var result = request.responseXML;
							
							//结果不能直接使用,必须先创建对应的节点,再把节点加入到#details中
							var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
							var website = result.getElementsByTagName("website")[0].firstChild.nodeValue;
							var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;
							
							var aNode = document.createElement("a");
							aNode.appendChild(document.createTextNode(name));
							aNode.href="mailto:"+email;
							
							var h2Node = document.createElement("h2");
							h2Node.appendChild(aNode);
							
							var aNode2 = document.createElement("a");
							aNode2.appendChild(document.createTextNode(website));
							aNode2.href=website;
							
							var detailsNode = document.getElementById("details");
							
							detailsNode.innerHTML = "";
							
							detailsNode.appendChild(h2Node);
							detailsNode.appendChild(aNode2);
						}
					}
				}
				return false;
			}
		}
	}
</script>
</head>
<body>
	
	<!--  
		本程序的意图:
			当点击某一个超链接的时候,异步请求服务器,将超链接请求的内容显示在div区域
	-->
	<h1>People</h1>
	<ul>
		<li><a href="files/andy.xml">Andy</a></li>
		<li><a href="files/richard.xml">Richard</a></li>
		<li><a href="files/jeremy.xml">Jeremy</a></li>
	</ul>
	<div id="details"></div>

</body>
</html>