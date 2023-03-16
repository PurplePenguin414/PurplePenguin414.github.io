// Delta College - CST 283 - Klingler & Gaddis Text                  
// A generic linked queue class.

public class LinkedQueueDemo
{
    public static void main(String [] args)
    {
        LinkedQueue<Date> queue = new LinkedQueue<Date>();
       
        Date aDate;
        
        aDate = new Date(12,25,2016);
        queue.enqueue(aDate);
         aDate = new Date(7,4,2016);
        queue.enqueue(aDate);
        aDate = new Date(2,29,2016);
        queue.enqueue(aDate);
        
        System.out.println("\nState of queue is:");
        System.out.println(queue);
        System.out.println("\n\n");
    }
}