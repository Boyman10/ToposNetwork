package org.rhm.climb.webapp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handling gravatar upload using Ajax call in a modal box from the index
 * @author bob
 *
 */
public class Gravatar extends ActionSupport {

	private static final long serialVersionUID = 17L;
    
	private InputStream inputStream;
    
    public InputStream getInputStream() {
        return inputStream;
    }
    
    
	@Override
	public String execute() throws Exception {

        inputStream = new ByteArrayInputStream("Response from gravatar action".getBytes("UTF-8"));
		
		
		return ActionSupport.SUCCESS;
	}

}
