package org.rhm.climb.webapp.action.admin;

import java.util.List;

import javax.inject.Inject;

import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Site;

import com.opensymphony.xwork2.ActionSupport;

/**
 * API returning listing of sites
 * @author bob
 * @version 0.1.0
 */
public class Sites extends ActionSupport {

	private static final long serialVersionUID = 1987984L;
	
	
    // ==================== Attributes ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Out elements
    private List<Site> siteList;


    // ==================== Getters/Setters ====================
    public List<Site> getSiteList() {
        return siteList;
    }


    // ==================== Methods ====================
    /**
     * Ajax action returning listing
     * @return success
     */
    public String execute() {
    	
    	siteList = managerFactory.getSiteManager().getSiteList();
        return ActionSupport.SUCCESS;
    }

}
