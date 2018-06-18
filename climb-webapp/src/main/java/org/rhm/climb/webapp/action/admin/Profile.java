package org.rhm.climb.webapp.action.admin;

import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.user.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for profile interface
 * 
 * @author bob
 * @version 1.0
 */
public class Profile extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1455L;
	private static final Logger LOGGER = LogManager.getLogger(Profile.class);

	// Constant to be used to identify session
	private static final String USER = "user";

	// ==================== Attributes ====================

	// Handling session
	private Map<String, Object> userSession;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Out element
	private User user;

	// ==================== Getters/Setters ====================

	public User getUser() {
		return user;
	}

	@Override
	public String execute() {

		if (null != this.userSession.get(USER) && this.userSession.containsKey(USER)) {
			//user = managerFactory.getUserManager().findUserByBean((User) this.userSession.get(USER));
			user = (User) this.userSession.get(USER);
			LOGGER.debug("Retrieving profile of user " + user.getUsername());
		} else {
			this.addActionError("A problem occured with the session system - contact the admin !!");
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;

	}

}
