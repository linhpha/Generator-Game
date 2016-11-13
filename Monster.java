public class Monster {

	private String name;
	private String treasureClass;

	/**
	 * Constructor for the Monster object
	 * @param name the name of the monster
	 * @param treasureClass the treasureClass associated with this monster
	 */
	public Monster(String name, String treasureClass) {
		this.name = name;
		this.treasureClass = treasureClass;
	}

	/**
	 * Getter method for the name of the Monster object
	 * @return name the string representing the name of this Monster
	 */
	public String getMonsterName() { 
		return this.name; 
	}
	
	/**
	 * Getter method for the treasureClass of the Monster object
	 * @return treasureClass the string representing the treasureClass of this Monster
	 */
	public String getTreasureClass() { 
		return this.treasureClass;
	}
}
