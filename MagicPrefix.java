import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MagicPrefix<I> {
	public String name;
	public String mod1Code;
	public Integer mod1Min;
	public Integer mod1Max;

	public MagicPrefix (String name, String mod1Code, Integer mod1Min, Integer mod1Max) {
		this.name = name;
		this.mod1Code = mod1Code;
		this.mod1Min = mod1Min;
		this.mod1Max = mod1Max;
	}
	public MagicPrefix<I> splitLine (String line) {
		String[] split = line.split("\t");	
		return new MagicPrefix<I> (split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
	}


	public List<MagicPrefix<I>> readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File ("MagicPrefix.txt"));
		List<MagicPrefix<I>> listPrefix = new ArrayList<MagicPrefix<I>>();
		listPrefix.add(splitLine(sc.nextLine()));
		sc.close();
		return listPrefix;

	}
	

	public String generatePrefixStat(I item) throws FileNotFoundException {
		List<MagicPrefix<I>> prefixList = readFile();
		Random rand = new Random();
		Integer baseStat = 0;
		for (int i = 0; i < prefixList.size(); i++) {
			if (prefixList.get(i).name.equals(item)) {
				baseStat = rand.nextInt(prefixList.get(i).mod1Max - prefixList.get(i).mod1Min 
						+ prefixList.get(i).mod1Min);
			}
		}
		return baseStat.toString();
	}


}
