// Delta College - CST 283 - Klingler
// This program reads a multiple lines of coded text, parses out the coded
// data and writes the resul.

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ParseData 
{
    public static final String filename = "rawdata.txt";
    
    public static void main(String[] args) 
    {
        
        String aLine = new String();
        
        try
        {
            File infile;       
            infile = new File(filename); 
                            
            if (!infile.exists())
            {
                System.out.println("ERROR: Input File Not Found");
                System.exit(0);
            }
            
            // File exists and OK; instantiate Scanner object to read
            Scanner inputFileScanner = new Scanner(infile);  

            // Read contents of file line-by-line and send to method to
            // be processed
            while (inputFileScanner.hasNext())
            {
                 aLine = inputFileScanner.nextLine();
                 parseData(aLine);
            }

        }
        catch ( IOException e )
        {
            System.out.println("ERROR: Input File Error");
            System.exit(0);
        }       


    }  // end main


    //**************************************************************************
    // This function receives a line of formatted data and extracts
    // different fields before writing the details to the console
    public static void parseData(String oneLine)
    {
        System.out.println(oneLine);
        
        String firstName = "";
        String lastName  = "";
        String phone     = "";
        double fraction  = 0;
        
        // Break main string down
        StringTokenizer lineTokens = new StringTokenizer(oneLine, " ");
        String nameStr   = lineTokens.nextToken();
        phone            = lineTokens.nextToken();
        String numberStr = lineTokens.nextToken();
        
        // Break apart name
        StringTokenizer nameTokens = new StringTokenizer(nameStr, ",");
        lastName   = nameTokens.nextToken();
        firstName  = nameTokens.nextToken();
 
        // Remove all but digits from phone
        phone = phone.replace("-", "");
        phone = phone.replace("(", "");
        phone = phone.replace(")", "");
        
        // Break apart digits and convert to number
        StringTokenizer numTokens = new StringTokenizer(numberStr, "/");
        double numerator   = Double.parseDouble(numTokens.nextToken());
        double denominator = Double.parseDouble(numTokens.nextToken());
        fraction = numerator/denominator;
        
       // Garrett,Clifford (202)-555-3456 9/123
        
        
        System.out.println(firstName +"|" + lastName + "|" +
                           phone     +"|" + fraction + "\n\n");

    }  // end printMorse
}
