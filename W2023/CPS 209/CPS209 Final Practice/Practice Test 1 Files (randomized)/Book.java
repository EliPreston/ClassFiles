
public class Book implements Comparable<Book>
{
	private String author;
	private String title;
	private int year;
	
	public Book(String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int compareTo(Book other)
	{
		return this.year - other.year;
	}
	
	public boolean equals(Object other)
	{
		Book otherB = (Book) other;
		return this.title.equals(otherB.title) && this.author.equals(otherB.author) && this.year == otherB.year;
	}
	
	public String toString()
	{
		return "[" + title + ", " + author + ", " + year + "]";
	}
}
