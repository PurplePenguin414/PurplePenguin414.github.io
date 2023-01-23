/**
 * Delta College - CST 283 - Klingler & Gaddis Text 
 * This program sequentially searches an int array for a specified value.
 */

public class SearchArray 
{

    public static void main(String[] args) {
        int[] points = {87, 75, 98, 66, 82, 100, 43, 90};
        int results;

        // Search the array for the value 100.
        results = sequentialSearch(points, 100, points.length);

      // Determine whether 100 was found and
        // display an appropriate message.
        if (results == -1) {
            System.out.println("You did not "
                    + "earn 100 points on any score");
        } else {
            System.out.println("You earned 100 "
                    + "points on event " + (results + 1));
        }
    }

    /**
     * The sequentialSearch method searches an array for a value.
     *
     * @param array The array to search.
     * @param value The value to search for.
     * @param numElems Number of valid array elements (numElems <= array.length)
     * @return The subscript of the value if found in the array, otherwise -1.
     */
    public static int sequentialSearch(int[] array, int value, int numElems) 
    {
        int index;        // Loop control variable
        int element;      // Position the value is found at
        boolean found;    // Flag indicating search results

        index = 0;        // Start search at index zero
        element = -1;     // Set to default values;
        found = false;    // assuming not found

        // Begin search of array from index zero forward.  
        // Search while not found and not yet at end of list
        while (!found && index < numElems) {
            if (array[index] == value) // If found
            {
                found = true;             //   reset to terminate search
                element = index;          //   retain index of target value
            }
            index++;                      // Otherwise, advance to next element
        }

        return element;
    }
}
