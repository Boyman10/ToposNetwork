package org.rhm.climb.webapp.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.ServletContextAware;
import org.rhm.climb.webapp.utils.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handling files(s) upload using JQuery
 * @see 
 * @author bob
 *
 */
public class Upload extends ActionSupport implements ServletContextAware {

	private static final Logger LOGGER = LogManager.getLogger(Upload.class);

	private static final long serialVersionUID = 17L;


	// Handling the file being submitted
	private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFilename;

    // Saving to app specified dir
    private ServletContext context;
    private String filesPath;
    
	// ============= GETTERS/ SETTERS ===============
	
    public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
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
    			
    			//FileUtils.saveFile(getUploadFile(), getUploadFileFileName(), context.getRealPath("/") + File.separator + filesPath);
    			FileUtils.saveFile(getUploadFile(), getUploadFileFileName());

    			addActionMessage("File successfully saved !");
    			
    		} catch (IOException e) {
    			
    			//e.printStackTrace();
    			
    			addActionError("File must be valid !" + e.getMessage());
    			
    			return ActionSupport.INPUT;
    		}
        	
        }
				
        return hasErrors() ? ActionSupport.INPUT : ActionSupport.SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;		
	}

}
