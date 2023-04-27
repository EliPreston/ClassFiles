import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 
 * This class simulates a horizontal bar graph using text characters ('*'). 
 * A bar graph consists of a list of HorizontalBar objects.
 * Each HorizontalBar object has a label, a date (integer month) and an integer length.
 * 
 * A bar with label "Mar" and length 5 will output as follows "Mar |*****\n".
 * 
 * Run BarGraphTester.java to see the expected output of a complete bar graph.
 */
public class BarGraph
{
	ArrayList<HorizontalBar>  barGraph;
	
	public BarGraph()
	{
		barGraph = new ArrayList<HorizontalBar>();
	}
	
	public void addBar(HorizontalBar bar)
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// Add the HorizontalBar object bar to the barGraph
		barGraph.add(bar);
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Print the horizontal bar graph
	void printGraph()
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		for (int i = 0; i < barGraph.size(); i++) {
			barGraph.get(i).print();
		}
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	// Sort the HorizontalBar objects in the barGraph by length (smallest to largest)
	void sortBarsByLength()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barGraph, new LengthComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class LengthComparator that implements the Comparator interface
	// and compares two Horizontal Bar objects based on their length
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class LengthComparator implements Comparator<HorizontalBar> {

		public int compare(HorizontalBar b1, HorizontalBar b2) {
			return b1.getLength() - b2.getLength();

			// if (b1.getLength() > b2.getLength()) {return 1;}
			// else if (b1.getLength() < b2.getLength()) {return -1;}
			// else {return 0;}

		}

	}
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	//Sort the Horizontal Bar objects in the barGraph by date (i.e. month) (earliest to latest)
	void sortBarsByDate()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barGraph, new DateComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class DateComparator that implements the Comparator interface
	// and compares two Horizontal Bar objects based on their month
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class DateComparator implements Comparator<HorizontalBar> {

		public int compare(HorizontalBar b1, HorizontalBar b2) {
			return b1.getMonth() - b2.getMonth();
			// if (b1.getMonth() > b2.getMonth()) {return 1;}
			// else if (b1.getMonth() < b2.getMonth()) {return -1;}
			// else {return 0;}
		}
	}
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
