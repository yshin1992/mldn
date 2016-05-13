package org.ysh.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 绑定session的实体类
 * @author Administrator
 *
 */
public class LoginUser implements HttpSessionBindingListener {

	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("当前绑定session:"+event.getSession().getId() + "添加属性:"+this.getUsername());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("当前绑定session:"+event.getSession().getId() + "移除属性:"+this.getUsername());
	}

}
