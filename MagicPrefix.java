public class MagicPrefix {
	public String name;
	public String mod1Code;
	public Integer mod1Min;
	public Integer mod1Max;

	/**
	 * Constructor for the MagicPrefix object
	 * @param name the name of the prefix itself
	 * @param mod1Code the code for this MagicPrefix object 
	 * @param mod1Min the minimum additional statistic text for this MagicPrefix object
	 * @param mod1Max the maximum additional statistic text for this MagicPrefix object
	 */
	public MagicPrefix (String name, String mod1Code, Integer mod1Min, Integer mod1Max) {
		this.name = name;
		this.mod1Code = mod1Code;
		this.mod1Min = mod1Min;
		this.mod1Max = mod1Max;
	}

}
