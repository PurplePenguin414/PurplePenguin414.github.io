// Delta College - CST 283 - Klingler                  
// This application demonstrates basic linked list operations
// for searching and retrieving data
// Version 4

import java.util.Scanner;
import java.io.*;

public class TestList4
{     
    public static void main(String [] args)
    {
        LinkedList<Data> theList = new LinkedList<Data>();
        
        int key, data;
        
        // Read file and populate linked list with Data objects
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("data.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                key  = inputFileScanner.nextInt();  
                data = inputFileScanner.nextInt();
                
                // Instantiate object from data line and add to list
                Data newDataObj = new Data(key,data);
                theList.add(newDataObj);
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error");
            System.exit(0);
        }
      
        // Partially populate a Data object only with key.  Search to match key.
        // If found, return Data object from list containing related data.
        int searchKey = 324;
        System.out.println("Searching for Data related to key: "+ searchKey);
        Data searchTarget = new Data();
        searchTarget.setKey(searchKey);
        if (theList.contains(searchTarget))
        {
            Data returnObject = theList.retrieve(searchTarget);
            System.out.println("FOUND: Key: " + searchKey + ", Data: " + returnObject.getData());
        }
        else
            System.out.println("NOT FOUND: Key: " + searchKey);        
               
        // For demonstration, write contents of list 
         System.out.println("\n\nThe list contents:");
         System.out.println(theList);
   }  
}
