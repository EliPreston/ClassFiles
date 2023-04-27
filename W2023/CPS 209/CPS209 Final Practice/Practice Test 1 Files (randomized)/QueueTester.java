// Test the MyPriorityQueue class
public class QueueTester
{
	public static void main(String[] args)
	{
		MyPriorityQueue pq = new MyPriorityQueue();
		
		System.out.println("Human Test");
		pq.add(new Human("John", 178));
		pq.add(new Human("Jane", 178));
		pq.add(new Human("James", 188));
		pq.add(new Human("Jack", 167));
		pq.add(new Human("Jill", 155));
		pq.add(new Human("Jabar", 199));
		pq.add(new Human("Jan", 175));
		pq.add(new Human("Juan", 179));
		
		while (!pq.isEmpty())
		{
			Human p = (Human) pq.remove();
			p.print();
		}
		System.out.println("\nExpected:\n" 
		    + "Jabar height: 199 cm\n"
				+ "James height: 188 cm\n"
				+ "Juan  height: 179 cm\n"
				+ "Jane  height: 178 cm\n"
				+ "John  height: 178 cm\n"
				+ "Jan   height: 175 cm\n"
				+ "Jack  height: 167 cm\n"
				+ "Jill  height: 155 cm");
		
		System.out.println("\nPackage Test");
		pq.add(new Package("iPad", 494));
		pq.add(new Package("iPhone", 228));
		pq.add(new Package("Mac", 920));
		pq.add(new Package("Apple TV", 425));
		pq.add(new Package("Apple Watch", 35));
				
		while (!pq.isEmpty())
		{
			Package p = (Package) pq.remove();
			p.print();
		}
		System.out.println("\nExpected:\n" 
		    + "Mac          weight: 920 grams\n"
				+ "iPad         weight: 494 grams\n"
				+ "Apple TV     weight: 425 grams\n"
				+ "iPhone       weight: 228 grams\n"
				+ "Apple Watch  weight: 35  grams");
	}
}
