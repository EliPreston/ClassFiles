import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * This program tests the CanadianCitizen class and the TaxDeduction class
 * It also demonstrates polymorphism via a general search() method
 */
public class FindTester2
{
	public static void main(String[] args)
	{
		ArrayList<CanadianCitizen> citizens	= new ArrayList<CanadianCitizen>();
		ArrayList<TaxDeduction> deductions 	= new ArrayList<TaxDeduction>();
		
		citizens.add(new CanadianCitizen("Tony", 37, "324567"));
		citizens.add(new CanadianCitizen("Malcolm", 62, "227557"));
		citizens.add(new CanadianCitizen("Brendan", 55, "654312"));
		citizens.add(new CanadianCitizen("Daniel", 84, "7564532"));
		citizens.add(new CanadianCitizen("Noah", 70, "766432"));
		
		deductions.add(new TaxDeduction("1234", "Home Office", "021399", "Tony", "324567"));
		deductions.add(new TaxDeduction("3524", "Car Lease", "062210", "Tony", "324567"));
		deductions.add(new TaxDeduction("8775", "Charities", "042911", "Malcolm", "227557"));
		deductions.add(new TaxDeduction("4532", "Tuition", "031609", "Brendan", "654312"));
		deductions.add(new TaxDeduction("5643", "Transportation", "012996", "Tony", "324567"));
		deductions.add(new TaxDeduction("1234", "Home Office", "021405", "Malcolm", "227557"));
		deductions.add(new TaxDeduction("1234", "Home Office", "062693", "Tony", "324567"));
		deductions.add(new TaxDeduction("3524", "Car Lease", "052320", "Daniel", "7564532"));
		deductions.add(new TaxDeduction("8775", "Charities", "012396", "Noah", "766432"));
		
		// For each deduction, find the citizen in the citizens list that that deduction corresponds 
		// to. Then add the deduction to that citizen. 
		for (int i = 0; i < deductions.size(); i++)
		{
			TaxDeduction deduction = deductions.get(i);
		    //-----------Start below here. To do: approximate lines of code = 5
		    // get the name and SIN from the TaxDeduction object 
			// Create a temporary CanadianCitizen object from this info (see class CanadianCitizen)
			// Use the general search() method at the bottom to find the matching CanadianCitizen object 
			// in the citizens array list. If a matching citizen was found, add the deduction to 
			// their list of deductions and print: "Add " followed by the deduction description followed by
			// " to " followed by the CanadianCitizen information via the toString() method 
			// NOTE: YOU MUST USE THE search() METHOD at the bottom of this class
			// Hint: you will need to cast!
			
			CanadianCitizen temp = new CanadianCitizen(deduction.getName(), deduction.getSocialInsuranceNumber());

			Object match = search(temp, citizens);
			if (match != null) {
				CanadianCitizen cMatch = (CanadianCitizen) match;
				if (cMatch.addTaxDeduction(deduction)) {
					System.out.println("Add " + deduction.getDescription() + " to " + cMatch.toString());
				}

			}

		    
		    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		}
		printExpected1();
		
		// Determine which citizens have claimed the Home Office tax deduction
		TaxDeduction homeOffice = new TaxDeduction("1234", "Home Office", "");
		System.out.println("\nCitizens who have claimed the Home Office deduction");
		for (int i = 0; i < citizens.size(); i++)
		{
			//-----------Start below here. To do: approximate lines of code = 4
			// get the array list of tax deductions for each citizen
			// Use the search() method at the bottom to determine if the citizen has claimed
			// a Home Office deduction (make use of the homeOffice object above). 
			// If a match was found, print the CanadianCitizen information using toString()

			ArrayList<TaxDeduction> currTaxDed = citizens.get(i).getTaxDeductions();
			Object claimed = search(homeOffice, currTaxDed);

			if (claimed != null) {
				System.out.println(citizens.get(i).toString());
			}
			
			
			
			
			
			//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		}
		printExpected2();
	}
	
	// General method to search any array list.
	// The first parameter is the reference to the Object to be found. 
	// The second parameter is an array list of objects to be searched
	// If the object is found in the list then return a reference to the list object, otherwise return null
	static Object search(Object o, ArrayList list)
	{
		int index = list.indexOf(o);
		if (index != -1) return list.get(index);
		return null;
	}

	
	static void printExpected1()
	{
		System.out.println("Expected:\nAdd Home Office to SIN: 324567 Name: Tony Age: 37\n"
				+ "Add Car Lease to SIN: 324567 Name: Tony Age: 37\n"
				+ "Add Charities to SIN: 227557 Name: Malcolm Age: 62\n"
				+ "Add Tuition to SIN: 654312 Name: Brendan Age: 55\n"
				+ "Add Transportation to SIN: 324567 Name: Tony Age: 37\n"
				+ "Add Home Office to SIN: 227557 Name: Malcolm Age: 62\n"
				+ "Add Car Lease to SIN: 7564532 Name: Daniel Age: 84\n"
				+ "Add Charities to SIN: 766432 Name: Noah Age: 70");
	}
	
	static void printExpected2()
	{
		System.out.println("Expected:\nCitizens who have claimed the Home Office deduction\n"
				+ "SIN: 324567 Name: Tony Age: 37\n"
				+ "SIN: 227557 Name: Malcolm Age: 62");
	}
}
