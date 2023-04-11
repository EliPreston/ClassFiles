// Eli Preston -- 501152959

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Simulation of audio content in an online store
// The songs, podcasts, audiobooks listed here can be "downloaded" to your library

public class AudioContentStore
{
		private ArrayList<AudioContent> contents; 
		private Map<String, Integer> titleIndex = new HashMap<String, Integer>(); 
		private Map<String, ArrayList<Integer>> artistAuthorIndexes = new HashMap<String, ArrayList<Integer>>(); 
		private Map<String, ArrayList<Integer>> genreIndexes = new HashMap<String, ArrayList<Integer>>(); 
		
		public AudioContentStore()
		{

			try {
				contents = readStoreFile();	

				for (int i = 0; i < contents.size(); i++) {

					AudioContent current = contents.get(i);
					titleIndex.put(current.getTitle(), i);
					
					if (current.getType().equals(Song.TYPENAME)) {

						Song currSong = (Song) current;
						
						String genreS = currSong.getGenre().toString();

						if (genreIndexes.containsKey(genreS)) {
							ArrayList<Integer> indexes = genreIndexes.get(genreS);
							indexes.add(i);
							genreIndexes.put(genreS, indexes);
						}
						else {
							ArrayList<Integer> indexes = new ArrayList<Integer>();
							indexes.add(i);
							genreIndexes.put(genreS, indexes);
						}

						if (artistAuthorIndexes.containsKey(currSong.getArtist())) {
							ArrayList<Integer> indexes = artistAuthorIndexes.get(currSong.getArtist());
							indexes.add(i);
							artistAuthorIndexes.put(currSong.getArtist(), indexes);
						}
						else {
							ArrayList<Integer> indexes = new ArrayList<Integer>();
							indexes.add(i);
							artistAuthorIndexes.put(currSong.getArtist(), indexes);
						}
					}

					if (current.getType().equals(AudioBook.TYPENAME)) {
						AudioBook currAudio = (AudioBook) current;

						if (artistAuthorIndexes.containsKey(currAudio.getAuthor())) {
							ArrayList<Integer> indexes = artistAuthorIndexes.get(currAudio.getAuthor());
							indexes.add(i);
							artistAuthorIndexes.put(currAudio.getAuthor(), indexes);
						}
						else {
							ArrayList<Integer> indexes = new ArrayList<Integer>();
							indexes.add(i);
							artistAuthorIndexes.put(currAudio.getAuthor(), indexes);
						}
					}

				}
	
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}

		private ArrayList<AudioContent> readStoreFile() throws FileNotFoundException
		{
			ArrayList<AudioContent> contentFromStore = new ArrayList<AudioContent>();

			File storeFile = new File("W2023/CPS 209/Assignments/A2-W2023/store.txt");
			Scanner storeScanner = new Scanner(storeFile);
		

			while (storeScanner.hasNextLine()) {

				String type = storeScanner.nextLine();
				System.out.println("Loading " + type);


				if (type.equals(Song.TYPENAME))
				{
					String id = storeScanner.nextLine();
					String title = storeScanner.nextLine();

					int year = Integer.parseInt(storeScanner.nextLine());
					int length = Integer.parseInt(storeScanner.nextLine());

					String artist = storeScanner.nextLine();
					String composer = storeScanner.nextLine();

					String genreStr = storeScanner.nextLine();
					Song.Genre genre = toGenre(genreStr);

					int lyricLinesNum = Integer.parseInt(storeScanner.nextLine());
					String lyrics = "";
					for (int i = 0; i < lyricLinesNum; i++) {
						String currentLyricLine = storeScanner.nextLine();
						lyrics += currentLyricLine + "\r\n";
					}

					contentFromStore.add(new Song(title, year, id, type, lyrics, length, artist, composer, genre, lyrics));

				}

				if (type.equals(AudioBook.TYPENAME))
				{
					String id = storeScanner.nextLine();
					String title = storeScanner.nextLine();
					int year = Integer.parseInt(storeScanner.nextLine());
					int length = Integer.parseInt(storeScanner.nextLine());
					String author = storeScanner.nextLine();
					String narrator = storeScanner.nextLine();
					int chapsNum = Integer.parseInt(storeScanner.nextLine());

					ArrayList<String> chapterTitles = new ArrayList<String>();
					ArrayList<String> chapters = new ArrayList<String>();

					for (int i = 0; i < chapsNum; i++) {
						chapterTitles.add(storeScanner.nextLine());
					}

					for (int i = 0; i < chapsNum; i++) {

						int chapLines = Integer.parseInt(storeScanner.nextLine());
						String currChapter = "";

						for (int j = 0; j < chapLines; j++) {
							currChapter += storeScanner.nextLine() + "\r\n";
						}
						chapters.add(currChapter);
					}

					contentFromStore.add(new AudioBook(title, year, id, type, "", length, author, narrator, chapterTitles, chapters));
					
				}
				
			}
			System.out.println();
			return contentFromStore;
		}

		// Convert genre string from file to Song.Genre so it can be used in the song constructor
		private Song.Genre toGenre(String genre)
		{
			if (genre.equalsIgnoreCase("POP")) 		{return Song.Genre.POP; }
			if (genre.equalsIgnoreCase("ROCK")) 		{return Song.Genre.ROCK; }
			if (genre.equalsIgnoreCase("JAZZ")) 		{return Song.Genre.JAZZ; }
			if (genre.equalsIgnoreCase("HIPHOP")) 	{return Song.Genre.HIPHOP; }
			if (genre.equalsIgnoreCase("RAP")) 		{return Song.Genre.RAP; }
			if (genre.equalsIgnoreCase("CLASSICAL")) 	{return Song.Genre.CLASSICAL; }
			return null;
		}

		
		public Map<String, ArrayList<Integer>> getArtistsAuthors() 
		{
			return artistAuthorIndexes;
		}

		public Map<String, ArrayList<Integer>> getGenres() 
		{
			return genreIndexes;
		}	
		
		public AudioContent getContent(int index)
		{
			if (index < 1 || index > contents.size())
			{
				return null;
			}
			return contents.get(index-1);
		}
		
		public void listAll()
		{
			for (int i = 0; i < contents.size(); i++)
			{
				int index = i + 1;
				System.out.print("" + index + ". ");
				contents.get(i).printInfo();
				System.out.println();
			}
		}

		public void search(String title) 
		{
			int indexInStore = titleIndex.get(title);
			System.out.print((indexInStore + 1) + ". ");
			contents.get(indexInStore).printInfo();
			System.out.println();

		}

		public void searchA(String artistOrAuthor) 
		{

			ArrayList<Integer> indexesInStore = artistAuthorIndexes.get(artistOrAuthor);
			for (int i = 0; i < indexesInStore.size(); i++) {
				int indexInStore = indexesInStore.get(i);
				System.out.print((indexInStore + 1) + ". ");
				contents.get(indexInStore).printInfo();
				System.out.println();
			}

		}

		public void searchG(String genre) 
		{
			ArrayList<Integer> indexesInStore = genreIndexes.get(genre);
			for (int i = 0; i < indexesInStore.size(); i ++) {
				int indexInStore = indexesInStore.get(i);
				System.out.print((indexInStore + 1) + ". ");
				contents.get(indexInStore).printInfo();
				System.out.println();
			}

		}
		
		public void searchP(String forThisString)
		{

			int countCheck = 0;
			for (int i = 0; i < contents.size(); i++)
			{
				try {
					if (checkContent(contents.get(i), forThisString) == true) {
						countCheck ++;
						contents.get(i).printInfo();
						System.out.println();
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (countCheck == 0) {System.out.println("No matches");}

		}
		
		private boolean checkContent(AudioContent content, String substr)
		{
			substr = substr.toLowerCase();
			if (content.getType().equals(Song.TYPENAME))
			{
				Song s = (Song) content;
				if (s.getTitle().toLowerCase().contains(substr)) {return true;}
				if (s.getArtist().toLowerCase().contains(substr)) {return true;}
				if (s.getAudioFile().toLowerCase().contains(substr)) {return true;}
				if (s.getLyrics().toLowerCase().contains(substr)) {return true;}
				if (s.getComposer().toLowerCase().contains(substr)) {return true;}
				
				return false;
			}

			if (content.getType().equals(AudioBook.TYPENAME))
			{
				AudioBook a = (AudioBook) content;
				if (a.getTitle().toLowerCase().contains(substr)) {return true;}
				if (a.getAuthor().toLowerCase().contains(substr)) {return true;}

				for (int i = 0; i < a.getChapterTitles().size(); i++) {
					if (a.getChapterTitles().get(i).toLowerCase().contains(substr)) {return true;}
					if (a.getChapters().get(i).toLowerCase().contains(substr)) {return true;}
				}

				return false;				
			}
			return false;
			
		}
}
