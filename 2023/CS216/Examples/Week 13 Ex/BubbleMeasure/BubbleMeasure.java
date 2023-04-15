// Delta College - CST 283 - Klingler  
// This program demonstrates real-time computing requirements
// necessary to perform the bubble sort on large lists.

import java.util.Random; 
import java.text.SimpleDateFormat;

public class BubbleMeasure
{   
    final static int MAXPOWER_OF_2 = 25;

    public static void main( String args[])
    {
        // Time variables
        long startTime, endTime;   
        long currentTime;
        double elapsed;             // To measure computing time as decimal
        int theArray[];             // Array to sort
        
        StopWatch timer = new StopWatch();
         
        // Set up for date/time formatting
        SimpleDateFormat time_formatter 
                 = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

        // Perform test: randomize array, mark time, sort, mark
        // time again.  Report elapsed time.  Increment array
        // size by 10 and repeat
        for (int size = 2; size <= Math.pow(2,MAXPOWER_OF_2); size *= 2)
        {
           theArray = new int[size];
           timer.reset();

           makeRandArray(theArray);   // Create random array

           // Perform Bubble Sort - marking time before/after
           timer.start();
           bubbleSort(theArray);
           timer.stop();

           // Calculate results as decimal seconds
           elapsed = timer.getElapsedTime() / 1000.0;
           
           // Report this experiment along with ending time
           System.out.print("Sorting " + size + " elements: " +
                      String.format("%8.4f second(s)",elapsed) +" - ending ");

           
           
           // Write current local date/time
           System.out.println(time_formatter.format(System.currentTimeMillis()));                
        }
        
        System.exit(0);
    }

    /************************************************************/
    // Bubble Sort - sort an array of integers
    /************************************************************/
    public static void bubbleSort(int[] array)
    {
        int lastPos;     
        int index;       
        int temp;    
      
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
        {
            for (index = 0; index <= lastPos - 1; index++)
            {
                if (array[index] > array[index + 1])
                {
                   temp = array[index];
                   array[index] = array[index + 1];
                   array[index + 1] = temp;
                }
             }
        }
    }

    /************************************************************/
    // Method creates an array of n elements that initially
    // include 1,2,...,n.  Elements are randomized and array is
    // returned.
    /************************************************************/
    public static void makeRandArray(int theArray[])
    {        
        Random randomNumGen = new Random(); 
        int index1, index2, temp;
        
        // Initally, populate array data as actual index
        for (int i = 0; i < theArray.length; i++ )
        {
             theArray[i] = i;
        }

        // Next, make 10 passes through array swapping elements
        // at random.
        for (int i = 0; i < 10 * theArray.length; i++ )
        {
            // Generate two random indexes
            index1 = randomNumGen.nextInt(theArray.length);
            index2 = randomNumGen.nextInt(theArray.length);
            
            // Swap array elements ad indexes
            temp = theArray[index1];
            theArray[index1] = theArray[index2];             
            theArray[index1] = temp;
        }
    }
}

