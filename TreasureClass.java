import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TreasureClass<I> {

	//public HashMap <K, List<I>> hMap;
	public I treasureClass;
	public I item1;
	public I item2;
	public I item3;

	public TreasureClass(I treasureClass, I item1, I item2, I item3) {
		this.treasureClass = treasureClass;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;

	}

	@SuppressWarnings("unchecked")
	public TreasureClass<I> splitLine (String line) {
		String[] split = line.split("\t");	
		return new TreasureClass<I> ((I) split[0], (I) split[1], (I) split[2], (I) split[3]);
	}

	public I generateBaseItem(Monster<I> monster) throws FileNotFoundException {
		HashMap<I, List<I>> hMap = readFile();
		return generateBaseItemH(hMap, monster.fetchTreasureClass());
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

	
//	public String generateAffix(I baseItem) {
//		Random rand = new Random();
//		if (rand.nextInt(2) == 1) {
//			return generatePrefix (baseItem);
//		}
//	}
	
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
	
	@SuppressWarnings("unchecked")
	public HashMap<I, List<I>> readFile() throws FileNotFoundException {
		HashMap<I, List<I>> hMap = new HashMap<I, List<I>>();
		Scanner sc = new Scanner(new File("TreasureClass.txt"));	
		while (sc.hasNextLine()) {
			String[] split =  sc.nextLine().split("\t");
			List<I> itemList = new ArrayList<I>();
			for (int i  = 1; i < 4; i++) {
				itemList.add((I) split[i]);
			}
			hMap.put((I) split[0], itemList);
		}
		sc.close();
		return hMap;
	}

}
