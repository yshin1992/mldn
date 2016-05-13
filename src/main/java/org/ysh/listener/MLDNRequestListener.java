package org.ysh.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ServletRequestListener
 *
 */
public class MLDNRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("处理请求:"+sre.getServletRequest().getRemoteAddr()+
    			"-->请求context"+sre.getServletContext().getContextPath()+"销毁...");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("处理请求:"+sre.getServletRequest().getRemoteAddr()+
    			"-->请求context"+sre.getServletContext().getContextPath()+"开始...");
    }
	
}
