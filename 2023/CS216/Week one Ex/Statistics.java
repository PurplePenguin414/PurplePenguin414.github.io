// Delta College - CST 183 - Klingler
// This program processes a file of integers and calculates the
// statistical parameters mean, median, and mode for the dataset.
// The dataset is assumed to be values ranging from 0...100

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class Statistics
{
    final static int MAXSIZE = 1000;             // Max size of dataset (and array)

    public static void main( String args[] ) throws IOException
    {
         int[] data = new int[MAXSIZE]; 
         int numElems;
         double mean;
         int median, mode;
         String outMessage = "";
       
         File fileIn = new File ("statdata.txt");
         Scanner inputFile = new Scanner(fileIn);

         // Check for file existence.  If not found, display error and crash
         if (!fileIn.exists())
         {   
             JOptionPane.showMessageDialog( null, 
               "File was not found",  "File Error", 
               JOptionPane.ERROR_MESSAGE );
             System.exit(0);
         }
        
        // Read file and count values in array
        numElems = getData(inputFile,data);

        inputFile.close();  // Close input file - dont with it

        // If file not empty, calculate statistics and prepare output
        if (numElems > 0)
        {
            // Do the stats
            mean   = getAverage(data,numElems);
            median = getMedian(data,numElems);
            mode   = getMode(data,numElems);
            
            // Formulate output message
            outMessage += String.format("Mean: %6.2f", mean) + "\n";
            outMessage += "Median: " + median                + "\n";
            outMessage += "Mode: "   + mode                  + "\n";
            outMessage += "n =   "   + numElems              + "\n";         
        }
        else
             outMessage = "ERROR:  No data processed";
            
        // Display the results
        JOptionPane.showMessageDialog( null, 
             outMessage, "Statistical Summary", 
             JOptionPane.INFORMATION_MESSAGE );

        System.exit(0);
    }

    // ------------------------------------------------------------------------
    // This method reads integers from a file and stores the values in
    // an array.  It returns the loaded array (by reference) and the number of
    // elements in the array as the method return value.
    public static int getData(Scanner inFile, int inValues[])
    {
        int goodDataCount = 0;
        
        int i = 0;
        while (inFile.hasNext() && i < MAXSIZE)
        {
          inValues[i] = inFile.nextInt();
          i++;
        }
        goodDataCount = i;             // Capture number in array
        return goodDataCount;

}

    // ------------------------------------------------------------------------
    // This method receives an array of integers, calculates the average
    // of the array values, and returns it.
    public static double getAverage(int inValues[], int dataSize)
    {
        double sum = 0.0;

        for (int i = 0; i < dataSize; i++)
        sum = sum + inValues[i];

        return sum / dataSize;
    }

    // ------------------------------------------------------------------------
    // This method receives an array of integers, sorts it and retrieves the
    // middle (median) value
    public static int getMedian(int inValues[], int dataSize)
    {
        sortArray(inValues, dataSize);   // Sort array
        int middleIndex = dataSize / 2;  // Find index of middle value
        return inValues[middleIndex];
    }

    // ------------------------------------------------------------------------
    // This method receives a list of values of type int
    // as an array.  The function performs a bubble sort and
    // returns the list in ascending order.
    // Note:  elems is number of elements in list
    private static void sortArray(int array[], int elems)
    {
        int temp, end;

        for (end = elems - 1; end >= 0; end--)
        {
            for (int count = 0; count < end; count++)
            {
                if (array[count] > array[count + 1])
                {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                }
            }
        }
    }

    // ------------------------------------------------------------------------
    // This method receives an array of integers and returns the list element
    // that occurs the most frequently.
    // Precondition:  range of array values is 0...10
    public static int getMode(int inValues[], int dataSize)
    {
        int frequency[] = new int[101];    // Array for counting in range 0...100

        // Zero all array values
        for (int i = 0; i <= 100; i++)
            frequency[i] = 0;

        // Count occurrences of each score
        for (int i = 0; i < dataSize; i++)
            frequency[inValues[i]]++;      // Increment counter corresponding to score

        // Get max from frequency array
        int maxIndex = 0;                 // To keep index of max array value
        int maxCount = 0;                 // To keep max array value

        for (int i = 0; i <= 100; i++)
            if (frequency[i] > maxCount)   // If number of occurrences exceeds largest so far
            {
                maxIndex = i;               // Then keep the index and array value for the
                maxCount = frequency[i];    // largest value so far
            }

        return maxIndex;                  // Return max value as mode for list
    }

}