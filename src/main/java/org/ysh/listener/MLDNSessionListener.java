package org.ysh.listener;

import java.util.Set;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器
 * session属性监听器
 * @author Administrator
 *
 */
public class MLDNSessionListener implements HttpSessionAttributeListener,
		HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session : "+se.getSession().getId()+" 创建...");
		Set<String> onlineSession = (Set<String>) se.getSession().getServletContext().getAttribute("online");
		onlineSession.add(se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session : "+se.getSession().getId()+" 销毁...");
		Set<String> onlineSession = (Set<String>) se.getSession().getServletContext().getAttribute("online");
		onlineSession.remove(se.getSession().getId());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session : "+se.getSession().getId()+" 增加属性:"+se.getName()+"-->"+se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session : "+se.getSession().getId()+" 移除属性:"+se.getName()+"-->"+se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session : "+se.getSession().getId()+" 替换属性:"+se.getName()+"-->"+se.getValue());
	}

}
