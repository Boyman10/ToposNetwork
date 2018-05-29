package org.rhm.climb.webapp.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for contact form
 * @author bob
 * @version 1.0
 */
@Service
public class Contact extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(Contact.class);

	private String contactEmail;
	
	
	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	@Override
	public String execute() {
		
		LOGGER.debug("In success method for action Contact - sending an email here...");
		
		return SUCCESS;
	}
	public void validate(){
		
		LOGGER.debug("In validate method for action Contact...");
	    if (this.contactEmail.length() == 0) {
	        addFieldError("contactEmail", "Email is required.");
	    }

	}
}
