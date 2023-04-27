import java.util.ArrayList;

public class RyStudent
{
	private String name;
	private double gpa;
	private String status;
	private ArrayList<String> courses;
	
	public RyStudent()
	{
		name = "";
		gpa = 0.0;
		status = "";
		courses = new ArrayList<String>();
	}
	
	public void print()
	{
		System.out.printf("Name: %-12s Status: %-2s GPA: %1.1f Courses:", name, status, gpa);
		for (String course: courses)
		{
			System.out.printf(" %-6s", course);
		}
		System.out.println();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getGpa()
	{
		return gpa;
	}

	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}

	public ArrayList<String> getCourses()
	{
		return courses;
	}

	public void setCourses(ArrayList<String> courses)
	{
		this.courses = courses;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}
