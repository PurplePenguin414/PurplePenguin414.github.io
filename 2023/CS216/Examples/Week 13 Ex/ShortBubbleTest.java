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
