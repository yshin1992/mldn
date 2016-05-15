package org.ysh.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 第一个自定义Tag
 * 继承自 TagSupport
 * @author lion
 *
 */
public class HelloTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			writer.write("Hello,world!这是第一个自定义标签!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}

	
}
