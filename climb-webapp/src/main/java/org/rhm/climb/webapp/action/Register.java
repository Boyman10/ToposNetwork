package org.rhm.climb.webapp.action;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.user.Role;
import org.climb.model.bean.user.User;
import org.rhm.climb.webapp.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Defined Action for registration form
 * 
 * @author bob
 * @version 0.1.0
 */
public class Register extends ActionSupport implements Preparable {

	private static final Logger LOGGER = LogManager.getLogger(Register.class);

	private static final long serialVersionUID = 1L;

	// The bean to be defined for the login form - using corresponding entity
	private User userBean;
	private String confirm;

	// optional parameter just for testing
	private String datereg;

	// Just for the interceptor
	private String error = "";

	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;


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
	

	public String getDatereg() {
		return datereg;
	}

	public void setDatereg(String datereg) {
		this.datereg = datereg;
	}
	/**
	 * Confirm password 
	 * @return the confirm
	 */
	public String getConfirm() {
		return confirm;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	/**
	 * If there is an error filled from within an interceptor...
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String input() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;

		LOGGER.debug("Are we having a user - input ? " + userBean);

		if (userBean != null && !StringUtils.isEmpty(Integer.toString(userBean.getId()))) {

			LOGGER.debug("What are we doing here -> lead to logout page or tell him to go somewhere else...");
			
		}

		return vResult;
	}

	@Override
	public String execute() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;
		
		// Let's clear the messages and errors first !
		//this.clearErrorsAndMessages();

		// Check if we have password and userBean submitted :
		if (userBean != null && !StringUtils.isAllEmpty(Integer.toString(userBean.getId()))) {

			if (!this.error.equals("")) {
				
				this.addActionError(this.error);
				return vResult;
				
			} else {
			
				try {
	
					LOGGER.debug("Retrieving user with pseudo " + userBean.getUsername() + " With date " + userBean.getDatereg() );
	
					// First retrieve the default Role by its name :
					Role role = this.managerFactory.getRoleManager().getRoleByName("ROLE_USER");
					userBean.setRole(role);
					
					// verify password :
					if (!userBean.getPassword().equals(confirm)) {
						
						this.addActionError("Password don't match!");
						LOGGER.debug("Password don't match " + confirm + " != " + userBean.getPassword());
						return vResult;
					}
					
					// Encrypt password :
					PasswordEncoder encoding = new PasswordEncoder();
					userBean.setPassword(encoding.encodePassword(userBean.getPassword()));
	
					// Persist data to db now :
					if (this.managerFactory.getUserManager().addUser(userBean)) {
						vResult = ActionSupport.SUCCESS;
						/* Perfect we are all good we should continue now : */
	
						this.addActionMessage(
								"Welcome here dude, you should now confirm your email and then sign in from the menu !");
	
						LOGGER.debug("Adding user to DB - Adding event to send confirmation email");
					} else {
						this.addActionError("Somehting went wrong please check your entries!");
						this.userBean = null;
						LOGGER.debug("Not written to db - removing bean now");
					}
				} catch (Exception pEx) {
	
					if (pEx.getMessage().contains("Duplicate"))
						this.addActionError("This user name or email is already in use, please pick up another value !");
					else 
						this.addActionError("Something went wrong please contact our support with the following error : " + pEx.getCause().getMessage());
				}
			}
		}

		return vResult;
	}

	@Override
	public void prepare() throws Exception {
		LOGGER.debug("In prepare method for registration - any bean ? " + userBean);
	}
}
