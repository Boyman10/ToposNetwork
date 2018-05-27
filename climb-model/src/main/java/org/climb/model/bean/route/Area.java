package org.climb.model.bean.route;

/**
 * Area class with details - an area can have several routes and belongs to a site
 * @author bill
 *
 */
public class Area {

	/** auto increment id */
	private int id;
	
	/** name of area */
	private String name;
	
	/** details of area */
	private String details;	
	
	/** area Site */
	private Site site;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public int getId() {
		return id;
	}
	
}
