// Delta College - CST 283 - Klingler & Gaddis Text                  
// A generic linked stack class.

class LinkedStack<ItemType>
{
    // -----------------------------------------------------
    // The Node class is used to implement the linked list.
  
    private class Node
    {
        ItemType value;
        Node next;
        Node(ItemType val, Node n)
        {
            value = val; 
            next = n;
        }       
    }
    // -----------------------------------------------------
   
    private Node top;  // Top of the stack
    
     // -----------------------------------------------------
    
    // No-arg consgtructor
    public LinkedStack()
    {
        top = null;
    }
    
    // Copy constructor.  Constructs deep copy from anotherStack to
    // "this" stack.
    public LinkedStack(LinkedStack<ItemType> anotherStack)
    {    
        Node ptr1;    // Reference for stack to copy from
        Node ptr2;    // Reference for stack to copy to ("this")
        
        if ( anotherStack.top == null )
            this.top = null ;
        else                  
        {    
             // Allocate first node
            this.top = new Node(anotherStack.top.value,null);
            ptr1 = anotherStack.top.next;
            ptr2 = this.top;
            while ( ptr1 != null )    // Deep copy other nodes
            {   
                ptr2.next = new Node(null,null);
                ptr2 = ptr2.next ;
                ptr2.value = ptr1.value;
                ptr1 = ptr1.next ;
            }
            ptr2.next = null ;    
        }
    }
        
    // The empty method checks for an empty stack.
    // Return true if stack is empty, false otherwise.
    public boolean isEmpty()
    {
        return top == null;
    }
    
    // The push method adds a new item to the stack.
    // Parameter s The item to be pushed onto the stack.
    public void push(ItemType newItem)
    {
        top = new Node(newItem, top);
    }
    
    // The Pop method removes the value at the top of the stack.
    // Return value at the top of the stack.
    public ItemType pop()
    {         
        ItemType retValue = top.value;
        top = top.next;            
        return retValue;    
    } 
    
    // The peek method returns the top value on the stack.
    // Removes and returns the value at the top of the stack.
    public ItemType peek()
    {
        return top.value;
    }
    
    // The toString method returns a string representation of
    // the contents of the stack.
    public String toString()
    {
        String outString = "";
        
        Node p = top;
        while (p != null)
        {
            outString += p.value.toString();            
            p = p.next;
            if (p != null)
                outString += "\n";
        }
        return outString;
    }
}