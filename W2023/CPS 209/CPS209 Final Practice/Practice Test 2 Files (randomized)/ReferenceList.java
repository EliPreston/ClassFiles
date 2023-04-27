import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
/*
 * This class stores a linked list of published academic papers (each paper is a Reference) 
 * 
 * It also has functionality to add a citation to a specific Reference. That is, the citation is in the form of a string
 * For example, one Reference might be:
 * Deformable Models in Medical Image Analysis: A Survey, McInerney, Medical Image Analysis, 1996
 * 
 * and a paper that was published later that cited the paper above might be:
 * "Cortical surface-based analysis: Segmentation and surface reconstruction, Dale, Neuroimage, 1999"
 */
public class ReferenceList
{
	LinkedList<Reference> references;
	
	public ReferenceList()
	{
		references = new LinkedList<Reference>();
	}
	/*
	 * Add a paper (a Reference) to the linked list of Reference objects
	 * Keep the References in the linked list sorted based on year of publication 
	 * (Hint: look at the imports above and class Reference)
	 * Note: before adding, throw a DuplicateReferenceException() if this Reference is 
	 * already in the linked list and pass the toString() of the reference to the constructor 
	 * of the exception object.
	 */
	public void addPaper(String author, String title, String journal, int year)
	{
		//-----------Start below here. To do: approximate lines of code = 5
		// 


		Reference newRef = new Reference(author, title, journal, year);
		if (references.contains(newRef)) {
			throw new DuplicateReferenceException(newRef.toString());
		}
		else {
			references.add(newRef);
			Collections.sort(references);
		}
		


		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	/*
	 * Add a citation to the Reference. Uses the author, title, journal, year parameters
	 * to find the Reference object in the linked list. If the Reference is found, add the citation to it
	 * If it is not found, throw a ReferenceNotFoundException  
	 */
	public void addCitation(String author, String title, String journal, int year, String citation)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// Hint: construct a temporary Reference object using the parameters 
		// and make use of the equals() method in class Reference
		
		Reference tempRef = new Reference(author, title, journal, year);
		int check = -1;
		for (int i = 0; i < references.size(); i++) {
			if (references.get(i).equals(tempRef)) {
				references.get(i).addCitation(citation);
				check = 1;
			}
		}

		if (check == -1) {
			throw new ReferenceNotFoundException();
		}

		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	/*
	 * Given the parameters, finds the Reference object in the linked list and 
	 * prints all the citations stored in the Reference object
	 * If the Reference object is not found, throw a ReferenceNotFoundException
	 */
	public void printCitations(String author, String title, String journal, int year)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		//

		Reference tempRef = new Reference(author, title, journal, year);
		int check = -1;
		for (int i = 0; i < references.size(); i++) {
			if (references.get(i).equals(tempRef)) {
				check = 1;

				references.get(i).printCitations();
			}
		}

		if (check == -1) {
			throw new ReferenceNotFoundException("Reference Not Found");
		}
		
		
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public void printPapers()
	{
		for (Reference ref: references)
		{
			System.out.println(ref.toString());
		}
	}
}


class DuplicateReferenceException extends RuntimeException
{
	public DuplicateReferenceException() {}
	
	public DuplicateReferenceException(String msg) 
	{
		super(msg);
	}
}

class ReferenceNotFoundException extends RuntimeException
{
	public ReferenceNotFoundException() {}
	
	public ReferenceNotFoundException(String msg) 
	{
		super(msg);
	}
}