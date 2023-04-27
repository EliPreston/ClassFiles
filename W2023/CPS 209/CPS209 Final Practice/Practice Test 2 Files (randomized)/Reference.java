import java.util.LinkedList;
/*
 * This class models a reference to a published academic journal paper
 * 
 * It stores the paper author, title, journal name, and year of publication
 * It also contains a linked list of all papers (each paper stored as a string) that cited this paper
 */
public class Reference implements Comparable<Reference>
{
	private String author;
	private String title;
	private String journal;
	private int year;
	private LinkedList<String> citedBy = new LinkedList<String>();
	
	public Reference(String author, String title, String journal, int year)
	{
		this.author = author;
		this.title = title;
		this.journal = journal;
		this.year = year;
	}

	// Compare based on the year of publication (ordered oldest to most recent)
	public int compareTo(Reference other)
	{
		return this.year - other.year;
	}
	
	// Overrides the equals() method and compare the this and other Reference object
	// They are equal if their author and title and journal and year are equal
	public boolean equals(Object other)
	{
		Reference otherRef = (Reference) other;
		return author.equals(otherRef.author) && title.equals(otherRef.title) && journal.equals(otherRef.journal) && year == otherRef.year;
	}
	
	public String toString()
	{
		return title + ", " + author + ", " + journal + ", " + year;
	}
	
	public void addCitation(String paper)
	{
		citedBy.add(paper);
	}
	
	public void printCitations()
	{
		int counter = 1;
		for (String cite: citedBy)
		{
			System.out.println(counter + ". " + cite);
			counter++;
		}
	}
	
}
