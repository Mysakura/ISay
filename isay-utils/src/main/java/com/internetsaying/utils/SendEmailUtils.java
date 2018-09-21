package com.internetsaying.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmailUtils {

	private static String account;	//登录用户名
	private static String pass;		//登录密码
	private static String from;		//发件地址
	private static String host;		//服务器地址（邮件服务器）
	private static String port;		//端口
	private static String protocol; //协议
	
	static{
		Properties prop = new Properties();
//		InputStream instream = ClassLoader.getSystemResourceAsStream("email.properties");//测试环境
		try {
//			prop.load(instream);//测试环境
			prop = PropertiesLoaderUtils.loadAllProperties("email.properties");//生产环境
		} catch (IOException e) {
			System.out.println("加载属性文件失败");
		}
		account = prop.getProperty("e.account");
		pass = prop.getProperty("e.pass");
		from = prop.getProperty("e.from");
		host = prop.getProperty("e.host");
		port = prop.getProperty("e.port");
		protocol = prop.getProperty("e.protocol");
	}
	
	static class MyAuthenricator extends Authenticator{  
        String u = null;  
        String p = null;  
        public MyAuthenricator(String u,String p){  
            this.u=u;  
            this.p=p;  
        }  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
            return new PasswordAuthentication(u,p);  
        }  
    }
	
	private String to;	//收件人
	private String token;	//口令
	private String subject;	//主题
	private String text;	//内容
	
	public SendEmailUtils(String to, String token, String subject, String text) {
		this.to = to;
		this.token = token;
		this.subject = subject;
		this.text = text;
	}

	public void send(){
		System.out.println("进入send:" + token);
		Properties prop = new Properties();
		//协议
		prop.setProperty("mail.transport.protocol", protocol);
		//服务器
		prop.setProperty("mail.smtp.host", host);
		//端口
		prop.setProperty("mail.smtp.port", port);
		//使用smtp身份验证
		prop.setProperty("mail.smtp.auth", "true");
		//使用SSL，企业邮箱必需！
		//开启安全协议
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
//		prop.put("mail.smtps.ssl.protocols", "TSLv1 TSLv1.1 TLSv1.2");
//		prop.put("mail.smtps.ssl.ciphersuites", 
//				"TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA TLS_RSA_WITH_AES_128_CBC_SHA TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA TLS_ECDH_RSA_WITH_AES_128_CBC_SHA TLS_DHE_RSA_WITH_AES_128_CBC_SHA TLS_DHE_DSS_WITH_AES_128_CBC_SHA TLS_ECDHE_ECDSA_WITH_RC4_128_SHA TLS_ECDHE_RSA_WITH_RC4_128_SHA SSL_RSA_WITH_RC4_128_SHA TLS_ECDH_ECDSA_WITH_RC4_128_SHA TLS_ECDH_RSA_WITH_RC4_128_SHA TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA SSL_RSA_WITH_3DES_EDE_CBC_SHA TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA SSL_RSA_WITH_RC4_128_MD5 TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
		
		Session session = Session.getDefaultInstance(prop, new MyAuthenricator(account, pass));
		session.setDebug(true);
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress(from,"SmallTarget"));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setSentDate(new Date());
			mimeMessage.setText(text + token);
			mimeMessage.saveChanges();
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

}
