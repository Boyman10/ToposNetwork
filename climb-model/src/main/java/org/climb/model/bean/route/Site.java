package org.climb.model.bean.route;

/**
 * Class defining the main details about a site
 * @author bill
 *
 */
public class Site {

	
	/////////////// Attributes //////////////
	
	/** id of a site */
	private int id;
	
	/** name of a site */
	private String name;	
	
	/** site type */
	private String type;
	
	/** region of a site */
	private String region;	
	
	/** site dpt */
	private String department;
	
	/** country of a site */
	private String country;
	
	/** location of a site */
	private String location;

	/////////////// GETTER/SETTERS //////////////
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}		
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}		
}
