// Delta College - CST 283 - Klingler                  
// This application demonstrates reversing a very long linked list
// recursively.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestListCrash
{     
    public static void main(String [] args)
    {
        LinkedList<String> theList = new LinkedList<String>();
        String aWord;        // Work variable for input

        // File loop to populate linked list
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("wordList.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            while (inputFileScanner.hasNext())
            {
                // Read word and add to list
                aWord  = inputFileScanner.next();  
                theList.add(aWord);
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: Problem opening word file");
            System.exit(0);
        }

      
        // Demonstrate list in reverSe order
        System.out.println("\nThe list elements in reverse order are:");
        System.out.println(theList.reverseToString());
        
    }  
}
