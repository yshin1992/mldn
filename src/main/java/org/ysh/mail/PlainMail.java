package org.ysh.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainMail {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InternetAddress[] address = null;
		String mailServer="smtp.163.com";
		String from = "yshin1992@163.com";
		String to = "1658922720@qq.com";
		String subject = "Java Mail 普通邮件测试";
		String messageText = "这是一封系统测试邮件，勿回!";
		Properties props = null;
		props = System.getProperties();
		props.put("mail.smtp.host", mailServer);
		props.put("mail.smtp.auth", "true");
		
		Session mailSession = Session.getDefaultInstance(props,new MailSecurity("yshin1992@163.com", "1658922720"));
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		address = InternetAddress.parse(to, false);//设定传送邮件至收件人的邮箱
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(messageText);
		Transport.send(msg,msg.getAllRecipients());
	}

}
