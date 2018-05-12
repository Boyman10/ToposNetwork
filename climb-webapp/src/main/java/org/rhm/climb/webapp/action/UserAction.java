package org.rhm.climb.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
	
	// Constant to be used to identify session
	private static final String USER = "user";

	// Handling session
	private Map<String, Object> userSession;
	private HttpServletRequest servletRequest;
	
	// The bean to be defined for the login form - using corresponding entity
	private User userBean;
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
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
		if (this.userSession.containsKey(USER) && null != this.userSession.get(USER)) {
			
			return ActionSupport.SUCCESS;     
		} 
		
		
        
        // Check if we have password and userBean submitted :
        if (userBean != null && userBean.getPseudo() != null && !StringUtils.isAllEmpty(userBean.getPseudo(), password)) {
            try {
            	
            	System.out.println("Retrieving user with pseudo " + userBean.getPseudo());
            	
                Utilisateur vUtilisateur
                        = managerFactory.getUtilisateurManager()
                                      .getUtilisateur(userBean.getPseudo());

                this.addActionError("You are already there !");
                
            } catch (NotFoundException pEx) {
                //this.addActionError("Identifiant ou mot de passe invalide !");

            	/* Perfect we are all good we should continue now :*/
                
                System.out.println("Adding user to session");
                
                try {
                	managerFactory.getUtilisateurManager().addUtilisateur(userBean);
				} catch (FunctionalException e) {
					e.printStackTrace();
				}
                
                // Ajout de l'utilisateur en session
                this.userSession.put(USER, userBean);
                
                vResult = ActionSupport.SUCCESS;            	
            	
            }
        }
        
        return vResult;
	}

	/**
	 * Action de déconnexion d'un utilisateur
	 * 
	 * @return success
	 */
	public String doLogout() {
		
	    this.userSession.remove(USER);
        // Invalidation de la session
        this.servletRequest.getSession().invalidate();
		return ActionSupport.SUCCESS;
	}

}
