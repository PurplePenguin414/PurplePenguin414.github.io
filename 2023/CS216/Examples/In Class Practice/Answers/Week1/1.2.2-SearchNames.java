//******************************************************************************
// Delta College - CST 283 - Klingler
// This program reads a large list of names into arrays.  It then prompts the
// user for a first name, searchs for all list elements with matching first
// names, and returns the result via a dialog box.
//******************************************************************************

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;


public class SearchNames 
{
    public static final String namefilename = "namedata.txt";
    public static final int MAX_LIST = 1500;  // Max input names
    
    public static void main(String[] args) 
    {
        String outputString = "Matchings names:/n";   
        String nameList;    // Method return variable
        String targetFirst; // First name search target
        int totalNames;   
        
        String firstnames[] = new String[MAX_LIST];  
        String lastnames[]  = new String[MAX_LIST];  
    
        // Build arrays from file
        totalNames = createNameList(firstnames,lastnames);
        
        targetFirst = JOptionPane.showInputDialog("Enter first name");
   
        nameList = searchFirstNames(firstnames,lastnames,totalNames,targetFirst);
    
        JOptionPane.showMessageDialog(null, nameList);

        System.exit( 0 );

    }  

    //**************************************************************************
    // This method builds arrays containing the alphabet and matching
    // Morse code pattern.  If file not found, program is crashed.
    // Return value is the number of valid names in the lists.
    //**************************************************************************
    public static int createNameList(String[] first, String[] last)
    {
        int numElems = 0;
        
        try
        {
            File inputfile;       
            inputfile = new File(namefilename); 
                            
            if (!inputfile.exists())
            {
                System.out.println("ERROR: Names File Not Found");
                System.exit(0);
            }
            
            // File exists and OK; instantiate Scanner object to read
            Scanner inputFileScanner = new Scanner(inputfile);  

            // Read contents of file int array; count words as it processes
            int i = 0;    
            while (inputFileScanner.hasNext() && i < MAX_LIST)
            {
                 first[i] = inputFileScanner.next();
                 last[i]  = inputFileScanner.next(); 
                 i++;
            }
            numElems = i;   // Capture number of names in file
        }
        catch ( IOException e )
        {
            System.out.println("ERROR: Names File Error");
            System.exit(0);
        }   
        return numElems;
    }

    //**************************************************************************
    // This method searchs the first name list to find all matches of the 
    // name passed in as the parameter.  It then builds a string with all 
    // first/last names that match.
    //**************************************************************************
    public static String searchFirstNames(String[] first, String[] last,
                                          int numElems, String target)
    {
        String outNames   = new String();   // For output
        int matchingNames = 0;
        
        // Search for all matching first names
        for (int i = 0; i < numElems; i++)
        {
            if (target.equals(first[i]))
            {
                outNames += (first[i] + " " + last[i] + "\n");
                matchingNames++;
            }
        }
        
        // If no names match, adjust output message
        if (matchingNames == 0)
            outNames = "No matching names";
        
        return outNames;
    }  
}
