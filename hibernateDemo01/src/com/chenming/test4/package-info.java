/**
 * @author Lenovo
 *	com.chenming.test4这个包是用来测试Hibernate自定义数据类型的映射
 *	举个简单的例子：对于TUser对象,我们需要为其增加一个email字段,且一个TUser对象可以有多个email,这就是一个一对多的问题。
 *	对于一对多关系的映射通常由三种解决思路:
 *		1.为T_User表增加email1、email2...字段
 *		2.增加一个T_Email表,T_User表通过主键与其形成一对多关联
 *		3.折中做法,email字段中保存用户所有的email信息,各个邮箱之间用特定的分隔符隔开。
 *	这三种做法,各有各的优点和缺点,这个包中使用的通过UserType解决这类问题 	
 */
package com.chenming.test4;