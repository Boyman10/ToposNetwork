package org.rhm.climb.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for authentication purpose and may be additional user management - will be separated..
 * @author bob
 * @version 1.0
 */
public class UserAction  extends ActionSupport implements SessionAware {

	/**
	 * TODO : https://www.journaldev.com/2203/get-servlet-session-request-response-context-attributes-struts-2-action 
	 */
	private static final long serialVersionUID = -312477649388098567L;

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}


}
