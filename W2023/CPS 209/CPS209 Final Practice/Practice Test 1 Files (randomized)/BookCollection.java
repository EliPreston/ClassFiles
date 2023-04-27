import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * 
 * This class implements a collection of books categorized by genre.
 * The collections is implemented using an array of LinkedLists. 
 * Each LinkedList stores a list of Book objects for a specific category 
 */
public class BookCollection
{
	public static final int HORROR = 0;
	public static final int DRAMA  = 1;
	public static final int ACTION = 2;
	
	LinkedList<Book>[] bookLists;
		
	public BookCollection()
	{
		bookLists = new LinkedList[3];
		//-----------Start below here. To do: approximate lines of code = 2
		// Create 3 LinkedList objects and assign each as an array element of bookLists
		bookLists[0] = new LinkedList<Book>();
		bookLists[1] = new LinkedList<Book>();
		bookLists[2] = new LinkedList<Book>();
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/*
	 * Adds a book to the appropriate linked list based on Category
	 * Keeps the books in each linked list sorted alphabetically by year published
	 * 
	 * If the book is already in the linked list then throw a
	 * DuplicateBookException and pass in the message title followed 
	 * by a ", " followed by author followed by " already in collection"
	 *
	 * If the category is unknown (i.e. not in the range 0 to 2 inclusive) then
	 * throw a UnknownCategoryException and pass in the message "Unknown Category: " followed by
   * the category number	 
	 */
	public void addBook(Book book, int category)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		//
		// Check to see if category is 0, 1 or 2
		if (category < 0 || category > 2) {
			throw new UnknownCategoryException("Unknown Category: " + category);
		}
		else {
			// Check to see if already in the linked list

			if (bookLists[category].contains(book)) {

				throw new DuplicateBookException(book.getTitle() + ", " + book.getAuthor() + " already in collection");
			}
			else {
				// Add book to the appropriate linked list 
				bookLists[category].add(book);

				// Sort the book list
				Collections.sort(bookLists[category]);
			}

		}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
  /*
   * Print all the linked lists that have at least one book
   * For each Linked List in the array that has at least one book, print (on one line)
   * the category followed by a ": " and then use the toString() method of class LinkedList
   * to print the LinkedList of Book objects   
   */
	public void print()
	{
		//-----------Start below here. To do: approximate lines of code = 9
		//

		for (int i = 0; i < bookLists.length; i++) {

			if (bookLists[i].size() > 0) {
				String booksString = "[";

				for (int j = 0; j < bookLists[i].size(); j++) {
					if (j == bookLists[i].size()-1) {
						booksString += bookLists[i].get(j).toString() + "]";
					}
					else {
						booksString += bookLists[i].get(j).toString() + ", ";

					}
				}

				if (i == 0) {
					System.out.println("Horror: " + booksString);

				}
				else if (i == 1) {
					System.out.println("Drama: " + booksString);

				}
				else if (i == 2) {
					System.out.println("Action: " + booksString);

				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

class UnknownCategoryException extends RuntimeException
{
	public UnknownCategoryException() {}
	public UnknownCategoryException(String msg)
	{
		super(msg);
	}
}

class DuplicateBookException extends RuntimeException
{
	public DuplicateBookException() {}
	public DuplicateBookException(String msg)
	{
		super(msg);
	}
}
