package org.ysh.mail;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MultiPartMail {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		InternetAddress[] address = null;
		String mailServer="smtp.163.com";
		String from = "yshin1992@163.com";
		String to = "yanshuai@gmistech.com";
		String subject = "Java Mail 附带文件测试";
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
	
		
		Multipart multipart = new MimeMultipart();
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(new File("D:"+File.separator + "logo.png"));
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("logo.png");
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg,msg.getAllRecipients());
	}

}
