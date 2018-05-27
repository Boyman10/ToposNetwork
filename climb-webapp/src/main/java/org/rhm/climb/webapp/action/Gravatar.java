package org.rhm.climb.webapp.action;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climb.model.bean.user.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handling gravatar upload using Ajax call in a modal box from the index
 * 
 * @author bob
 *
 */
public class Gravatar extends ActionSupport implements SessionAware {

	private static final Logger LOGGER = LogManager.getLogger(Gravatar.class);

	private static final long serialVersionUID = 17L;
	// Constant to be used to identify session
	private static final String USER = "user";
	// Handling session
	private Map<String, Object> userSession;

	// Handling the file being submitted
	private File uploadFile;
    private String contentType;
    private String filename;
    
    // testing field from form submission - ajax
    private String sourceToken;
	/*
	 * @Inject ManagerFactory managerFactory;
	 */
	private String gravatar;

	// ============= GETTERS/ SETTERS ===============
	public String getSourceToken() {
		return sourceToken;
	}

	public void setSourceToken(String sourceToken) {
		this.sourceToken = sourceToken;
	}
	
	/**
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}
	/**
	 * @param gravatar
	 *            the gravatar to set
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	// ============= METHODS ==============

	/**
	 * Upload handling set of methods - matching name of upload field
	 * @param file
	 */
    public void setUploadFile(File file) {
    	LOGGER.debug("Setting upload file");
        this.uploadFile = file;
     }

     public void setContentType(String contentType) {
        this.contentType = contentType;
     }

     public void setFileName(String filename) {
    	 
    	 LOGGER.debug("Setting upload filename : " + filename);
        this.filename = filename;
     }
	
	
	/**
	 * Default action method to deliver the listing
	 */
	@Override
	public String execute() throws Exception {

		LOGGER.debug("Within execute action : " );
		//gravatar = ((User) (userSession.get(USER))).getGravatar();
        if (filename == null) {
            addActionError("File must be valid !");
        } else 
        	gravatar = filename;
		
		Thread.sleep(5000);
		
        return hasErrors() ? ActionSupport.INPUT : ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

}
