// This example validates a sequence of stack and queue operations

public class StackQueueDemo
{
    public static void main(String [] args)
    {    
       StringStack stack = new StringStack(50);
       StringQueue queue = new StringQueue(50);
       
       stack.push("AB");
       stack.push("XY");       
       queue.enqueue("JK");
       queue.enqueue(stack.pop());
       System.out.println(stack.peek());
       stack.push("JV");
       stack.push("PQ");
       queue.enqueue("SD");
       System.out.println(queue.peek());
       stack.pop();
       System.out.println(stack.peek());
       stack.push(queue.dequeue());
       queue.enqueue("CV");
       queue.enqueue("SA");
       stack.pop();
       while (!queue.isEmpty())
          stack.push(queue.dequeue());
       while (!stack.isEmpty())
          System.out.println(stack.pop());
    }    
}