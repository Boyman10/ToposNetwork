package org.rhm.climb.webapp.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.servlet.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action class to display image from a specific folder !
 * @author Boyman
 * @version 0.1.0
 */
public class ShowImage extends ActionSupport implements ServletResponseAware {

	private static final long serialVersionUID = 7242580538989306432L;

	private static final Logger LOGGER = LogManager.getLogger(ShowImage.class);

	  private HttpServletResponse response;

	
	public String execute() throws Exception{
	    response.setContentType("image/png");
	    return SUCCESS;
	  }		
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}
	
	public HttpServletResponse getServletResponse(){
	    return this.response;
	  }
}
