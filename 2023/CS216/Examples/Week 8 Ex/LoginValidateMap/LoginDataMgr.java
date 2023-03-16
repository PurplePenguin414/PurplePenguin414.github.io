/**
 * This class manages a set of user IDs and associated passwords
 * @author      Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class LoginDataMgr
{
    private final int MAX_LIST_SIZE = 1000;
    private final String INPUT_FILENAME = "userIDpass.txt";

    // Primary data structure for usernames and passwords
    private HashMap users;        

    private File inputfile;        // Reference for input file
    private final String COMMA = ",";

    /**
    * Constructor
    * @pre     (1) File exists; (2) Number of file elements <= MAX_ARRAY_SIZE    
    */    
    public LoginDataMgr()
    {
        // Load arrays from file
        try
        {
            String dataLine = new String();;
            Scanner inputFileScanner;
            String username,password;
            File inputfile;
            inputfile = new File(INPUT_FILENAME); 
            inputFileScanner = new Scanner(inputfile);
            
            users = new HashMap();   // Instiate map data structure

            // Read file into map data structure
            while (inputFileScanner.hasNext())
            {   
                // Read one line of raw  data and tokenize
                // Format:  username,password
                dataLine = inputFileScanner.nextLine();  
                StringTokenizer tokens = new StringTokenizer(dataLine, COMMA);
                
                username  = tokens.nextToken();   
                password  = tokens.nextToken();
                
                // Add data for given state to data map
                users.put(username, password);
                // Add key and data to map
               
            }
            
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, send note to log and shut down.
        {
           System.out.println("File Input Error");
           System.exit(0);
        }
        catch (Exception e)  // Catch any exception for controlled shut-down
        {
           System.out.println("Unknown Input Error");
           System.exit(0);
        }    
    }  
        
    /**
     * Search hash map to match username
     *
     * @param    username
     * @return   boolean indication if username exists
     */
    public boolean containsUsername(String username) 
    {
        if (users.containsKey(username)) 
        {
            return true;
        }   
        else 
        {
            return false;
        }
    }
      
    /**
     * Search hash map to match password assuming username OK
     *
     * @param    username
     * @param    password
     * @pre      username already matched as included in data structure
     * @return   boolean indication if password matches parameter
     */
    public boolean passwordOK(String username, String password)
    {
        // Get stored password given the valid username provided.  Action
        // returns Object type so typecast to String
        String databasePassword = (String)users.get(username);
        
        // Test password parameter to valid stored password
        if (password.equals(databasePassword))
        {
            return true;
        }   
        else 
        {
            return false;
        }
    }

}
