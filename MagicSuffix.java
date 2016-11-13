public class MagicSuffix {

	public String name;
	public String mod1Code;
	public Integer mod1Min;
	public Integer mod1Max;

	/**
	 * Constructor for the MagicSuffix object
	 * @param name the name of the suffix itself
	 * @param mod1Code the code for this MagicSuffix object 
	 * @param mod1Min the minimum additional statistic text for this MagicSuffix object
	 * @param mod1Max the maximum additional statistic text for this MagicSuffix object
	 */
	public MagicSuffix (String name, String mod1Code, Integer mod1Min, Integer mod1Max) {
		this.name = name;
		this.mod1Code = mod1Code;
		this.mod1Min = mod1Min;
		this.mod1Max = mod1Max;
	}
}

