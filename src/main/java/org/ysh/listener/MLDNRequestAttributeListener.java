package org.ysh.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class MLDNRequestAttributeListener
 *
 */
public class MLDNRequestAttributeListener implements ServletRequestAttributeListener {


    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	ServletRequest req = srae.getServletRequest();
    	ServletContext ctx = srae.getServletContext();
    	System.out.println(req.getRemoteAddr()+":"+req.getRemotePort() + "访问 "+ ctx.getContextPath() + ": 增加属性 "
    			+ srae.getName() + "--<>" + srae.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	ServletRequest req = srae.getServletRequest();
    	ServletContext ctx = srae.getServletContext();
    	System.out.println(req.getRemoteAddr()+":"+req.getRemotePort() + "访问 "+ ctx.getContextPath() + ": 移除属性 "
    			+ srae.getName() + "--<>" + srae.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	ServletRequest req = srae.getServletRequest();
    	ServletContext ctx = srae.getServletContext();
    	System.out.println(req.getRemoteAddr()+":"+req.getRemotePort() + "访问 "+ ctx.getContextPath() + ": 替换属性 "
    			+ srae.getName() + "--<>" + srae.getValue());
    }
	
}
