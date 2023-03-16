/**
 * This class manages a queue of music titles
 * Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MusicManager
{
    private final int MAX_QUEUE_SIZE = 50;
    private final String INPUT_FILENAME = "songs.txt";

    // Objets to manage music
    private StringQueue musicPlayQueue;          // Play queue
    private ArrayList<String> musicLibrary;      // Entire music library
    private String currentSongPlaying;           // Current song

    /**
    * Constructor
    * @pre     (1) File exists; (2) Number of file elements <= MAX_ARRAY_SIZE    
    */    
    public MusicManager()
    {
        musicPlayQueue = new StringQueue(MAX_QUEUE_SIZE);
                
        // Load music library from file
        try
        {
            String songTitle;
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(INPUT_FILENAME); 
            inputFileScanner = new Scanner(inputfile);
            
            // Instantiate list object
            musicLibrary  = new ArrayList<String>();    
                        
            int i = 0;
            while (inputFileScanner.hasNext())
            {   
                songTitle = inputFileScanner.nextLine();  
                musicLibrary.add(songTitle);
            }
            
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error,indicate to log and shut down.
        {
           System.out.println("File Input Error");
           System.exit(0);
        }
        currentSongPlaying = "NO SONG";   // Initially no song playing
    }
           
    /**
    * Accessor for list size
    * @return   Number of songs in music library
    */
    public int getMaxSongs()
    {
        return musicLibrary.size();
    }    
        
    /**
     * Linear search to match and verify song name in library
     *
     * @param    Song title to search for
     * @return   boolean indicating song within song library
     */
    public boolean songFound(String targetSong) 
    {
        for (String currSong : musicLibrary)
        {
            if (currSong.equalsIgnoreCase(targetSong))
                return true;
        }
        return false;     // If no match found, default to "not found" return
    }

    /**
     * Return library of songs as array list of strings
     *
     * @return   ArrayList of song name strings
     */
    public ArrayList<String> getSongList()
    {
        return musicLibrary;
    }
    
    /**
    * Add a song to current song queue
    */
    public void addToQueue(String newSong)
    {
        musicPlayQueue.enqueue(newSong);
    } 
    
    /**
    * Dequeue and return next song to be played at front of queue
    */
    public String getNextSong()
    {
        if (!musicPlayQueue.isEmpty())
        {
            currentSongPlaying = musicPlayQueue.dequeue();
        }
        else
            currentSongPlaying = "NO SONG"; 
        
        return currentSongPlaying;
    }    
     
    /**
    * Selects song at random and adds to queue
    */
    public void addRandomSong()
    {
        Random randGenerator = new Random();
        int newRandSongIndex = randGenerator.nextInt(musicLibrary.size());
        musicPlayQueue.enqueue(musicLibrary.get(newRandSongIndex));
    }
    
    /**
    * Return all data elements as a multi-line string formatted for output.
    */
    public String toString()
    {
        String outString = "NEXT UP ...\n" + musicPlayQueue.toString();
        
        return outString;
    }
    
        

}
