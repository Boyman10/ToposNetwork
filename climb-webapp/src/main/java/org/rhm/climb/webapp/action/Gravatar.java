package org.rhm.climb.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climb.model.bean.user.User;
import org.rhm.climb.webapp.utils.FileUtils;

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
    private String uploadFileContentType;
    private String uploadFileFilename;
    
    // testing field from form submission - ajax
    private String sourceToken;


	// ============= GETTERS/ SETTERS ===============
	public String getSourceToken() {
		return sourceToken;
	}

	public void setSourceToken(String sourceToken) {
		this.sourceToken = sourceToken;
	}
	
	
    public File getUploadFile() {
        return this.uploadFile;
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

     public void setUploadFileContentType(String contentType) {
        this.uploadFileContentType = contentType;
     }

     public void setUploadFileFileName(String filename) {
    	 
    	 LOGGER.debug("Setting upload filename : " + filename);
        this.uploadFileFilename = filename;
     }
     public String getUploadFileFileName() {
    	 
         return this.uploadFileFilename;
       }
  			
	
	/**
	 * Default action method to deliver the listing
	 */
	@Override
	public String execute() throws Exception {

		LOGGER.debug("Within execute action : " );

        if (uploadFileFilename == null) {
            LOGGER.debug("Within execute action - no file sent yet..." );
        } else {
        	    		
        	try {
    			LOGGER.debug("Saving file to proper location" );
    			
    			FileUtils.saveFile(getUploadFile(), getUploadFileFileName());

    			addActionMessage("File successfully saved !");
    			
    		} catch (IOException e) {
    			
    			//e.printStackTrace();
    			
    			addActionError("File must be valid !" + e.getMessage());
    			
    			return ActionSupport.INPUT;
    		}
        	
        }
		
		Thread.sleep(5000);
		
        return hasErrors() ? ActionSupport.INPUT : ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

}
