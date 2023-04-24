// This static class defines a "home" for the following n^2 sorting algorithms:
// - Bubble sort
// - Selection sort
// - Insertion sort

public class CompareSort {



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

    // This application demonstrates the bubble sort that allows early completion
// when a sorted list is detected.

public class ShortBubbleTest
{
    public static void main(String[] args) 
    {
        System.out.println("SHORT BUBBLE SORT");
        
        // Declare array
        int[] array1 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        // Sort the array
        shortBubbleSort(array1);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        System.out.println("\n\n");
    }

    // This method performs the bubble sort (ascending) on an array
    // of integers.  It completes the algorithm when the list is sorted.
    public static void shortBubbleSort(int[] array) 
    {
        boolean swap;
        int temp;
    
        int end = array.length - 1;   // To control stopping point

        do
        {
           swap = false;                    // Assume no swap this pass
           for (int count = 0; count < end; count++)
           {
              if (array[count] > array[count + 1])
              {
                 temp = array[count];
                 array[count] = array[count + 1];
                 array[count + 1] = temp;
                 swap = true;               // Mark that swap occured  
              }
           }     
           end--;    // Move stopping point up
      
         // Continue if a swap occurred that pass
       } while (swap); 
    }
}

// This static class defines a "home" for the following nlog2n sorting algorithms:
// - Heap sort
// - Quick sort

public class SortingNlog2N 
{
    // ======================================================================
    //    HEAP SORT
    // ======================================================================

    // Public launch point for heap sort.
    //   1) Work is done to convert random array int heap
    //   2) Array is sorted by swapping largest element and reheaping
    public static void heapSort(int array[]) 
    {
        int index;
        int numValues = array.length;

        // Convert the array of values into a heap
        for (index = numValues / 2 - 1; index >= 0; index--) 
            reheapDown(array, index, numValues - 1);

        // Sort the array
        for (index = numValues - 1; index >= 1; index--) 
        {
            swap(array, 0, index);
            reheapDown(array, 0, index - 1);
        }
    }
    
    // -----------------------------------------------------------------------
    // This method performs the REHEAP DOWN action to restore
    // a binary tree to a heap after a removal from the root.  This is
    // a basic, specific algorithm for integer heaps only.
    // Postcondition: Heap property is restored.
    private static void reheapDown(int elements[], int root, int bottom) 
    {
        int maxChild = 0;
        int rightChild;
        int leftChild;
        
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        
        if (leftChild <= bottom) 
        {
            if (leftChild == bottom) 
                maxChild = leftChild;
            else if (elements[leftChild] <= elements[rightChild]) 
                maxChild = rightChild;
            else 
                maxChild = leftChild;

            if (elements[root] < elements[maxChild]) 
            {
                swap(elements, root, maxChild);
                reheapDown(elements, maxChild, bottom);
            }
        }
    }
    
    
    // ======================================================================
    //    QUICK SORT
    // ======================================================================

    // Public method to launch quick sort
    public static void quickSort(int array[]) 
    {
        // Initiate sort by passing array and begin/end index
        // to private recursive method.
        doQuickSort(array, 0, array.length - 1);

    }

    // -----------------------------------------------------------------------
    // Recursive action of quicksort algorithm
    private static void doQuickSort(int array[], int start, int end) 
    {
        int pivotPoint;

        if (start < end) 
        {
            // Get the pivot point.
            pivotPoint = partition(array, start, end);

            // Sort the first sub list.
            doQuickSort(array, start, pivotPoint - 1);

            // Sort the second sub list.
            doQuickSort(array, pivotPoint + 1, end);
        }
    }

    // -----------------------------------------------------------------------
    /*
     The partiton method selects a pivot value in an array
     and arranges the array into two sub lists. All the
     values less than the pivot will be stored in the left
     sub list and all the values greater than or equal to
     the pivot will be stored in the right sub list.
     @param array The array to partition.
     @param start The starting subscript of the area to partition.
     @param end The ending subscript of the area to partition.
     @return The subscript of the pivot value.
     */
    private static int partition(int array[], int start, int end) 
{
        int pivotValue;    // To hold the pivot value
        int endOfLeftList; // Last element in the left sub list.
        int mid;           // To hold the mid-point subscript

        // Find the subscript of the middle element.
        // This will be our pivot value.
        mid = (start + end) / 2;

        // Swap the middle element with the first element.
        // This moves the pivot value to the start of 
        // the list.
        swap(array, start, mid);

        // Save the pivot value for comparisons.
        pivotValue = array[start];

        // For now, the end of the left sub list is
        // the first element.
        endOfLeftList = start;

        // Scan the entire list and move any values that
        // are less than the pivot value to the left
        // sub list.
        for (int scan = start + 1; scan <= end; scan++) 
            if (array[scan] < pivotValue) 
            {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }

        // Move the pivot value to end of the
        // left sub list.
        swap(array, start, endOfLeftList);

        // Return the subscript of the pivot value.
        return endOfLeftList;
    }

    // ======================================================================
    // A swap function for the 'elements' array.
    private static void swap(int elements[], int fromIndex, int toIndex) 
    {
        int temp = elements[fromIndex];
        elements[fromIndex] = elements[toIndex];
        elements[toIndex] = temp;
    }
}

}
