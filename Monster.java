import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Monster<TC> {
	public String classMon;
	public TC treasureClass;


	public Monster(String classMon, TC treasureClass) {
		this.classMon = classMon;
		this.treasureClass = treasureClass;
	}
	
	
	@SuppressWarnings("unchecked")
	public Monster<TC> splitLine (String line) {
		String[] split = line.split("\t");		
		return new Monster<TC> (split[0], (TC) split[3]);
	}
	

	public List<Monster<TC>> readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("monstats.txt"));	
		List<Monster<TC>> monsList = new ArrayList<Monster<TC>>();
		monsList.add(splitLine(sc.nextLine()));
		sc.close();
		return monsList;
	}
	public void pickMonster() {

	}
}
