package org.ysh.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 继承自BodyTagSupport实现自定义标签
 * @author lion
 *
 */
public class BodyIterateTag extends BodyTagSupport {

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
	
	//如果不写此方法将无法输出
	//使用BodyTagSupport时BodyTag会将内容设置到bodyContent内，但是bodyContent不会自动输出的
	public int doEndTag() throws JspException{
		if(null != bodyContent)
		{
			try {
				bodyContent.writeOut(getPreviousOut());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return BodyTagSupport.EVAL_PAGE; //正常执行完毕
	}
}
