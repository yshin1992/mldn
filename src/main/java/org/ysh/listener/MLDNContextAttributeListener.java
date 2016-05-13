package org.ysh.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MLDNContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("application 增加属性 "+event.getName() + "-->"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("application 移除属性 "+event.getName() + "-->"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("application 替换属性值  "+event.getName() + "-->"+event.getValue());
	}

}
