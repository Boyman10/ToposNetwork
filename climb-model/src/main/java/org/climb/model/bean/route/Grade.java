package org.climb.model.bean.route;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Route grade - cotation in french - refer to the level of a route
 * @author bill
 *
 */
@Entity
@Table(name = "climb_grade")
public class Grade {

	/** integer as a reference */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** refer to level */
	@Enumerated(EnumType.STRING)
	@Column(name="level")
	private Level level;
	
	/** details of grade */
	@Column(name="details")
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
