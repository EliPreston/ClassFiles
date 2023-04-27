/*
 * class storing information about a human person (name and height)
 */
public class Human implements Priority
{
	private String name;
	private int height;
	
	public Human(String name, int height)
	{
		
		this.name   = name;
		this.height = height;
	}
	
	public int getPriority()
	{
		return height;
	}
	
	public void print()
	{
		System.out.printf("\n%-5s height: %-3d cm", name, height);
	}
}