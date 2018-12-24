<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){

		/* Ajax访问Servlet */
		testAjax.onclick = function(){
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						console.log(xhr.responseType);
						/*
						//如果没有设置 xhr.responseType = 'json';那么就要手动将JSON格式的字符串转换成对象 
						var data = xhr.responseText;
						data = JSON.parse(data);
						console.log(data.jsonData.name);    //陈明 
						*/
						/*
						//如果设置了 xhr.responseType = 'json';浏览器会自动将返回的JSON格式的字符串转换成对象,不需要我们手动转换
						var data = xhr.response;
						console.log(data.jsonData.name);   //陈明
						*/
					}
				}
			}
			xhr.open("GET","/testWeb/TestAjaxServlet",true);
			xhr.responseType = "json";
			xhr.send(null);
		}


		/* Ajax访问XML */
		testAjax2.onclick = function(){
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						var data = xhr.responseXML;
						var stuElement = data.getElementsByTagName("STUDENT")[0];
						console.log(stuElement.firstElementChild.firstChild.nodeValue);
					}
				}
			}
			xhr.open("GET","/testWeb/xml/test1.xml",true);
			xhr.send(null);
		}


		/* Ajax访问图片 */
		testAjax3.onclick = function(){
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						var data = xhr.response;
						var imgElement = document.createElement("img");
						imgElement.onload = function(){
			                URL.revokeObjectURL(imgElement.src);
			            }
						var blob = URL.createObjectURL(data);
						console.log(blob);
						imgElement.src = blob;
						result3.appendChild(imgElement);
					}
				}
			}
			xhr.open("GET","/testWeb/img/5.jpg",true);
			xhr.responseType = 'blob';
			xhr.send(null);
		}

		/* Ajax提交表单 */
		/* btn1.onclick = function(){
			var formData = new FormData(document.forms.form1);
			var xhr = new XMLHttpRequest;
			xhr.open("POST","/testWeb/TestFormServlet",true);
			xhr.send(formData);
		} */


		/* 测试Ajax请求进度 */
		testAjax4.onclick = function(){
			var xhr = new XMLHttpRequest();

			xhr.onloadstart = function(){
				console.log("start...");
			}
			xhr.onprogress = function(){
				console.log("progress...");
			}
			xhr.onerror = function(){
				console.log("error...");
			}
			xhr.onabort = function(){
				console.log("abort...");
			}
			xhr.onload = function(){
				console.log("load...");
			}
			xhr.onloadend = function(){
				console.log("loadend...");
			}
			/* xhr.timeout = 2000;  //2s
			xhr.ontimeout = function(){
				console.log("timeout...");
			} */

			xhr.open("POST","/testWeb/TestFormServlet",true);
			xhr.send(null);
			setTimeout(function() {
				xhr.abort();
			}, 1000)
		}


		//异步请求books.xml
		testAjax5.onclick = function(){

			var xhr = new XMLHttpRequest();
			xhr.open("GET","xml/books.xml",true);
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						var xmlDoc = xhr.responseXML;
						console.log(xmlDoc);
					}
				}
			}
			xhr.send(null);
		}


		//加载tables.xml和furniture.xml
		testAjax6.onclick = function(){
			var xmlDoc = document.implementation.createDocument("", "", null);
			xmlDoc.async = false;
			xmlDoc.load("xml/tables.xml");
			console.log(xmlDoc);
			
			var xmlDoc2 = document.implementation.createDocument("", "", null);
			xmlDoc2.async = false;
			xmlDoc2.load("xml/furniture.xml");
			console.log(xmlDoc2);
			var xmlDocument = xmlDoc2.documentElement
			console.log(xmlDocument.getElementsByTagName("width")[0]);
		}

		//加载books.xml
		testAjax7.onclick = function(){
			var xmlDoc = document.implementation.createDocument("", "", null);
			xmlDoc.async = false;
			xmlDoc.load("xml/books.xml");
			var bookEle = xmlDoc.getElementsByTagName("book")[0];
			console.log(bookEle.innerHTML);
			console.log(bookEle.childNodes);
		}


		//测试XPath
		testAjax8.onclick = function(){
			//1. 加载XML
			var xmlDoc = document.implementation.createDocument("", "", null);
			xmlDoc.async = false;
			xmlDoc.load("xml/books2.xml");	

			//2. 非IE浏览器使用xmlDoc.evaluate(xpath, xmlDoc, null, XPathResult.ANY_TYPE,null)选取节点;
			//2.1 选取所有title
			var xpath = "/bookstore/book/title";
			var nodeList = xmlDoc.evaluate(xpath,xmlDoc,null,XPathResult.ANY_TYPE,null);
			var result = nodeList.iterateNext();
			while(result){
				var textNode = result.childNodes[0];
				console.log(textNode.nodeName+"--"+textNode.nodeType+"--"+textNode.nodeValue);
				result = nodeList.iterateNext();
			}

			console.log("\n\n\n");
			
			//2.2 选取第一个book的title
			xpath = "/bookstore/book[1]/title";
			nodeList = xmlDoc.evaluate(xpath,xmlDoc,null,XPathResult.ANY_TYPE,null)
			var result = nodeList.iterateNext();
			while(result){
				var textNode = result.childNodes[0];
				console.log(textNode.nodeName+"--"+textNode.nodeType+"--"+textNode.nodeValue);
				result = nodeList.iterateNext();
			}

			console.log("\n\n\n");

			//2.3 选取所有价格
			xpath = "/bookstore/book/price/text()";
			nodeList = xmlDoc.evaluate(xpath,xmlDoc,null,XPathResult.ANY_TYPE,null)
			var result = nodeList.iterateNext();
			while(result){
				console.log(result.nodeName+"--"+result.nodeType+"--"+result.nodeValue);
				result = nodeList.iterateNext();
			}
		}
		
	}
</script>
</head>
<body>	

	<a href="/testWeb/servletTest1?id=1">跳到Servlet</a>
	<br/><br/>

	<a id="testAjax">访问TestAjaxServlet</a>
	<br/><br/>
	
	<a id="testAjax2">Ajax访问xml</a>
	<br/><br/>


	<a id="testAjax3">Ajax访问图片</a>
	<div id="result3"></div>
	<br/><br/>
	
	
	<a id="testAjax4">Ajax访问TestFormServlet</a>
	<div id="result4"></div>
	<br/><br/>
	
	<form id="form1" action="/testWeb/TestFormServlet" method="post">
		姓名: <input name="username" />
		年龄: <input name="age" />
		爱好: 
			 <select name="hobby" multiple="multiple" size="2">
			 	<option value="java">Java</option>
			 	<option value="novel">小说</option>
			 	<option value="movie">电影</option>
			 </select>
		<!-- <button type="button" id="btn1">提交</button> -->
		<input type="submit" value="提交" />
		
	</form>
	<br/><br/>
	
	
	<a href="submitForm.jsp">跳转到submitForm.jsp</a>
	<br/><br/>
	
	
	<a id="testAjax5">访问books.xml</a>
	<br/><br/>
	
	
	<a id="testAjax6">加载tables.xml和furniture.xml</a>
	<br/><br/>
	
	
	<a id="testAjax7">加载tables.xml</a>
	<br/><br/>
	
	
	<a id="testAjax8">测试XPath</a>
	<br/><br/>
	
</body>
</html>