// Delta College - CST 283 - Klingler & Dale text 
// Definition of class PQType, which represents the Priority Queue ADT
// An array is used to implement the heap for this data type

import java.util.ArrayList;

class PQtype<ItemType extends Comparable<ItemType>>
{
    private ArrayList<ItemType> elements;    // ArrayList to be allocated dynamically
    
     // -----------------------------------------------------------------------
   // Constructor to initialize heap
    public PQtype()
    {
        elements = new ArrayList<ItemType>();
    }
    
     // -----------------------------------------------------------------------
   // Adds newItem to the rear of the queue.
    // Pre:  Queue is not full.
    // Post: newItem is in the queue. 
    public void enqueue(ItemType newItem)
    {
        elements.add(newItem);
        reheapUp(0,elements.size()-1);
    }  
    
     // -----------------------------------------------------------------------
   // Removes element with highest priority from the queue and returns it in item.
    // Pre:  Queue is not empty.
    // Post: Highest priority element has been removed from the queue.
    //       item is a copy of the removed element.
    public ItemType dequeue()
    {
        ItemType returnItem = elements.get(0);
        int lastIndex = elements.size()-1;
        elements.set(0,elements.get(lastIndex));
        elements.remove(lastIndex);
        reheapDown(0, lastIndex-1);
        
        return returnItem;
    }
    
    // -----------------------------------------------------------------------
    // Determines whether the queue is empty.
    // Post: Function value = true if the queue is empty; false, otherwise    
    // Return true if heap array empty
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }
    
    // -----------------------------------------------------------------------
    // Return size of heap array
    public int size()
    {
        return elements.size();
    }
    
    // -----------------------------------------------------------------------
    // Returns string containing current heap contents
    public String toString()
    {
                String outputString = "";
        for (ItemType anItem: elements)
            outputString += anItem.toString() + "\n";
        return outputString;
    }    

    // -----------------------------------------------------------------------
    // This method performs the REHEAP DOWN action to restore
    // a binary tree to a heap after a removal from the root
    // Postcondition: Heap property is restored.
    private void reheapDown(int root, int bottom) 
    {
        int maxChild;
        int rightChild;
        int leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        if (leftChild <= bottom) {
            if (leftChild == bottom) 
                maxChild = leftChild;
            else
                if (elements.get(leftChild).compareTo(elements.get(rightChild)) <= 0) 
                    maxChild = rightChild;
                else
                    maxChild = leftChild;
            if (elements.get(root).compareTo(elements.get(maxChild)) < 0)
            {
                swap(root, maxChild);
                reheapDown(maxChild, bottom);
            }
        }
    }

    // -----------------------------------------------------------------------
    // This method performs the REHEAP UP action to restore
    // a binary tree to a heap after addition of an item at
    // the bottom open position
    // Postcondition: Heap property is restored.
    private void reheapUp(int root, int bottom) 
    {
        int parent;
        if (bottom > root) 
        {
            parent = (bottom - 1) / 2;
            if (elements.get(parent).compareTo(elements.get(bottom)) < 0)
            {
                swap(parent, bottom);
                reheapUp(root, parent);
            }
        }
    }
    
    // -----------------------------------------------------------------------
    // A swap function for the 'elements' array.
    private void swap(int fromIndex, int toIndex) 
    {
        ItemType temp = elements.get(fromIndex);
        elements.set(fromIndex, elements.get(toIndex));
        elements.set(toIndex, temp);
    } 
}
