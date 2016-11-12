import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TreasureClass<TC, I> {

	//public HashMap <K, List<I>> hMap;
	public TC keys;
	public I item1;
	public I item2;
	public I item3;

	public TreasureClass(TC key, I item1, I item2, I item3) {
		this.keys = key;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
//		this.hMap = new HashMap<K, List<I>>();	
//		hMap.put(key, itemList);
	}

	@SuppressWarnings("unchecked")
	public TreasureClass<TC, I> splitLine (String line) {
		String[] split = line.split("\t");	
		return new TreasureClass<TC, I> ((TC) split[0], (I) split[1], (I) split[2], (I) split[3]);
	}
	
	public void fetchTreasureClass() {

	}
	
	public void generateBaseItem() {
		
	}

//
//	@SuppressWarnings("unchecked")
//	public void readFile() throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("TreasureClass.txt"));	
//		while (sc.hasNextLine()) {
//			String[] split =  sc.nextLine().split("\t");
//			List<I> itemList = new ArrayList<I>();
//			for (int i  = 1; i < 4; i++) {
//				itemList.add((I) split[i]);
//			}
//			hMap.put((K) split[0], itemList);
//		}
//		sc.close();
//	}

}
