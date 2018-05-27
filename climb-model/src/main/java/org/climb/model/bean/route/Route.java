package org.climb.model.bean.route;

/**
 * Route details belonging to area
 * @author bill
 *
 */
public class Route {

	/** id */
	private int id;
	
	/** name of route */
	private String name;
	
	/** details of route */
	private String details;
		
	/** Height of route */
	private Double summit;
	
	/** Number of points for route */
	private int nbPoints;
	
	/** area of route */
	private Area area;
	
	/** grade of route */
	private Grade grade;

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

	public Double getSummit() {
		return summit;
	}

	public void setSummit(Double summit) {
		this.summit = summit;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
