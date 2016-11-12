import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Armor<I> {
	public I name;
	public int minAc;
	public int maxAc;


	public Armor(I name, int minAc, int maxAc) {
		this.name = name;
		this.minAc = minAc;
		this.maxAc = maxAc;
	}


	@SuppressWarnings("unchecked")
	public Armor<I> splitLine(String line) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("armor.txt"));
		String[] split =  sc.nextLine().split("\t");
		sc.close();
		return new Armor<I> ((I) split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}


	public List<Armor<I>> readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("armor.txt"));	
		List<Armor<I>> armorList = new ArrayList<Armor<I>>();
		armorList.add(splitLine(sc.nextLine()));
		sc.close();
		return armorList;
	}

	public String generateBaseStats(I item) throws FileNotFoundException {
		List<Armor<I>> armorList = readFile();
		Random rand = new Random();
		Integer baseStat = 0;
		for (int i = 0; i < armorList.size(); i++) {
			if (armorList.get(i).name.equals(item)) {
				baseStat = rand.nextInt(armorList.get(i).maxAc - armorList.get(i).minAc 
						+ armorList.get(i).minAc);
			}
		}
		return "Defense: " + baseStat;
	}


}
//	@SuppressWarnings("unchecked")
//	public void readFile() throws FileNotFoundException {
//			
//		while (sc.hasNextLine()) {
//			String[] split =  sc.nextLine().split("\t");
//			List<Integer> acList = new ArrayList<Integer>();
//			for (int i  = 1; i < 3; i++) {
//				acList.add(Integer.parseInt(split[i]));
//			}
//			hMap.put((N) split[0], acList);
//		}
//		sc.close();
//	}


