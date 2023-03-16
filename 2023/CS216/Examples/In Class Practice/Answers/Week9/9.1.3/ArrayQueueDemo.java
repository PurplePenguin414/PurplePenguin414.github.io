/**
   Delta College - CST 283 - Klingler & Gaddis Text  
   The ArrayQueueDemo demonstrates the use of the ArrayQueue class.
*/

public class ArrayQueueDemo
{
    public static void main(String [] args)
    {    
       String str;  // Holds various string values
            
       StringQueue queue = new StringQueue(4);
       str = "Queue has capacity ";
       System.out.println(str + queue.capacity());
       System.out.println("State of queue is: ");
       System.out.println(queue);
       
       // Add 4 names
       String [ ] names 
             = {"Alfonso", "Bob", "Carol", "Deborah"};
       System.out.println("Adding names: ");
       for (String s : names)
       {
           System.out.print(s + " ");
           queue.enqueue(s);         
       }
       System.out.println("\nState of queue is: ");
       System.out.println(queue);
       
       // Remove 2 names
       System.out.println("Removing 2 names.");
       queue.dequeue(); queue.dequeue();   
       System.out.println("State of queue is: ");
       System.out.println(queue);
       
       // Add a name
       System.out.println("Adding the name Elaine:");
       queue.enqueue("Elaine");
       System.out.println("State of queue is: ");
       System.out.println(queue);       
       
       // Create 2nd queue
       
       StringQueue queue2 = new StringQueue(4);
       queue.enqueue("Carol");
       queue.enqueue("Deborah");
       
       if (queue.equals(queue2))
           System.out.println("EQUAL");
       else
           System.out.println("UNEQUAL");

       queue2 = new StringQueue(queue);         
       System.out.println(queue2);  
         
       if (queue.equals(queue2))
           System.out.println("EQUAL");
       else
           System.out.println("UNEQUAL");
    }    
}