// Each Season should consist of 
    // a list of episodes (strings representing the "audiofiles") 
    // a list of episode titles (strings) 
    // a list of episode lengths (in minutes). 


import java.util.ArrayList;

public class Season {

    private ArrayList<String> episodeTitles;
    private ArrayList<String> episodeFiles;
    private ArrayList<Integer> episodeLengths;

    public Season()
    {
        this.episodeTitles = new ArrayList<String>();
        this.episodeFiles = new ArrayList<String>();
        this.episodeLengths = new ArrayList<Integer>();
    }

    // Create Season object and initialize with an arraylists of episode titles, episode audio files, and episode lengths
    public Season(ArrayList<String> episodeTitles, ArrayList<String> episodeFiles, ArrayList<Integer> episodeLengths)
    {
        setEpisodeTitles(episodeTitles);
        setEpisodeFiles(episodeFiles);
        setEpisodeLengths(episodeLengths);

        this.episodeFiles = getEpisodeFiles();
        this.episodeTitles = getEpisodeTitles();
        this.episodeLengths = getEpisodeLengths();
    }

    // Next six methods are simple getter/setter methods for a Season object
    public ArrayList<String> getEpisodeFiles()
    {
        return episodeFiles;
    }

    public void setEpisodeFiles(ArrayList<String> episodeFiles)
    {
        this.episodeFiles = episodeFiles;
    }

    public ArrayList<String> getEpisodeTitles()
    {
        return episodeTitles;
    }

    public void setEpisodeTitles(ArrayList<String> episodeTitles)
    {
        this.episodeTitles = episodeTitles;
    }

    public ArrayList<Integer> getEpisodeLengths()
    {
        return episodeLengths;
    }

    public void setEpisodeLengths(ArrayList<Integer> episodeLengths)
    {
        this.episodeLengths = episodeLengths;
    }    
    
    // Add episode title (string) to episodeTitles arraylist
    public void addEpisodeTitle(String episodeTitle)
    {
        episodeTitles.add(episodeTitle);
    }

    // Add episode audio file (string) to episodeFiles arraylist
    public void addEpisodeFile(String episodeFile)
    {
        episodeFiles.add(episodeFile);
    }

    // Add episode length (int) to episodeLengths arraylist
    public void addEpisodeLength(int episodeLength)
    {
        episodeLengths.add(episodeLength);
    }

    // Print table of contents (episodes) for a podcast season.
    public void printTOC()
    {
        for (int i = 0; i < episodeTitles.size(); i++)
        {
            int epNum = i+1;
            System.out.println("Episode " + epNum + ". " + episodeTitles.get(i));
			
			// if (i == episodeTitles.size()-1) { break;}
			System.out.println("");
        }
    }
    
}
