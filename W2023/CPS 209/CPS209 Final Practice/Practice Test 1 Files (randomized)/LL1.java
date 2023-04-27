public class LL1
{
	public static void main(String[] args)
	{
		BookCollection collection = new BookCollection();
		String[] titles = {"VR Rocks","VR Rocks", "Research for Dummies", "Book of Exceptions", "The Interweb", "Wizard 8.0", "SuperCryto"};
		String[] authors = {"Tim", "Tim", "Rick", "Java Expert", "Cherie", "Eric", "Isaac"};
		int[] category = {BookCollection.ACTION, BookCollection.ACTION, BookCollection.DRAMA, 5, 
				              BookCollection.HORROR, BookCollection.HORROR, BookCollection.ACTION};
		int[] published = {2016, 2016, 2001, 2015, 2021, 1945, 1995};


		//-----------Start below here. To do: approximate lines of code = 8
		// Create Book objects using the titles, authors, category and published arrays above.
		// Add each Book object to the BookCollection called collection above. 
		// Make sure you catch exceptions that could be thrown - see class BookCollection for possible exceptions
		// If an exception is thrown, print the message in the Exception object and continue to add the next book
		

		for (int i = 0; i < titles.length; i++) {
			Book newBook = new Book(titles[i], authors[i], published[i]);
			
			try {
				collection.addBook(newBook, category[i]);
			}
			catch(UnknownCategoryException e) {
				System.out.println(e.getMessage());
			}
			catch(DuplicateBookException e) {
				System.out.println(e.getMessage());
			}

		}
	
	
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

		// Prints the linked lists
		collection.print();

		System.out.println("\nExpected:\n" + "VR Rocks, Tim already in collection\n"
				+ "Unknown Category: 5\n\n" 
				+ "Horror: [[Wizard 8.0, Eric, 1945], [The Interweb, Cherie, 2021]]\n"
				+ "Drama : [[Research for Dummies, Rick, 2001]]\n"
				+ "Action: [[SuperCryto, Isaac, 1995], [VR Rocks, Tim, 2016]]");
	}
}
