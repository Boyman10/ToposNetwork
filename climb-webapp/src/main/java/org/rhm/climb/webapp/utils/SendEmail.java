package org.rhm.climb.webapp.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Class handling the email sending from the actions - using Gmail secure smtp
 * @author Boyman10
 * @version 0.1.1
 */
public class SendEmail {
	
	private String authPassword = "", emailFrom = "";
	
	/**
	 * Constructor initializing smtp mail parameters - 
	 * @todo use properties file to handle the configuration parameters...
	 * @param pass
	 * @param emailFrom
	 */
	public SendEmail(String pass, String emailFrom) {
		this.authPassword = pass;
		this.emailFrom = emailFrom;
	}
	
	public int sendMail(String to, String subject, String msg) {

		// setting gmail smtp properties
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailFrom, authPassword);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// add the Subject of email
			message.setSubject(subject);

			// message body
			message.setText(msg);

			Transport.send(message);
			return 1;
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
