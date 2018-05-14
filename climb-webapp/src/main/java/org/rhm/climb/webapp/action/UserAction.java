package org.rhm.climb.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.climb.model.bean.user.User;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Defined Action for authentication purpose and may be additional user
 * management - will be separated..
 * 
 * @author bob
 * @version 1.0
 */
@Service
public class UserAction extends ActionSupport implements SessionAware, ServletRequestAware {

	/**
	 * TODO :
	 * https://www.journaldev.com/2203/get-servlet-session-request-response-context-attributes-struts-2-action
	 */
	private static final long serialVersionUID = -312477649388098567L;

	// Constant to be used to identify session
	private static final String USER = "user";

	// Handling session
	private Map<String, Object> userSession;
	private HttpServletRequest servletRequest;

	// The bean to be defined for the login form - using corresponding entity
	private User userBean;

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

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

	/**
	 * Login method checking user sign in
	 * 
	 * @return
	 */
	public String doLogin() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;

		// Redirect if user already logged in :
		if (null != this.userSession.get(USER) && this.userSession.containsKey(USER)) {

			return ActionSupport.SUCCESS;
		}

		// Check if we have password and userBean submitted :
		if (userBean != null && userBean.getUsername() != null
				&& !StringUtils.isAllEmpty(userBean.getUsername(), userBean.getPassword())) {

			try {

				System.out.println("Retrieving user with pseudo " + userBean.getUsername());

				/*
				 * User vUtilisateur = managerFactory.getUtilisateurManager()
				 * .getUtilisateur(userBean.getPseudo());
				 */
				this.addActionError("You are already there !");

			} catch (Exception pEx) {

				// this.addActionError("Identifiant ou mot de passe invalide !");

				/* Perfect we are all good we should continue now : */

				System.out.println("Adding user to session");

				// Adding user to session :
				this.userSession.put(USER, userBean);

				vResult = ActionSupport.SUCCESS;

			}
		}

		return vResult;
	}

	/**
	 * Login out current user :
	 * 
	 * @return success
	 */
	public String doLogout() {

		this.userSession.remove(USER);
		// Invalide session - security @TODO check further details about security :
		this.servletRequest.getSession().invalidate();
		return ActionSupport.SUCCESS;
	}

	/**
	 * Register new user :
	 * 
	 * @return success
	 */
	public String doRegister() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;

		// Check if we have password and userBean submitted :
		if (userBean != null 
				&& !StringUtils.isAllEmpty(userBean.getUsername(), userBean.getPassword())) {

			try {

				System.out.println("Retrieving user with pseudo " + userBean.getUsername());

				/*
				 * User vUtilisateur = managerFactory.getUtilisateurManager()
				 * .getUtilisateur(userBean.getPseudo());
				 */
				this.addActionError("You are already there !");

			} catch (Exception pEx) {

				// this.addActionError("Identifiant ou mot de passe invalide !");

				/* Perfect we are all good we should continue now : */

				System.out.println("Adding user to session");

				vResult = ActionSupport.SUCCESS;

			}
		}
		
		return vResult;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

}
