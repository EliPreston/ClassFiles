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

// Provide the ability to 
//      play a specific episode of a season. 

// You may want to create a class Season to hold the episode information 
// for a season. 

// Add code to MyAudioUI.java for actions PODCASTS, PLAYPOD.
// Add methods to class Library

import java.util.ArrayList;

public class Podcast extends AudioContent 
{
    public static final String TYPENAME = "PODCAST";

    private String host;
    private ArrayList<Season> seasons;

    public Podcast(String title, int year, String id, String type, String audioFile, int length,
                    String host, ArrayList<Season> seasons)
    {
        super(title, year, id, type, audioFile, length);

        this.host = host;
        setSeasons(seasons);
        this.seasons = getSeasons();

    }

    public String getType()
	{
		return TYPENAME;
	}

    public boolean podEquals(Object other)
    {
        Podcast pod2 = (Podcast) other;
        boolean tt = this.getTitle().equals(pod2.getTitle());
		boolean yr = this.getYear() == pod2.getYear();
		boolean id = this.getId().equals(pod2.getId());
		boolean tp = this.getType().equals(pod2.getType());
        boolean le = this.getLength() == pod2.getLength();
        boolean ho = this.getHost().equals(pod2.getHost());

        if (tt && yr && id && tp && le && ho) { return true; }
        return false;
    }

    public void printInfo()
	{
		super.printInfo();
		System.out.println("Host: " + host + "\nSeasons: " + seasons.size());
	}

    public void play()
    {
        String epFile = this.getSeasons().get(0).getEpisodeFiles().get(0);
        // setAudioFile("Season 1: " + epTitle + "\n" + epFile);
        setAudioFile("Season 1:\n" + epFile);
        super.play();

        // setAudioFile(seasons.);
    }

    public void play(int season, int episode)
    {
        setAudioFile(this.getSeasons().get(season-1).getEpisodeFiles().get(episode-1));
        super.play();

        // setAudioFile(seasons.);
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