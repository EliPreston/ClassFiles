import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
 * 
 * This class contains a map that maps a string key, representing a professors to an array list of strings.
 * Each string in the array list represents a grad. student of a specific professor.
 * That is, the key is a professor String and the map value is not just a String but an ArrayList<String>
 * 
 * For example, if students "Ali", "Mohamed", "Hamna" all have "Dr. Smart" as their professor, then the map 
 * would map the key "Dr. Smart" to an array list where element 0 in the list is "Ali", element 1 is "Mohamed" and 
 * element 2 is "Hamna".
 * 
 * In other words, with this map we can keep track of the distribution of grad. students as well as the individual students
 * who are supervised by a specific professor
 */
public class ProfessorMap
{
	//-----------Start below here. To do: approximate lines of code = 1
	// Declare a map called professors that maps a String representing a professor name
	// to an ArrayList of Strings. 
	Map<String, ArrayList<String>> professors;
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	public ProfessorMap()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// create an empty tree map and assign to professors
		professors = new TreeMap<String, ArrayList<String>>();
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	/*
	 * Establishes a mapping from the given professor to their list of grad. students
	 */
	public void add(String professor, String student)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// map the professor to an array list and add the student to that list
		// Hint: if this is the first mapping for the professor, create an empty array list,
		// add the student to it then create the mapping from the professor key to the array list in the tree map
		if (professors.keySet().contains(professor)) {
			ArrayList<String> students = professors.get(professor);
			students.add(student);
			professors.put(professor, students);

		}
		else {
			ArrayList<String> students = new ArrayList<String>();
			students.add(student);
			professors.put(professor, students);
		}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/*
	 * Prints the student distribution
	 */
	public void printStudentsOfProfessor()
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// Prints all the keys and associated lists 
		// Each line that is printed should print the professor followed by ": " followed by the size of the
		// array list for that key, followed by " - " followed by each of the students in the list separated by a ", "
		// Ensure the last student in a list has no following ", "
		
		for (String professor : professors.keySet()) {
			ArrayList<String> students = professors.get(professor);

			String output = professor + ": " + students.size() + " - ";
			
			for (int i = 0; i < students.size(); i++) {
				if (i == students.size()-1) {
					output += students.get(i);
				}
				else {
					output += students.get(i) + ", ";
				}
			}
			System.out.println(output);

		}
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}
