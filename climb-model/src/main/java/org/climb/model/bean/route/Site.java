package org.climb.model.bean.route;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class defining the main details about a site
 * @author bill
 *
 */
@Entity
@Table(name="climb_site", uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")})
public class Site {

	
	/////////////// Attributes //////////////
	
	/** id of a site */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/** name of a site */
	@Column(name = "name", unique = true, nullable = false, length = 100)
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
	
	/**
	 * Defining the oneToMany relationship with Area entity - see getter
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	private Set<Area> areas = new HashSet<Area>(0);

	/////////////// GETTER/SETTERS //////////////
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	/**
	 * Now when you load a Site from the database, 
	 * JPA loads its id, name, and other fields for you. 
	 * But you have two options for Areas: to load it together with the rest of the fields (i.e. eagerly) 
	 * or to load it on-demand (i.e. lazily) when you call the site's getAreas() method.
	 * @return
	 */
	public Set<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
}
