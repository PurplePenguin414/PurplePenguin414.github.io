/**
 * This class manages stat information stored in one array of objects.
 * @author      Delta College - CST 283 - gibbs        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class readStats
{
    private final int MAX_ARRAY_SIZE = 50;
    private final String INPUT_FILENAME = "teamData.txt";

    // Primary arry of objects
    private Player playerData[];        

    private int numElems;          // Number of actual data elements stored in array
    private File inputfile;        // Reference for input file

    /**
    * Constructor
    * @pre     (1) File exists; (2) Number of file elements <= MAX_ARRAY_SIZE    
    */    
    public readStats()
    {
        // Load arrays from file
        try
        {
            String dataLine;
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(INPUT_FILENAME); 
            inputFileScanner = new Scanner(inputfile);
            
            String name;
            double ppg;
            double reb;
            double ast;
            
            playerData  = new Player[MAX_ARRAY_SIZE];    
                        
            // Loop through file.  Tokenize each line into correct array.
            int i = 0;
            while (inputFileScanner.hasNext())
            {   
                // Read one line and instantiate a tokenizer object
                dataLine = inputFileScanner.next();  
                StringTokenizer dataTokens = new StringTokenizer( dataLine, "," );

                // Tokenize line and save data
                name  = dataTokens.nextToken();   
                ppg   = Double.parseDouble(dataTokens.nextToken());
                reb   = Double.parseDouble(dataTokens.nextToken());
                ast   = Double.parseDouble(dataTokens.nextToken());
                
                // Construct object and add to array of objects
                Player addPlayer = new Player(name, ppg, reb, ast);
                playerData[i] = addPlayer;

                i++;      // Advance marker index   
            }
            numElems = i;
            
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, send note to log and shut down.
        {
           System.out.println("File Input Error");
           System.exit(0);
        }

       // return playerData;
    }
           
    /**
    * Accessor for list size
    * @return   Number of element sin list
    */
    public int getNumElems()
    {
        return numElems;
    }

    //to string for player
    public String toString()
    {
        String outString = "";
        for (int i = 0; i < numElems; i++)
            outString += playerData[i].toString();

        return outString;
    }
}
    