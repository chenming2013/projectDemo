package com.itcast.javaMail.send;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 测试JavaMail邮件发送：
 * 	在Demo1.java中已经测试了一种方法邮件的方法,这里测试发送邮件的另一种方法
 * @author Lenovo
 *
 */
public class Demo2
{
	public static void main(String[] args) throws Exception
	{
		Properties props = new Properties();
		//邮件传输协议,必填
		props.setProperty("mail.transport.protocol", "smtp");
		//用户名密码验证,必填
		props.setProperty("mail.smtp.auth", "true");
		//输出命令
		props.setProperty("mail.debug", "true");
		//邮箱的主机和端口(端口默认可以不写)
		props.setProperty("mail.host", "smtp.sina.com");
		//在这里对用户名和密码进行校验
		Session session = Session.getInstance(props,new Authenticator()
						//这是创建Authenticator的匿名子类
						{
							protected PasswordAuthentication getPasswordAuthentication() 
							{
								return new PasswordAuthentication("chenming_test@sina.com", "CM20130530819");
							};
						});
		
		
		//创建邮件对象
		Message message = new MimeMessage(session);
		/**
		 * setContent()方法能够发送HTML格式的邮件内容,在Demo1.java中的setText()方法只能发送纯文本格式的内容
		 * 	第一个参数是邮件内容,第二个参数是邮件类型
		 * 
		 */
		String obj = "";
			   obj += "<h1>这是我的第二封测试邮件</h1>"
				   +  "	<ul>"
				   +  "		<li style='color:red'>首先要创建Message对象</li>"
				   +  "		<li style='color:red'>然后要使用Transport的send()静态方法发出邮件</li>"
				   +  "	</ul>";
		message.setContent(obj, "text/html;charset=utf-8");
		//设置发件人
		message.setFrom(new InternetAddress("chenming_test@sina.com"));
		//设置邮件的发送方式(发件TO、抄送CC、密送BCC)和收件人
		message.setRecipients(RecipientType.TO, new Address[] {new InternetAddress("chenming_test@sohu.com"),new InternetAddress("2040820766@qq.com")});
		/*
		 * 这里我们调用Transport.send()静态方法发送邮件
		 * 	Transport.send()方法内部又做了三步：
		 * 		1. 创建Transport对象
		 * 		2. 发送邮件
		 * 		3. 关闭传输对象
		 */
		Transport.send(message);
		
	}
}
