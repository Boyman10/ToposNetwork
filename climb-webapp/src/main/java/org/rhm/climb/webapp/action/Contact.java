package org.rhm.climb.webapp.action;

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

	@Override
	public String execute() {
		
		return SUCCESS;
	}
	
}
