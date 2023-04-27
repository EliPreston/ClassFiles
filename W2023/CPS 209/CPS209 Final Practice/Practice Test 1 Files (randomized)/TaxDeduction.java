/* 
 * 
 * A class representing a tax deduction for a person
 */
public class TaxDeduction
{
	private String code; // Government code for this tax deduction
	private String description;
	private String date;
	private String name;
	private String SIN;
		
	public TaxDeduction(String code, String descr, String date)
	{
		this.date = date;
		this.description = descr;
		this.code = code;
	}
	
	public TaxDeduction(String code, String descr, String date, String name, String sin)
	{
		this.date = date;
		this.description = descr;
		this.code = code;
		this.name = name;
		this.SIN = sin;
	}
	
	public boolean equals(Object other)
	{
		TaxDeduction otherDeduction = (TaxDeduction) other;
		return this.code.equals(otherDeduction.code);
	}
	
	public String getDate()
	{
		return date;
	}

	public String getDescription()
	{
		return description;
	}

	public String getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public String getSocialInsuranceNumber()
	{
		return SIN;
	}
}
