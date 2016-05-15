package org.ysh.tags;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * List迭代标签
 * @author lion
 *
 */
public class IteraterTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private List<?> list;
	
	private Iterator<?> iter;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException{
		if(null != list)
		{
			iter = list.iterator();
			if(iter.hasNext())
			{
				pageContext.setAttribute(id, iter.next());
				return TagSupport.EVAL_BODY_INCLUDE;
			}else
			{
				return TagSupport.SKIP_BODY;
			}
		}
		return TagSupport.SKIP_BODY;
	}
	
	@Override
	public int doAfterBody() throws JspException{
		if(iter.hasNext())
		{
			pageContext.setAttribute(id, iter.next());
			return TagSupport.EVAL_BODY_AGAIN;
		}
		return TagSupport.SKIP_BODY;
	}
}
