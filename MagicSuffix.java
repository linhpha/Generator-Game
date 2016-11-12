
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class MagicSuffix<I> {

	public String name;
	public String mod1Code;
	public Integer mod1Min;
	public Integer mod1Max;

	public MagicSuffix (String name, String mod1Code, Integer mod1Min, Integer mod1Max) {
		this.name = name;
		this.mod1Code = mod1Code;
		this.mod1Min = mod1Min;
		this.mod1Max = mod1Max;
	}
	public MagicSuffix<I> splitLine (String line) {
		String[] split = line.split("\t");	
		return new MagicSuffix<I> (split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
	}


	public List<MagicSuffix<I>> readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File ("MagicSuffix.txt"));
		List<MagicSuffix<I>> listSuffix = new ArrayList<MagicSuffix<I>>();
		listSuffix.add(splitLine(sc.nextLine()));
		sc.close();
		return listSuffix;

	}


	public String generatePrefixStat(I item) throws FileNotFoundException {
		List<MagicSuffix<I>> listSuffix = readFile();
		Random rand = new Random();
		Integer baseStat = 0;
		for (int i = 0; i < listSuffix.size(); i++) {
			if (listSuffix.get(i).name.equals(item)) {
				baseStat = rand.nextInt(listSuffix.get(i).mod1Max - listSuffix.get(i).mod1Min 
						+ listSuffix.get(i).mod1Min);
			}
		}
		return baseStat.toString();
	}


}

