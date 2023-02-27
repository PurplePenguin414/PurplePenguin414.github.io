// Delta College - CST 183 - Klingler & Gaddis Text                          
// This program demonstrates the binary search algorithm on an integer array.

import javax.swing.JOptionPane;

public class BinSearchRecurse 
{
    public static void main(String args[]) 
    {
        int tests[] = {5, 12, 27, 33, 39, 50, 61, 75, 88, 96};
        String output;
        int results;

        // Search array for value of 39 and write results
        results = binarySearch(tests, 0, tests.length, 39);
        if (results >= 0)
            output = "Value 39 found at array position " + results + "\n";
        else
            output = "Value 39 not found in array" + "\n";

        // Search array for value of 80 and write results
        results = binarySearch(tests, 0, tests.length, 80);
        if (results >= 0)
            output += "Value 80 found at array position " + results + "\n";
        else
            output += "Value 80 not found in array" + "\n";

        // Display output messsage    
        JOptionPane.showMessageDialog(null, output);

        System.exit(0);   // Terminate application
    }  // end main

    //***************************************************************
    // The binarySearch function performs a recursive binary search *
    // on a range of elements of an integer array passed into the   *
    // parameter array.The parameter first holds the subscript of   *
    // the range's starting element, and last holds the subscript   *
    // of the ranges's last element. The parameter value holds the  *
    // the search value. If the search value is found, its array    *
    // subscript is returned. Otherwise, -1 is returned indicating  *
    // the value was not in the array.                              *
    //***************************************************************
    public static int binarySearch(int array[], int first, int last, int value) 
    {
        int middle;     // Mid point of search

        if (first > last)
            return -1;
        
        middle = (first + last) / 2;
        
        if (array[middle] == value)
            return middle;

        if (array[middle] < value)
            return binarySearch(array, middle + 1, last, value);
        else
            return binarySearch(array, first, middle - 1, value);
    }
} // end application class
