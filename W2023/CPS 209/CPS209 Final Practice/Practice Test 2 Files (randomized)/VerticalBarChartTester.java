/*
 * 
 * This program simulates a vertical bar chart using text characters ('X'). 
 * A vertical bar chart consists of a list of Vertical Bars. 
 * Each VerticalBar object has a label and an integer height.
 * 
 * The chart is printed vertically (see methods printExpectedHeightSorted() and printExpectedLabelSorted() to see what the
 * output should look like)
 */
public class VerticalBarChartTester
{
	public static void main(String[] args)
	{
		VerticalBarChart barChart = new VerticalBarChart();
		String[] labels = {"D", "B", "F", "A", "E", "C"};
		int[] heights= {4, 6, 1, 9, 5, 2};
		for (int i = 0; i < labels.length; i++)
		{
			int h = heights[i];
			barChart.addVerticalBar(new VerticalBar(labels[i], heights[i]));
		}
				
		System.out.println("Sort By Height");
		barChart.sortVerticalBarsByHeight();
		barChart.printChart();
		System.out.println("Expected:");
		printExpectedHeightSorted();
		
		System.out.println("Sort By Label");
		barChart.sortVerticalBarsByLabel();
		barChart.printChart();
		System.out.println("Expected:");
		printExpectedLabelSorted();
	}
	
	static void printExpectedHeightSorted()
	{
		System.out.println("Sort By Height");
		System.out.println("F C D E B A");
		System.out.println("- - - - - -");
		System.out.println("X X X X X X");
		System.out.println("  X X X X X");
		System.out.println("    X X X X");
		System.out.println("    X X X X");
		System.out.println("      X X X");
		System.out.println("        X X");
		System.out.println("          X");
		System.out.println("          X");
		System.out.println("          X");
	}
	
	static void printExpectedLabelSorted()
	{
		System.out.println("Sort By Label");
		System.out.println("A B C D E F");
		System.out.println("- - - - - -");
		System.out.println("X X X X X X");
		System.out.println("X X X X X  ");
		System.out.println("X X   X X  ");
		System.out.println("X X   X X  ");
		System.out.println("X X     X  ");
		System.out.println("X X        ");
		System.out.println("X          ");
		System.out.println("X          ");
		System.out.println("X          ");
	}
}
