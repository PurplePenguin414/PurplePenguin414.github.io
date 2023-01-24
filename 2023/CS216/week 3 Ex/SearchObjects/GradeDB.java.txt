/**
 * This class manages grade information stored in one array of objects.
 * @author      Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GradeDB
{
    private final int MAX_ARRAY_SIZE = 50;
    private final String INPUT_FILENAME = "gradeData.txt";

    // Primary arry of objects
    private Student studentData[];        

    private int numElems;          // Number of actual data elements stored in array
    private File inputfile;        // Reference for input file

    /**
    * Constructor
    * @pre     (1) File exists; (2) Number of file elements <= MAX_ARRAY_SIZE    
    */    
    public GradeDB()
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
            int    id;
            double gpa;
            char   grade;
            
            studentData  = new Student[MAX_ARRAY_SIZE];    
                        
            // Loop through file.  Tokenize each line into correct array.
            int i = 0;
            while (inputFileScanner.hasNext())
            {   
                // Read one line and instantiate a tokenizer object
                dataLine = inputFileScanner.next();  
                StringTokenizer dataTokens = new StringTokenizer( dataLine, "," );

                // Tokenize line and save data
                name  = dataTokens.nextToken();   
                id    = Integer.parseInt(dataTokens.nextToken());  
                grade = dataTokens.nextToken().charAt(0);  
                gpa   = Double.parseDouble(dataTokens.nextToken());
                
                // Construct object and add to array of objects
                Student addStudent = new Student(id, name, gpa, grade);
                studentData[i] = addStudent;

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
    * @return   Number of element sin list
    */
    public int getNumElems()
    {
        return numElems;
    }    
    
     /**
    * Accessor for Student data given an array index.
    * @return   String data for matching student; error message if not found
    */
    public String getDataforID(int targetID)
    {
        int targetIndex = sequentialSearch(targetID);
        
        if (targetIndex >= 0)
        {
            return studentData[targetIndex].toString();
        }
        else
            return "No Student Info Found";
    }    
        
    /**
     * The sequentialSearch method searches ID array for a match.
     *
     * @param targetID The value to search for.
     * @return The subscript of the value if found in the array, otherwise -1.
     */
    private int sequentialSearch(int targetID) 
    {
        int index;        // Loop control variable
        int element;      // Position the value is found at
        boolean found;    // Flag indicating search results

        index = 0;        // Start search at index zero
        element = -1;     // Set to default values;
        found = false;    // assuming not found

        // Begin search of array from index zero forward.  
        // Search while not found and not yet at end of list
        while (!found && index < numElems) 
        {
            if (studentData[index].getID() == targetID) // If found
            {
                found = true;             //   reset to terminate search
                element = index;          //   retain index of target value
            }
            index++;                      // Otherwise, advance to next element
        }

        return element;
    }
      
    /**
    * Return all data elements as a multi-line string formatted for output.
    */
    public String toString()
    {
        String outString = "";
        
        for (int i = 0; i < numElems; i++)
            outString += studentData[i].toString();
        
        return outString;
    }

}
