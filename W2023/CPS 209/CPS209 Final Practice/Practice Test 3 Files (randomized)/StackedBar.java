/* 
 * This class simulates a single Stacked Bar using text characters to "draw" the length of the bar for a Stacked Bar Chart.
 *  
 * String label is the label for the stacked bar. 
 * int numDataItems keeps track of the number of data items that will be represented when the stacked bar is drawn
 * int[] data is an array storing the value associated with a particular item
 * 
 * The symbols 'X' 'Y' 'Z' 'A' 'B' are used to draw the stacked bar where the number of 'X' characters printed corresponds 
 * to the value of the 0th data item, the number of 'Y' characters printed corresponds to the value of the 1st data item,  
 * and so on. There is a maximum of 5 data items supported. 
 * 
 * For example, if the label is "Hamilton", the number of data items is 3, and these have values 3, 4, and 1, then the output is
 * 
 * Hamilton|XXXYYYYZ
 */
public class StackedBar 
{
	private String label;
	private int[] data;
	private int numDataItems;
	private static final int MAXITEMS = 5;
	
	public StackedBar(String label, int numDataItems)
	{
		this.label  = label;
		this.numDataItems = numDataItems;
		data = new int[numDataItems];
	}

	public int getValue(int item)
	{
		return data[item];
	}
	
	public void setValue(int item, int value)
	{
		data[item] = value;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public int getNumDataItems()
	{
		return numDataItems;
	}

	public void setNumDataItems(int numDataItems)
	{
		this.numDataItems = numDataItems;
	}

  /*
	 * Print a stacked bar on a single line as a label followed by a "|" followed by a string containing a series of marks   
	 * ('X' 'Y' 'Z' 'A' 'B' ) where 'X' is used as the mark for the 0th data item and 'Y' for the 1st and so on. Print out
	 * the number of marks corresponding to the value stored in the data array. For example, if data[0] is equal to 4 then
	 * print "XXXX", if data[1] is equal to 2 then print "YY" and so on. 
	 */
	public void print()
	{
		//-----------Start below here. To do: approximate lines of code = 8
		//
		String output = getLabel() + "|";
		String[] marks = new String[5];
		marks[0] = "X";
		marks[1] = "Y";
		marks[2] = "Z";
		marks[3] = "A";
		marks[4] = "B";

		for (int i = 0; i < getNumDataItems(); i++) {
			for (int j = 0; j < data[i]; j++) {
				output += marks[i];
			}
		}
		System.out.println(output);

		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
}


