package org.climb.model.bean.route;

/**
 * Route grade - cotation in french - refer to the level of a route
 * @author bill
 *
 */
public class Grade {

	/** integer as a reference */
	private int id;
	
	/** refer to level */
	private Level level;
	
	/** details of grade */
	private String details;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}
	
	
}
