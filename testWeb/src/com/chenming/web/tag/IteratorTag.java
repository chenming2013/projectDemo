package com.chenming.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 测试自定义标签(迭代标签)
 * @author ADMIN
 *
 */
public class IteratorTag extends TagSupport{
	private String name;
	private String[] items;
	private int i = 1;
	
	/*
	 * 开始标签执行方法
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		System.out.println("循环...");
		
		if(items!=null && items.length>0) {
			pageContext.setAttribute(name, items[0]);
			return EVAL_BODY_INCLUDE;
		}else {
			return SKIP_BODY;
		}
	}
	
	/**
	 * 
	 */
	@Override
	public int doAfterBody() throws JspException {
		if(i<items.length) {
			pageContext.setAttribute(name, items[i]);
			i++;
			return EVAL_BODY_AGAIN;
		}else {
			return SKIP_BODY;
		}
	}
	
	/* Setter */
	public void setName(String name) {
		this.name = name;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
}
