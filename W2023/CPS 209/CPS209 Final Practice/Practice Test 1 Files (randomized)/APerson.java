/*
 * Generic Person class
 */
public class APerson 
{
	private String name;
	private int age;
	
	public APerson(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public APerson(String name)
	{
		this.name = name;
		this.age = 0;
	}
	
	public boolean equals(Object other)
	{
		APerson p = (APerson)other;
		return this.name.equals(p.name); 
	}
	
	public String toString()
	{
		return "Name: " + name + " Age: " + age;
	}
}