/**
 * This class manages grade information stored in multiple parallel.
 * arrays
 * @author      Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GradeDB
{
    private final int MAX_ARRAY_SIZE = 50;
    private final String INPUT_FILENAME = "gradeData.txt";

    // Data storage arrays - related info stored in parallel
    private String name[];        
    private int    id[];
    private char   grade[];
    private double gpa[];

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
            
            name  = new String[MAX_ARRAY_SIZE];    
            id    = new int[MAX_ARRAY_SIZE];
            grade = new char[MAX_ARRAY_SIZE];
            gpa   = new double[MAX_ARRAY_SIZE];
                        
            // Loop through file.  Tokenize each line into correct array.
            int i = 0;
            while (inputFileScanner.hasNext())
            {   
                // Read one line and instantiate a tokenizer object
                dataLine = inputFileScanner.next();  
                StringTokenizer dataTokens = new StringTokenizer( dataLine, "," );

                // Tokenize line and save data
                name[i]  = dataTokens.nextToken();   
                id[i]    = Integer.parseInt(dataTokens.nextToken());  
                grade[i] = dataTokens.nextToken().charAt(0);  
                gpa[i]   = Double.parseDouble(dataTokens.nextToken());  

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
    * Sort all data by student name - Ascending
    */
    public void sortNameAsc()
    {
        for (int lastPos = numElems - 1; lastPos >= 0; lastPos--)
            for (int index = 0; index <= lastPos - 1; index++)
               if (name[index].compareTo(name[index + 1]) > 0)
                   swapStudents(index,index+1);
    }
    
    /**
    * Sort all data by student id - Ascending
    */
    public void sortIDAsc()
    {
        for (int lastPos = numElems - 1; lastPos >= 0; lastPos--)
            for (int index = 0; index <= lastPos - 1; index++)
               if (id[index] > id[index + 1])
                   swapStudents(index,index+1);
    }
    
    /**
    * Sort all data by student grade - Ascending.  If grades are equal, the
    * secondary sort is descending by GPA>
    */
    public void sortGradeAsc()
    {
        for (int lastPos = numElems - 1; lastPos >= 0; lastPos--)
            for (int index = 0; index <= lastPos - 1; index++)
               if (grade[index] > grade[index + 1])
                   swapStudents(index,index+1);
               else if (grade[index] == grade[index + 1])
               {
                   if (gpa[index] < gpa[index + 1])
                       swapStudents(index,index+1);
               }
    }
    
     /**
    * Sort all data by student GPA - Descending
    */
    public void sortGPADesc()
    {
        for (int lastPos = numElems - 1; lastPos >= 0; lastPos--)
            for (int index = 0; index <= lastPos - 1; index++)
               if (gpa[index] < gpa[index + 1])
                   swapStudents(index,index+1);
    }
    
   /**
    * Swap elements in all arrays between the given indexes
    */
    public void swapStudents(int index1, int index2)
    {
        String tempStr = name[index1];
        name[index1] = name[index2];
        name[index2] = tempStr;
        int tempID = id[index1];
        id[index1] = id[index2];
        id[index2] = tempID;
        double tempGPA = gpa[index1];
        gpa[index1] = gpa[index2];
        gpa[index2] = tempGPA; 
        char tempGrade = grade[index1];
        grade[index1] = grade[index2];
        grade[index2] = tempGrade;
    }
    
    /**
    * Return one set of student data with formatting
    */
    public String getStudentFormatted(int index)
    {
        String outString =  String.format("%-8s", id[index])  +
                String.format("%-15s", name[index]) +
                String.format("%-6s", grade[index]) +
                String.format("%3.1f", gpa[index]) ;
        
        return outString;
    }
      
    /**
    * Return all data elements as a multi-line string formatted for output.
    */
    public String toString()
    {
        String outString = "ID      Name         Grade   GPA\n";
        
        for (int i = 0; i < numElems; i++)
            outString += getStudentFormatted(i) + "\n";
        
        return outString;
    }

}
