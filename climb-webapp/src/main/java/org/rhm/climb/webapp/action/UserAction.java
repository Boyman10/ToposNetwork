package org.rhm.climb.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for authentication purpose and may be additional user management - will be separated..
 * @author bob
 * @version 1.0
 */
public class UserAction  extends ActionSupport implements ServletRequestAware, SessionAware {

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
