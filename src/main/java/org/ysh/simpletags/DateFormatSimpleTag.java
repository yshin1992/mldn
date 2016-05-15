package org.ysh.simpletags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 基于simpleTagSupport开发自定义标签
 * @author lion
 *
 */
public class DateFormatSimpleTag extends SimpleTagSupport {

	private Date formatDate;
	
	private String pattern;

	public void setFormatDate(Date formatDate) {
		this.formatDate = formatDate;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	@Override
	public void doTag() throws JspException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		getJspContext().getOut().write(sdf.format(formatDate));
	}
	
	
}
