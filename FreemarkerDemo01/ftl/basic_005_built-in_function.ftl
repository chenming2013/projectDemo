<<<<<<< HEAD
<#--  
	测试日期内建函数
-->
<#-- 1. date、time、datetime: 这些内建函数用来指定日期变量中哪些部分被使用 -->
${nowDate?date}				<#-- 输出: 2018-11-23 -->
${nowDate?time}				<#-- 输出: 17:26:57 -->
${nowDate?datetime}			<#-- 输出: 2018-11-23 17:26:57 -->

<#-- 2. string()内建函数以指定的格式转换日期类型到字符串类型 -->
<#-- 2.1 自定义格式 -->
${nowDate?string("yyyy/MM/dd HH:mm:ss.sss")}	<#-- 输出: 2018/11/23 17:39:30.030 -->
<#-- 2.2.1 使用内建格式 -->
${nowDate?date?string.short}	<#-- 输出: 18-11-23 -->
${nowDate?date?string.medium}	<#-- 输出: 2018-11-23 -->
${nowDate?date?string.long}		<#-- 输出: 2018年11月23日 -->
${nowDate?date?string.full}		<#-- 输出: 2018年11月23日 星期五 -->
${nowDate?date?string.xs}		<#-- 输出: 2018-11-23+08:00 -->
${nowDate?date?string.iso}		<#-- 输出: 2018-11-23 -->
<#-- 2.2.2 使用内建格式 -->
${nowDate?time?string.short}	<#-- 输出: 下午5:50 -->
${nowDate?time?string.medium}	<#-- 输出: 17:50:56 -->
${nowDate?time?string.long}		<#-- 输出: 下午05时50分56秒 -->
${nowDate?time?string.full}		<#-- 输出: 下午05时50分56秒 CST -->
${nowDate?time?string.xs}		<#-- 输出: 17:50:56.025+08:00 -->
${nowDate?time?string.iso}		<#-- 输出: 17:50:56.025+08:00 -->
<#-- 2.2.3 使用内建格式 -->
${nowDate?datetime?string.short}	<#-- 输出: 18-11-23 下午5:52	 -->
${nowDate?datetime?string.medium}	<#-- 输出: 2018-11-23 17:52:28 -->
${nowDate?datetime?string.long}		<#-- 输出: 2018年11月23日 下午05时52分28秒 -->
${nowDate?datetime?string.full}		<#-- 输出: 2018年11月23日 星期五 下午05时52分28秒 CST -->
${nowDate?datetime?string.xs}		<#-- 输出: 2018-11-23T17:52:28.021+08:00 -->
${nowDate?datetime?string.iso}		<#-- 输出: 2018-11-23T17:52:28.021+08:00 -->


=========================== 分割符 ================================


<#--  
	测试布尔值内建函数
-->
<#-- 1. string内建函数: 使用string内建函数返回的一定是字符串 -->
<#-- 1.1 foo?string("yes","no") -->
${flag?string("是","否")}		<#-- 输出: 是 -->
${flag2?string("是","否")}		<#-- 输出: 否 -->
${(flag3?string("是","否"))!"flag3 is null"}		<#-- 输出: flag3 is null -->
<#-- 1.2 foo?string -->
${flag?string}					<#-- 输出: true -->
${flag2?string}					<#-- 输出: false -->
${(flag3?string)!"flag3 is null"}				<#-- 输出: flag3 is null -->
<#-- 1.3 foo?c -->
${flag?c}						<#-- 输出: true -->
${flag2?c}						<#-- 输出: false -->
${(flag3?c)!"flag3 is null"}					<#-- 输出: flag3 is null -->
<#-- 1.4 -->
<#assign x=10>
<#assign y=20>
${(x>y)?string(x,y)}			<#-- 输出: 20 -->
${(x<y)?string(x,y)}			<#-- 输出: 10 -->
${(x<y)?c}						<#-- 输出: true -->
${100 + (x>y)?string(x,y)}		<#-- 输出: 10020,  这个很明显不是我们要的结果,虽然y是数字类型,但是调用string内建函数之后,就变成了字符串"20" -->
${100 + (x>y)?c}				<#-- 输出: 100false -->
<#--  
	注: foo?String("yes","no") 已经不建议使用,建议使用 ?then("yes","no") 代替
	    foo?string 已经不建议使用,建议使用 ?c 代替	
-->

<#-- 2. then内建函数: 使用then内建函数返回的可以任何类型的数据 -->
<#-- 2.1 -->
${flag?then("是","否")}			<#-- 输出: 是 -->
${flag2?then("是","否")}			<#-- 输出: 否 -->
${(flag3?then("是","否"))!"flag3 is null"}		<#-- 输出: flag3 is null -->
<#-- 2.2 -->
<#assign n1=10>
<#assign n2=20>
${(x>y)?then(x,y)}				<#-- 输出: 20 -->
${(x<y)?then(x,y)}				<#-- 输出: 10 -->
${100 + (x>y)?then(x,y)}		<#-- 输出: 120,   这个就是我们的想要取得的数据 -->
${100 + (x>y)?then(2,3)}		<#-- 输出: 102 -->
${100 + (x>y)?then("2","3")}	<#-- 输出: 1003 -->


=========================== 分割符 ================================


<#--  
	测试数字内建函数
-->
<#-- 1. abs: 求出数字的绝对值 -->
<#assign x=-101 y=102>
${x?abs}						<#-- 输出: 101 -->
${y?abs}						<#-- 输出: 102 -->
${(num2?abs)!"num2 is null"}	<#-- 输出: num2 is null -->

<#-- 2. lower_abc: 将数字转换成26个小写英文字符 -->
<#list 1..10 as n>
	${n?lower_abc} <#t>
</#list>
<#-- 输出结果: a b c d e f g h i j -->
<#list 1..30 as n>
	${n?lower_abc} <#t>
</#list>
<#-- 输出结果: a b c d e f g h i j k l m n o p q r s t u v w x y z aa ab ac ad  -->

<#-- 3. upper_abc: 将数字转换成26个大写英文字符 -->
<#list 1..10 as n>
	${n?upper_abc} <#t>
</#list>
<#-- 输出结果: A B C D E F G H I J -->
<#list 1..30 as n>
	${n?upper_abc} <#t>
</#list>
<#-- 输出结果: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z AA AB AC AD -->

<#-- 
	4.round、floor、ceiling: 使用确定的舍入法则，转换一个数字到整数
		1) round: 返回最近的整数。 如果数字以.5结尾，那么它将进位(四舍五入)
		2) floor: 返回数字的舍掉小数后的整数 (向下取整)
		3) ceiling: 返回数字小数进位后的整数 (向上取整)
-->
<#assign x1=-1 x2=-1.4 x3=-1.6 x4=1 x5=1.4 x6=1.6 x7=-1.49 x8=1.49 />
<#-- 4.1 round内建函数 -->
${x1?round}						<#-- 输出: -1 -->
${x2?round}						<#-- 输出: -1 -->
${x3?round}						<#-- 输出: -2 -->
${x4?round}						<#-- 输出: 1 -->
${x5?round}						<#-- 输出: 1 -->
${x6?round}						<#-- 输出: 2 -->
${x7?round}						<#-- 输出: -1 -->
${x8?round}						<#-- 输出: 1 -->
<#-- 4.2 floor内建函数 -->
${x1?floor}						<#-- 输出: -1 -->
${x2?floor}						<#-- 输出: -2 -->
${x3?floor}						<#-- 输出: -2 -->
${x4?floor}						<#-- 输出: 1 -->
${x5?floor}						<#-- 输出: 1 -->
${x6?floor}						<#-- 输出: 1 -->
${x7?floor}						<#-- 输出: -2 -->
${x8?floor}						<#-- 输出: 1 -->
<#-- 4.3 ceiling内建函数 -->
${x1?ceiling}					<#-- 输出: -1 -->
${x2?ceiling}					<#-- 输出: -1 -->
${x3?ceiling}					<#-- 输出: -1 -->
${x4?ceiling}					<#-- 输出: 1 -->
${x5?ceiling}					<#-- 输出: 2 -->
${x6?ceiling}					<#-- 输出: 2 -->
${x7?ceiling}					<#-- 输出: -1 -->
${x8?ceiling}					<#-- 输出: 2 -->

<#--  
	5. string: 将一个数字转换成字符串,可以使用这个内建函数指定一种格式,也可以使用自带的本地格式
		有四种预定义的数字格式: computer、currency、number 、percent
-->
<#assign x=666>
<#-- 5.1 使用自带的本地格式 -->
<#-- 5.1.1 没有设置默认的数字格式 -->
<#-- 因为我们本地是 zh_CN,所以会输出下面的 -->
${x}							<#-- 输出: 666,读取默认格式 -->
${x?string}						<#-- 输出: 666,读取默认格式 -->
${x?string.computer}			<#-- 输出: 666 -->
${x?string.currency}			<#-- 输出: ￥666.00 -->
${x?string.number}				<#-- 输出: 666 -->
${x?string.percent}				<#-- 输出: 66,600% -->
<#-- 5.1.2 设置了默认的数字格式 -->
<#setting number_format="currency">
${x}							<#-- 输出: ￥666.00 -->
${x?string}						<#-- 输出: ￥666.00 -->
${x?string.computer}			<#-- 输出: 666 -->
${x?string.currency}			<#-- 输出: ￥666.00 -->
${x?string.number}				<#-- 输出: 666 -->
${x?string.percent}				<#-- 输出: 66,600% -->

<#-- 5.2 使用Java数字格式语法,指定自己需要的格式 -->
<#assign x=1.567>
${x?string("0")}				<#-- 输出: 2 -->
${x?string("0.#")}				<#-- 输出: 1.6 -->
${x?string("0.##")}				<#-- 输出: 1.57 -->
${x?string("0.###")}			<#-- 输出: 1.567 -->
${x?string("0.####")}			<#-- 输出: 1.567 -->

${x?string("000.00")}			<#-- 输出: 001.57 -->
${x?string("000.000")}			<#-- 输出: 001.567 -->
${x?string("000.0000")}			<#-- 输出: 001.5670 -->
${x?string(".00")}				<#-- 输出: 1.57 -->

<#-- 下面要注意一下 -->
${1.5?string("0")}				<#-- 输出: 2 -->
${2.5?string("0")}				<#-- 输出: 2 -->
${3.5?string("0")}				<#-- 输出: 4 -->
${4.5?string("0")}				<#-- 输出: 4 -->

${4.52?string("0")}				<#-- 输出: 5 -->
${4.58?string("0")}				<#-- 输出: 5 -->


=========================== 分割符 ================================


<#--  
	测试 序列内建函数
-->
<#assign seq=['a','b','c','d','e','f','g','h','i','j']>
<#-- 1. chunk: 将序列分隔为多个序列 -->
<#list seq?chunk(4) as row> 
	<#list row as cell>${cell} <#t></#list>
</#list>
<#-- 
输出结果:   
	a b c d 
	e f g h 
	i j 
-->
<#list seq?chunk(4,"*") as row>
	<#list row as cell>${cell} <#t></#list>
</#list>
<#--  
输出结果:
	a b c d 
	e f g h 
	i j * *
-->

<#-- 2. first: 序列的第一个子变量 -->
${seq?first}					<#-- 输出: a -->

<#-- 3. last: 序列的最后一个子变量 -->
${seq?last}						<#-- 输出: j -->

<#-- 4. size: 序列中子变量的数量 -->
${seq?size}						<#-- 输出: ￥10.00, 这里之所以输出这个,是因为我们之前设置了 <#setting number_format="currency"> , 那么所有的数值都会显示成货币 -->
${seq?size?string.number}		<#-- 输出: 10 -->

<#-- 
	5. join: 使用给定的分隔符来连接序列中的项为一个独立的字符串 
		join内建函数最多可以有三个参数:
		1) 分割符,必选
		2) 空值,默认是""(空字符串),如果序列为空,使用该值
		3) 列表结尾,默认是""(空字符串),如果列表序列不为空,该值在最后一个值后面输出。
-->
${seq?join(",")}				<#-- 输出: a,b,c,d,e,f,g,h,i,j -->
${[]?join(",","*")}				<#-- 输出: * -->
${seq?join(",","*","!")}		<#-- 输出: a,b,c,d,e,f,g,h,i,j! -->

<#-- 6. reverse: 序列反转 -->
<#list seq?reverse as item>
	${item} <#t>
</#list>
<#-- 输出: j i h g f e d c b a  -->

<#-- 7. seq_contains: 判断序列中是否包含指定的值,返回布尔值 .  注意:包含指定的值的类型也要判断 -->
${seq?seq_contains("f")?string("包含","不包含")}		<#-- 输出: 包含 -->
${seq?seq_contains("t")?string("包含","不包含")}		<#-- 输出: 不包含 -->

<#-- 
	8. seq_index_of: 返回序列中第一次出现该值时的索引位置,索引从0开始,找不到返回-1
		该内建函数包含两个参数:
		1) 第一次参数是要搜索的值
		2) 第二个参数索引开始的位置,默认为0; 如果第二个参数是负数,也相当于0
-->
<#setting number_format="number">
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#-- 8.1 没有第二个参数 -->
${str?seq_index_of("w")}		<#-- 输出: 1 -->
${str?seq_index_of("g")}		<#-- 输出: 8 -->
${str?seq_index_of("p")}		<#-- 输出: -1 -->

<#-- 8.2 有第二个参数 -->
${str?seq_index_of("d",1)}		<#-- 输出: 4 -->
${str?seq_index_of("d",20)}		<#-- 输出: -1 -->
${str?seq_index_of("d",-2)}		<#-- 输出: 0 -->

<#-- 9. seq_last_index_of: 返回序列中最后一次出现值的索引位置 -->
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#-- 9.1 没有第二个参数 -->
${str?seq_last_index_of("x")}	<#-- 输出: 6 -->
${str?seq_last_index_of("p")}	<#-- 输出: -1 -->

<#-- 9.2 有第二个参数 -->
${str?seq_last_index_of("x",9)}	<#-- 输出: 6 -->
${str?seq_last_index_of("x",5)}	<#-- 输出: 2 -->

<#-- 10 sort: 以升序方式返回序列 -->
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#list str?sort as temp>
	${temp} <#t>
</#list>
<#-- 输出结果: a d d d f g r w x x -->

<#-- 11 sort_by: 按照给定的名称来升序排列序列 -->
<#assign user=[
				{"name":"zhangsan","age",25},
				{"name":"lisi","age":20},
				{"name":"wangwu","age":38},
				{"name":"zhaoliu","age":18},
				{"name":"qianqi","age",28}
			]>
<#list user?sort_by("name") as temp>
	${temp.name}-${temp.age}
</#list>
<#--  
输出结果:
	lisi-20
	qianqi-28
	wangwu-38
	zhangsan-25
	zhaoliu-18
-->


=========================== 分割符 ================================


<#--  
	测试 哈希表内建函数
-->
<#-- 1. keys: 包含哈希表中查找到的键的序列 -->
<#assign user={"name":"chenming","age":24,"province":"hubei","grade":"university"}>
<#assign userKeys = user?keys>
<#list userKeys as key>
	${key} <#t><#sep>,</#sep>
</#list>
<#-- 输出结果: name ,age ,province ,grade -->

<#-- 2. values: 包含哈希表中变量值的序列 -->
<#assign userValues = user?values>
<#list userValues as value>
	${value} <#t><#sep>,</#sep>
</#list>
<#-- 输出结果: chenming ,24 ,hubei ,university -->


=========================== 分割符 ================================


<#--  
	测试 循环变量内建函数: 这些内建函数只能用于list指令和items指令
-->
<#-- 1. counter: 返回当前迭代从1开始的索引 -->
<#assign str=["a","b","c","d","e"]>
<#list str as item>
	${item?counter}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 1,2,3,4,5 -->

<#-- 2. has_next: 判断是否循环项是否还有下一项,即判断当前项是不是最后一项 -->
<#list str as item>
	${item?has_next?string("Y","N")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: Y,Y,Y,Y,N -->

<#-- 3. index: 返回当前迭代从0开始的索引 -->
<#list str as item>
	${item?index}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 0,1,2,3,4 -->

<#-- 4. is_first: 是否是当前迭代的第一项 -->
<#list str as item>
	${item?is_first?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 是,否,否,否,否 -->

<#-- 5. is_last： 是否是当前迭代的最后一项 -->
<#list str as item>
	${item?is_last?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 否,否,否,否,是 -->

<#-- 6. is_even_item: 判断当前迭代项是否是偶数项 -->
<#list str as item>
	${item?is_even_item?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 否,是,否,是,否 -->

<#-- 7. is_odd_item: 判断当前迭代项是否是奇数项 -->
<#list str as item>
	${item?is_odd_item?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 是,否,是,否,是 -->

<#-- 8. item_parity: 基于当前迭代间隔为1的索引的奇偶性,返回字符串为"odd"或"even" -->
<#list str as item>
	<tr class="${item?item_parity}Row"></tr>
</#list>
<#--  
输出结果:
	<tr class="oddRow"></tr>
	<tr class="evenRow"></tr>
	<tr class="oddRow"></tr>
	<tr class="evenRow"></tr>
	<tr class="oddRow"></tr>
-->

<#-- 9. item_parity_cap: 基于当前迭代间隔为1的索引的奇偶性,返回"Odd"或"Even"(注意是大写) -->
<#list str as item>
	<tr class="row${item?item_parity_cap}"></tr>
</#list>
<#-- 
输出结果: 
	<tr class="rowOdd"></tr>
	<tr class="rowEven"></tr>
	<tr class="rowOdd"></tr>
	<tr class="rowEven"></tr>
	<tr class="rowOdd"></tr>
-->


=========================== 分割符 ================================


<#--  
	测试 字符串内建函数
-->
<#-- 1. boolean: 字符串转为布尔值,字符串必须是true或false(大小写敏感),或者必须是由boolean_format设置的特定格式 -->

<#-- 2. cap_first: 字符串中的首单词的首字母大写  uncap_first-->
${"hello"?cap_first}			<#-- 输出: Hello -->
${"hello world"?cap_first}		<#-- 输出: Hello world -->
${"HELLO WORLD"?uncap_first}	<#-- 输出: hELLO WORLD -->

<#-- 3. capitalize: 字符串中所有单词的首字母大写 -->
${"my name is chenming"?capitalize} <#-- 输出: My Name Is Chenming -->

<#-- 4. contains: 是否包含指定子串 -->
${"my name is chenming"?contains("nm")?string("是","否")}	<#-- 输出: 是 -->

<#-- 5. date、time、datetime: 字符串转换成日期值 -->
${"2018-11-25 15:03:30"?datetime}	<#-- 输出: 2018-11-25 15:03:30 -->
<#-- 上面取出的究竟是字符串,还是日期类型呢?  可以调用一下日期类型的内建函数试一下 -->
${"2018-11-25 15:03:30"?datetime?date?string.short}	<#-- 输出: 18-11-25 -->
<#-- 上面的一行能够正常输出,说明 "2018-11-25 15:03:30"?datetime 返回的就是date类型  -->
<#-- 指定输出的格式 -->
${"2018/11/25 15/03/30"?datetime("yyyy/MM/dd HH/mm/ss")}	<#-- 输出: 2018-11-25 15:03:30 -->

<#-- 6. starts_with: 判断是否以指定的字符串开头 -->
${"hello world"?starts_with("he")?string("true","false")}	<#-- 输出: true -->

<#-- 7. ensure_starts_with:  -->
${"hello world"?ensure_starts_with("every","every one,")}	<#-- 输出: every one,hello world -->
${"hello world"?ensure_starts_with("he","hello")}			<#-- 输出: hello world -->

<#-- 8. ends_with -->
${"hello world"?ends_with("ld")?string("true","false")}		<#-- 输出: true -->
${"hello world"?ends_with("l")?string("true","false")}		<#-- 输出: false -->

<#-- 9. ensure_ends_with -->
${"hello world!"?ensure_ends_with("ld")}	<#-- 输出: hello world!ld -->

<#-- 10. index_of -->
${"hello world"?index_of("lo")}				<#-- 输出: 3 -->

<#-- 11. length -->
${"hello world"?length}						<#-- 输出: 11 -->

<#-- 12. lower_case -->
${"HELLO WORLD"?lower_case}		<#-- 输出: hello world -->

<#-- 13. upper_case -->
${"hello world"?upper_case}		<#-- 输出: HELLO WORLD -->

<#-- 14. number -->
${ 1 + "12"?number}				<#-- 输出: 13 -->

<#-- 15. replace -->
${"hello world"?replace("o","G")}	<#-- 输出: hellG wGrld -->

<#-- 16. split -->
<#list "hello world"?split(" ") as item>
	${item}
</#list>
<#-- 
输出 
	hello
	world
-->

<#-- 17. substring -->
${"hello world"?substring(1)}	<#-- 输出: ello world -->

<#-- 18. html -->
${"<p>hello world</p>"?html}	<#-- 输出: &lt;p&gt;hello world&lt;/p&gt; -->





=======
<#--  
	测试日期内建函数
-->
<#-- 1. date、time、datetime: 这些内建函数用来指定日期变量中哪些部分被使用 -->
${nowDate?date}				<#-- 输出: 2018-11-23 -->
${nowDate?time}				<#-- 输出: 17:26:57 -->
${nowDate?datetime}			<#-- 输出: 2018-11-23 17:26:57 -->

<#-- 2. string()内建函数以指定的格式转换日期类型到字符串类型 -->
<#-- 2.1 自定义格式 -->
${nowDate?string("yyyy/MM/dd HH:mm:ss.sss")}	<#-- 输出: 2018/11/23 17:39:30.030 -->
<#-- 2.2.1 使用内建格式 -->
${nowDate?date?string.short}	<#-- 输出: 18-11-23 -->
${nowDate?date?string.medium}	<#-- 输出: 2018-11-23 -->
${nowDate?date?string.long}		<#-- 输出: 2018年11月23日 -->
${nowDate?date?string.full}		<#-- 输出: 2018年11月23日 星期五 -->
${nowDate?date?string.xs}		<#-- 输出: 2018-11-23+08:00 -->
${nowDate?date?string.iso}		<#-- 输出: 2018-11-23 -->
<#-- 2.2.2 使用内建格式 -->
${nowDate?time?string.short}	<#-- 输出: 下午5:50 -->
${nowDate?time?string.medium}	<#-- 输出: 17:50:56 -->
${nowDate?time?string.long}		<#-- 输出: 下午05时50分56秒 -->
${nowDate?time?string.full}		<#-- 输出: 下午05时50分56秒 CST -->
${nowDate?time?string.xs}		<#-- 输出: 17:50:56.025+08:00 -->
${nowDate?time?string.iso}		<#-- 输出: 17:50:56.025+08:00 -->
<#-- 2.2.3 使用内建格式 -->
${nowDate?datetime?string.short}	<#-- 输出: 18-11-23 下午5:52	 -->
${nowDate?datetime?string.medium}	<#-- 输出: 2018-11-23 17:52:28 -->
${nowDate?datetime?string.long}		<#-- 输出: 2018年11月23日 下午05时52分28秒 -->
${nowDate?datetime?string.full}		<#-- 输出: 2018年11月23日 星期五 下午05时52分28秒 CST -->
${nowDate?datetime?string.xs}		<#-- 输出: 2018-11-23T17:52:28.021+08:00 -->
${nowDate?datetime?string.iso}		<#-- 输出: 2018-11-23T17:52:28.021+08:00 -->


=========================== 分割符 ================================


<#--  
	测试布尔值内建函数
-->
<#-- 1. string内建函数: 使用string内建函数返回的一定是字符串 -->
<#-- 1.1 foo?string("yes","no") -->
${flag?string("是","否")}		<#-- 输出: 是 -->
${flag2?string("是","否")}		<#-- 输出: 否 -->
${(flag3?string("是","否"))!"flag3 is null"}		<#-- 输出: flag3 is null -->
<#-- 1.2 foo?string -->
${flag?string}					<#-- 输出: true -->
${flag2?string}					<#-- 输出: false -->
${(flag3?string)!"flag3 is null"}				<#-- 输出: flag3 is null -->
<#-- 1.3 foo?c -->
${flag?c}						<#-- 输出: true -->
${flag2?c}						<#-- 输出: false -->
${(flag3?c)!"flag3 is null"}					<#-- 输出: flag3 is null -->
<#-- 1.4 -->
<#assign x=10>
<#assign y=20>
${(x>y)?string(x,y)}			<#-- 输出: 20 -->
${(x<y)?string(x,y)}			<#-- 输出: 10 -->
${(x<y)?c}						<#-- 输出: true -->
${100 + (x>y)?string(x,y)}		<#-- 输出: 10020,  这个很明显不是我们要的结果,虽然y是数字类型,但是调用string内建函数之后,就变成了字符串"20" -->
${100 + (x>y)?c}				<#-- 输出: 100false -->
<#--  
	注: foo?String("yes","no") 已经不建议使用,建议使用 ?then("yes","no") 代替
	    foo?string 已经不建议使用,建议使用 ?c 代替	
-->

<#-- 2. then内建函数: 使用then内建函数返回的可以任何类型的数据 -->
<#-- 2.1 -->
${flag?then("是","否")}			<#-- 输出: 是 -->
${flag2?then("是","否")}			<#-- 输出: 否 -->
${(flag3?then("是","否"))!"flag3 is null"}		<#-- 输出: flag3 is null -->
<#-- 2.2 -->
<#assign n1=10>
<#assign n2=20>
${(x>y)?then(x,y)}				<#-- 输出: 20 -->
${(x<y)?then(x,y)}				<#-- 输出: 10 -->
${100 + (x>y)?then(x,y)}		<#-- 输出: 120,   这个就是我们的想要取得的数据 -->
${100 + (x>y)?then(2,3)}		<#-- 输出: 102 -->
${100 + (x>y)?then("2","3")}	<#-- 输出: 1003 -->


=========================== 分割符 ================================


<#--  
	测试数字内建函数
-->
<#-- 1. abs: 求出数字的绝对值 -->
<#assign x=-101 y=102>
${x?abs}						<#-- 输出: 101 -->
${y?abs}						<#-- 输出: 102 -->
${(num2?abs)!"num2 is null"}	<#-- 输出: num2 is null -->

<#-- 2. lower_abc: 将数字转换成26个小写英文字符 -->
<#list 1..10 as n>
	${n?lower_abc} <#t>
</#list>
<#-- 输出结果: a b c d e f g h i j -->
<#list 1..30 as n>
	${n?lower_abc} <#t>
</#list>
<#-- 输出结果: a b c d e f g h i j k l m n o p q r s t u v w x y z aa ab ac ad  -->

<#-- 3. upper_abc: 将数字转换成26个大写英文字符 -->
<#list 1..10 as n>
	${n?upper_abc} <#t>
</#list>
<#-- 输出结果: A B C D E F G H I J -->
<#list 1..30 as n>
	${n?upper_abc} <#t>
</#list>
<#-- 输出结果: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z AA AB AC AD -->

<#-- 
	4.round、floor、ceiling: 使用确定的舍入法则，转换一个数字到整数
		1) round: 返回最近的整数。 如果数字以.5结尾，那么它将进位(四舍五入)
		2) floor: 返回数字的舍掉小数后的整数 (向下取整)
		3) ceiling: 返回数字小数进位后的整数 (向上取整)
-->
<#assign x1=-1 x2=-1.4 x3=-1.6 x4=1 x5=1.4 x6=1.6 x7=-1.49 x8=1.49 />
<#-- 4.1 round内建函数 -->
${x1?round}						<#-- 输出: -1 -->
${x2?round}						<#-- 输出: -1 -->
${x3?round}						<#-- 输出: -2 -->
${x4?round}						<#-- 输出: 1 -->
${x5?round}						<#-- 输出: 1 -->
${x6?round}						<#-- 输出: 2 -->
${x7?round}						<#-- 输出: -1 -->
${x8?round}						<#-- 输出: 1 -->
<#-- 4.2 floor内建函数 -->
${x1?floor}						<#-- 输出: -1 -->
${x2?floor}						<#-- 输出: -2 -->
${x3?floor}						<#-- 输出: -2 -->
${x4?floor}						<#-- 输出: 1 -->
${x5?floor}						<#-- 输出: 1 -->
${x6?floor}						<#-- 输出: 1 -->
${x7?floor}						<#-- 输出: -2 -->
${x8?floor}						<#-- 输出: 1 -->
<#-- 4.3 ceiling内建函数 -->
${x1?ceiling}					<#-- 输出: -1 -->
${x2?ceiling}					<#-- 输出: -1 -->
${x3?ceiling}					<#-- 输出: -1 -->
${x4?ceiling}					<#-- 输出: 1 -->
${x5?ceiling}					<#-- 输出: 2 -->
${x6?ceiling}					<#-- 输出: 2 -->
${x7?ceiling}					<#-- 输出: -1 -->
${x8?ceiling}					<#-- 输出: 2 -->

<#--  
	5. string: 将一个数字转换成字符串,可以使用这个内建函数指定一种格式,也可以使用自带的本地格式
		有四种预定义的数字格式: computer、currency、number 、percent
-->
<#assign x=666>
<#-- 5.1 使用自带的本地格式 -->
<#-- 5.1.1 没有设置默认的数字格式 -->
<#-- 因为我们本地是 zh_CN,所以会输出下面的 -->
${x}							<#-- 输出: 666,读取默认格式 -->
${x?string}						<#-- 输出: 666,读取默认格式 -->
${x?string.computer}			<#-- 输出: 666 -->
${x?string.currency}			<#-- 输出: ￥666.00 -->
${x?string.number}				<#-- 输出: 666 -->
${x?string.percent}				<#-- 输出: 66,600% -->
<#-- 5.1.2 设置了默认的数字格式 -->
<#setting number_format="currency">
${x}							<#-- 输出: ￥666.00 -->
${x?string}						<#-- 输出: ￥666.00 -->
${x?string.computer}			<#-- 输出: 666 -->
${x?string.currency}			<#-- 输出: ￥666.00 -->
${x?string.number}				<#-- 输出: 666 -->
${x?string.percent}				<#-- 输出: 66,600% -->

<#-- 5.2 使用Java数字格式语法,指定自己需要的格式 -->
<#assign x=1.567>
${x?string("0")}				<#-- 输出: 2 -->
${x?string("0.#")}				<#-- 输出: 1.6 -->
${x?string("0.##")}				<#-- 输出: 1.57 -->
${x?string("0.###")}			<#-- 输出: 1.567 -->
${x?string("0.####")}			<#-- 输出: 1.567 -->

${x?string("000.00")}			<#-- 输出: 001.57 -->
${x?string("000.000")}			<#-- 输出: 001.567 -->
${x?string("000.0000")}			<#-- 输出: 001.5670 -->
${x?string(".00")}				<#-- 输出: 1.57 -->

<#-- 下面要注意一下 -->
${1.5?string("0")}				<#-- 输出: 2 -->
${2.5?string("0")}				<#-- 输出: 2 -->
${3.5?string("0")}				<#-- 输出: 4 -->
${4.5?string("0")}				<#-- 输出: 4 -->

${4.52?string("0")}				<#-- 输出: 5 -->
${4.58?string("0")}				<#-- 输出: 5 -->


=========================== 分割符 ================================


<#--  
	测试 序列内建函数
-->
<#assign seq=['a','b','c','d','e','f','g','h','i','j']>
<#-- 1. chunk: 将序列分隔为多个序列 -->
<#list seq?chunk(4) as row> 
	<#list row as cell>${cell} <#t></#list>
</#list>
<#-- 
输出结果:   
	a b c d 
	e f g h 
	i j 
-->
<#list seq?chunk(4,"*") as row>
	<#list row as cell>${cell} <#t></#list>
</#list>
<#--  
输出结果:
	a b c d 
	e f g h 
	i j * *
-->

<#-- 2. first: 序列的第一个子变量 -->
${seq?first}					<#-- 输出: a -->

<#-- 3. last: 序列的最后一个子变量 -->
${seq?last}						<#-- 输出: j -->

<#-- 4. size: 序列中子变量的数量 -->
${seq?size}						<#-- 输出: ￥10.00, 这里之所以输出这个,是因为我们之前设置了 <#setting number_format="currency"> , 那么所有的数值都会显示成货币 -->
${seq?size?string.number}		<#-- 输出: 10 -->

<#-- 
	5. join: 使用给定的分隔符来连接序列中的项为一个独立的字符串 
		join内建函数最多可以有三个参数:
		1) 分割符,必选
		2) 空值,默认是""(空字符串),如果序列为空,使用该值
		3) 列表结尾,默认是""(空字符串),如果列表序列不为空,该值在最后一个值后面输出。
-->
${seq?join(",")}				<#-- 输出: a,b,c,d,e,f,g,h,i,j -->
${[]?join(",","*")}				<#-- 输出: * -->
${seq?join(",","*","!")}		<#-- 输出: a,b,c,d,e,f,g,h,i,j! -->

<#-- 6. reverse: 序列反转 -->
<#list seq?reverse as item>
	${item} <#t>
</#list>
<#-- 输出: j i h g f e d c b a  -->

<#-- 7. seq_contains: 判断序列中是否包含指定的值,返回布尔值 .  注意:包含指定的值的类型也要判断 -->
${seq?seq_contains("f")?string("包含","不包含")}		<#-- 输出: 包含 -->
${seq?seq_contains("t")?string("包含","不包含")}		<#-- 输出: 不包含 -->

<#-- 
	8. seq_index_of: 返回序列中第一次出现该值时的索引位置,索引从0开始,找不到返回-1
		该内建函数包含两个参数:
		1) 第一次参数是要搜索的值
		2) 第二个参数索引开始的位置,默认为0; 如果第二个参数是负数,也相当于0
-->
<#setting number_format="number">
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#-- 8.1 没有第二个参数 -->
${str?seq_index_of("w")}		<#-- 输出: 1 -->
${str?seq_index_of("g")}		<#-- 输出: 8 -->
${str?seq_index_of("p")}		<#-- 输出: -1 -->

<#-- 8.2 有第二个参数 -->
${str?seq_index_of("d",1)}		<#-- 输出: 4 -->
${str?seq_index_of("d",20)}		<#-- 输出: -1 -->
${str?seq_index_of("d",-2)}		<#-- 输出: 0 -->

<#-- 9. seq_last_index_of: 返回序列中最后一次出现值的索引位置 -->
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#-- 9.1 没有第二个参数 -->
${str?seq_last_index_of("x")}	<#-- 输出: 6 -->
${str?seq_last_index_of("p")}	<#-- 输出: -1 -->

<#-- 9.2 有第二个参数 -->
${str?seq_last_index_of("x",9)}	<#-- 输出: 6 -->
${str?seq_last_index_of("x",5)}	<#-- 输出: 2 -->

<#-- 10 sort: 以升序方式返回序列 -->
<#assign str=["d","w","x","r","d","a","x","f","g","d"]>
<#list str?sort as temp>
	${temp} <#t>
</#list>
<#-- 输出结果: a d d d f g r w x x -->

<#-- 11 sort_by: 按照给定的名称来升序排列序列 -->
<#assign user=[
				{"name":"zhangsan","age",25},
				{"name":"lisi","age":20},
				{"name":"wangwu","age":38},
				{"name":"zhaoliu","age":18},
				{"name":"qianqi","age",28}
			]>
<#list user?sort_by("name") as temp>
	${temp.name}-${temp.age}
</#list>
<#--  
输出结果:
	lisi-20
	qianqi-28
	wangwu-38
	zhangsan-25
	zhaoliu-18
-->


=========================== 分割符 ================================


<#--  
	测试 哈希表内建函数
-->
<#-- 1. keys: 包含哈希表中查找到的键的序列 -->
<#assign user={"name":"chenming","age":24,"province":"hubei","grade":"university"}>
<#assign userKeys = user?keys>
<#list userKeys as key>
	${key} <#t><#sep>,</#sep>
</#list>
<#-- 输出结果: name ,age ,province ,grade -->

<#-- 2. values: 包含哈希表中变量值的序列 -->
<#assign userValues = user?values>
<#list userValues as value>
	${value} <#t><#sep>,</#sep>
</#list>
<#-- 输出结果: chenming ,24 ,hubei ,university -->


=========================== 分割符 ================================


<#--  
	测试 循环变量内建函数: 这些内建函数只能用于list指令和items指令
-->
<#-- 1. counter: 返回当前迭代从1开始的索引 -->
<#assign str=["a","b","c","d","e"]>
<#list str as item>
	${item?counter}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 1,2,3,4,5 -->

<#-- 2. has_next: 判断是否循环项是否还有下一项,即判断当前项是不是最后一项 -->
<#list str as item>
	${item?has_next?string("Y","N")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: Y,Y,Y,Y,N -->

<#-- 3. index: 返回当前迭代从0开始的索引 -->
<#list str as item>
	${item?index}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 0,1,2,3,4 -->

<#-- 4. is_first: 是否是当前迭代的第一项 -->
<#list str as item>
	${item?is_first?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 是,否,否,否,否 -->

<#-- 5. is_last： 是否是当前迭代的最后一项 -->
<#list str as item>
	${item?is_last?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 否,否,否,否,是 -->

<#-- 6. is_even_item: 判断当前迭代项是否是偶数项 -->
<#list str as item>
	${item?is_even_item?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 否,是,否,是,否 -->

<#-- 7. is_odd_item: 判断当前迭代项是否是奇数项 -->
<#list str as item>
	${item?is_odd_item?string("是","否")}<#sep>,</#sep><#t>
</#list>
<#-- 输出结果: 是,否,是,否,是 -->

<#-- 8. item_parity: 基于当前迭代间隔为1的索引的奇偶性,返回字符串为"odd"或"even" -->
<#list str as item>
	<tr class="${item?item_parity}Row"></tr>
</#list>
<#--  
输出结果:
	<tr class="oddRow"></tr>
	<tr class="evenRow"></tr>
	<tr class="oddRow"></tr>
	<tr class="evenRow"></tr>
	<tr class="oddRow"></tr>
-->

<#-- 9. item_parity_cap: 基于当前迭代间隔为1的索引的奇偶性,返回"Odd"或"Even"(注意是大写) -->
<#list str as item>
	<tr class="row${item?item_parity_cap}"></tr>
</#list>
<#-- 
输出结果: 
	<tr class="rowOdd"></tr>
	<tr class="rowEven"></tr>
	<tr class="rowOdd"></tr>
	<tr class="rowEven"></tr>
	<tr class="rowOdd"></tr>
-->


=========================== 分割符 ================================


<#--  
	测试 字符串内建函数
-->
<#-- 1. boolean: 字符串转为布尔值,字符串必须是true或false(大小写敏感),或者必须是由boolean_format设置的特定格式 -->

<#-- 2. cap_first: 字符串中的首单词的首字母大写  uncap_first-->
${"hello"?cap_first}			<#-- 输出: Hello -->
${"hello world"?cap_first}		<#-- 输出: Hello world -->
${"HELLO WORLD"?uncap_first}	<#-- 输出: hELLO WORLD -->

<#-- 3. capitalize: 字符串中所有单词的首字母大写 -->
${"my name is chenming"?capitalize} <#-- 输出: My Name Is Chenming -->

<#-- 4. contains: 是否包含指定子串 -->
${"my name is chenming"?contains("nm")?string("是","否")}	<#-- 输出: 是 -->

<#-- 5. date、time、datetime: 字符串转换成日期值 -->
${"2018-11-25 15:03:30"?datetime}	<#-- 输出: 2018-11-25 15:03:30 -->
<#-- 上面取出的究竟是字符串,还是日期类型呢?  可以调用一下日期类型的内建函数试一下 -->
${"2018-11-25 15:03:30"?datetime?date?string.short}	<#-- 输出: 18-11-25 -->
<#-- 上面的一行能够正常输出,说明 "2018-11-25 15:03:30"?datetime 返回的就是date类型  -->
<#-- 指定输出的格式 -->
${"2018/11/25 15/03/30"?datetime("yyyy/MM/dd HH/mm/ss")}	<#-- 输出: 2018-11-25 15:03:30 -->

<#-- 6. starts_with: 判断是否以指定的字符串开头 -->
${"hello world"?starts_with("he")?string("true","false")}	<#-- 输出: true -->

<#-- 7. ensure_starts_with:  -->
${"hello world"?ensure_starts_with("every","every one,")}	<#-- 输出: every one,hello world -->
${"hello world"?ensure_starts_with("he","hello")}			<#-- 输出: hello world -->

<#-- 8. ends_with -->
${"hello world"?ends_with("ld")?string("true","false")}		<#-- 输出: true -->
${"hello world"?ends_with("l")?string("true","false")}		<#-- 输出: false -->

<#-- 9. ensure_ends_with -->
${"hello world!"?ensure_ends_with("ld")}	<#-- 输出: hello world!ld -->

<#-- 10. index_of -->
${"hello world"?index_of("lo")}				<#-- 输出: 3 -->

<#-- 11. length -->
${"hello world"?length}						<#-- 输出: 11 -->

<#-- 12. lower_case -->
${"HELLO WORLD"?lower_case}		<#-- 输出: hello world -->

<#-- 13. upper_case -->
${"hello world"?upper_case}		<#-- 输出: HELLO WORLD -->

<#-- 14. number -->
${ 1 + "12"?number}				<#-- 输出: 13 -->

<#-- 15. replace -->
${"hello world"?replace("o","G")}	<#-- 输出: hellG wGrld -->

<#-- 16. split -->
<#list "hello world"?split(" ") as item>
	${item}
</#list>
<#-- 
输出 
	hello
	world
-->

<#-- 17. substring -->
${"hello world"?substring(1)}	<#-- 输出: ello world -->

<#-- 18. html -->
${"<p>hello world</p>"?html}	<#-- 输出: &lt;p&gt;hello world&lt;/p&gt; -->





>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
