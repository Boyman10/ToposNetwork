package org.climb.model.bean.route;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Area class with details - an area can have several routes and belongs to a
 * site
 * 
 * @author bill
 *
 */
@Entity
@Table(name = "climb_area")
public class Area {

	/** auto increment id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** name of area */
	@Column(name = "name")
	private String name;

	/** details of area */
	@Column(name = "details")
	private String details;

	/** area Site */
	private Site site;

	/**
	 * Empty constructor
	 */
	public Area() {
	}

	/**
	 * Constructor for the class being called from AreaTypeConverter
	 * 
	 * @param name
	 * @param details
	 * @param site
	 */
	public Area(String name, String details, Site site) {
		super();
		this.name = name;
		this.details = details;
		this.site = site;
	}

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
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
