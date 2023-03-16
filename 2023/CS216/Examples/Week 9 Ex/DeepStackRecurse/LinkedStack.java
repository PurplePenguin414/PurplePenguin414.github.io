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
    // "this" stack.  A recursive approach is included.
    public LinkedStack(LinkedStack<ItemType> anotherStack)
    {    
	    this.top = clone(anotherStack.top); 
    }
    
    // This recursive method receives a reference to a node.  It instantitates
    // the a new node and then recursively continues using the 'next' reference.
    private Node clone(Node aNode)
    {
        if(aNode == null)
            return null;
        else
            return new Node(aNode.value, clone(aNode.next) );
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