package org.rhm.climb.webapp.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rhm.climb.webapp.utils.SendEmail;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for contact form
 * 
 * @author bob
 * @version 1.0
 */
@Service
public class Contact extends ActionSupport {

	private static final long serialVersionUID = 144432L;
	private static final Logger LOGGER = LogManager.getLogger(Contact.class);

	private String contactEmail;
	private String contactMessage;
	private String contactSubject;
	
	// temporary field - just for testing
	@Deprecated
	private String tempPass;

	/**
	 * @return the contactMessage
	 */
	public String getContactMessage() {
		return contactMessage;
	}

	/**
	 * @param contactMessage
	 *            the contactMessage to set
	 */
	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}

	/**
	 * @param tempPass
	 * the password to set for smtp
	 */
	public void setTempPass(String tmpPass) {
		this.tempPass = tmpPass;
	}
	/**
	 * @return the tmpPass
	 */
	public String getTempPass() {
		return tempPass;
	}	
	
	/**
	 * @return the contactSubject
	 */
	public String getContactSubject() {
		return contactSubject;
	}

	/**
	 * @param contactSubject
	 *            the contactSubject to set
	 */
	public void setContactSubject(String contactSubject) {
		this.contactSubject = contactSubject;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String execute() {

		if (!StringUtils.isAnyEmpty(contactEmail, contactMessage, contactSubject)) {

			LOGGER.debug("In success method for action Contact - sending an email here...");
			
			
			SendEmail mailer = new SendEmail(tempPass,contactEmail);

			int resp = mailer.sendMail(contactEmail, contactSubject, contactMessage);

			if (resp == 1) {
				this.addActionMessage("Message sent, thank you, you will get a reply soon!");
				return SUCCESS;
			} else {
				this.addActionError("Problem while sending the message!");
				return INPUT;
			}
			
			
		} else
			return INPUT;
	}

}
