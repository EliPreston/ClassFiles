// Publications
// List of JournalPaper
// 
public class ReferenceListTester
{
	public static void main(String[] args)
	{
		ReferenceList references = new ReferenceList();
		
		System.out.println("Reference List:");
		references.addPaper("Tim", "A Brilliant Theory", "Journal of Brilliant Theories", 1999);
		references.addPaper("Jake","A Theory of Everything", "Journal of Genius Stuff", 2021);
		references.addPaper("Donald", "The Stolen Election", "Journal of Conspiracies", 2020);
		references.printPapers();
		System.out.println("Expected:\nReference List:\n"
				+ "A Brilliant Theory, Tim, Journal of Brilliant Theories, 1999\n"
				+ "The Stolen Election, Donald, Journal of Conspiracies, 2020\n"
				+ "A Theory of Everything, Jake, Journal of Genius Stuff, 2021");
		
		
		System.out.println("\nCheck Duplicate Exceptions");
		try
		{
			references.addPaper("Donald", "The Stolen Election", "Journal of Conspiracies", 2020);
		}
		catch (DuplicateReferenceException e)
		{
			System.out.println("Duplicate Reference: " + e.getMessage());
		}
		System.out.println("Expected:\nCheck Duplicate Exceptions\n"
				+ "Duplicate Reference: The Stolen Election, Donald, Journal of Conspiracies, 2020");
		
		String[] citations = {"Suspect Theories by Tim that Somehow Got Published, Eric, Journal of Brilliant Theories, 2000",
				                  "A Theory of Nothing, NohOne, The Nonexistent Journal, 101010",
				                  "I Won You Lost, Joe, Journal of Reality, 2021",
				                  "Everything is Beautiful, Initsownway, Journal of The Obvious, 2024",
				                  "Java is Genius, Professor, Journal of Genius Stuff, 2024"};
		
		
		references.addCitation("Tim", "A Brilliant Theory", "Journal of Brilliant Theories", 1999, citations[0]);
		references.addCitation("Jake","A Theory of Everything", "Journal of Genius Stuff", 2021, citations[1]);
		references.addCitation("Jake","A Theory of Everything", "Journal of Genius Stuff", 2021, citations[3]);
		references.addCitation("Jake","A Theory of Everything", "Journal of Genius Stuff", 2021, citations[4]);
		references.addCitation("Donald", "The Stolen Election", "Journal of Conspiracies", 2020, citations[2]);
		
		System.out.println("\nJake Citations");
		references.printCitations("Jake","A Theory of Everything", "Journal of Genius Stuff", 2021);
		System.out.println("Expected:\nJake Citations\n"
				+ "1. A Theory of Nothing, NohOne, The Nonexistent Journal, 101010\n"
				+ "2. Everything is Beautiful, Initsownway, Journal of The Obvious, 2024\n"
				+ "3. Java is Genius, Professor, Journal of Genius Stuff, 2024");
		
		System.out.println("\nTim Citations");
		references.printCitations("Tim", "A Brilliant Theory", "Journal of Brilliant Theories", 1999);
		System.out.println("Expected:\nTim Citations\n"
				+ "1. Suspect Theories by Tim that Somehow Got Published, Eric, Journal of Brilliant Theories, 2000");
		
		System.out.println("\nDonald Citations");
		references.printCitations("Donald", "The Stolen Election", "Journal of Conspiracies", 2020);
		System.out.println("Expected:\nDonald Citations\n"
				+ "1. I Won You Lost, Joe, Journal of Reality, 2021");
		
		try
		{
			System.out.println("\nCheck Reference Not Found:\nTim, A Not So Brilliant Theory, Journal of Brilliant Theories, 1999");
			references.printCitations("Tim", "A Not So Brilliant Theory", "Journal of Brilliant Theories", 1999);
		}
		catch (ReferenceNotFoundException e)
		{
			System.out.println("Reference Not Found");
		}
		System.out.println("Expected:\nCheck Reference Not Found:\n"
				+ "Tim, A Not So Brilliant Theory, Journal of Brilliant Theories, 1999\n"
				+ "Reference Not Found");
	}
}
