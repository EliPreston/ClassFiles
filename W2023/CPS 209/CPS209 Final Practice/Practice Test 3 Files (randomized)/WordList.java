import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
/*
 * 
 * This class contains an array of LinkedLists. Each LinkedList stores a list of words (strings) having the
 * same length. 
 */
public class WordList
{
	static final int MAXWORDLENGTH = 12;
	LinkedList<String>[] wordLists;
		
	public WordList()
	{
		wordLists = new LinkedList[MAXWORDLENGTH+1];
		//-----------Start below here. To do: approximate lines of code = 2
		// Create MAXWORDLENGTH LinkedList objects and assign each as an array element of wordLists
		for (int i = 0; i < MAXWORDLENGTH+1; i++) {
			wordLists[i] = new LinkedList<String>();
		}
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/*
	 * Adds a word to the appropriate linked list based on the length of the word
	 * Keeps the words in each linked list sorted alphabetically
	 * For example, if the word is "cat" then add the word to the linked list with index 3 in the array of linked lists.
	 * If the word is "to" then add the word to the linked list with index 2
	 * 
	 * Note: linked list 0 is not used
	 * 
	 * If the length of the word is greater than the MAXWORDLENGTH then throw a
	 * WordLengthException and pass in the message "Word: " followed by the word followed by " is too long"
	 * 
	 * If the word is already in the linked list then throw a
	 * DuplicateWordException and pass in the message "Word: " followed by the word followed by " already in word list"
	 */
	public void addWord(String word)
	{
		//-----------Start below here. To do: approximate lines of code = 7
		//
		
		// Check to see if word too long
		if (word.length() > MAXWORDLENGTH) {
			throw new WordLengthException("Word: " + word + " is too long");
		}
		
		
		// Check to see if already in the linked list
		if (wordLists[word.length()].contains(word)) {
			throw new DuplicateWordException("Word: " + word + " already in word list");
		}
		
		// Add word to the appropriate linked list 
		wordLists[word.length()].add(word);
		// Sort the list
		Collections.sort(wordLists[word.length()]);
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
  /*
   * Print all the linked lists that have at least one word
   * For each Linked List in the array that has at least one word, print 
   * the array index (which matches the word length) followed by the Linked List itself
   * (Note: assume class LinkedList<String> has a toString() method)   
   */
	public void print()
	{
		//-----------Start below here. To do: approximate lines of code = 3
		//
		for (int i = 0; i < wordLists.length; i++) {

			if (wordLists[i].size() > 0) {
				System.out.println("" + i  + ". " + wordLists[i]);
			}

		}
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

class WordLengthException extends RuntimeException
{
	public WordLengthException() {}
	public WordLengthException(String msg)
	{
		super(msg);
	}
}

class DuplicateWordException extends RuntimeException
{
	public DuplicateWordException() {}
	public DuplicateWordException(String msg)
	{
		super(msg);
	}
}
