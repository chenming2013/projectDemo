<#--  
	这是配合  HelloworldTest#testMethod_1()方法 进行测试五种类型
-->
${.vars['name']}
${.vars['num']}
${.vars['date']?datetime}
${.vars['nameList'][0]}
${.vars['nameMap'].zhangsan}

${.data_model['name']}
${.data_model['num']}
${.data_model['date']?datetime}
${.data_model['nameList'][0]}
${.data_model['nameMap'].zhangsan}

${name}
${num}
${date?datetime}
${nameList[0]}
${nameMap.zhangsan}

