package diablo;




public class Monster {
	private String classMon;
	private String treasureClass;


	public Monster(String classMon, String treasureClass) {
		this.classMon = classMon;
		this.treasureClass = treasureClass;
	}

	public String getTreasureClass() { return this.treasureClass;}

	public String getMonsterName() { return this.classMon;}

}
