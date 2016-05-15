package org.ysh.tags;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * 使得在标签中定义的变量可以在页面中使用
 * 例如:
 * 	<jsp:useBean id="book" class="xxxx" />
 *  <% book.setPrice(122); %>
 * @author lion
 *
 */
public class BodyIterateTagExtraInfo extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData data) {
		// TODO Auto-generated method stub
		return new VariableInfo[]{new VariableInfo(data.getId(),
				"java.lang.String", true, VariableInfo.NESTED)
		};
	}

	
}
