<#--  
	这是配合  NullValueTest#testMethod_1()方法 进行测试空值
-->
${name!"name is null"}
${num!0}
${(date?datetime)!"date is null"}

${(nameList?size)!"nameList is null"}
<#if nameList??>
	${nameList?size}
<#else>
	nameList is null	
</#if>

${(nameList2?size)!"nameList2 is null"}
<#if nameList2??>
	${nameList2?size}
<#else>
	nameList2 is null	
</#if>

${(nameList3?size)!"nameList3 is null"}
<#if nameList3??>
	${nameList3?size}
<#else>
	nameList3 is null
</#if>

<#-- map没有size方法 -->
${nameMap!"nameMap is null"}

