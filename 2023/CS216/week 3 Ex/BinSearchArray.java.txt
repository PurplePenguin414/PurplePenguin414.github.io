// Delta College - CST 283 - Klingler & Gaddis Text                          
// This program demonstrates the binary search algorithm on an integer array.

import javax.swing.JOptionPane;

public class BinSearchArray
{
    public static void main( String args[])
    {
        int tests[] = {5, 12, 27, 33, 39, 50, 61, 75, 88, 96};
        String output;
        int results;

        // Search array for value of 33 and write results
        results = binarySearch(tests, 33, tests.length);
        if (results >= 0)
            output =  "Value 33 found at array position " + results + "\n";
        else
            output =  "Value 33 not found in array" + "\n";
        
        // Search array for value of 70 and write results
        results = binarySearch(tests, 70, tests.length);
        if (results >= 0)
            output +=  "Value 70 found at array position " + results + "\n";
        else
            output +=  "Value 70 not found in array" + "\n";
            
        // Display output messsage    
        JOptionPane.showMessageDialog( null, output );
        
        System.exit(0);   // Terminate application
    }  // end main
    
    //***************************************************************
    // This method performs a binary search on aninteger array.     *
    // The array is searched for the number stored in value. If the *
    // number is found, its array subscript is returned. Otherwise, *
    // -1 is returned indicating the value was not in the array.    *
    //***************************************************************
    public static int binarySearch(int array[], int value, int numElems)
    {
        int first = 0,                 // Index of first array element
            last = numElems - 1,       // Index of last good array element
            middle,                    // Mid point of search
            position = -1;             // Position of search value
            boolean found = false;     // To indicate if found or not

        while (!found && first <= last)
        {
            middle = (first + last) / 2;     // Calculate mid point
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
    
} // end application class

