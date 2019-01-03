package com.itcast.javaMail.send;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 测试发送邮件：
 * 	这是邮件发送的一种方法,邮件发送的另一种方法请参考Demo2.java
 * @author 陈明
 *
 */
public class Demo1
{
	public static void main(String[] args)
	{
		
		try
		{
			Properties props = new Properties();
			//发送邮件的时候需要验证(验证发件人的用户名和密码),这是必须的
			props.setProperty("mail.smtp.auth", "true");
			//调试信息
			props.setProperty("mail.debug", "true");
			//使用的传输协议,这是必须的
			props.setProperty("mail.transport.protocol", "smtp");
			Session session = Session.getInstance(props);
			
			//邮件对象
			Message message = new MimeMessage(session);
			message.setText("hello,这是我的第一封测试邮件!"); //这是发简单的纯文本邮件
			message.setFrom(new InternetAddress("chenming_test@sohu.com"));  //可以不填 
			
			//传输协议对象
			Transport transport = session.getTransport();
			/**
			 * 连接邮箱服务器
			 * 四个参数：smtp服务器、smtp服务器端口号、邮箱账号、邮箱密码
			 */
			transport.connect("smtp.sohu.com", 25, "chenming_test", "CM20130530819"); 
			
			//发送邮件
			/**
			 * 这里是一个Address[]，说明这一封邮件可以发给多个人
			 */
			transport.sendMessage(message,new Address[] {new InternetAddress("chenming_test@sina.com")});
			
			//发完邮件之后要关闭
			transport.close();
		} catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
