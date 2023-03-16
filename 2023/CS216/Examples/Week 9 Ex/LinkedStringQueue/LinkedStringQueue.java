// Delta College - CST 283 - Klingler & Gaddis Text                  
// A linked queue of String objects.

class LinkedStringQueue
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
   
    private Node front; 
    private Node rear; 
    
    // -----------------------------------------------------
    
    // No-arg constructor
    public LinkedStringQueue()
    {
        front = null;
        rear  = null; 
    }   
        
    // The method enqueue adds a value to the queue.
    // Parameter s is the value to be added to the queue.
    public void enqueue(String newItem)
    {
        if (rear != null)
        {
           rear.next = new Node(newItem, null);
           rear = rear.next;
        }
        else
        {
            rear = new Node(newItem, null);
            front = rear;
        }
    }
    
    // The empty method checks to see if the queue is empty.
    // Returns true if and only if queue is empty.
    public boolean isEmpty()
    {
        return front == null;
    }
    
    // The method peek returns value at the front of the queue.
    // Postcondition: Front item not removed
    public String peek()
    {
        return front.value;        
    }
    
    // The dequeue method removes and returns the item at the front of the queue.
    // Returns item at front of queue
    public String dequeue()
    {
           String returnItem = front.value;
           front = front.next;
           if (front == null) 
               rear = null;    
           return returnItem;
    }
    
    // Returns string representation of items of queue.
    public String toString()
    {
       StringBuilder sBuilder = new StringBuilder();
       
       // Walk down the list and append all values
       Node p = front;
       while (p != null)
       {
           sBuilder.append(p.value + " ");
           p = p.next;
       }
       return sBuilder.toString();        
    }
}