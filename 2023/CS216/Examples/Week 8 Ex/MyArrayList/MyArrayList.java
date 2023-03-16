/**
 * This class attempts to replicate the "behind-the-scenes" implementation of
 * the Java ArrayList class.  Class implemented as a generic to allow array-based
 * list of any type (a class; no primitives).
 */

public class MyArrayList<ItemType>
{
    private Object list[];         // Reference for data array
    private int numElems;          // Number of actual data elements stored in array
    private int listCapacity;      // Number of actual data elements stored in array

    public static final int INITIAL_LIST_LIST_CAPACITY = 10;    // Default initial max size of array

    // -------------------------------------------------------------------------------------------

    // No-arg constructor.  Create object with default number of elements
    public MyArrayList() {
        list = new Object[INITIAL_LIST_LIST_CAPACITY];
        listCapacity = INITIAL_LIST_LIST_CAPACITY;
        numElems = 0;
    }

    // Parameterized constructor.   Create object with default size passed in as parameter
    public MyArrayList(int initCapacity) {
        list = new Object[initCapacity];
        listCapacity = initCapacity;
        numElems = 0;
    }

    // -------------------------------------------------------------------------------------------

    // Add an element to the list at the end.  First, insure capacity and increase it if the
    // addition will fill up the current list.
    public void add(ItemType newItem)
    {
        if (numElems+1 == listCapacity)
            increaseArrayCapacity();

        list[numElems] = newItem;
        numElems++;

    }

    // Add an element to the list at a given index.  First, insure capacity and increase it if the
    // addition will fill up the current list.  Move all subsequent elements down one position to
    // make room.
    public void add(ItemType addItem, int index)
    {
        if (index < numElems && (numElems+1) == listCapacity)
            increaseArrayCapacity();

        for (int i = numElems; i > index; i--)
            list[i+1] = list[i];

        list[index] = addItem;

    }

    // Private method to increase capacity of array of objects when needed.  Will bump up
    // capacity by an additional 50% of current level.  Strategy is to move elements to
    // a temporary array, re-instantiate primary array to larger size and then move items
    // back over.
    private void increaseArrayCapacity()
    {
        listCapacity = 3 * listCapacity / 2;            // Increase list capacity by 50%

        Object tempList[] = new Object[listCapacity];   // Instantiate temporary storage array

        for (int i = 0; i < numElems; i++)              // Move existing items to temp array
            tempList[i] = list[i];

        list = new Object[listCapacity];                // Re-instantiate primary storage array

        for (int i = 0; i < listCapacity; i++)          // Move all objects back from temp array
            list[i] = tempList[i];                      // to primary array.
    }

    // -------------------------------------------------------------------------------------------

    // Remove a list element at a provided index.  All subsequent elements moved up.
    public void remove(int index)
    {
        if (index < numElems) {
            for (int i = index; i < numElems - 1; i++)
                list[i] = list[i + 1];
        }
    }

    // Remove a list element matching the parameter passed in.   All subsequent elements moved up.
    public void remove(ItemType itemToDelete)
    {
        int i = 0;
        while (!list[i].equals(itemToDelete) && i < numElems)
            i++;
        int targetIndex = i;

        if (i < numElems)
        {
            for (i = targetIndex; i < numElems - 1; i++)
                list[i] = list[i + 1];
        }
    }

    // -------------------------------------------------------------------------------------------

    // Search routine to return index of first occurrence of target object.  If object not
    // found, index -1 is returned.
    public int indexOf(ItemType searchTarget)
    {
        int returnIndex = -1;
        for(int i = 0; i < numElems - 1; i++)
        {
            if (list[i].equals(searchTarget))
                returnIndex = i;
        }
        return returnIndex;
    }

    // Get element at provided index.  If index past list size, null is returned.
    public ItemType get(int index)
    {
        if (index < numElems)
            return (ItemType) list[index];
        else
            return null;
    }

    // Set element at provided index.  If index is past list size, operation ignored.
    public void set(int index, ItemType replacementItem)
    {
        if (index < numElems)
            list[index] = replacementItem;
    }

    // Return current number of data elements stored in list.
    public int getListSize()
    {
        return numElems;
    }

    // Return current number of data elements stored in list.
    public int getListCapacity()
    {
        return listCapacity;
    }

}
