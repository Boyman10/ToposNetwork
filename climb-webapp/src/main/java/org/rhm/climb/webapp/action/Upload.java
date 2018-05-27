package org.rhm.climb.webapp.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handling files(s) upload using JQuery
 * 
 * @author bob
 *
 */
public class Upload extends ActionSupport implements ServletContextAware {

	private static final Logger LOGGER = LogManager.getLogger(Upload.class);

	private static final long serialVersionUID = 17L;


	// Handling the file being submitted
	private File uploadFile;
    private String contentType;
    private String filename;

    // Saving to app specified dir
    private ServletContext context;
    
	// ============= GETTERS/ SETTERS ===============
	

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
        this.contentType = contentType;
     }

     public void setUploadFileFileName(String filename) {
    	 
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
        } 
				
        return hasErrors() ? ActionSupport.INPUT : ActionSupport.SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;		
	}

}
