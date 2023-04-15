// Delta College - CST 283 - Klingler & Gaddis text           
// This class demonstrates n^2 sorting algorithms

public class SortTestNlog2N 
{
    public static void main(String[] args) 
    {
        // ****************** HEAP SORT ******************

        System.out.println("HEAP SORT");
        
        // Declare array
        int[] array1 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        // Sort the array
        SortingNlog2N.heapSort(array1);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        System.out.println("\n\n");

      // ****************** QUICK SORT ******************

        System.out.println("QUICK SORT");
              
        // Declare array
        int[] array2 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array2) 
            System.out.print(element + " ");

        // Sort the array
        SortingNlog2N.quickSort(array2);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array2) 
            System.out.print(element + " ");

        System.out.println("\n\n");

    }
}
