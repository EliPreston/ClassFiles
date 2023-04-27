import java.util.ArrayList;

public class CanadianCitizen extends APerson
{
	private String SIN; // Social Insurance Number
	private ArrayList<TaxDeduction> taxDeductions = new ArrayList<TaxDeduction>();
	
	//Initialize the name and age variables inherited from Person and initialize variable SIN 
	public CanadianCitizen(String name, int age, String sinNumber)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		super(name, age);
		this.SIN = sinNumber;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	//Initialize the name variable inherited from Person and initialize variable SIN 
	public CanadianCitizen(String name, String sinNumber)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		super(name);
		this.SIN = sinNumber;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	// Two CanadianCitizens are equal if their names are equal and their SINs
	public boolean equals(Object other)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		if (super.equals(other)) {
			return true;
		}
		return false;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	
	// Return a string containing "SIN: " followed by the SIN followed by 
	// the Person info
	public String toString()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		return "SIN: " + this.SIN + " " + super.toString();
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	/*
	 * Adds a tax deduction to the list of tax deductions for this citizen
	 * A citizen cannot claim the same deduction more than once so if the
	 * deduction is already in the list, return false
	 * Otherwise, add the deduction to the list and return true
	 */
	public boolean addTaxDeduction(TaxDeduction deduction)
	{
		//-----------Start below here. To do: approximate lines of code = 4
		// add the tax deduction to the list of deductions only if it is not already in the list

		

		if (taxDeductions.contains(deduction)) {
			return false;
		}
		else {
			taxDeductions.add(deduction);
			return true;
		}

		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public ArrayList<TaxDeduction> getTaxDeductions()
	{
		return taxDeductions;
	}
	
}


