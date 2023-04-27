/*
 * Generic Person class
 */
public class Person 
{
	String name;
	int age;
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object other)
	{
		Person p = (Person)other;
		return this.name.equals(p.name) && this.age == p.age; 
	}
	
	public String toString()
	{
		return "Name: " + name + " Age: " + age;
	}
}
