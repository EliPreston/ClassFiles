import java.util.Scanner;

public class WordListTester
{
	public static void main(String[] args)
	{
		WordList list = new WordList();
		String words = "precociousness and for the time we have had together is not for the faint of heart";
		Scanner scanner = new Scanner(words);
		
		//-----------Start below here. To do: approximate lines of code = 7
		// Use the scanner and add each word in the String words above to the WordList object called list
		// If an exception is throw, catch it and print the message stored in the exception object. Then
		// continue to the next word
		while (scanner.hasNext()) {
			try {
				String curr = scanner.next();
				list.addWord(curr);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		
		// Prints the linked lists
		list.print();
		
		System.out.println("Expected:\nWord: precociousness is too long\n"
				+ "Word: for already in word list\n"
				+ "Word: the already in word list\n"
				+ "2. [is, of, we]\n"
				+ "3. [and, for, had, not, the]\n"
				+ "4. [have, time]\n"
				+ "5. [faint, heart]\n"
				+ "8. [together]");
	}
}
