package org.ysh.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱登录验证类
 * @author Administrator
 *
 */
public class MailSecurity extends Authenticator {

	private String name;
	
	private String password;

	public MailSecurity()
	{
		name = "";
		password = "";
	}
	
	public MailSecurity(String name,String password){
		this.name = name;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(name,password);
	}
	
}
