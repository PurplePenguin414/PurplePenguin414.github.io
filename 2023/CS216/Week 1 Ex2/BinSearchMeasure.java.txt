// Delta College - CST 283 - Klingler                          
// This program performs an experiment to demonstrate the relative
// efficiency of the binary search versus the linear search.  The
// number of comparisons (if statements) performed for each search
// is counted as a measure of the "work" performed

import javax.swing.JOptionPane;
import java.util.Random;       

public class BinSearchMeasure
{   
    final static int ARRAY_SIZE = 32768;
    final static int NUM_TESTS  = 1000;

    // Global variables used as counters for experiment
    static int numTestsLin = 0;    // To count number of tests for linear search
    static int numTestsBin = 0;    // To count number of tests for binary search

    public static void main( String args[])
    {
        int list[] = new int[ARRAY_SIZE];
        int target, testReturn;

        Random randomNumbers = new Random();    

        generateArray(list);

        for (int i = 1; i <= NUM_TESTS; i++)
        {
            // Get search value
            target = randomNumbers.nextInt(ARRAY_SIZE);

            // Perform linear search
            testReturn = sequentialSearch(list, target);

            // Perform binary search
            testReturn = binarySearch(list, target);
        }

        String message = "List size: " + ARRAY_SIZE + "\n\n";
        message += "Average comparisons for:\n";

        message += "Linear search: " + 
                   String.format("   Linear search: %6.1f\n",
                   (double)numTestsLin/(double)NUM_TESTS);
                   
        message += "Binary search: " + 
                   String.format("   Binary search: %6.1f\n",
                   (double)numTestsBin/(double)NUM_TESTS);
        
        JOptionPane.showMessageDialog(null,message);
    
        System.exit(0);
    }

    //*****************************************************************
    // This method generates a basic array with data                *
    // data 1,2,3, ..., (ARRAY_SIZE) to be used in this simulation.   *
    //*****************************************************************
    public static void generateArray(int theList[])
    {
        for (int i = 0; i < ARRAY_SIZE; i++)
            theList[i] = i+1;
    }


    //*****************************************************************
    // The searchList method performs a linear search on an           *
    // integer array. The array list, which has a maximum of numElems *
    // elements, is searched for the number stored in value. If the   *
    // number is found, its array subscript is returned. Otherwise,   *
    // -1 is returned indicating the value was not in the array.      *
    //*****************************************************************
    public static int sequentialSearch(int[] array, int value) 
    {
        int index;        // Loop control variable
        int element;      // Position the value is found at
        boolean found;    // Flag indicating search results

        index = 0;        // Start search at index zero
        element = -1;     // Set to default values;
        found = false;    // assuming not found

        // Begin search of array from index zero forward.  
        // Search while not found and not yet at end of list
        while (!found && index < ARRAY_SIZE) 
        {
            numTestsLin++;
            if (array[index] == value) // If found
            {
                found = true;             //   reset to terminate search
                element = index;          //   retain index of target value
            }
            index++;                      // Otherwise, advance to next element
        }

        return element;
    }


    //***************************************************************
    // This method performs a binary search on aninteger array.     *
    // The array is searched for the number stored in value. If the *
    // number is found, its array subscript is returned. Otherwise, *
    // -1 is returned indicating the value was not in the array.    *
    //***************************************************************
    public static int binarySearch(int array[], int value)
    {
        int first = 0,                 // Index of first array element
            last = ARRAY_SIZE - 1,     // Index of last good array element
            middle,                    // Mid point of search
            position = -1;             // Position of search value
            boolean found = false;     // To indicate if found or not

        while (!found && first <= last)
        {
            middle = (first + last) / 2;     // Calculate mid point
            numTestsBin++;
            if (array[middle] == value)      // If value is found at mid
            {
                found = true;
                position = middle;
            }
            else if (array[middle] > value)  // If value is in lower half
                last = middle - 1;
            else
                first = middle + 1;          // If value is in upper half
        }
        return position;
    }
}
