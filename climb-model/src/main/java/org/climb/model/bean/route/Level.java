package org.climb.model.bean.route;

/**
 * Defining levels related to grades 
 * @see https://www.guidedolomiti.com/en/rock-climbing-grades/
 * @author bob
 */
public enum Level {

	NOVICE("Novice"),
	BEGIN("Beginner"),
	INTER("Intermediate"),
	ADVANCED("Advanced"),
	EXPERT("Expert"),
	SUPEXP("Super Expert"),
	ELITE("Elite"),
	SUPELITE("Super Elite"),
	ALIEN("Alien");
	
	  private String name = "";
	   
	  //Constructor
	  Level(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	
}
