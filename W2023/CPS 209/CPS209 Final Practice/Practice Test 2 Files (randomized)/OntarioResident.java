import java.util.ArrayList;
/*
 * An OntarioResident is a Person and has a health card number.
 * A list of medical procedures the resident has undergone is stored as well
 */
public class OntarioResident extends Person 
{
	String healthCardNumber;
	ArrayList<MedicalProcedure> procedures = new ArrayList<MedicalProcedure>();
	
	// Initialize the name and age variables inherited from Person and the healthCardNumber 
	public OntarioResident(String name, int age, String cardNumber)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		super(name, age);
		this.healthCardNumber = cardNumber;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	// Two OntarioResidents are equal if their name and age are equal and their healthCardNumbers
	public boolean equals(Object other)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		//
		return super.equals(other);
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	
	// Return a string containing "HCN: " followed by the healthCardNumber followed by 
	// the Person info
	public String toString()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		//
		return "HCN: " + this.healthCardNumber + " " + super.toString();
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public void addMedicalProcedure(MedicalProcedure mp)
	{
		procedures.add(mp);
	}
	
	public ArrayList<MedicalProcedure> getMedicalProcedures()
	{
		return procedures;
	}
	
}
