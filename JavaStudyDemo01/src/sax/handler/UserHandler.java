package sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX 事件处理程序
 * 
 * @author 陈明
 * @date 2018年12月4日
 */
public class UserHandler extends DefaultHandler {
	boolean nameFlag = false;
	boolean ageFlag = false;
	boolean gradeFlag = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			String rollNo = attributes.getValue("rollno");
			System.out.println("Roll No : " + rollNo);
		} else if (qName.equalsIgnoreCase("name")) {
			nameFlag = true;
		} else if (qName.equalsIgnoreCase("age")) {
			ageFlag = true;
		} else if (qName.equalsIgnoreCase("grade")) {
			gradeFlag = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			System.out.println("End Element :" + qName);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (nameFlag) {
			System.out.println("name: " + new String(ch, start, length));
			nameFlag = false;
		} else if (ageFlag) {
			System.out.println("age: " + new String(ch, start, length));
			ageFlag = false;
		} else if (gradeFlag) {
			System.out.println("grade: " + new String(ch, start, length));
			gradeFlag = false;
		}
	}
}
