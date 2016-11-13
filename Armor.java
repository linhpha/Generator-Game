public class Armor {
	public String name;
	public int minAc;
	public int maxAc;

	/**
	 * Constructor for Armor object
	 * @param name the name of the armor item
	 * @param minAc the minimum base statistic for this item
	 * @param maxAc the maximum base statistic for this item
	 */
	public Armor(String name, int minAc, int maxAc) {
		this.name = name;
		this.minAc = minAc;
		this.maxAc = maxAc;
	}


}


