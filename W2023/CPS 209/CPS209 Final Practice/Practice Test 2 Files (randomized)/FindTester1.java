import java.util.ArrayList;

public class FindTester1
{
	public static void main(String[] args)
	{
		ArrayList<OntarioResident> residents  = new ArrayList<OntarioResident>();
		ArrayList<MedicalProcedure> procedures = new ArrayList<MedicalProcedure>();
		
		residents.add(new OntarioResident("Tony", 37, "324567"));
		residents.add(new OntarioResident("Malcolm", 62, "227557"));
		residents.add(new OntarioResident("Brendan", 55, "654312"));
		residents.add(new OntarioResident("Daniel", 84, "7564532"));
		residents.add(new OntarioResident("Noah", 70, "766432"));
		
		procedures.add(new MedicalProcedure("1234", "Colonoscopy", "021399", "Tony", 37, "324567"));
		procedures.add(new MedicalProcedure("3524", "Gastroscopy", "062210", "Tony", 37, "324567"));
		procedures.add(new MedicalProcedure("8775", "Ultrasound", "042911", "Malcolm", 62, "227557"));
		procedures.add(new MedicalProcedure("4532", "Radiation", "031609", "Brendan", 55, "654312"));
		procedures.add(new MedicalProcedure("5643", "Surgery", "012996", "Tony", 37, "324567"));
		procedures.add(new MedicalProcedure("1234", "Colonoscopy", "021405", "Malcolm", 62, "227557"));
		procedures.add(new MedicalProcedure("1234", "Colonoscopy", "062693", "Tony", 37, "324567"));
		procedures.add(new MedicalProcedure("3524", "Gastroscopy", "052320", "Daniel", 84, "7564532"));
		procedures.add(new MedicalProcedure("8775", "Ultrasound", "012396", "Noah", 70, "766432"));
		
		// For each medical procedure, find the corresponding resident in the residents list. Then add the 
		// medical procedure to that resident.
		for (int i = 0; i < procedures.size(); i++)
		{
			MedicalProcedure mp = procedures.get(i);
		    //-----------Start below here. To do: approximate lines of code = 5
		    // get the name, age and healthCardNumber from the MedicalProcedure object 
			// Create a temporary OntarioResident object from this info (see class OntarioResident)
			// Use the general find() method at the bottom to find the matching OntarioResident object 
			// in the residents array list. If a matching resident was found, add the medical procedure to 
			// their list of procedures and print: "Add " followed by the medical procedure description followed by
			// " to " followed by the OntarioResident information via toString() 
			// NOTE: YOU MUST USE THE find() METHOD at the bottom of this class
			// Hint: you will need to cast
		    String name = mp.getName();
			int age = mp.getAge();
			String hcn = mp.getHealthCardNumber();

			OntarioResident temp = new OntarioResident(name, age, hcn);

			Object found = find(temp, residents);
			if (found != null) {
				OntarioResident curr = (OntarioResident) found;
				curr.addMedicalProcedure(mp);
				System.out.println("Add " + mp.getDescription() + " to " + curr.toString());
			}
		    
		    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		}
		printExpected1();
		
		// Determine which residents of Ontario have had at least one colonoscopy
		MedicalProcedure colonoscopy = new MedicalProcedure("1234", "Colonoscopy", "");
		System.out.println("\nPatients who have had a colonoscopy");
		for (int i = 0; i < residents.size(); i++)
		{
			//-----------Start below here. To do: approximate lines of code = 4
			// get the array list of procedures for each resident
			// Use the find() method at the bottom to determine if the resident has had
			// a colonoscopy (make use of the colonoscopy object above). 
			// If a match was found, print the OntarioResdient information using toString()
			ArrayList<MedicalProcedure> currMedProArr = residents.get(i).getMedicalProcedures();
			Object found = find(colonoscopy, currMedProArr);

			if (found != null) {
				System.out.println(residents.get(i).toString());
			}
			
			
			
			
			
			//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		}
		printExpected2();
	}
	
    // General method to search any array list.
	// The first parameter is the reference to the Object to be found. 
	// The second parameter is an array list of objects to be searched
	// If the object is found in the list then return a reference to the list object, otherwise return null
	static Object find(Object o, ArrayList list)
	{
		int index = list.indexOf(o);
		if (index != -1) return list.get(index);
		return null;
	}
	
	
	static void printExpected1()
	{
		System.out.println("Expected:\nAdd Colonoscopy to HCN: 324567 Name: Tony Age: 37\n"
				+ "Add Gastroscopy to HCN: 324567 Name: Tony Age: 37\n"
				+ "Add Ultrasound to HCN: 227557 Name: Malcolm Age: 62\n"
				+ "Add Radiation to HCN: 654312 Name: Brendan Age: 55\n"
				+ "Add Surgery to HCN: 324567 Name: Tony Age: 37\n"
				+ "Add Colonoscopy to HCN: 227557 Name: Malcolm Age: 62\n"
				+ "Add Colonoscopy to HCN: 324567 Name: Tony Age: 37\n"
				+ "Add Gastroscopy to HCN: 7564532 Name: Daniel Age: 84\n"
				+ "Add Ultrasound to HCN: 766432 Name: Noah Age: 70");
	}
	
	static void printExpected2()
	{
		System.out.println("Expected:\nPatients who have had a colonoscopy\n"
				+ "HCN: 324567 Name: Tony Age: 37\n"
				+ "HCN: 227557 Name: Malcolm Age: 62");
	}
}
