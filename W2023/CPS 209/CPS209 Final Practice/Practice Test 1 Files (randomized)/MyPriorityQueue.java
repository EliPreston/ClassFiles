import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
/*
 * This class implements a priority queue using a linked list. The queue can hold a reference to 
 * any object whose class implements the Priority interface. The getPriority() method is used to 
 * determine the priority of an object and where it should be placed in the queue.
 */

public class MyPriorityQueue
{
	LinkedList<Priority> queue = new LinkedList<Priority>();

	public void add(Priority o)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// add an object o to the queue based on its priority.
		// The priority is determined by calling the getPriority() method of the object. 
		// The object should be added such that the priority
		// is from largest to smallest. Hint: use an iterator. Also, handle the special case
		// when the queue is empty
		// NOTE: you cannot make use of the Collections.sort() method!
		// You can use a listIterator to search for and add the element

		ListIterator<Priority> iter = queue.listIterator(0);
		boolean added = false;

		if (queue.size() == 0) {
			iter.add(o);
		}
		else {

			while(iter.hasNext()) {
				Priority temp = iter.next();
				if (o.getPriority() >= temp.getPriority()) {
					iter.previous();
					iter.add(o);
					added = true;
					break;
				}
			}

			if (added == false) {
				iter.add(o);
			}
		}
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public Priority remove()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// remove an object from the front of the queue
		return queue.removeFirst();
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
}
