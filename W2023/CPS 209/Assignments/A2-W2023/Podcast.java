// Eli Preston -- 501152959

// Podcast: Design a class which is also a subclass of 
// AudioContent that contains extra information. 

// A podcast is essentially a talk radio series on demand. Podcasts 
// tend to be focused on a theme or topic. 
// Podcasts should have 
//      a host (String) as well as 
//      a list of Seasons. 
//      Each Season should consist of 
            // a list of episodes (strings representing the "audiofiles") 
            // a list of episode titles (strings) 
            // a list of episode lengths (in minutes). 
// See the video of an example of podcast content. 

/*
 * A Podcast is a type of AudioContent. A podcast has extra fields such as host (person(s) hosting the podasct)
 * and seasons with a number of episodes. 
 */

import java.util.ArrayList;

public class Podcast extends AudioContent 
{
    public static final String TYPENAME = "PODCAST";

    private String host;                    // Can be multiple names seperated by commas
    private ArrayList<Season> seasons;

    // Initialize podcast object with superclass, and then initializes host and seasons attributes
    public Podcast(String title, int year, String id, String type, String audioFile, int length,
                    String host, ArrayList<Season> seasons)
    {
        super(title, year, id, type, audioFile, length);

        this.host = host;
        setSeasons(seasons);
        this.seasons = getSeasons();

    }

    // Check if 2 podcast objects are equal, makes use of superclass
    public boolean podEquals(Object other)
    {
        Podcast pod2 = (Podcast) other;
        if (super.equals(other) && this.getTitle().equals(pod2.getTitle()) && this.getHost().equals(pod2.getHost()))
        {
            return true;
        }
        return false;

    }

    // Prints info about podcast, uses superclass printInfo
    public void printInfo()
	{
		super.printInfo();
		System.out.println("Host: " + host + "\nSeasons: " + seasons.size());
	}

    // To play a podcast with no given season or episode, the audiofile and title are set to the first episode
    // from the first season, then the superclass play() method is called.
    public void play()
    {
        String epFile = this.getSeasons().get(0).getEpisodeFiles().get(0);
        String epTitle = this.getSeasons().get(0).getEpisodeTitles().get(0);
        
        setAudioFile(epTitle + epFile);
        super.play();

    }

    // To play a podcast given a specified season and episode sets the audiofile to the given episode 
    // from the given season before calling the superclass play() method.
    public void play(int season, int episode)
    {
        setAudioFile(this.getSeasons().get(season-1).getEpisodeTitles().get(episode-1) + "\n" + this.getSeasons().get(season-1).getEpisodeFiles().get(episode-1));
        super.play();

        // setAudioFile(seasons.);
    }

    // Accessor and mutator methods for podcast attributes
    public String getType()
	{
		return TYPENAME;
	}

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getHost()
    {
        return host;
    }

    public void setSeasons(ArrayList<Season> seasons)
    {
        this.seasons = seasons;
    }

    public ArrayList<Season> getSeasons()
    {
        return seasons;
    }

    public int getNumSeasons()
    {
        return seasons.size();
    }
    
}
