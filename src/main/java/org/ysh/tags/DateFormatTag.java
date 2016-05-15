package org.ysh.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Date 格式化标签
 * @author lion
 *
 */
public class DateFormatTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private Date formatDate;
	
	private String pattern;

	public void setFormatDate(Date formatDate) {
		this.formatDate = formatDate;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public int doStartTag() throws JspException{
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		try {
			pageContext.getOut().write(fmt.format(formatDate));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}

}
