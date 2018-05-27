package org.rhm.climb.webapp.action;

import java.io.File;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.climb.model.bean.user.User;
import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handling gravatar upload using Ajax call in a modal box from the index
 * 
 * @author bob
 *
 */
public class Gravatar extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 17L;
	// Constant to be used to identify session
	private static final String USER = "user";
	// Handling session
	private Map<String, Object> userSession;

	// Handling the file being submitted
	private File uploadFile;
    private String contentType;
    private String filename;
	/*
	 * @Inject ManagerFactory managerFactory;
	 */
	private String gravatar;

	// ============= GETTERS/ SETTERS ===============

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
        this.uploadFile = file;
     }

     public void setUploadFileContentType(String contentType) {
        this.contentType = contentType;
     }

     public void setUploadFileFileName(String filename) {
        this.filename = filename;
     }
	
	
	/**
	 * Default action method to deliver the listing
	 */
	@Override
	public String execute() throws Exception {

		gravatar = ((User) (userSession.get(USER))).getGravatar();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

}
