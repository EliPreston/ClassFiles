import java.util.ArrayList;

/*
 * A class used in displaying a bar chart where the bars are drawn vertically using text characters to represent bar height
 */
public class VerticalBar 
{
	private String label;
	private int height;
	
	public VerticalBar(String label, int h)
	{
		this.label  = label;
		this.height = h;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	/*
	 * Outputs a vertical bar as an array list of strings where the 0th element in the array list is the label, the
	 * 1st element in the array list is the string "-" and each subsequent element is the string "X" where the 
	 * number of these subsequent elements is equal to the height of this bar
	 */
	public ArrayList<String> output()
	{
		ArrayList<String> vertBar = new ArrayList<String>();
		vertBar.add(label);
		vertBar.add("-");
		for (int i = 0; i < height; i++)
			vertBar.add("X");
		return vertBar;
	}
}


