/**
 * This class manages an ordered list of integers.  Length of file
 * unknown but it does not exceed 1000 as precondition.
 * @author      Delta College - CST 283 - Klingler        
 */

import java.util.Scanner;
import java.io.*;

public class OrderList
{
    public static final int LIST_CAPACITY = 1000;  // Default max size of array
    enum SortState { ASCENDING, DESCENDING, UNSORTED }
  
    private int data[];            // Reference for data array
    private int numElems;          // Number of actual data elements stored in array
    private File inputfile;        // Reference for input file
    private boolean listStatusOK;  // Status of relative to file input
    private SortState sortStatus;  // Either ASCENDING or DESCENDING
    private int currentPosition;   // Used as index marker for iterator operations
    
    /**
    * Constructor - No-arg - Create a new empty list
    * @pre     list is initially in an ascending ordered state
    */
    public OrderList()
    {
        data = new int[LIST_CAPACITY];   
        sortStatus =  SortState.ASCENDING;
    }
    
    /**
    * Constructor
    * @param   filename    string value of local filename containing data
    * @param   state       enumerated type defining current state of list
    * @pre     list is initially in an ascending ordered state
    * @post    if list is initially unordered at construction, it is sorted ascending  
    */
    public OrderList(String filename, SortState state)
    {
        sortStatus   = state;     // Capture sort state of file being read in
        listStatusOK = false;     // Initialize to not OK until file loaded
        
        // Create file input object and attempt to instantiate scanner object 
        try
        {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(filename);  // Create file input object
            inputFileScanner = new Scanner(inputfile);
            
            data = new int[LIST_CAPACITY];    
            
            // File processing loop - Continue while not empty
            // Read file element and store in array
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                data[i] = inputFileScanner.nextInt();  // Capture next string
                i++;                                   // Advance array marker
            }
            numElems = i;
            
            if (numElems > 0)                        // Declare list file input OK
                listStatusOK = true;
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, reset list status flag
        {
            listStatusOK = false;
        }
        
        // If list OK but came into object instance unordered, sort it ascending
        if (listStatusOK == true && sortStatus == SortState.UNSORTED)
        {
            sortList(SortState.ASCENDING);
        }
    }
       
    /**
    * Accessor for list file status
    * @return   boolean indicating status of file.  True if file loaded OK; false otherwise.
    */
    public boolean statusOK()
    {
        return listStatusOK;
    } 
    /**
    * Accessor for list size
    * @return   Number of element sin list
    */
    public int getNumElems()
    {
        return numElems;
    }    
     
    /**
    * Accessor for list capacity
    * @return   Number of element sin list
    */
    public int getCapacity()
    {
        return LIST_CAPACITY;
    }     
    
     /**
    * Observer returning whether or not list is full
    * @return   true if list is full, false otherwise
    */
    public boolean isFull()
    {
        if (numElems == LIST_CAPACITY)
            return true;
        else
            return false;
    } 
    
    /**
    * Insert new element into the list.  List ordering is preserved.
    * @param   newElement   Element to be added to the list in proper position.
    * @pre     List array has at least one more position available    
    */
    public void insert(int newElement)
    {
        // Locate position to insert value at - index ptr
        int ptr = 0;
        if (sortStatus == SortState.ASCENDING)
            while (newElement > data[ptr] && ptr < numElems)    
                ptr++;
        if (sortStatus == SortState.DESCENDING)
            while (newElement < data[ptr] && ptr < numElems)    
                ptr++;
               
        // Move all successors down one array position:  bottom-up
        for (int i = numElems; i > ptr; i--)
            data[i] = data[i-1];
   
        // Insert net item   
        data[ptr] = newElement;
     
        // Adjust number of elements in list  
        numElems++;                                 
    }
    
    /**
    * Delete existing element into the list.  List ordering is preserved.
    * If element is not in list, nothing is done.
    * @param   oldElement to be deleted.
    */
    public void delete(String oldElement)
    {
        // Locate item to delete
        int ptr = 0;
        while (!oldElement.equals(data[ptr]) && ptr < numElems)    
            ptr++;
   
        // Move all successors up one position - deleting target value           
        for (int i = ptr; i < numElems - 1; i++)
            data[i] = data[i+1];
           
        // Adjust number of elements in list  
        numElems--;                                 
    }
    
    /**
     * The binary method searches an array for a specific string.
     *
     * @param target  String to search for in list
     * @return The subscript of the value if found in the array, otherwise -1.
     */    
    public int search(int target) 
    {
        int first = 0,                 // Index of first array element
            last = numElems - 1,       // Index of last good array element
            middle,                    // Mid point of search
            position = -1;             // Position of search value
            boolean found = false;     // To indicate if found or not

        while (!found && first <= last)
        {
            middle = (first + last) / 2;      // Calculate mid point
            if (data[middle] == target)       // If value is found at mid
            {
                found = true;
                position = middle;
            }
            else if ( (sortStatus == SortState.ASCENDING && 
                       data[middle] > target)  
                 ||   (sortStatus == SortState.DESCENDING && 
                       data[middle] < target) )            
                last = middle - 1;
            else
                first = middle + 1;          // If value is in upper half
            
        }
        return position;
    }
 
    /**
    * Perform bubble sort on list either ascending or descending as indicated
    * by parameter.
    */
    public void sortList(SortState desiredState)
    {
        sortStatus = desiredState;      // Reset list state to desired order
        
        // Perform bubble sort to define list 
        int lastPos;     
        int index;       
        int temp;     
      
        for (lastPos = numElems - 1; lastPos >= 0; lastPos--)
        {
            for (index = 0; index <= lastPos - 1; index++)
            {
                // Compare an element with its neighbor.  Swap if out of order
                if ( (sortStatus == SortState.ASCENDING && 
                      data[index] > data[index + 1] )
                ||   (sortStatus == SortState.DESCENDING && 
                      data[index] < data[index + 1]) )
                {
                   // Swap the two elements.
                   temp = data[index];
                   data[index] = data[index + 1];
                   data[index + 1] = temp;
                }
             }
        }
    }
  
    /**
    * Merges ordered list passed in as parameter into itself.  
    * @post "This" list includes ordered list combining both.
    */
    public OrderList mergeLists(OrderList secondList)
    {
        int ptr1, ptr2, outPtr;
        ptr1 = 0;
        ptr2 = 0;
        outPtr = 0;
        
        int outListCapacity = this.getCapacity() + secondList.getCapacity();
        OrderList outList = new OrderList();
   
        // While neither list empty, merge lists
        while (ptr1 < this.numElems && ptr2 < secondList.numElems)
        {
            if (this.data[ptr1] < secondList.data[ptr2])
            {
                outList.data[outPtr] = this.data[ptr1];
                ptr1++;
            }
            else
            {
                outList.data[outPtr] = secondList.data[ptr2];
                ptr2++;
            }
            outPtr++;   
        }

        // While items remain in list 1, fill end of output list
        while (ptr1 < this.numElems)
        {
            outList.data[outPtr] = this.data[ptr1];
            ptr1++;
            outPtr++;
        }

        // While items remain in list 2, fill end of output list
        while (ptr2 < secondList.numElems)
       {
            outList.data[outPtr] = secondList.data[ptr2];
            ptr2++;
            outPtr++;
        }
        outList.numElems = outPtr;        // Capture number of items in final list
        return outList;
    }
         
    /**
    * Merges ordered list passed in as parameter into itself.  
    * @pre  List is ordered and may contain duplicate entries.
    * @post List remains ordered and all elements are unique.
   */
    public void removeDuplicates()
    {
        int i,j;
        i = 0;
        while (i < numElems - 1)                     // For all list elements (up to last)
        {
            if (data[i] == data[i+1])                // if next list item is duplicate
            {
                for (j = i; j < numElems - 1; j++)   //   then move elements back one space
                    data[j] = data[j+1];             //   to overlay the duplicate
                numElems--; 
            }
            else
                 i++;                                // otherwise, go to next element 
        } 
    }
 
    /**
    * Iterator action - reset current position to preceed first element (-1)
    */
    public void resetList()
    {
        currentPosition = -1;
    }


   /**
    * Iterator action - Advance to next position and retrieve integer item there
    * @return List element at current position
    */
    public int getNextItem()
    {
        currentPosition++;              // Advance to next position
        return data[currentPosition];  // Get data at current position
    }

   /**
    * Iterator action - Determines if at end of list (currPos == size)  
    * @return List element at current position
    */
   public boolean atEnd()
   {
        if (currentPosition == (numElems - 1))
            return true;
        else
            return false;
    }
       
    /**
    * Return list as a string with elements separated by line feeds.
    */
    public String toString()
    {
        String outString = "";
        for (int i = 0; i < numElems; i++)
            outString += data[i] + "\n";
        
        return outString;
    }

    /**
    * Send list to text file - filename passed in as parameter
    */
    public void writeToFile(String outputfilename)
    {
        try
        {
            // Delclare and instantiate output writer object
            PrintWriter outputfileWriter;      
            outputfileWriter = new PrintWriter(outputfilename); 

            // Write data to file
            for (int i = 0; i < numElems; i++)
            {
                outputfileWriter.println(data[i]);
            }
            outputfileWriter.close();
        }
        catch (IOException e)  
        {
            listStatusOK = false;
        }
    }
}
