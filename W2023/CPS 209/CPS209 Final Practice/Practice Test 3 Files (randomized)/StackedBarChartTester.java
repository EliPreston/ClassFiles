/* 
 * This program simulates a bar chart using text characters. The data in this program is the sales of a set of 
 * product items at 4 different stores. The product sales for the items is printed as a "stacked" bar.
 * 
 * For example, if there are 3 different products sold at a store located in Hamilton and the number of items sold 
 * for each of the 3 products (over the course of a week) is 3, 4, 1 respectively, then the stacked bar would print as:
 * 
 * Hamilton|XXXYYYYZ
 * 
 * where XXX represents 3 product #0 items sold, YYYY represents 4 product #1 items sold, Z represents 1 product #2 items sold
 * 
 * See class StackedBar and class StackedBarChart to for details on the code you write 
 *  
 */
public class StackedBarChartTester
{
	public static void main(String[] args)
	{
		StackedBarChart barChart = new StackedBarChart();
		String[] stores = {"Hamilton", "Newmarket", "Downsview", "Brampton"};
		int[] numProductItems = { 3, 4, 3, 2};
		int[][] productSales = {{3, 4, 1}, {2, 5, 2, 1}, {4, 5, 3}, {7, 3}};
		for (int i = 0; i < 4; i++)
		{
			StackedBar bar = new StackedBar(stores[i], numProductItems[i]);
		  for (int j = 0; j < productSales[i].length; j++)
		  	bar.setValue(j, productSales[i][j]);
			barChart.addStackedBar(bar);
		}		
		barChart.printChart();
		System.out.println("Expected:\nHamilton|XXXYYYYZ\nNewmarket|XXYYYYYZZA\nDownsview|XXXXYYYYYZZZ\nBrampton|XXXXXXXYYY");
		
		System.out.println("Sort By 0th Product Value");
		barChart.sortStackedBarsByItemValue();
		barChart.printChart();
		System.out.println("Expected:\nNewmarket|XXYYYYYZZA\nHamilton|XXXYYYYZ\nDownsview|XXXXYYYYYZZZ\nBrampton|XXXXXXXYYY");
		
		System.out.println("Sort By Store Name");
		barChart.sortStackedBarsByLabel();
		barChart.printChart();
		System.out.println("Expected:\nBrampton|XXXXXXXYYY\nDownsview|XXXXYYYYYZZZ\nHamilton|XXXYYYYZ\nNewmarket|XXYYYYYZZA");
	}
}
