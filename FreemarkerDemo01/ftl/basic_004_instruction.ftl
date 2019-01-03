<<<<<<< HEAD
<#--  
	这是配合  InstructionTest#testMethod_1()方法 进行测试常用指令
-->
<#--  
	注意
	1. ??只能判断某个变量不存在,或者某个变量的值为null,而不能判断某个变量的值是空字符串或空数组或空集合列表,
	       而要判断是否有内容(元素或列表),需要用到内建函数has_content
-->
<#-- 测试 if 指令 -->
<#if name??>
	${name}
</#if>

<#-- 测试  if...else...指令 -->
<#if name??>
	${name}
<#else>
	name is null
</#if>

<#-- 测试 if...else if...else指令 -->
<#if num??>
	<#if num lt 100>
		${num + "小于等于100"}
	<#elseif num lt 500>
		${num + "大于100小于等于500"}
	<#elseif num lt 1000>
		${num + "大于500小于等于1000"}
	<#else>
		${num + "大于1000"}		
	</#if>
<#else>
	num is null
</#if>


================= 分割符 =================


<#-- 测试switch...case指令 -->
<#if num??>
<#switch num>
	<#case 100>
		${"num is " + num}
		<#break>
	<#case 500>
		${"num is " + num}
		<#break>
	<#case 666>
		${"num is " + num}
		<#break>
	<#case 1000>
		${"num is " + num}
		<#break>
	<#default>
		${num + "不在列出的[100,500,666,1000]之中"}
</#switch>
<#else>
	num is null;
</#if>



================= 分割符 =================


<#-- 测试 include 和  import 指令 -->
<#-- import指令: 引入一个库,也就是说,它会创建一个新的空命名空间,然后在那个命名空间中执行给定path参数中的模板 -->
<#import "include/include1.ftl" as my>
${my.username}
${my.age}
<#-- 
	include指令: 只是将文件引入,并不会创建新的命名空间 
		可选的参数有: 
		1. parse: 是将被包含的文件当做FTL模板来解析,还是当做纯文本。
		2. encoding: 指定被包含文件的字符编码
		3. ignore_missing: 当找不到被包含的文件时,是否忽略;如果为false,找不到文件将会报错;如果为true,找不到文件也不报错
-->
<#include "include/include1.ftl">
${province}
<#include "include/include1.ftl" encoding="UTF-8" parse=false>
<#--  
输出
	<#assign username="chenming">
	<#assign age = 24>
	<#assign province="guangdong">
	<#assign city="zhongshan">
-->
<#include "include/not_exist.ftl" ignore_missing=true>
<#-- 找不到 not_exist.ftl文件,本来会报错,但是设置了ignore_missing=true,就压制了错误 -->


================= 分割符 =================


<#--  
	测试 assign 指令
		使用该指令可以创建新的变量,或者替换已经存在的变量(注意: 仅仅只有顶级变量可以被创建)
-->
<#assign x=10>
${x}
<#-- 注意: 不能写成 num++ -->
<#assign num=num+1>
${num}
<#assign y=21 z=22>
${y}
${z}


================= 分割符 =================


<#--  
	测试 list 指令
-->
<#list nameList3 as name>
	${name}
</#list>
<#--  
输出:
	zhangsan
	lisi
	wangwu
	zhaoliu
	qianqi
-->

<#if nameList2??>
<#list nameList2 as name>
	${name}
<#else>
	nameList2 is not null,but it is empty sequence
</#list>
<#else>
	nameList2 is null
</#if>
<#-- 输出: nameList2 is not null,but it is empty sequence -->

<ul>
<#list nameList3 as name>
	<li>${name}</li>
</#list>
</ul>
<#--  
	上面的插值在 nameList3 包含有元素的时候没有问题,但是当 nameList3 是一个空序列的话,那么就会输出<ul></ul>,这显然不是我们想要的,
	那么就需要改进了,此时可以使用 items 指令
-->

<#list nameList2>
	<ul>
		<#items as name>
			<li>${name}</li>
		</#items>
	</ul>
</#list>
<#--  
	当 nameList2 不包含任何元素的时候不会有任何输出
-->

<#--  
	第一条数据之前、最后一条数据之后不能有"逗号"
-->
<#list nameList3 as name>${name}<#sep>,</#sep></#list>
<#-- 输出: zhangsan,lisi,wangwu,zhaoliu,qianqi -->

<#-- 可以使用 break 指令在迭代的任意点退出 -->
<#list nameList3 as name>
	<#if name=="lisi">
		<#break>
	<#else>
		${name}
	</#if>
</#list>
<#-- 只输出 : zhangsan -->


================= 分割符 =================


<#-- 
	测试 compress 指令 
		compress指令能够压缩多余的空白
-->
<#compress>
	1 2  4        5
		${name}
	
</#compress>
<#--  
输出:
1 2 4 5
chenming
-->


================= 分割符 =================


<#--  
	测试 noparse 指令
		noparse指令: 不对noparse指令间的内容进入FTL解析,只是当做单纯的纯文本输出
-->
<#compress>
<#noparse>
	<#list nameList3 as name>
		${name}
	</#list>
</#noparse>
</#compress>
<#--  
输出:
	<#list nameList3 as name>
	${name}
	</#list>
-->


================= 分割符 =================


<#--  
	测试 escape 和  noescape
	escape: 进行转义 , 如: 将 <p> 转移成 &lt;p&gt;
	noescape: 不进行转义
-->
<#escape x as x?html>
	${content}
	${name}
	${date?datetime}
</#escape>
<#--  
	上面的代码相当于下面的
		${content?html}
		${name?html}
		${date?datetime?html}
-->
<#--  
输出结果:
	&lt;p&gt;点这有惊喜&lt;/p&gt;
	chenming
	2018-11-22 18:22:55
-->

<#escape x as x?html>
	<#noescape>${content}</#noescape>
	${content}
	${name}
	${date?datetime}
</#escape>
<#--  
输出结果:
	<p>点这有惊喜</p>
	&lt;p&gt;点这有惊喜&lt;/p&gt;
	chenming
	2018-11-23 11:18:34
-->


================= 分割符 =================


<#--  
	测试 attempt、recover 指令
	如果 attempt 指令包含的内容报错,但是Freemarker模板前台不会报错(后台会报错),而是输出 recover 指令的内容
-->
<#--  
hello
<#attempt>
	${not_exist_variable}
<#recover>
	这段语句输出就说明 attempt 指令报错了
</#attempt>
-->
<#--  
输出结果:
hello
	这段语句输出就说明 attempt 指令报错了
-->


================= 分割符 =================


<#--  
	测试 macro 指令: 
		macro指令能自定义指令
-->
<#-- 1.自定义一个 cm1 指令,没有任何内容 -->
<#macro cm1></#macro>
<@cm1>
</@cm1>
<#-- 什么都不输出 -->

<#-- 2.自定义一个cm2 指令,带有内容 -->
<#macro cm2>
	<font size="+2">Hello chenming!</font>
</#macro>
<@cm2></@cm2>
<#--  
输出:
	<font size="+2">Hello chenming!</font>
-->

<#-- 3.自定义一个 cm3 指令,带有参数和内容 -->
<#macro cm3 color user>
	<font color="${color}">Hello,${user}!</font>
</#macro>
<@cm3 color="red" user="陈明"></@cm3>
<#--  
输出:
	<font color="red">Hello,陈明!</font>
-->

<#-- 4.自定义一个 cm4 指令,带有参数和默认值 -->
<#macro cm4 color="red" user="cm4">
	<font color="${color}">Hello,${user}!</font>
</#macro>
<@cm4></@cm4> <#-- 输出: <font color="red">Hello,cm4!</font> -->
<@cm4 color="green"></@cm4> <#-- 输出: <font color="green">Hello,cm4!</font> -->
<@cm4 color="green" user="陈明"></@cm4> <#-- 输出: <font color="green">Hello,陈明!</font> -->


================= 分割符 =================


<#--  
	测试 nested 指令:
		nested指令: 执行自定义指令开始和结束标签中间的模板片段.嵌套的片段可以包含模板中任意合法的内容：插值、指令等。
-->
<#macro cm5>
	1.<#nested>
	2.<#nested>
</#macro>
<@cm5>something</@cm5>
<#--  
输出:
	1.something
	2.something
-->

<#-- nested 指令可以对嵌套内容创建循环变量。 -->
<#macro do_thrice>
  <#nested 1>
  <#nested 2>
  <#nested 3>
</#macro>
<@do_thrice ; x>
  ${x} Anything.
</@do_thrice>
<#--  
输出:
	1 Anything.
	2 Anything.
	3 Anything.
-->

<#-- 更复杂的示例 -->
<#macro repeat count>
  <#list 1..count as x>
    <#nested x, x/2, x==count>
  </#list>
</#macro>
<@repeat count=4 ; c, halfc, last>
  ${c}. ${halfc}<#if last> Last!</#if>
</@repeat>
<#--  
输出:
	1. 0.5
	2. 1
	3. 1.5
	4. 2 Last!
-->


================= 分割符 =================


<#-- 
	测试 return 指令
		return 指令: 可以在任意位置结束一个宏或函数定义
-->
<#macro test>
  Test text
  <#return>
  Will not be printed.
</#macro>
<@test/>	<#-- 输出: Test text -->


================= 分割符 =================


<#--  
	测试 function 指令:
		function 指令: 创建一个方法变量
-->
<#-- avg是方法名,x、y是传入方法的参数 -->
<#function avg x y>
  <#return (x + y) / 2>
</#function>
${avg(10, 20)}	
<#-- 输出: 15 -->

<#function avg nums...>
  <#local sum = 0>
  <#list nums as num>
    <#local sum = sum + num>
  </#list>
  <#if nums?size != 0>
    <#return sum / nums?size>
  </#if>
</#function>
${avg(10, 20)}	<#-- 输出: 15 -->
${avg(10, 20, 30, 40)}	<#-- 输出: 25 -->
${avg()!"N/A"}	<#-- 输出: N/A -->


================= 分割符 =================


<#--  
	测试  t指令, lt指令, rt指令: 这些指令，指示FreeMarker去忽略标记中行的特定的空白：
		t指令: 忽略本行中首和尾的所有空白。
	   lt指令: 忽略本行中首部所有的空白
	   rt指令: 忽略本行中尾部所有的空白。
-->
--
  1 <#t>
  2<#t>
  3<#lt>
  4
  5<#rt>
  6
--
=======
<#--  
	这是配合  InstructionTest#testMethod_1()方法 进行测试常用指令
-->
<#--  
	注意
	1. ??只能判断某个变量不存在,或者某个变量的值为null,而不能判断某个变量的值是空字符串或空数组或空集合列表,
	       而要判断是否有内容(元素或列表),需要用到内建函数has_content
-->
<#-- 测试 if 指令 -->
<#if name??>
	${name}
</#if>

<#-- 测试  if...else...指令 -->
<#if name??>
	${name}
<#else>
	name is null
</#if>

<#-- 测试 if...else if...else指令 -->
<#if num??>
	<#if num lt 100>
		${num + "小于等于100"}
	<#elseif num lt 500>
		${num + "大于100小于等于500"}
	<#elseif num lt 1000>
		${num + "大于500小于等于1000"}
	<#else>
		${num + "大于1000"}		
	</#if>
<#else>
	num is null
</#if>


================= 分割符 =================


<#-- 测试switch...case指令 -->
<#if num??>
<#switch num>
	<#case 100>
		${"num is " + num}
		<#break>
	<#case 500>
		${"num is " + num}
		<#break>
	<#case 666>
		${"num is " + num}
		<#break>
	<#case 1000>
		${"num is " + num}
		<#break>
	<#default>
		${num + "不在列出的[100,500,666,1000]之中"}
</#switch>
<#else>
	num is null;
</#if>



================= 分割符 =================


<#-- 测试 include 和  import 指令 -->
<#-- import指令: 引入一个库,也就是说,它会创建一个新的空命名空间,然后在那个命名空间中执行给定path参数中的模板 -->
<#import "include/include1.ftl" as my>
${my.username}
${my.age}
<#-- 
	include指令: 只是将文件引入,并不会创建新的命名空间 
		可选的参数有: 
		1. parse: 是将被包含的文件当做FTL模板来解析,还是当做纯文本。
		2. encoding: 指定被包含文件的字符编码
		3. ignore_missing: 当找不到被包含的文件时,是否忽略;如果为false,找不到文件将会报错;如果为true,找不到文件也不报错
-->
<#include "include/include1.ftl">
${province}
<#include "include/include1.ftl" encoding="UTF-8" parse=false>
<#--  
输出
	<#assign username="chenming">
	<#assign age = 24>
	<#assign province="guangdong">
	<#assign city="zhongshan">
-->
<#include "include/not_exist.ftl" ignore_missing=true>
<#-- 找不到 not_exist.ftl文件,本来会报错,但是设置了ignore_missing=true,就压制了错误 -->


================= 分割符 =================


<#--  
	测试 assign 指令
		使用该指令可以创建新的变量,或者替换已经存在的变量(注意: 仅仅只有顶级变量可以被创建)
-->
<#assign x=10>
${x}
<#-- 注意: 不能写成 num++ -->
<#assign num=num+1>
${num}
<#assign y=21 z=22>
${y}
${z}


================= 分割符 =================


<#--  
	测试 list 指令
-->
<#list nameList3 as name>
	${name}
</#list>
<#--  
输出:
	zhangsan
	lisi
	wangwu
	zhaoliu
	qianqi
-->

<#if nameList2??>
<#list nameList2 as name>
	${name}
<#else>
	nameList2 is not null,but it is empty sequence
</#list>
<#else>
	nameList2 is null
</#if>
<#-- 输出: nameList2 is not null,but it is empty sequence -->

<ul>
<#list nameList3 as name>
	<li>${name}</li>
</#list>
</ul>
<#--  
	上面的插值在 nameList3 包含有元素的时候没有问题,但是当 nameList3 是一个空序列的话,那么就会输出<ul></ul>,这显然不是我们想要的,
	那么就需要改进了,此时可以使用 items 指令
-->

<#list nameList2>
	<ul>
		<#items as name>
			<li>${name}</li>
		</#items>
	</ul>
</#list>
<#--  
	当 nameList2 不包含任何元素的时候不会有任何输出
-->

<#--  
	第一条数据之前、最后一条数据之后不能有"逗号"
-->
<#list nameList3 as name>${name}<#sep>,</#sep></#list>
<#-- 输出: zhangsan,lisi,wangwu,zhaoliu,qianqi -->

<#-- 可以使用 break 指令在迭代的任意点退出 -->
<#list nameList3 as name>
	<#if name=="lisi">
		<#break>
	<#else>
		${name}
	</#if>
</#list>
<#-- 只输出 : zhangsan -->


================= 分割符 =================


<#-- 
	测试 compress 指令 
		compress指令能够压缩多余的空白
-->
<#compress>
	1 2  4        5
		${name}
	
</#compress>
<#--  
输出:
1 2 4 5
chenming
-->


================= 分割符 =================


<#--  
	测试 noparse 指令
		noparse指令: 不对noparse指令间的内容进入FTL解析,只是当做单纯的纯文本输出
-->
<#compress>
<#noparse>
	<#list nameList3 as name>
		${name}
	</#list>
</#noparse>
</#compress>
<#--  
输出:
	<#list nameList3 as name>
	${name}
	</#list>
-->


================= 分割符 =================


<#--  
	测试 escape 和  noescape
	escape: 进行转义 , 如: 将 <p> 转移成 &lt;p&gt;
	noescape: 不进行转义
-->
<#escape x as x?html>
	${content}
	${name}
	${date?datetime}
</#escape>
<#--  
	上面的代码相当于下面的
		${content?html}
		${name?html}
		${date?datetime?html}
-->
<#--  
输出结果:
	&lt;p&gt;点这有惊喜&lt;/p&gt;
	chenming
	2018-11-22 18:22:55
-->

<#escape x as x?html>
	<#noescape>${content}</#noescape>
	${content}
	${name}
	${date?datetime}
</#escape>
<#--  
输出结果:
	<p>点这有惊喜</p>
	&lt;p&gt;点这有惊喜&lt;/p&gt;
	chenming
	2018-11-23 11:18:34
-->


================= 分割符 =================


<#--  
	测试 attempt、recover 指令
	如果 attempt 指令包含的内容报错,但是Freemarker模板前台不会报错(后台会报错),而是输出 recover 指令的内容
-->
<#--  
hello
<#attempt>
	${not_exist_variable}
<#recover>
	这段语句输出就说明 attempt 指令报错了
</#attempt>
-->
<#--  
输出结果:
hello
	这段语句输出就说明 attempt 指令报错了
-->


================= 分割符 =================


<#--  
	测试 macro 指令: 
		macro指令能自定义指令
-->
<#-- 1.自定义一个 cm1 指令,没有任何内容 -->
<#macro cm1></#macro>
<@cm1>
</@cm1>
<#-- 什么都不输出 -->

<#-- 2.自定义一个cm2 指令,带有内容 -->
<#macro cm2>
	<font size="+2">Hello chenming!</font>
</#macro>
<@cm2></@cm2>
<#--  
输出:
	<font size="+2">Hello chenming!</font>
-->

<#-- 3.自定义一个 cm3 指令,带有参数和内容 -->
<#macro cm3 color user>
	<font color="${color}">Hello,${user}!</font>
</#macro>
<@cm3 color="red" user="陈明"></@cm3>
<#--  
输出:
	<font color="red">Hello,陈明!</font>
-->

<#-- 4.自定义一个 cm4 指令,带有参数和默认值 -->
<#macro cm4 color="red" user="cm4">
	<font color="${color}">Hello,${user}!</font>
</#macro>
<@cm4></@cm4> <#-- 输出: <font color="red">Hello,cm4!</font> -->
<@cm4 color="green"></@cm4> <#-- 输出: <font color="green">Hello,cm4!</font> -->
<@cm4 color="green" user="陈明"></@cm4> <#-- 输出: <font color="green">Hello,陈明!</font> -->


================= 分割符 =================


<#--  
	测试 nested 指令:
		nested指令: 执行自定义指令开始和结束标签中间的模板片段.嵌套的片段可以包含模板中任意合法的内容：插值、指令等。
-->
<#macro cm5>
	1.<#nested>
	2.<#nested>
</#macro>
<@cm5>something</@cm5>
<#--  
输出:
	1.something
	2.something
-->

<#-- nested 指令可以对嵌套内容创建循环变量。 -->
<#macro do_thrice>
  <#nested 1>
  <#nested 2>
  <#nested 3>
</#macro>
<@do_thrice ; x>
  ${x} Anything.
</@do_thrice>
<#--  
输出:
	1 Anything.
	2 Anything.
	3 Anything.
-->

<#-- 更复杂的示例 -->
<#macro repeat count>
  <#list 1..count as x>
    <#nested x, x/2, x==count>
  </#list>
</#macro>
<@repeat count=4 ; c, halfc, last>
  ${c}. ${halfc}<#if last> Last!</#if>
</@repeat>
<#--  
输出:
	1. 0.5
	2. 1
	3. 1.5
	4. 2 Last!
-->


================= 分割符 =================


<#-- 
	测试 return 指令
		return 指令: 可以在任意位置结束一个宏或函数定义
-->
<#macro test>
  Test text
  <#return>
  Will not be printed.
</#macro>
<@test/>	<#-- 输出: Test text -->


================= 分割符 =================


<#--  
	测试 function 指令:
		function 指令: 创建一个方法变量
-->
<#-- avg是方法名,x、y是传入方法的参数 -->
<#function avg x y>
  <#return (x + y) / 2>
</#function>
${avg(10, 20)}	
<#-- 输出: 15 -->

<#function avg nums...>
  <#local sum = 0>
  <#list nums as num>
    <#local sum = sum + num>
  </#list>
  <#if nums?size != 0>
    <#return sum / nums?size>
  </#if>
</#function>
${avg(10, 20)}	<#-- 输出: 15 -->
${avg(10, 20, 30, 40)}	<#-- 输出: 25 -->
${avg()!"N/A"}	<#-- 输出: N/A -->


================= 分割符 =================


<#--  
	测试  t指令, lt指令, rt指令: 这些指令，指示FreeMarker去忽略标记中行的特定的空白：
		t指令: 忽略本行中首和尾的所有空白。
	   lt指令: 忽略本行中首部所有的空白
	   rt指令: 忽略本行中尾部所有的空白。
-->
--
  1 <#t>
  2<#t>
  3<#lt>
  4
  5<#rt>
  6
--
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
