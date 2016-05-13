package org.ysh.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MLDNServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println(event.getServletContext().getContextPath()+"开始启动...");
		Set<String> onlineSession = new HashSet<String>();
		event.getServletContext().setAttribute("online", onlineSession);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println(event.getServletContext().getContextPath()+"开始销毁...");
		Set<String> onlineSession = (Set<String>) event.getServletContext().getAttribute("online");
		System.out.println("当前session共"+onlineSession.size()+"条");
		for(String sessionId : onlineSession)
		{
			System.out.println(sessionId);
		}
		event.getServletContext().removeAttribute("online");
	}

}
