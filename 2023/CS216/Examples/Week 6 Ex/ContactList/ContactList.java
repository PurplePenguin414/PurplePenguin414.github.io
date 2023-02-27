/**
 * This class manages a list of Contact objects
 * @author      Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ContactList
{
    private final int MAX_LIST_SIZE = 1000;
    private final String INPUT_FILENAME = "contacts.txt";

    // Primary arry of objects
    private Contact myContacts[];        

    private int numElems;          // Number of actual data elements stored in array
    private File inputfile;        // Reference for input file

    /**
    * Constructor
    * @pre     (1) File exists; (2) Number of file elements <= MAX_ARRAY_SIZE    
    */    
    public ContactList()
    {
        // Load arrays from file
        try
        {
            String dataLine;
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(INPUT_FILENAME); 
            inputFileScanner = new Scanner(inputfile);
            
            // Instantiate list object
            myContacts  = new Contact[MAX_LIST_SIZE];    
                        
            int i = 0;
            while (inputFileScanner.hasNext())
            {   
                // Read one line of raw contact data
                dataLine = inputFileScanner.nextLine();  
                
                // Construct object with raw data and add to array of objects
                Contact newContact = new Contact(dataLine);
                myContacts[i] = newContact;

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
    }
           
    /**
    * Accessor for list size
    * @return   Number of elements in list
    */
    public int getNumElems()
    {
        return numElems;
    }    
        
    /**
     * Linear search for a contact by last name
     *
     * @param    month, day of birth date
     * @return   String with all all data related to all contacts with matching 
     *           birth dates.
     */
    public String searchContactsByBirthDate(int month, int day) 
    {
        String outputString = "";

        for (int i = 0; i < numElems; i++) 
        {
            if (myContacts[i].matchesBirthDate(month,day))
               outputString += myContacts[i].toString();    
        }
        return outputString;
    }
      
    /**
    * Return all data elements as a multi-line string formatted for output.
    */
    public String toString()
    {
        String outString = "";
        
        for (int i = 0; i < numElems; i++)
            outString += myContacts[i].toString();
        
        return outString;
    }

}
