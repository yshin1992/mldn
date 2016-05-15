package org.ysh.simpletags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleIteraterTag extends SimpleTagSupport {

	private String id;
	
	private List<?> list;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		Iterator<?> iter = list.iterator();
		
		while(iter.hasNext())
		{
			getJspContext().setAttribute(id, iter.next());
			getJspBody().invoke(null);
		}
	}
	
	
}
