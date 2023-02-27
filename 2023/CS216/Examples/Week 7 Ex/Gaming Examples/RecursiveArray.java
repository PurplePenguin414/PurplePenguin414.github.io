// Delta College - CST 183
// This program demonstrates three recursive methods that perform work
// on Java arrays

import java.util.Scanner;

public class RecursiveArray {

    public static void main(String args[]) 
    {
        int array1[] = {3, 5, 7, 9, 15, 22, 55};
        
        int array2[] = {2, 4, 6, 9, 8, 14, 16, 18, 24, 22};
        
        int array3[] = {2, -4, 6, 9, -8, 14, 16, -18, 26, -30};

        System.out.println("Array1 sorted: " + isSortedIterative(0, array1));
        System.out.println("Array1 sorted: " + isSortedRecursive(0, array1));
        
        System.out.println("Array2 sorted: " + isSortedIterative(0, array2));
        System.out.println("Array2 sorted: " + isSortedRecursive(0, array2));
        
        System.out.println("Array3 negatives: " + countNegs(0, array3));

        System.exit(0);
    }

    // This method scans an array of integers to verify the array is
    // sorted in ascending order.  The algorithm is iterative.
    public static boolean isSortedIterative(int index, int array[]) 
    {
        boolean sortedOK = true;

        for (int i = 0; i < array.length - 1; i++) 
            if (array[i] > array[i + 1])
                sortedOK = false;

        return sortedOK;
    }

    // This method scans an array of integers to verify the array is
    // sorted in ascending order.  The algorithm is recursive.
    public static boolean isSortedRecursive(int index, int array[]) 
    {
        if (index < array.length-1) 
        {
            if (array[index] > array[index + 1]) 
                return false;
            else 
                return isSortedRecursive(index + 1, array);
        }
        else
            return true;
    }

    // This method scans an array of integers recursively and counts the number
    // of negative numbers in the array.
    public static int countNegs(int index, int array[]) 
    {
        int addCount = 0;
        if (index == array.length) 
            return 0;
        else
        {
            if (array[index] < 0) 
                addCount = 1;
            return addCount + countNegs(index + 1, array);
        }
    }

}
