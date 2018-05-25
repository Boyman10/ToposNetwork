package org.rhm.climb.webapp.action;

import org.climb.business.manager.interfaces.factory.ManagerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

/**
 * Handling gravatar upload using Ajax call in a modal box from the index
 * @author bob
 *
 */
public class Gravatar extends ActionSupport {

	private static final long serialVersionUID = 17L;
    
	@Inject
	ManagerFactory managerFactory;
    
	@Override
	public String execute() throws Exception {
		
		
		return ActionSupport.SUCCESS;
	}

}
