package org.rhm.climb.webapp.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.model.bean.user.User;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for registration form
 * 
 * @author bob
 * @version 0.1.0
 */
@Service
public class Register extends ActionSupport {

	//static final Logger logger = LogManager.getLogger("org.rhm.climb");
	private static final Log LOGGER = LogFactory.getLog(Register.class);
	
	private static final long serialVersionUID = 1L;
	// The bean to be defined for the login form - using corresponding entity
	private User userBean;

	/**
	 * @return the userBean
	 */
	public User getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	@Override
	public String execute() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;

		// Check if we have password and userBean submitted :
		if (userBean != null && !StringUtils.isAllEmpty(userBean.getUsername(), userBean.getPassword())) {

			try {

				LOGGER.debug("Retrieving user with pseudo " + userBean.getUsername());

				/*
				 * User vUtilisateur = managerFactory.getUtilisateurManager()
				 * .getUtilisateur(userBean.getPseudo());
				 */
				
				vResult = ActionSupport.SUCCESS;
				
				
				/* Perfect we are all good we should continue now : */

				this.addActionMessage("Welcome here dude, you should now confirm your email and then sign in from the menu !");
				
				LOGGER.debug("Adding user to DB - Adding event to send confirmation email");


			} catch (Exception pEx) {

				this.addActionError("Somehting went wrong please check your entries !");
			}
		}

		return vResult;
	}

	@Override
	public void validate() {

		// Beware POST or not :
		if (userBean != null) {

			if (userBean.getUsername().length() == 0) {
				addFieldError("userBean.username", "user name is required.");
			}

			if (userBean.getEmail().length() == 0) {
				addFieldError("userBean.email", "Email is required.");
			}
		}

	}
}
