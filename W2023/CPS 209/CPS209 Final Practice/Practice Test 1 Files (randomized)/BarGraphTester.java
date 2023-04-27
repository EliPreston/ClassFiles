/*
 *  This program creates a prints a simple bar graph using text characters ('*') to represent the
 *  length of a bar
 *
 */
public class BarGraphTester
{
	public static void main(String[] args)
	{
		BarGraph barGraph = new BarGraph();
		String[] labels = {"Jul", "Mar", "May", "Jan", "Nov", "Sep"};
		int[] dates  = {7, 3, 5, 1, 11, 9};
		int[] heights= {4, 6, 1, 9, 5, 2};
		for (int i = 0; i < 6; i++)
			barGraph.addBar((new HorizontalBar(labels[i], heights[i], dates[i])));
				
		barGraph.printGraph();
		System.out.println("Expected:\nJul |****\nMar |******\nMay |*\nJan |*********\nNov |*****\nSep |**");
		
		System.out.println("Sort By Length");
		barGraph.sortBarsByLength();
		barGraph.printGraph();
		System.out.println("Expected:\nMay |*\nSep |**\nJul |****\nNov |*****\nMar |******\nJan |*********");
		
		System.out.println("Sort By Date");
		barGraph.sortBarsByDate();
		barGraph.printGraph();
		System.out.println("Expected:\nJan |*********\nMar |******\nMay |*\nJul |****\nSep |**\nNov |*****");
	}
}
