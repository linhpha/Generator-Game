import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicAffix {
	public String name;
	public String mod1Code;
	public Integer mod1Min;
	public Integer mod1Max;

	public MagicAffix (String name, String mod1Code, Integer mod1Min, Integer mod1Max) {
		this.name = name;
		this.mod1Code = mod1Code;
		this.mod1Min = mod1Min;
		this.mod1Max = mod1Max;
	}

	public MagicAffix splitLine (String line) {
		String[] split = line.split("\t");	
		return new MagicAffix (split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
	}


	public List<MagicAffix> readfile(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File (fileName));
		List<MagicAffix> listAffix = new ArrayList<MagicAffix>();
		listAffix.add(splitLine(sc.nextLine()));
		sc.close();
		return listAffix;

	}
	public void generateAffix() {
		
	}
}
