import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Monster<I> {
	private String classMon;
	private I treasureClass;


	public Monster(String classMon, I treasureClass) {
		this.classMon = classMon;
		this.treasureClass = treasureClass;
	}
	
	
	@SuppressWarnings("unchecked")
	public Monster<I> splitLine (String line) {
		String[] split = line.split("\t");		
		return new Monster<I> (split[0], (I) split[3]);
	}
	
	public I fetchTreasureClass() { return this.treasureClass;}
	
	public String getMonsterName() { return this.classMon;}

	public List<Monster<I>> readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("monstats.txt"));	
		List<Monster<I>> monsList = new ArrayList<Monster<I>>();
		monsList.add(splitLine(sc.nextLine()));
		sc.close();
		return monsList;
	}
	public Monster<I> pickMonster(List<Monster<I>> monsList) {
		Random rand = new Random();
		return monsList.get(rand.nextInt(monsList.size()));
		
	}
}
