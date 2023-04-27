/*
 * A class used in displaying a bar graph printed horizontally
 * 
 * A bar with label "Mar" and length 5 will output as follows "Mar |*****\n".
 */
public class HorizontalBar 
{
	private String label;
	private int length;
	private int month;
	
	public HorizontalBar(String label, int len, int month)
	{
		this.label  = label;
		this.length = len;
		this.month = month;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}
	/*
	 * Print a horizontal bar on a single line as a label followed by a " " followed
	 * by "|" followed by a string containing a series of '*' characters that total 
	 * the length of this horizontal bar (see instance variable length above)
	 */
	public void print()
	{
		//-----------Start below here. To do: approximate lines of code = 6
		//
		String stars = "";
		for (int i = 0; i < this.getLength(); i++) {
			stars += "*";
		}
		System.out.println(this.getLabel() + " |" + stars);
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
}


