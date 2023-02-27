// Delta College - CST 183
// This program demonstrates recursion by interating through an array of
// integers to count the number of negative elements.

public class CountNegatives 
{

    public static void main(String args[]) 
    {
        int array[] = {6, -4, 1, 2, 5, -3, 7, -9, 0, 8};

        System.out.println("Negatives in array: " + countNegs(0, array));
 
        System.exit(0);
    }

    // This recursive method receives a current index, determines if the value
    // is negative or not and the recurses to the next higher index.  A count
    // of zero or one is returned depending on this call.  The base case
    // stopping point for the recursion is the index one less than the array
    // length.
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
