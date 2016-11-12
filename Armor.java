import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Armor<I> {
	private I item;
	private int minAc;
	private int maxAc;
	
	
	public Armor(I item, int minAc, int maxAc) {
		this.item = item;
		this.minAc = minAc;
		this.maxAc = maxAc;
	}
	
	
	@SuppressWarnings("unchecked")
	public Armor<I> splitLine(String line) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("armor.txt"));
		String[] split =  sc.nextLine().split("\t");
		List<Integer> acList = new ArrayList<Integer>();
		for (int i  = 1; i < 3; i++) {
			acList.add(Integer.parseInt(split[i]));
		}		
		sc.close();
		return new Armor<I> ((I) split[0], acList);
	}
	
	
	public void generateBaseStat(I item) {
		
		
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

}
