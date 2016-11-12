package diablo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TreasureClass {

	//public HashMap <K, List<I>> hMap;
	public String treasureClass;
	public String[] itemArray;
//	public String item1;
//	public String item2;
//	public String item3;

	public TreasureClass(String treasureClass, String[] itemArray) {
		this.treasureClass = treasureClass;
		this.itemArray = itemArray; 

	}

	/*
	public String generateBaseItem(Monster monster) throws FileNotFoundException {
		HashMap<I, List<I>> hMap = readFile();
		return generateBaseItemH(hMap, monster.getTreasureClass());
	}


	public I generateBaseItemH (HashMap<I, List<I>> hMap, I item) {
		if (hMap.containsKey(item)) {
			List<I> keysAsArray = new ArrayList<I>(hMap.keySet());
			Random rand = new Random();
			@SuppressWarnings("unchecked")
			I randomKey = (I) hMap.get(keysAsArray.get(rand.nextInt(keysAsArray.size())));
			List<I> listItem = hMap.get(randomKey);

			int randNum = rand.nextInt(listItem.size());
			return generateBaseItemH(hMap, listItem.get(randNum));
		} else {
			return item;
		}
	}
	*/

	
//	public String generateAffix(I baseItem) {
//		Random rand = new Random();
//		if (rand.nextInt(2) == 1) {
//			return generatePrefix (baseItem);
//		}
//	}
	
	/*
	public String generatePrefix (I baseItem) throws FileNotFoundException {
		Random rand = new Random();
		Integer prefixStat = 0;
		int randNum = rand.nextInt(371);
		if (rand.nextInt(2) == 1) {
			Scanner sc = new Scanner(new File("MagicPrefix.txt"));
			String prefixLine = "";
			while (randNum >= 0) {
				prefixLine  = sc.nextLine();
				randNum--;
			}
			String[] splitPrefix = prefixLine.split("\t");
			
			prefixStat = rand.nextInt(Integer.parseInt(splitPrefix[2]) 
					- Integer.parseInt(splitPrefix[1])
					 + Integer.parseInt(splitPrefix[1]));
			sc.close();
		}
		return prefixStat.toString();
		
	}
	
	public String generateSuffix (I baseItem) throws FileNotFoundException {
		Random rand = new Random();
		Integer suffixStat = 0;
		int randNum = rand.nextInt(371);
		if (rand.nextInt(2) == 1) {
			Scanner sc = new Scanner(new File("MagicSuffix.txt"));
			String suffixLine = "";
			while (randNum >= 0) {
				suffixLine  = sc.nextLine();
				randNum--;
			}
			String[] splitPrefix = suffixLine.split("\t");
			
			suffixStat = rand.nextInt(Integer.parseInt(splitPrefix[2]) 
					- Integer.parseInt(splitPrefix[1])
					 + Integer.parseInt(splitPrefix[1]));
			sc.close();
		}
		return suffixStat.toString();
		
	}
	
	*/

	
	
	
}
