import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 
 * This class simulates a bar chart using text. A bar chart consists of a list of VerticalBar objects.
 * Each VerticalBar object has a label and an integer height.
 * 
 * See VerticalBarChartTester for an example of what a complete VerticalBarChart looks like
 */
public class VerticalBarChart
{
	ArrayList<VerticalBar>  barChart;
	static final int MAXHEIGHT = 11;
	
	public VerticalBarChart()
	{
		barChart = new ArrayList<VerticalBar>();
	}
	
	public void addVerticalBar(VerticalBar bar)
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// Add the VerticalBar object bar to the barChart
		barChart.add(bar);
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Print the bar chart
	void printChart()
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// print the vertical bar chart. Hint: use  a nested loop. Outer loop is the number of rows
		// using the MAXHEIGHT constant as the max number of rows. The inner loop loops over the VerticalBar
		// objects from the barChart array list and for each one, gets the output array list (see class VerticalBar). 
		// Print out the row entry (if it exists in the array list, otherwise print a " "). Then print another " " 
		// unless this is the last VerticalBar.  


			for (int i = 0; i < MAXHEIGHT; i++) {

				for (int j = 0; j < barChart.size(); j++) {

					VerticalBar curr = barChart.get(j);
					ArrayList<String> currArr = curr.output();

					if (i <= currArr.size()-1){
						System.out.print(currArr.get(i));
					}
					else {
						System.out.print(" ");
					}

					if (j != barChart.size()-1) {
						System.out.print(" ");
					}
	
				}
				System.out.println();

			}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	// Sort the VerticalBar objects in the barChart by height (smallest to largest)
	void sortVerticalBarsByHeight()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barChart, new HeightComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class HeightComparator that implements the Comparator interface
	// and compares two VerticalBar objects based on their height (smallest to largest)
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class HeightComparator implements Comparator<VerticalBar>
	{
		public int compare(VerticalBar v1, VerticalBar v2)
		{
			return v1.getHeight() - v2.getHeight();
		}
	}
	
	
	
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	//Sort the VerticalBar objects in the barChart by label
	void sortVerticalBarsByLabel()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		Collections.sort(barChart, new LabelComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	// Create a helper class LabelComparator that implements the Comparator interface
	// and compares two VerticalBar objects based on their labels
	//-----------Start below here. To do: approximate lines of code = 3
	//
	class LabelComparator implements Comparator<VerticalBar>
	{
		public int compare(VerticalBar v1, VerticalBar v2)
		{
			return v1.getLabel().compareTo(v2.getLabel());
			
		}
	}
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
