import java.util.LinkedList;
import java.util.Queue;
/*
 * 
 * Simple program demonstrating the use of a chain of queues. An add() and remove() method are to be implemented.
 * 
 * A large queue is often broken into a series of shorter queues. In this program there are 3 queues (A, B, C)
 * 
 * Queue A has a capacity limit of 5 persons (a String) and queue B has a capacity limit of 7 persons. 
 * Queue C has an unlimited capacity.
 * 
 * Add to the chain of queues:
 * When a person joins the chain of queues they are added to the end of queue C. The exceptions to this rule are: 
 * If queue C is empty and queue B is not empty and there is room to join queue B. 
 * If queue C is empty and queue B is empty then a person joins queue A if there is room, otherwise they join queue B.
 * 
 * Remove from the chain of queues:
 * A person is always removed from the front of queue A. This causes a "chain reaction" and a person is then automatically
 * removed from the front of queue B (if it is not empty) and is added to the end of queue A. 
 * Furthermore, a person is then automatically removed from the front of queue C (if it is not empty) 
 * and added to the end of queue B.  
 */
public class MultipleQueues
{
	static Queue<String> queueA = new LinkedList<String>();
	static Queue<String> queueB = new LinkedList<String>();
	static Queue<String> queueC = new LinkedList<String>();
	static final int limitA = 5;
	static final int limitB = 7;
	
	public static void main(String [] args)
	{
		add("Yoko");add("John");add("Paul");add("George");add("Ringo"); 
		add("Tim");add("Rick");add("Eric");add("Isaac");add("Dave");
		add("Jake");add("Cherie");add("Keith");add("Roger");add("Pete");
		print();
		System.out.println("\nExpected:\n" + "A: Yoko John Paul George Ringo \n"
				+ "B: Tim Rick Eric Isaac Dave Jake Cherie \n"
				+ "C: Keith Roger Pete ");    
		
		remove(); remove(); remove();
		print();
		System.out.println("\nExpected:\n" + "A: George Ringo Tim Rick Eric \n"
				+ "B: Isaac Dave Jake Cherie Keith Roger Pete \n" + "C: ");
		
		remove(); remove(); remove(); remove();
		add("Nelson");
		print();
		System.out.println("\nExpected:\n" + "A: Eric Isaac Dave Jake Cherie \n"
				+ "B: Keith Roger Pete Nelson \n"	+ "C: ");
		
		remove(); remove(); remove(); remove(); remove();
		add("Winnie");
		print();
		System.out.println("\nExpected:\n" + "A: Keith Roger Pete Nelson Winnie \n" + "B: \n"	+ "C: ");
	}

	// Add a new person to the chain of queues according to the rules outlined in the comments at the top. 
	static void add(String s)
	{
		//-----------Start below here. To do: approximate lines of code = 11
		//
		if (queueA.size() < 5) {
			queueA.add(s);
		}
		else if (queueA.size() == 5 && queueB.size() < 7) {
			queueB.add(s);
		}
		else if (queueA.size() == 5 && queueB.size() == 7) {
			queueC.add(s);
		}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	// Remove a person from the chain of queues according to the rules outlined in the comments at the top.
	// Returns the empty string "" if there is no person to remove.
	static String remove()
	{
		 String sA = "";
		 
		 if (!queueA.isEmpty())
		 {
			 sA = queueA.remove();
			 if (!queueB.isEmpty()) 
			 {
				   queueA.add(queueB.remove());
				   if (!queueC.isEmpty())
						  queueB.add(queueC.remove());
			 }
		 }
		 return sA;
	}
	
	static void print()
	{
		System.out.print("\nA: ");
		for (String a: queueA)
		{
			System.out.print(a + " ");
		}
		System.out.print("\nB: ");
		for (String b: queueB)
		{
			System.out.print(b + " ");
		}
		System.out.print("\nC: ");
		for (String c: queueC)
		{
			System.out.print(c + " ");
		}
	}
}


