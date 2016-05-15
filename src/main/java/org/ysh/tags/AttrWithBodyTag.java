package org.ysh.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 带有body体的标签
 * @author lion
 *
 */
public class AttrWithBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String scope;
	
	private String attributeName;

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public int doStartTag() throws JspException{
		
		Object value = null;
		
		if("page".equals(scope)){
			value = pageContext.getAttribute(attributeName,PageContext.PAGE_SCOPE);
		}else if("request".equals(scope)){
			value = pageContext.getAttribute(attributeName,PageContext.REQUEST_SCOPE);
		}else if("session".equals(scope)){
			value = pageContext.getAttribute(attributeName,PageContext.SESSION_SCOPE);
		}else if("application".equals(scope)){
			value = pageContext.getAttribute(attributeName,PageContext.APPLICATION_SCOPE);
		}
		
		if(null == value)
		{
			return TagSupport.SKIP_BODY;
		}
		else
		{
			return TagSupport.EVAL_BODY_INCLUDE;
		}
		
	}
}
