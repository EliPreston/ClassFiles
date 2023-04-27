import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 
 * This class simulates a stacked bar chart using text characters to "draw" the bars. A stacked bar chart
 * consists of a list of StackedBar objects. 
 * 
 * Run StackedBarChartTester to see examples of the expected output of complete bar charts.
 */
public class StackedBarChart
{
	ArrayList<StackedBar>  barChart;
	
	public StackedBarChart()
	{
		barChart = new ArrayList<StackedBar>();
	}
	
	public void addStackedBar(StackedBar bar)
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// Add the StackedBar object bar to the barChart
		barChart.add(bar);
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Print the stacked bar chart
	void printChart()
	{
		for (int i = 0; i < barChart.size(); i++)
			barChart.get(i).print();
	}
	
	// Sort the StackedBar objects in the bar chart by the value of the 0th data item (smallest to largest)
	void sortStackedBarsByItemValue()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barChart, new ItemValueComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class ItemValueComparator that implements the Comparator interface
	// and compares two StackedBar objects based on the value of the 0th data item (smallest to largest)
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class ItemValueComparator implements Comparator<StackedBar>
	{
		public int compare(StackedBar b1, StackedBar b2)
		{
			return b1.getValue(0) - b2.getValue(0);
		}
	}
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	//Sort the StackedBar objects in the bar chart by label (alphabetically)
	void sortStackedBarsByLabel()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barChart, new LabelComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class LabelComparator that implements the Comparator interface
	// and compares two StackedBar objects based on their label
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class LabelComparator implements Comparator<StackedBar>
	{
		public int compare(StackedBar b1, StackedBar b2)
		{
			return b1.getLabel().compareTo(b2.getLabel());
		} 
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
