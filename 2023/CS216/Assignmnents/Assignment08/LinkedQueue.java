// Delta College - CST 283 - gibbs                  
// A generic linked queue class.

class LinkedQueue<ItemType>
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
   
    private Node front; 
    private Node rear; 
    
    // -----------------------------------------------------
    
    // No-arg constructor
    public LinkedQueue()
    {
        front = null;
        rear  = null; 
    }   
        
    // The method enqueue adds a value to the queue.
    // Parameter s is the value to be added to the queue.
    public void enqueue(ItemType newItem)
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
    public ItemType peek()
    {
        return front.value;        
    }
    
    // The dequeue method removes and returns the item at the front of the queue.
    // Returns item at front of queue
    public ItemType dequeue()
    {
           ItemType returnItem = front.value;
           front = front.next;
           if (front == null) 
                rear = null;    
           return returnItem;
    }
    
    // Returns string representation of items of queue.
    // Queue elements are listed front to rear.
    public String toString()
    {
        String outString = "";
        
        Node p = front;
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