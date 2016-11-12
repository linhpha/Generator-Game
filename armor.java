import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class armor<N> {
	public N name;
	public List<Integer> ac; 
	
	
	public armor(N name, List<Integer> ac) {
		this.name = name;
		this.ac = ac;
	}
	
	
	@SuppressWarnings("unchecked")
	public armor<N> splitLine(String line) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("armor.txt"));
		String[] split =  sc.nextLine().split("\t");
		List<Integer> acList = new ArrayList<Integer>();
		for (int i  = 1; i < 3; i++) {
			acList.add(Integer.parseInt(split[i]));
		}		
		sc.close();
		return new armor<N> ((N) split[0], acList);
	}
	
	
	public void generateBaseStat() {
		
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
