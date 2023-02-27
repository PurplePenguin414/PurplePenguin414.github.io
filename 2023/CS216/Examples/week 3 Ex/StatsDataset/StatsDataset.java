/**
 * This class manages a basic statistical dataset of integers
 * 
 * @author      Delta College - CST 183 - Klingler
 * @version     1.0                 
 * @since       2015-07-23          
 */

import java.util.Scanner;
import java.io.*;

public class StatsDataset
{
    private int data[];       // Reference for data array
    private int numElems;     // Number of actual data elements stored in array
    private File inputfile;   // Reference for input file

    public static final int ARRAY_SIZE = 50;  // Default max size of array
        
    /**
    * Constructor
    * @param   filename    string value of local filename containing data
    * @pre     File exists - no error checking performed
    */
    public StatsDataset(String filename) throws IOException
    {
        inputfile = new File(filename);  // Create file input object
        data = new int[ARRAY_SIZE];      
        
                // Asserting file found, instantiate scanner object for input
        Scanner inputFileScanner = new Scanner(inputfile);  

        // File processing loop - Continue while not empty
        // Read file element and store in array
        int i = 0;
        while (inputFileScanner.hasNext())
        {
            data[i] = inputFileScanner.nextInt();   // Capture file value
            i++;                                // Advance array marker
        }
        numElems = i;
        
        inputFileScanner.close();   // Close file
    }
  
    /**
    * This method receives an array of integers and determines the sum of
    * all included elements.
    */
    public int calcSum()
    {
        int sum = 0;
        for (int i = 0; i < numElems; i++)
            sum += data[i];
        return sum;
    }
    
    /**
    * This method receives an array of integers and calculates the average
    *The return value is a floating point value
    */
    public double calcAverage()
    {
        int total = calcSum();
        double average = (double)total / (double)numElems;
        return average;
    }

    /**
    * This method receives an array of integers and returns the maximum
    * value in the array
    */
    public int getMax()
    {
	int highest = data[0];
	for (int i = 1; i < numElems; i++)
	{
            if (data[i] > highest)
                highest = data[i];
	}
        return highest;
    }
    
    /**
    * This method receives an array of integers and returns the minimum
    * value in the array
    */
    public int getMin()
    {
	int lowest = data[0];
	for (int i = 1; i < numElems; i++)
	{
            if (data[i] < lowest)
                lowest = data[i];
	}
        return lowest;
    }
}
