import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Reads a text file containing information about Ryerson students. 
// The first line of the file contains an integer number representing the number of student "records" stored
// in the file. A student record has the following format (demonstrated with an example):

// John Brown
// 3.8
// Full-Time
// 4:CPS209:CPS305:CPS311:CPS511

// That is, each record consists of 4 lines. Line 1: student name string Line 2: gpa (a double number)
// Line 3: status string (for example, Part-Time) Line 4: a list of course codes strings (separated by ':' )
// the student is taking. At the beginning of line 4 is an integer number representing the number of 
// course codes that follow. 
// 
// The expected output is as follows:
// Name: John Brown   Status: Full-Time  GPA: 3.8 Courses: CPS209  CPS305  CPS311  CPS511  
// Name: Abdy Abhari  Status: Part-Time  GPA: 4.1 Courses: CPS643  CPS305  
// Name: Eric Harley  Status: Full-Time  GPA: 4.3 Courses: CPS109  CPS209  CPS305  CPS311  CPS511  
// Name: Dave Mason   Status: Full-Time  GPA: 4.0 Courses: CPS209  CPS305  CPS511  
// Name: Tim Mc       Status: Part-Time  GPA: 1.8 Courses: CPS209  CPS643  
// Name: Rick V       Status: Part-Time  GPA: 4.3 Courses: CPS209  CPS721


public class FE1
{
	public static void main(String[] args)
	{
		ArrayList<RyStudent> students = null;

		try
		{
			students = loadStudentFile();
			for (RyStudent s: students)
				s.print();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("No file found " + e);  
		}
		catch (IOException exception)        
		{
			System.out.println("Input/output error " + exception); 
		}
		catch (NumberFormatException exception)
		{         
			System.out.println("Invalid Number");
		} 

		System.out.print("EXPECTED:\n");
		System.out.println("Name: John Brown   Status: FT GPA: 3.8 Courses: CPS209 CPS305 CPS311\n"
				+ "Name: Abdy Abhari  Status: PT GPA: 4.1 Courses:\n"
				+ "Name: Eric Harley  Status: FT GPA: 4.3 Courses: CPS109 CPS209 CPS305\n"
				+ "Name: Dave Mason   Status: FT GPA: 4.0 Courses: CPS209 CPS305 CPS511\n"
				+ "Name: Tim Mc       Status: PT GPA: 1.8 Courses: CPS209\n"
				+ "Name: Rick V       Status: PT GPA: 4.3 Courses: CPS209 CPS721");
	}

	// Load the information for all students from the rystudents.txt file 
	// into an array list of RyStudent. Return a reference to the array list.
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
	//-----------Start below here. To do: approximate lines of code = 1
	// the method should be called loadStudentFile() and is static. It should return an
	// ArrayList of RyStudent objects
	public static ArrayList<RyStudent> loadStudentFile() throws FileNotFoundException
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{
		ArrayList<RyStudent> students = new ArrayList<RyStudent>();
		Scanner in = new Scanner(new File("rystudents.txt"));
		int numStudents;

		//-----------Start below here. To do: approximate lines of code = 4
		// Read the first line of the file and convert to an integer and store in numStudents. 
		// This represents the number of student records in the rystudents.txt file
		// Call the method readNextStudent() numStudents times (hand in the reference to the scanner)
		// Add each returned RyStudent object to the array list
		numStudents = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numStudents; i++) {
			RyStudent s = readNextStudent(in);
			students.add(s);
		}

		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		return students;
	}

	// Use the given Scanner to read one student "record" from rystudents.txt and create and return a RyStudent object
	// A student record takes up 4 lines. See the top of this file for the exact format. 
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
	//-----------Start below here. To do: approximate lines of code = 1
	public static RyStudent readNextStudent(Scanner sc)
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{  
		//-----------Start below here. To do: approximate lines of code = 18
		// 
		
		// Line 1: student name string 
		// Line 2: gpa (a double number)
		// Line 3: status string (for example, Part-Time) 
		// Line 4: a list of course codes strings (separated by ':' ) the student is taking.
		String name = sc.nextLine();
		double gpa = Double.parseDouble(sc.nextLine());
		String status = sc.nextLine();
		String[] courses = sc.nextLine().split(":");
		ArrayList<String> coursesAL = new ArrayList<String>();

		for (int i = 0; i < courses.length; i++) {
			coursesAL.add(courses[i]);
		}
		coursesAL.remove(0);

		RyStudent currStudent = new RyStudent();
		currStudent.setName(name);
		currStudent.setGpa(gpa);
		currStudent.setStatus(status);
		currStudent.setCourses(coursesAL);

		return currStudent;

		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

