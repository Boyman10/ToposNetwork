package org.rhm.climb.webapp.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

			this.addActionMessage("Message sent, thank you, you will get a reply soon!");

			return SUCCESS;
		} else
			return INPUT;
	}

}
