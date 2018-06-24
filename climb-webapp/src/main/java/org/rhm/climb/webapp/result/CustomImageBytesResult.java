package org.rhm.climb.webapp.result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.rhm.climb.webapp.action.ShowImage;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * Class to serve an image content file
 * @author Boyman10
 */
public class CustomImageBytesResult implements Result {

	private static final long serialVersionUID = 2439369805979851068L;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		
		ShowImage action = (ShowImage) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType(action.getCustomContentType());
		response.getOutputStream().write(action.getCustomImageInBytes());
		response.getOutputStream().flush();		
	}

}
