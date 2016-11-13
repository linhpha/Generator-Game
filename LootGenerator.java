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
	/**
	 * Splitting the line based on the tab
	 * @param line
	 * @return a new monster 
	 */
	public static Monster splitLine (String line) {
		String[] x = line.split("\t");	
		return new Monster (x[0], x[3]);
	}


	/**
	 * Get a random monster from a list of monster
	 * @return a monster
	 * @throws FileNotFoundException
	 */
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

	/**
	 * Return the Treasure Class of the given monster
	 * @param monster
	 * @return a String
	 * @throws FileNotFoundException
	 */

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

	/**
	 * Make a new HashMap containing the treasure class and an item array
	 * @return
	 * @throws FileNotFoundException
	 */

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

	/**
	 * Generate base item helper
	 * @param hMap
	 * @param item
	 * @return a base item
	 */

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

	/**
	 * Generate base item
	 * @param treasureClass
	 * @return a String of base item
	 * @throws FileNotFoundException
	 */
	public static String generateBaseItem(String treasureClass) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("monstats.txt"));	
		sc.close();
		HashMap<String, String[]> hMap = makeHashMap();
		return generateBaseItemH(hMap, treasureClass);

	}

	public static Armor splitArmorLine(String line) throws FileNotFoundException {
		String[] split = line.split("\t");
		return new Armor( split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}


	/**
	 * Generate Base Statistics
	 * @param item
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String generateBaseStats(String item) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("armor.txt"));	
		List<Armor> armorList = new ArrayList<Armor>();
		while (sc.hasNextLine()) {
	
			armorList.add(splitArmorLine(sc.nextLine()));
		}
		sc.close();
		Random rand = new Random();
		Integer baseStat = 0;
		for (int i = 0; i < armorList.size(); i++) {
			if (armorList.get(i).name.equals(item)) {
				baseStat = rand.nextInt(armorList.get(i).maxAc - armorList.get(i).minAc) 
						+ armorList.get(i).minAc;

				return "Defense: " + baseStat;
			}
		}
		return "";
	}


	public static MagicPrefix splitPrefixLine (String line) {
		String[] split = line.split("\t");	
		return new MagicPrefix (split[0], split[1], Integer.parseInt(split[2]),
				Integer.parseInt(split[3]));
	}


	public static String[] generatePrefix (String baseItem) throws FileNotFoundException {
		Random rand = new Random();
		Integer prefixStat = 0;
		String[] prefixArray = {"", ""};
		Scanner sc = new Scanner(new File("MagicPrefix.txt"));	
		List<MagicPrefix> prefixList = new ArrayList<MagicPrefix>();
		while (sc.hasNextLine()) {
			prefixList.add(splitPrefixLine(sc.nextLine()));
		}
		sc.close();
		int randNum = rand.nextInt(prefixList.size());

		if (rand.nextInt(2) == 1) {
			MagicPrefix mP = prefixList.get(randNum);
			prefixArray[0] = mP.name + " ";
			if (mP.mod1Min == mP.mod1Max) {
				prefixStat = mP.mod1Min;
			} else {
				prefixStat = rand.nextInt(mP.mod1Max - mP.mod1Min) + mP.mod1Min;

			}
			prefixArray[1] = mP.mod1Code + ": " + prefixStat.toString();
		} 
		return prefixArray;

	}

	public static MagicSuffix splitSuffixLine (String line) {
		String[] split = line.split("\t");	
		return new MagicSuffix (split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
	}


	public static String[] generateSuffix (String baseItem) throws FileNotFoundException {
		Random rand = new Random();
		Integer suffixStat = 0;
		String[] suffixArray = {"", ""};
		Scanner sc = new Scanner(new File("MagicSuffix.txt"));	
		List<MagicSuffix> suffixList = new ArrayList<MagicSuffix>();
		while (sc.hasNextLine()) {
			suffixList.add(splitSuffixLine(sc.nextLine()));
		}
		sc.close();
		int randNum = rand.nextInt(suffixList.size());

		if (rand.nextInt(2) == 1) {
			MagicSuffix mP = suffixList.get(randNum);
			suffixArray[0] = " " + mP.name;
			if (mP.mod1Min == mP.mod1Max) {
				suffixStat = mP.mod1Min;
			} else {
				suffixStat = rand.nextInt(mP.mod1Max - mP.mod1Min) + mP.mod1Min;
			}
			suffixArray[1] = mP.mod1Code + ": " + suffixStat.toString();
		} 
		return suffixArray;
	}




	public static void playRound() throws FileNotFoundException {
		Monster myMonster = pickMonster();
		System.out.println("Fighting " + myMonster.getMonsterName());
		System.out.println("You have slain " + myMonster.getMonsterName() + "!");
		System.out.println(myMonster.getMonsterName() + " dropped: ");
		System.out.println("");
		
		String myTreasure = fetchTreasureClass(myMonster);
		String myBaseItem = generateBaseItem(myTreasure);
		String[] myPrefixArray = generatePrefix(myBaseItem);
		String[] mySuffixArray = generateSuffix(myBaseItem);
		String myStats = generateBaseStats(myBaseItem);
		
		System.out.printf("%s%s%s\n", myPrefixArray[0], myBaseItem, mySuffixArray[0]);
		System.out.println(myStats);
		if (!myPrefixArray[1].equals("")) { 
			System.out.println(myPrefixArray[1]);
		}
		if (!mySuffixArray[1].equals("")) { 
			System.out.println(mySuffixArray[1]);
		}
	}

	
	public static void main (String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		String userInput = "Y";
		while (userInput.equals("Y")) {
			playRound();
			System.out.print("\nFight again? [y/n] ");
			userInput = sc.next().toUpperCase();
		}
		sc.close();
	}
}




