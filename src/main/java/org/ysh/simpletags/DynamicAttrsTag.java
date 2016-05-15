package org.ysh.simpletags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 实现DynamicAttributes接口
 * @author lion
 *
 */
public class DynamicAttrsTag extends SimpleTagSupport implements
		DynamicAttributes {

	private List<String> keys = new ArrayList<String>();

	private List<Object> values = new ArrayList<Object>();

	/**
	 * localName保存属性名
	 * value保存属性值
	 */
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		keys.add(localName);
		values.add(value);
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(keys.size() > 0)
		{
			for(int i=0,j=keys.size();i<j;i++)
			{
				getJspContext().setAttribute("key", keys.get(i));
				getJspContext().setAttribute("value", values.get(i));
				getJspBody().invoke(null);
			}
		}
		
	}

}
