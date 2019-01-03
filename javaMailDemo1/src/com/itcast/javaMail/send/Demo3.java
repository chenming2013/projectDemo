package com.itcast.javaMail.send;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 测试邮件：
 * 	之前在Demo1.java和Demo2.java中，邮件的内容都是比较简单的，要么是直接的纯文本(Demo1),要么高级一点的html(Demo2)，
 *  现在在Demo3中更深入一点：
 *  	一封邮件有附件，邮件正文还要包含图片,
 *  	这里只是测试邮件内容,就不测试发邮件了
 * @author Lenovo
 *
 */
public class Demo3
{
	public static void main(String[] args) throws Exception
	{
		//我们这里只是测试邮件内容,就不连接邮件服务器了
		Session session = Session.getInstance(new Properties());
		//创建邮件对象
		Message message = new MimeMessage(session);
		
		//MimeMutipart对象是代表复杂邮件,multipart代表邮件内容之间的关系
		//有multipart/mixed,multipart/related,multipart/alternative三种关系
		//但是要注意：这里传入的参数是子类型(multipart是父类型,mixed、related、alternative都是multipart这个父类型下的子类型)
		MimeMultipart msgMultipart = new MimeMultipart("mixed");
		message.setContent(msgMultipart);
		
		//这是邮件的正文
		MimeBodyPart content = new MimeBodyPart();
		//这是邮件的附件
		MimeBodyPart attach1 = new MimeBodyPart();
		//这是邮件的附件
		MimeBodyPart attach2 = new MimeBodyPart();
		//将邮件正文，邮件附件添加到MimeMultipart复杂邮件对象中
		msgMultipart.addBodyPart(attach1);
		msgMultipart.addBodyPart(attach2);
		msgMultipart.addBodyPart(content);
		
		//处理附件
		DataSource dataSource1 = new FileDataSource("C:\\Users\\Lenovo\\Desktop\\知识点.txt");
		DataHandler dataHandler1 = new DataHandler(dataSource1);
		attach1.setDataHandler(dataHandler1);
		//附件都有一个附件名
		attach1.setFileName("knowledge.txt");
		DataSource dataSource2 = new FileDataSource("C:\\Users\\Lenovo\\Desktop\\核心.txt");
		DataHandler dataHandler2 = new DataHandler(dataSource2);
		attach2.setDataHandler(dataHandler2);
		attach2.setFileName("core.txt");
		
		//处理正文,而正文是由文本(或html)和图片组成的,又是一个复杂结构,
		//但是此时文本和图片的关闭就是mixed的,而是related
		MimeMultipart bodyMultipart = new MimeMultipart("related");
		content.setContent(bodyMultipart);
		//创建html部分的对象
		MimeBodyPart htmlPart = new MimeBodyPart();
		//创建图片部分的对象
		MimeBodyPart gifPart = new MimeBodyPart();
		
		//将html对象和图片对象设置到正文对象中
		bodyMultipart.addBodyPart(htmlPart);
		bodyMultipart.addBodyPart(gifPart);
		
		DataSource gifDataSource = new FileDataSource("C:\\Users\\Lenovo\\Pictures\\项目图片\\img\\2.gif");
		DataHandler gifDataHandler = new DataHandler(gifDataSource);
		gifPart.setDataHandler(gifDataHandler);
		
		htmlPart.setContent("<h1>测试复杂邮件</h1>","text/html;charset=utf-8");
		
		//这个方法是必须的
		message.saveChanges();
		
		//我们邮件对象已经全部完成了,现在不发送邮件,而是将这个邮件内容输出出来
		OutputStream out = new FileOutputStream("F:\\tempDirectory\\mail\\demo3.eml");
		message.writeTo(out);
		
		out.close();
	}
}
