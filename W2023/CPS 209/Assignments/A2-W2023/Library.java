// Eli Preston -- 501152959

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * This class manages, stores, and plays audio content such as songs and audiobooks. 
 */
public class Library
{
	private ArrayList<Song> 		songs; 
	private ArrayList<AudioBook> 	audiobooks;
	private ArrayList<Playlist> 	playlists; 
	
	
	public Library()
	{
		songs 		= new ArrayList<Song>(); 
		audiobooks 	= new ArrayList<AudioBook>();
		playlists   = new ArrayList<Playlist>();
		
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public void download(AudioContent content)
	{
		if (content.getType().equals(Song.TYPENAME)) 
		{
			Song s = (Song) content;
			if (songs.contains(s)) 
			{
				throw new SongAlreadyDownloadedException("SONG " + content.getTitle() + " Already Added to Library");
				
			}
			else if (!songs.contains(s))
			{
				songs.add(s);
				System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");

			}
		} 

		else if (content.getType().equals(AudioBook.TYPENAME)) 
		{
			AudioBook ab = (AudioBook) content;

			if (audiobooks.contains(ab)) 
			{
				throw new AudiobookAlreadyDownloadedException("AUDIOBOOK " + content.getTitle() + " Already Added to Library");
				
			}
			else if (!audiobooks.contains(ab))
			{
				audiobooks.add(ab);
				System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
			}
		} 

	}
	
	// Print Information (printInfo()) about all songs in the array list
	public void listAllSongs()
	{
		for (int i = 0; i < songs.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println();	
		}
	}
	
	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		for (int i = 0; i < audiobooks.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			audiobooks.get(i).printInfo();
			System.out.println();
		}
		
	}
	
	
  	// Print the name of all playlists in the playlists array list
	// First print the index number as in listAllSongs() above
	public void listAllPlaylists()
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			int index = i + 1;
			System.out.print(index + ". " + playlists.get(i).getTitle());
			System.out.println();	
		}
	}
	
  // Print the name of all artists. 
	public void listAllArtists()
	{
		// First create a new (empty) array list of string 
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist array list is complete, print the artists names
	
		ArrayList<String> artists = new ArrayList<>();
		for (int i = 0; i < this.songs.size(); i++)
		{
			if (!artists.contains(songs.get(i).getArtist()))
			{
				artists.add(songs.get(i).getArtist());
			}
		}

		// Print artists names from the arraylist created above
		for (int i = 0; i < artists.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". " + artists.get(i));
			System.out.println();	
		}
		
	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public void deleteSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			throw new SongNotFoundException("Song Not Found");
			
		}
		// Get the song we are trying to delete
		Song songToDel = songs.get(index-1);

		// Loop through playlists, check if it contains the song, if so, delete it from the playlist
		if (playlists.size() > 0) 
		{
			for (int i = 0; i < playlists.size(); i++)
			{
				if (this.playlists.get(i).getContent().contains(songToDel))
				{
					this.playlists.get(i).getContent().remove(songToDel);
				}
				
			}
			songs.remove(index-1);
			
		}
		throw new PlaylistEmpty("Playlist is Empty");
	}
	
  	//Sort songs in library by year
	public void sortSongsByYear()
	{
		// Use Collections.sort()
		Collections.sort(songs, new SongYearComparator()); 
		
	
	}
  	// Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	private class SongYearComparator implements Comparator<Song>
	{
		public int compare(Song s1, Song s2)
		{
			if (s1.getYear() > s2.getYear()) { return 1; } 
			else if (s1.getYear() < s2.getYear()) { return -1; }
			return 0;
		}
	}

	// Sort songs by length
	public void sortSongsByLength()
	{
	 // Use Collections.sort() 
	 Collections.sort(songs, new SongLengthComparator());
	}

  	// Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{
		public int compare(Song s1, Song s2)
		{
			if (s1.getLength() > s2.getLength()) { return 1; } 
			else if (s1.getLength() < s2.getLength()) { return -1; }
			return 0;			
		}
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
		// Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
		Collections.sort(songs);
	}
	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public void playSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			throw new SongNotFoundException("Song Not Found");
			
		}
		songs.get(index-1).play();
	}
	
	
	
	// Play a chapter of an audio book from list of audiobooks
	public void playAudioBook(int index, int chapter)
	{
		if (index < 1 || index > audiobooks.size())
		{
			throw new AudiobookNotFoundException("Audiobook Not Found");
		}
		AudioBook aud = audiobooks.get(index-1);
		
		if (chapter < 1 || chapter > aud.getNumberOfChapters())
		{
			throw new AudiobookChapterNotFoundException("Audiobook Chapter Not Found");
			
		}
		aud.selectChapter(chapter);
		aud.play();
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public void printAudioBookTOC(int index)
	{
		if (index < 1 || index > audiobooks.size())
		{
			throw new AudiobookNotFoundException("Audiobook Not Found");
		}
		
		audiobooks.get(index-1).printTOC();
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public void makePlaylist(String title)
	{
		Playlist np = new Playlist(title);
		if (playlists.contains(np))
		{
			throw new PlaylistAlreadyExists("Playlist with that title already exists");
			
		}
		playlists.add(np);
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public void printPlaylist(String title)
	{
		for (int i = 0; i < playlists.size(); i++)
		{			
			if (playlists.get(i).getTitle().equals(title))
			{
				playlists.get(i).printContents();
			}
		}
		throw new PlaylistNotFoundException("Playlist Not Found");
	}
	
	// Play all content in a playlist
	public void playPlaylist(String playlistTitle)
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				playlists.get(i).playAll();
			}
		}
	}
	
	// Play a specific song/audiobook in a playlist
	public void playPlaylist(String playlistTitle, int indexInPl)
	{
		// Loop through playlists
		for (int i = 0; i < playlists.size(); i++)
		{
			// Check if titles of current playlist and playlist being searched for
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				// Check if valid index of playlist
				if (indexInPl < 1 || indexInPl > playlists.get(i).getContent().size())
				{
					throw new AudioContentNotFoundException("Audio Content Not Found");
				}

				// If valid, play method is executed.
				System.out.println(playlistTitle);
				playlists.get(i).play(indexInPl-1);
			}
		}
		throw new PlaylistNotFoundException("Playlist Not Found");
	}
	
	// Add a song/audiobook from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public void addContentToPlaylist(String type, int index, String playlistTitle)
	{
		int plIndex = -1;
	
		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(playlistTitle))
				{
					plIndex = i;
					break;
				}
		}
		
		// check if index is invalid, ie. the playlist title was not found in the arraylist playlists
		if (plIndex == -1)
		{
			throw new PlaylistNotFoundException("Playlist Not Found");
		}

		
		if (type.equalsIgnoreCase("SONG")) {
			if (index < 1 || index > songs.size())
			{
				throw new SongNotFoundException("Song not found");
			}

			Song s = songs.get(index-1);
			playlists.get(plIndex).addContent(s);
		}

		if (type.equalsIgnoreCase("AUDIOBOOK"))
		{
			if (index < 1 || index > audiobooks.size())
			{
				throw new AudiobookNotFoundException("Audiobook Not Found");
			}

			AudioBook au = audiobooks.get(index-1);
			playlists.get(plIndex).addContent(au);
		}

		throw new AudioContentTypeNotFoundException("Audio Content Type Not Found");
	}

	
  // Delete a song/audiobook from a playlist with the given title
	// Make sure the given index of the song/audiobook in the playlist is valid 
	public void delContentFromPlaylist(int index, String title)
	{

		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(title))
			{
				if (playlists.get(i).contains(index))
				{
					playlists.get(i).deleteContent(index);
				}
				throw new AudioContentNotFoundException("Content Not Found");
			}
		}
		throw new PlaylistNotFoundException("Playlist Not Found");
		
	}

}




class SongAlreadyDownloadedException extends RuntimeException 
{
	public SongAlreadyDownloadedException() {}

	public SongAlreadyDownloadedException(String msg) 
	{
		super(msg);
	}
}

class SongNotFoundException extends RuntimeException 
{
	public SongNotFoundException() {}

	public SongNotFoundException(String msg) 
	{
		super(msg);
	}
}

class AudiobookAlreadyDownloadedException extends RuntimeException 
{
	public AudiobookAlreadyDownloadedException() {}

	public AudiobookAlreadyDownloadedException(String msg) 
	{
		super(msg);
	}
}

class AudiobookNotFoundException extends RuntimeException 
{
	public AudiobookNotFoundException() {}

	public AudiobookNotFoundException(String msg) 
	{
		super(msg);
	}
}

class AudiobookChapterNotFoundException extends RuntimeException
{
	public AudiobookChapterNotFoundException() {}

	public AudiobookChapterNotFoundException(String msg)
	{
		super(msg);
	}
}

class AudioContentNotFoundException extends RuntimeException 
{
	public AudioContentNotFoundException() {}

	public AudioContentNotFoundException(String msg) 
	{
		super(msg);
	}
}

class AudioContentTypeNotFoundException extends RuntimeException
{
	public AudioContentTypeNotFoundException() {}

	public AudioContentTypeNotFoundException(String msg)
	{
		super(msg);
	}
}

class PlaylistAlreadyExists extends RuntimeException 
{
	public PlaylistAlreadyExists() {}

	public PlaylistAlreadyExists(String msg) 
	{
		super(msg);
	}
}

class PlaylistNotFoundException extends RuntimeException 
{
	public PlaylistNotFoundException() {}

	public PlaylistNotFoundException(String msg) 
	{
		super(msg);
	}
}

class PlaylistEmpty extends RuntimeException
{
	public PlaylistEmpty() {}

	public PlaylistEmpty(String msg)
	{
		super(msg);
	}
}
