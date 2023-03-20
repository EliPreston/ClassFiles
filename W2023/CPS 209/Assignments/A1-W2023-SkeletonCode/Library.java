import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * This class manages, stores, and plays audio content such as songs, podcasts and audiobooks. 
 */
public class Library
{
	private ArrayList<Song> 		songs; 
	private ArrayList<AudioBook> 	audiobooks;
	private ArrayList<Playlist> 	playlists; 
  	private ArrayList<Podcast> 		podcasts;
	
	// Public methods in this class set errorMesg string 
	// Error Messages can be retrieved from main in class MyAudioUI by calling  getErrorMessage()
	// In assignment 2 we will replace this with Java Exceptions
	String errorMsg = "";
	
	public String getErrorMessage()
	{
		return errorMsg;
	}

	public Library()
	{
		songs 		= new ArrayList<Song>(); 
		audiobooks 	= new ArrayList<AudioBook>(); ;
		playlists   = new ArrayList<Playlist>();
	  	podcasts	= new ArrayList<Podcast>(); ;
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs, podcasts and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/podcast/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public boolean download(AudioContent content)
	{
		if (content.getType().equals(Song.TYPENAME)) 
		{
			Song s = (Song) content;
			if (songs.contains(s)) 
			{
				errorMsg = "Song already downloaded.";
				return false;
			}
			else if (!songs.contains(s))
			{
				songs.add(s);
				return true;
			}
			return false;

		} 
		else if (content.getType().equals(AudioBook.TYPENAME)) 
		{
			AudioBook ab = (AudioBook) content;

			if (audiobooks.contains(ab)) 
			{
				errorMsg = "Audiobook already downloaded.";
				return false;
			}
			else if (!audiobooks.contains(ab))
			{
				audiobooks.add(ab);
				return true;
			}
			return false;
			
		} 

		else if (content.getType().equals(Podcast.TYPENAME)) 
		{
			Podcast p = (Podcast) content;
			if (podcasts.contains(p)) 
			{
				errorMsg = "Podcast already downloaded.";
				return false;
			}
			else if (!podcasts.contains(p))
			{
				podcasts.add(p);
				return true;
			}
			return false;

		}
		return false;
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
	
  // Print Information (printInfo()) about all podcasts in the array list
	public void listAllPodcasts()
	{
		for (int i = 0; i < podcasts.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			podcasts.get(i).printInfo();
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

		for (int i = 0; i < artists.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". " + artists.get(i));
			System.out.println();	
		}
		
	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public boolean deleteSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		Song songToDel = songs.get(index-1);
		songs.remove(index-1);

		if (playlists.size() > 0) 
		{
			for (int i = 0; i < playlists.size(); i++)
			{
				if (playlists.get(i).getContent().contains(songToDel))
				{
					playlists.get(i).getContent().remove(songToDel);
				}
			}
			return true;
		}
		errorMsg = "Playlist Empty";
		return false;
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
			if (s1.getYear() > s2.getYear())
			{
				return 1;
			} else if (s1.getYear() < s2.getYear())
			{
				return -1;
			}
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
			if (s1.getLength() > s2.getLength())
			{
				return 1;
			} else if (s1.getLength() < s2.getLength())
			{
				return -1;
			}
			return 0;			
		}
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
		// Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
		Collections.sort(songs, new SongTitleComparator());
	}

	private class SongTitleComparator implements Comparator<Song>
	{
		public int compare(Song s1, Song s2)
		{
			return s1.compareTo(s2);
		}
	}

	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public boolean playSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		songs.get(index-1).play();
		return true;
	}
	
	// Play podcast from list (specify season and episode)
	// Bonus
	public boolean playPodcast(int index, int season, int episode)
	{
		if (index < 1 || index > podcasts.size())
		{
			errorMsg = "Podcast Not Found";
			return false;
		}
		Podcast currPod = podcasts.get(index-1);
		if (season < 1 || season > currPod.getNumSeasons())
		{
			errorMsg = "Podcast Season Not Found";
			return false;
		}
		Season currSeason = currPod.getSeasons().get(season-1);
		if (episode < 1 || episode > currSeason.getEpisodeTitles().size())
		{
			errorMsg = "Podcast Episode Not Found";
			return false;
		}
		podcasts.get(index-1).play(season, episode);
		return true;
	}
	
	// Print the episode titles of a specified season
	// Bonus 
	public boolean printPodcastEpisodes(int index, int season)
	{
		
		if (index < 1 || index > podcasts.size())
		{
			errorMsg = "Podcast Not Found";
			return false;
		}
		
		Podcast currPod = podcasts.get(index-1);
		if (season < 1 || season > currPod.getNumSeasons())
		{
			errorMsg = "Podcast Season Not Found";
			return false;
		}
		currPod.getSeasons().get(season-1).printTOC();
		return true;
	}
	
	// Play a chapter of an audio book from list of audiobooks
	public boolean playAudioBook(int index, int chapter)
	{
		if (index < 1 || index > audiobooks.size())
		{
			errorMsg = "Audiobook Not Found";
			return false;
		}
		AudioBook aud = audiobooks.get(index-1);
		
		if (chapter < 1 || chapter > aud.getNumberOfChapters())
		{
			errorMsg = "Audiobook Chapter Not Found";
			return false;
		}
		
		aud.selectChapter(chapter);
		aud.play();
		return true;
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public boolean printAudioBookTOC(int index)
	{
		if (index < 1 || index > audiobooks.size())
		{
			errorMsg = "Audiobook Not Found";
			return false;
		}
		
		audiobooks.get(index-1).printTOC();
		return true;
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public boolean makePlaylist(String title)
	{
		Playlist np = new Playlist(title);
		if (playlists.contains(np))
		{
			errorMsg = "Playlist with that title already exists.";
			return false;
		}
		playlists.add(np);
		return true;
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public boolean printPlaylist(String title)
	{
		for (int i = 0; i < playlists.size(); i++)
		{			
			if (playlists.get(i).getTitle().equals(title))
			{
				playlists.get(i).printContents();
				return true;
			}
		}
		errorMsg = "Playlist Not Found";
		return false;
	}
	
	// Play all content in a playlist
	public boolean playPlaylist(String playlistTitle)
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				playlists.get(i).playAll();
				return true;
			}
		}

		return false;
	}
	
	// Play a specific song/audiobook in a playlist
	public boolean playPlaylist(String playlistTitle, int indexInPl)
	{

		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				if (indexInPl < 1 || indexInPl > playlists.size() )
				{
					errorMsg = "Audio Content Not Found";
					return false;
				}
				System.out.println(playlistTitle);
				playlists.get(i).play(indexInPl-1);
				return true;
			}
		}
		errorMsg = "Playlist Not Found";
		return false;	
	}
	
	// Add a song/audiobook/podcast from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public boolean addContentToPlaylist(String type, int index, String playlistTitle)
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
		if (plIndex == -1)
		{
			errorMsg = "Playlist Not Found";
			return false;
		}

		
		if (type.equalsIgnoreCase("SONG")) {
			if (index < 1 || index > songs.size())
			{
				errorMsg = "Song Not Found";
				return false;
			}

			Song s = songs.get(index-1);
			playlists.get(plIndex).addContent(s);
			return true;
		}

		if (type.equalsIgnoreCase("AUDIOBOOK"))
		{
			if (index < 1 || index > audiobooks.size())
			{
				errorMsg = "Audiobook Not Found";
				return false;
			}

			AudioBook au = audiobooks.get(index-1);
			playlists.get(plIndex).addContent(au);
			return true;
		}

		if (type.equalsIgnoreCase("PODCAST"))
		{
			if (index < 1 || index > podcasts.size())
			{
				errorMsg = "Podcast Not Found";
				return false;
			}

			Podcast pod = podcasts.get(index-1);
			playlists.get(plIndex).addContent(pod);
			return true;
		}

		errorMsg = "Audio Content Type Not Found";
		return false;

	}

	
  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid 
	public boolean delContentFromPlaylist(int index, String title)
	{

		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(title))
			{
				if (playlists.get(i).contains(index))
				{
					playlists.get(i).deleteContent(index);
					return true;
				}
				errorMsg = "Content Not Found";
				return false;
			}
		}
		errorMsg = "Playlist Not Found";
		return false;
		
	}

	public int numSongs()
	{
		return songs.size();
	}
	public int numAudbks()
	{
		return audiobooks.size();
	}
	public int numPods()
	{
		return podcasts.size();
	}
	
}


