/*
 * class storing information about a package (label and weight)
 */
public class Package implements Priority
{
	String label;
	int weight; 
	
	public Package(String label, int weight)
	{
		this.label = label;
		this.weight = weight;
	}
	public int getPriority()
	{
		return weight;
	}
	
	public void print()
	{
		System.out.printf("\n%-12s weight: %-3d grams", label, weight);
	}
}
