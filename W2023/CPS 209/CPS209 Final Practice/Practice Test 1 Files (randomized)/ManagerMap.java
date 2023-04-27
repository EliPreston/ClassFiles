import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;
/*
 * 
 * This class contains a map that maps a string key, representing a manager name, to a value that is
 * an ArrayList of strings.
 * That is, the key is a manager String and the map value is not just a String but an ArrayList<String>
 *  
 * Each string in an array list associated with a manager represents an employee of that manager
 * 
 * For example, if employees "Ali", "Jane", "Harry" all have the manager "BigBoss", then the map would map the
 * key "BigBoss" to an array list, where element 0 in the list is "Ali", element 1 is "Jane" and element 2 is "Harry"
 * 
 * In other words, with this map we can keep track of the distribution of employees as well as the individual employees
 * who work for a specific manager
 */
public class ManagerMap
{
	//-----------Start below here. To do: approximate lines of code = 1
	// Declare a map called managers that maps a String representing a manager name
	// to an ArrayList of Strings. 
	Map<String, ArrayList<String>> managers;
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	public ManagerMap()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// create an empty tree map and assign it to variable managers
		managers = new TreeMap<String, ArrayList<String>>();
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	/*
	 * Establishes a mapping between the given manager to the employee
	 */
	public void add(String manager, String employee)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// map the given manager to an array list and add the given employee to that list
		// Hint: if this is the first mapping for the manager, create an empty array list,
		// add the employee to it then create the mapping from the manager key to the array list in the tree map
		
		if (managers.keySet().contains(manager)) {
			ArrayList<String> temp = managers.get(manager);
			temp.add(employee);
			managers.put(manager, temp);

		}
		else {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(employee);
			managers.put(manager, temp);
		}
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/*
	 * Prints the grade distribution
	 */
	public void printEmployeesOfManager()
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// Prints all the keys and associated lists 
		// Each line that is printed should print the manager followed by ": " followed by the size of the
		// array list for that key, followed by " - " followed by a each of the employees in the list separated by a ", "
		// Ensure the last employee in a list has no following ", "
		

		for (String manager : managers.keySet()) {
			ArrayList<String> employees = managers.get(manager);

			String employeesString = "";
			for (int i = 0; i < employees.size(); i++) {
				
				if (i == employees.size()-1) {
					employeesString += employees.get(i);
				}
				else {
					employeesString += employees.get(i) + ", ";
				}
			}
			System.out.println(manager + ": " + employees.size() + " - " + employeesString);

		}
		
		
		

		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}
