package diablo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import diablo.Monster;

public class LootGenerator {

	//	public List<Monster<I>> readFile() throws FileNotFoundException {
	//		Scanner sc = new Scanner(new File("monstats.txt"));	
	//		List<Monster<I>> monsList = new ArrayList<Monster<I>>();
	//		monsList.add(splitLine(sc.nextLine()));
	//		sc.close();
	//		return monsList;
	//	}
	public static Monster splitLine (String line) {
		String[] x = line.split("\t");	
		return new Monster (x[0], x[3]);
	}
	
	
	
	public static Monster pickMonster() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("monstats.txt"));	
		List<Monster> monsList = new ArrayList<Monster>();
		while (sc.hasNextLine()) {
			monsList.add(splitLine(sc.nextLine()));
		}
		sc.close();
		Random rand = new Random();
		int randNum = rand.nextInt(monsList.size());
		return monsList.get(randNum);
	}
	
	public static String fetchTreasureClass(Monster monster) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("TreasureClassEx.txt"));
		while (sc.hasNextLine()) {
			String[] x = sc.nextLine().split("\t");	
			if (x[0].equals(monster.getTreasureClass())) {
				return x[0];
			}
		}
		sc.close();
		return null;
	}

	public static HashMap<String, String[]> makeHashMap() throws FileNotFoundException {
		HashMap<String, String[]> hMap = new HashMap<String, String[]>();
		Scanner sc = new Scanner(new File("TreasureClassEx.txt"));	
		while (sc.hasNextLine()) {
			String[] split =  sc.nextLine().split("\t");
			String[] itemArray = {split[1], split[2], split[3]};			
			hMap.put(split[0], itemArray);
		}
		sc.close();
		return hMap;
	}

	public static String generateBaseItemH (HashMap<String, String[]> hMap, String item) {
		if (hMap.containsKey(item)) {
			//List<String> keysAsArray = new ArrayList<String>(hMap.keySet());
			//String randomKey = keysAsArray.get(rand.nextInt(keysAsArray.size()));
			String[] itemArray = hMap.get(item);
			Random rand = new Random();
			return generateBaseItemH(hMap, itemArray[rand.nextInt(3)]);
		} else {
			return item;
		}
	}
	
	public static String generateBaseItem(String treasureClass) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("monstats.txt"));	
		sc.close();
		HashMap<String, String[]> hMap = makeHashMap();
		return generateBaseItemH(hMap, treasureClass);
		
	}
	
	


	

	public static void main (String[] args) throws FileNotFoundException {
		Monster newMonster = pickMonster();
		String treasure = fetchTreasureClass(newMonster);
		System.out.println(newMonster.getMonsterName());
		System.out.println(treasure);
		System.out.println(generateBaseItem("Act 1 Cast B"));

	}
}

	

	
//	@SuppressWarnings("unchecked")
//	public TreasureClass splitLine (String line) {
//		String[] split = line.split("\t");	
//		String[] itemArray = {split[1], split[2], split[3]};
//		return new TreasureClass (split[0], itemArray);
//	}
//	



