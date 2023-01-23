// Delta College - CST 283 - Klingler  
// This program reads a list of decimal values from a file, stores
// them in an array, and writes them to an output file in ascending sorted order.

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class BubbleSortFile
{
    // Constants
    public static final String inputfilename = "unsortdata.txt";  
    public static final String outputfilename = "sortdata.txt";  
    public static final int ARRAY_SIZE = 50;

    public static void main(String[] args) throws IOException
    {
        double value;                 // Variable to collect individual input values
        double data[];                // Reference for data array
        File inputfile;               // Reference for input file
        int i;                        // Array index marker
        int numElems = 0;             // Number of actual data elements stored in array
  
        // Instantiate required objects
        inputfile  = new File(inputfilename);            // Create file input object
         data = new double[ARRAY_SIZE];                  // Allocate array elements
        
        // Check for file existence.  If not found, display error and crash
        if (!inputfile.exists())
        {   
            JOptionPane.showMessageDialog( null, 
               "File was not found", 
               "File Error", 
               JOptionPane.ERROR_MESSAGE );
            System.exit(0);
        }
        
        // Asserting file found, instantiate scanner object for input
        Scanner inputFileScanner  = new Scanner(inputfile);   

        // File processing loop - Continue while not empty
        // Read file element and store in array
        i = 0;
        while (inputFileScanner.hasNext())
        {
            data[i] = inputFileScanner.nextDouble();  // Capture input data on line 
            i++;                                      // Advance array marker
        }
        numElems = i;
        inputFileScanner.close();
        
        bubbleSort(data,numElems);   // Sort data in array
        
         // Check for non-empty file.  If OK, write sorted array to output
        if (numElems > 0)
        {
            writeArrayToFile(data,numElems);
        }
        else  // Otherwise, assign output message to designate an error
           JOptionPane.showMessageDialog( null, "Empty file", 
                            "File Error",  JOptionPane.ERROR_MESSAGE );
            
        System.exit(0);         
    }
    
    // ---------------------------------------------------------------------
    // This method receives an array of floating point values (double) and sorts it.
    // PRECONDITION: Parameter numElems defines precise number of valid data
    //               elements in array and numElems > 0.
    // POSTCONDITION:  Array returned by reference in ascending order
    public static void bubbleSort(double[] array, int numElems)
    {
        int lastPos;     
        int index;       
        double temp;    
      
        for (lastPos = numElems - 1; lastPos >= 0; lastPos--)
        {
            for (index = 0; index <= lastPos - 1; index++)
            {
                if (array[index] > array[index + 1])
                {
                   temp = array[index];
                   array[index] = array[index + 1];
                   array[index + 1] = temp;
                }
             }
        }
    }
    
    // ---------------------------------------------------------------------
    // This method receives an array of floating point values (double) 
    // sends it to the output file (declared as constant).
    public static void writeArrayToFile(double data[], int numElems) throws IOException
    {
        // Delclare and instantiate output writer object
        PrintWriter outputfileWriter;      
        outputfileWriter = new PrintWriter(outputfilename); 

        // Write data to file
        for (int i = 0; i < numElems; i++)
        {
            outputfileWriter.println(data[i]);
        }
        outputfileWriter.close();
    }
} 

