// Delta College - CST 283 - Klingler & Gaddis text           
// This class demonstrates n^2 sorting algorithms

public class SortTestN2 
{

    public static void main(String[] args) 
    {
        // ****************** BUBBLE SORT ******************

        System.out.println("BUBBLE SORT");
        
        // Declare array
        int[] array1 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        // Sort the array
        SortingN2.bubbleSort(array1);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array1) 
            System.out.print(element + " ");

        System.out.println("\n\n");

      // ****************** INSERTION SORT ******************

        System.out.println("SELECTION SORT");
              
        // Declare array
        int[] array2 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array2) 
            System.out.print(element + " ");

        // Sort the array
        SortingN2.selectionSort(array2);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array2) 
            System.out.print(element + " ");

        System.out.println("\n\n");

        // ****************** INSERTION SORT ******************

        System.out.println("INSERTION SORT");
      
        // Declare array
        int[] array3 = {5, 1, 3, 9, 6, 4, 2, 8, 7};

        // Display before
        System.out.println("Original order: ");
        for (int element : array3) 
            System.out.print(element + " ");

        // Sort the array
        SortingN2.insertionSort(array3);

        // Display after
        System.out.println("\nSorted order: ");
        for (int element : array3) 
            System.out.print(element + " ");

        System.out.println("\n\n");

    }
}
