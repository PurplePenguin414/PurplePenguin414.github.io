// This static class defines a "home" for the following n^2 sorting algorithms:
// - Bubble sort
// - Selection sort
// - Insertion sort


public class SortingN2
{
    // Bubble sort on an array of integers (ascending)
    public static void bubbleSort(int[] array) 
    {
        int lastPos;     // Position of last element to compare
        int index;       // Index of an element to compare
        int temp;        // Used to swap to elements

         // The outer loop positions lastPos at the last element
        // to compare during each pass through the array. Initially
        // lastPos is the index of the last element in the array.
        // During each iteration, it is decreased by one.
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) 
        {
            // The inner loop steps through the array, comparing
            // each element with its neighbor. All of the elements
            // from index 0 thrugh lastPos are involved in the
            // comparison. If two elements are out of order, they
            // are swapped.
            for (index = 0; index <= lastPos - 1; index++) 
            {
                // Compare an element with its neighbor.
                if (array[index] > array[index + 1]) 
                {
                    // Swap the two elements.
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
    }

    // Selection sort on an array of integers (ascending)
    public static void selectionSort(int[] array) 
    {
        int startScan;   // Starting position of the scan
        int index;       // To hold a subscript value
        int minIndex;    // Element with smallest value in the scan
        int minValue;    // The smallest value found in the scan

        // The outer loop iterates once for each element in the
        // array. The startScan variable marks the position where
        // the scan should begin.
        for (startScan = 0; startScan < (array.length - 1); startScan++) 
        {
            // Assume the first element in the scannable area
            // is the smallest value.
            minIndex = startScan;
            minValue = array[startScan];

            // Scan the array, starting at the 2nd element in
            // the scannable area. We are looking for the smallest
            // value in the scannable area. 
            for (index = startScan + 1; index < array.length; index++) 
            {
                if (array[index] < minValue) 
                {
                    minValue = array[index];
                    minIndex = index;
                }
            }

            // Swap the element with the smallest value 
            // with the first element in the scannable area.
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
    }
    
    // Insertion sort on an array of integers (ascending)
    public static void insertionSort(int[] array) 
    {
        int unsortedValue;  // The first unsorted value
        int scan;           // Used to scan the array

        // The outer loop steps the index variable through 
        // each subscript in the array, starting at 1. The portion of
        // the array containing element 0  by itself is already sorted.
        for (int index = 1; index < array.length; index++) 
        {
            // The first element outside the sorted portion is
            // array[index]. Store the value of this element
            // in unsortedValue.
            unsortedValue = array[index];

            // Start scan at the subscript of the first element
            // outside the sorted part.
            scan = index;

            // Move the first element in the still unsorted part
            // into its proper position within the sorted part.
            while (scan > 0 && array[scan - 1] > unsortedValue) 
            {
                array[scan] = array[scan - 1];
                scan--;
            }

            // Insert the unsorted value in its proper position
            // within the sorted subset.
            array[scan] = unsortedValue;
        }
    }

}
