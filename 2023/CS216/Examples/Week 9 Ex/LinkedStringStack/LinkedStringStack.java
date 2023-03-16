// Delta College - CST 283 - Klingler & Gaddis Text                  
// A linked stack of String objects.

class LinkedStringStack
{
    // -----------------------------------------------------
    // The Node class is used to implement the linked list.
  
    private class Node
    {
        String value;
        Node next;
        Node(String val, Node n)
        {
            value = val; 
            next = n;
        }       
    }
    // -----------------------------------------------------
   
    private Node top;  // Top of the stack
    
     // -----------------------------------------------------
    
    // No-arg constructor
    public LinkedStringStack()
    {
        top = null;
    }
    
    // The empty method checks for an empty stack.
    // Return true if stack is empty, false otherwise.
    public boolean isEmpty()
    {
        return top == null;
    }
    
    // The push method adds a new item to the stack.
    // Parameter s The item to be pushed onto the stack.
    public void push(String s)
    {
        top = new Node(s, top);
    }
    
    // The Pop method removes the value at the top of the stack.
    // Return value at the top of the stack.
    public String pop()
    {         
            String retValue = top.value;
            top = top.next;            
            return retValue;    
    } 
    
    // The peek method returns the top value on the stack.
    // Removes and returns the value at the top of the stack.
    // Postcondition: Front item not removed
    public String peek()
    {
          return top.value;
    }
    
    // The toString method returns a string representation of
    // the contents of the stack.
    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();
        Node p = top;
        while (p != null)
        {
            sBuilder.append(p.value);            
            p = p.next;
            if (p != null)
        sBuilder.append("\n");
        }
        return sBuilder.toString();
    }
}