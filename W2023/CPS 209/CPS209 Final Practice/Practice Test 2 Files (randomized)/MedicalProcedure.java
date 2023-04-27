/*
 * class that stores information about a medical procedure as well as the person who had the procedure
 */
public class MedicalProcedure
{
	private String date;
	private String description;
	private String procedureId;
	private OntarioResident patient;
	private String name;
	private int age;
	private String healthCardNumber;
	
	public MedicalProcedure(String procId, String descr, String date)
	{
		this.date = date;
		this.description = descr;
		this.procedureId = procId;
	}
	
	public MedicalProcedure(String procId, String descr, String date, String name, int age, String card)
	{
		this.date = date;
		this.description = descr;
		this.procedureId = procId;
		this.name = name;
		this.age = age;
		this.healthCardNumber = card;
	}
	
	public boolean equals(Object other)
	{
		MedicalProcedure proc = (MedicalProcedure) other;
		return this.procedureId.equals(proc.procedureId);
	}
	
	public String getDate()
	{
		return date;
	}

	public String getDescription()
	{
		return description;
	}

	public String getProcedureId()
	{
		return procedureId;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String getHealthCardNumber()
	{
		return healthCardNumber;
	}
}
