// Eli Preston -- 501152959


import java.util.Scanner;
import java.util.ArrayList;

// Simulation of a Simple Text-based Music App (like Apple Music)

public class MyAudioUI
{
	public static void main(String[] args)
	{
		// Simulation of audio content in an online store
		// The songs, podcasts, audiobooks in the store can be downloaded to your mylibrary
		AudioContentStore store = new AudioContentStore();
		
		// Create my music mylibrary
		Library mylibrary = new Library();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			else if (action.equalsIgnoreCase("STORE"))	// List all songs
			{
				store.listAll(); 
			}
			else if (action.equalsIgnoreCase("SONGS"))	// List all songs
			{
				mylibrary.listAllSongs(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all songs
			{
				mylibrary.listAllAudioBooks(); 
			}
			else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
			{
				mylibrary.listAllArtists(); 
			}
			else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
			{
				mylibrary.listAllPlaylists(); 
			}
			// Get the *library* index (index of a song based on the songs list)
			// of a song from the keyboard and play the song 
			else if (action.equalsIgnoreCase("PLAYSONG")) 
			{
				int index = 0;
				System.out.print("Song Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}

				// Check if the song encounterd an error
				boolean played = mylibrary.playSong(index);
				if (!played)
				{
					System.out.println(mylibrary.getErrorMessage());
				}

				// Print error message if the song doesn't exist in the library
			}
			// Print the table of contents (TOC) of an audiobook that
			// has been downloaded to the library. Get the desired book index
			// from the keyboard - the index is based on the list of books in the library
			else if (action.equalsIgnoreCase("BOOKTOC")) 
			{
				int index = 0;
				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}
				
				// Check for error(s)
				boolean listed = mylibrary.printAudioBookTOC(index);
				if (!listed)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			// Print error message if the book doesn't exist in the library
			}
			// Similar to playsong above except for audio book
			// In addition to the book index, read the chapter 
			// number from the keyboard - see class Library
			else if (action.equalsIgnoreCase("PLAYBOOK")) 
			{
				int index = 0;
				int chapter = 0;

				// Check twice for keyboard input (ie. 2 scanner.next lines)
				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Chapter: ");
					if (scanner.hasNextInt())
					{
						chapter = scanner.nextInt();
						scanner.nextLine();
					}
				}

				// Check for error(s)
				boolean played = mylibrary.playAudioBook(index, chapter);
				if (!played)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			}
			// Specify a playlist title (string) 
			// Play all the audio content (songs, audiobooks, podcasts) of the playlist 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYALLPL")) 
			{
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();
				}

				// Check for error(s)
				boolean playedPlaylist = mylibrary.playPlaylist(title);
				if (!playedPlaylist)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			}
			// Specify a playlist title (string) 
			// Read the index of a song/audiobook/podcast in the playist from the keyboard 
			// Play all the audio content 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPL")) 
			{
				int index = 0;
				String title = "";
				
				System.out.print("Playlist Title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();

					System.out.print("Content Number: "); 
					if (scanner.hasNextInt())
					{
						index = scanner.nextInt();
						scanner.nextLine();
					}
				}

				// Check for error(s)
				boolean playedFromPl = mylibrary.playPlaylist(title, index);
				if (!playedFromPl)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			}
			// Delete a song from the list of songs in mylibrary and any play lists it belongs to
			// Read a song index from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELSONG")) 
			{
				int index = 0;
				System.out.print("Library Song #: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}

				// Check for error(s)
				boolean deletedLibrary = mylibrary.deleteSong(index);
				if (!deletedLibrary)
				{
					System.out.println(mylibrary.getErrorMessage());
				}

					
			}
			// Read a title string from the keyboard and make a playlist
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("MAKEPL")) 
			{
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();
				}

				// Check for error(s)
				boolean validPL = mylibrary.makePlaylist(title);
				if (!validPL)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
				
			}
			// Print the content information (songs, audiobooks, podcasts) in the playlist
			// Read a playlist title string from the keyboard
		  	// see class Library for the method to call
			else if (action.equalsIgnoreCase("PRINTPL"))	// print playlist content
			{
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();
				}

				// Check for error(s)
				boolean validPL = mylibrary.printPlaylist(title);
				if (!validPL)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
				
			}
			// Add content (song, audiobook, podcast) from mylibrary (via index) to a playlist
			// Read the playlist title, the type of content ("song" "audiobook" "podcast")
			// and the index of the content (based on song list, audiobook list etc) from the keyboard
		  	// see class Library for the method to call
			else if (action.equalsIgnoreCase("ADDTOPL")) 
			{
				String title = "";
				String contentType = "";
				int libraryContentNum = 0;

				System.out.print("Playlist Title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();

					System.out.print("Content Type [SONG, PODCAST, AUDIOBOOK]: ");
					if (scanner.hasNext())
					{
						contentType = scanner.nextLine();

						System.out.print("Library Content: ");
						if (scanner.hasNextInt())
						{
							libraryContentNum = scanner.nextInt();
							scanner.nextLine();
						}
					}
				}

				// Check for error(s)
				boolean added = mylibrary.addContentToPlaylist(contentType, libraryContentNum, title);
				if (!added)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			}
			// Delete content from play list based on index from the playlist
			// Read the playlist title string and the playlist index
		 	// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELFROMPL")) 
			{
				int index = 0;
				String title = "";

				System.out.print("Playlist title: ");
				if (scanner.hasNext())
				{
					title = scanner.nextLine();

					System.out.print("Content Number: "); 
					if (scanner.hasNextInt())
					{
						index = scanner.nextInt();
						scanner.nextLine();
					}
				}

				// Check for error(s)
				boolean delFromPl = mylibrary.delContentFromPlaylist(index, title);
				if (!delFromPl)
				{
					System.out.println(mylibrary.getErrorMessage());
				}
			}
			// Sorting actions
			else if (action.equalsIgnoreCase("SORTBYYEAR")) // sort songs by year
			{
				mylibrary.sortSongsByYear();
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort songs by name (alphabetic)
			{
				mylibrary.sortSongsByName();
			}
			else if (action.equalsIgnoreCase("SORTBYLENGTH")) // sort songs by length
			{
				mylibrary.sortSongsByLength();
			}


			// *************************************************************************
			// *************************************************************************
			// *************************************************************************
			// New feautres
			// *************************************************************************
			// *************************************************************************
			// *************************************************************************
			else if (action.equalsIgnoreCase("SEARCH")) 
			{
				System.out.print("Title: ");
				String title = "";
				if (scanner.hasNext())
				{
					title = scanner.nextLine();
				}
				store.search(title);
				

			}
			else if (action.equalsIgnoreCase("SEARCHA")) 
			{
				System.out.print("Artist: ");
				String artist = "";
				if (scanner.hasNext())
				{
					artist = scanner.nextLine();
				}
				store.searchA(artist);
				
			}
			else if (action.equalsIgnoreCase("SEARCHG")) 
			{
				System.out.print("Genre: ");
				String genre = "";
				if (scanner.hasNext())
				{
					genre = scanner.nextLine();
				}
				store.searchG(genre);
				
			}
			else if (action.equalsIgnoreCase("DOWNLOAD")) 
			{

				// *************************************************************************
				// Modify the download action so that it takes two store indices instead of 
				// one store index as parameters – i.e. a fromIndex and a toIndex. That is, you 
				// should now be able to download a range of songs/books etc. from the store (e.g. 
				// from song 2 to song 6, inclusive). If some of the songs are already in the library,
				//  then and error message for each of these songs should be printed (see the video)
				// *************************************************************************

				int from = 0;
				int to = 0;
				
				System.out.print("From Store Content #: ");
				if (scanner.hasNextInt())
				{
					from = scanner.nextInt();
					scanner.nextLine(); // "consume" nl character (necessary when mixing nextLine() and nextInt())

					System.out.print("To Store Content #: ");
					if (scanner.hasNextInt())
					{
						to = scanner.nextInt();
						scanner.nextLine(); // "consume" nl character (necessary when mixing nextLine() and nextInt())
					}
				}

				for (int i = from; i < to+1; i++) {
					AudioContent content = store.getContent(i);
					mylibrary.download(content);
					System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
				}
				
			}
			else if (action.equalsIgnoreCase("DOWNLOADA")) 
			{
				System.out.print("Artist Name: ");
				String artist = "";
				if (scanner.hasNext())
				{
					artist = scanner.nextLine();
				}

				ArrayList<Integer> aIndexes = store.getArtistsAuthors().get(artist);
				for (int i = 0; i < aIndexes.size(); i++) {
					AudioContent content = store.getContent(aIndexes.get(i));
					// try {
						mylibrary.download(content);
						System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
					// } 
					// catch(Exception e) {
						// System.out.println(content.getType() + " " + content.getTitle() + " already downloaded");
					// }
				}


			}
			else if (action.equalsIgnoreCase("DOWNLOADG")) 
			{
				System.out.print("Genre: ");
				String genre = "";
				if (scanner.hasNext())
				{
					genre = scanner.nextLine().toUpperCase();
				}

				ArrayList<Integer> gIndexes = store.getGenres().get(genre);
				for (int i = 0; i < gIndexes.size(); i++) {
					
					AudioContent content = store.getContent(gIndexes.get(i));
					
					// try {
						mylibrary.download(content);
						System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
					// } 
					// catch(Exception e) {
						// System.out.println(content.getType() + " " + content.getTitle() + " already downloaded");
					// }
				
				}
			}

			System.out.print("\n>");
		}
	}
}
