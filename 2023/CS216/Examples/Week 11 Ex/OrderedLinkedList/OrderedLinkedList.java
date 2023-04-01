// Delta College - CST 283 - Klingler & Gaddis Text                  
// This class implements an ordered singly-linked list of objects.

public class OrderedLinkedList<ItemType  extends Comparable<ItemType>>
{
    // --------------------------------------------------------------
    // Private inner class definition of standard data node
    private class Node
    {
        ItemType value;   
        Node next;      

        // Construct node with data and reference to successor
        Node(ItemType val, Node n)
        {
            value = val;
            next = n;
        } 
        
        // Construct node with data null sucessor
        Node(ItemType val)
        {
           this(val, null);            
        }
    }	
    // --------------------------------------------------------------
	 
    private Node first;  // list head
    private Node last;   // last element in list
    
    private Node currentPos;  // Current position for iterator action
	     
    // --------------------------------------------------------------
    // No-arg constructor for linked list.  Declare empty; null out pointers
    public OrderedLinkedList()
    {
        first = null;
        last = null;        
    }
    
    // --------------------------------------------------------------
    // Observer to determine if list empty
    public boolean isEmpty()
    {        
        return first == null;       
    }
    
    // --------------------------------------------------------------
    // Get current (integer) length of list
    public int size()
    {
        int count = 0;
        Node currNode = first;     
        while (currNode != null)
        {
            count++;                    // Increment counter
            currNode = currNode.next;   // Advance to next node
        }
        return count;
    }
    
    // --------------------------------------------------------------
    // Method adds an element to the front of the list
    public void add(ItemType newElementData)
    {
        Node nodePtr, previousNode;
        
        Node newNode = new Node(newElementData);
        
        if (isEmpty())      // If list empty, simply add new element
        {
            first = newNode;
            last = first;
        }
        else   
        {
            // Initialize nodePtr to head of list and previousNode to null.
            nodePtr = first;
            previousNode = null;

            // Skip all nodes whose value member is less than newValue.
            while (nodePtr != null && nodePtr.value.compareTo(newElementData) < 0)
            {    
                previousNode = nodePtr;
                nodePtr = nodePtr.next;
            }

            // If the new node is to be the 1st in the list,
            // insert it before all other nodes.
            if (previousNode == null)
            {
                first = newNode;
                newNode.next = nodePtr;
            }
            else if (nodePtr == null)    // If the item to add is last in the list
            {
                previousNode.next = newNode;
                newNode.next = null;
                last = newNode;
            }
            else    // Otherwise, in middle.  Insert it after the prev. node.
            {
                previousNode.next = newNode;
                newNode.next = nodePtr;
            }
        }         
    }
     
    // --------------------------------------------------------------
    // Method removes an element by searching for and matching the value
    public boolean remove(ItemType element)
    {
        // Special case:  empty list - do nothing
        if (isEmpty()) 
            return false;      
      
        // Special case: element matched for deletion is first element
        if (element.equals(first.value))
        {
            first = first.next;
            if (first == null)
                last = null;       
            return true;
        }
      
        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null && !pred.next.value.equals(element))
        {
            pred = pred.next;
        }

        // If not found return false
        if (pred.next == null)
            return false;
      
        // Otherwise, element found and pred.next.value is element
        pred.next = pred.next.next;     // Bypass element to delete it
      
        // Special case: check if pred is now last
        if (pred.next == null)
            last = pred;
      
        return true;       
    }
    
    // --------------------------------------------------------------
    // Method searches for existence of target in list using linear 
    // search.  If matching (i.e. equals method returns true) object
    // in list overwrites parameter hence returning entire list object
    // by reference.
    // Param:  target.  Search target.
    // Return:  boolean.  Found target or did not find target
    public boolean contains(ItemType target)
    {
      boolean moreToSearch;
      Node nodePtr;

      nodePtr = first;                  // Start search from head of list
      boolean found = false;            // Assume value not found
      moreToSearch = (nodePtr != null);

      while (moreToSearch && !found)
      {
          if (target.equals(nodePtr.value))
          {
             found = true;
          }
          else
          {
             nodePtr = nodePtr.next;
             moreToSearch = (nodePtr != null);
          }
       }
       return found;
    }  
    
    // --------------------------------------------------------------
    // Observer function to return current list length 
    public void resetList()
    {
       currentPos = first;
    }
    
    // --------------------------------------------------------------
    // Function: Gets the next element in list as 
    //           referenced by currPtr
    // Pre:  Current position is defined.
    // Post: Current position is updated to next position.
    //       item is a copy of element at current position.
    public ItemType getNextItem() 
    {
      ItemType item;

      if (currentPos == null)   
        currentPos = first;           // Wrap if position is at end

      item = currentPos.value;        // Get item at current position
      currentPos = currentPos.next;   // Advance to next position

      return item;                    // Return item
    } 


    // --------------------------------------------------------------
    // Observer function to determine if current 
    // is the end of the list      
    public boolean atEnd()
    {
        if (currentPos == null)
           return true;
        else
           return false;  
    }
    
    // --------------------------------------------------------------
    // The toString method computes the string representation of the list.
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
      
        // Use currPos to walk down the linked list
        Node currPos = first;
        while (currPos != null)
        {
            strBuilder.append(currPos.value + "\n"); 
            currPos = currPos.next;
        }      
        return strBuilder.toString(); 
    }
}