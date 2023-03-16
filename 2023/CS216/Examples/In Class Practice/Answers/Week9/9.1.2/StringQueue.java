/**
 * Delta College - CST 283 - Klingler & Gaddis Text
 * This class defines an array-based queue for String data.
 */

import java.util.*;

class StringQueue 
{
    private String[] qArray; // Holds queue elements
    private int front;         // Next item to be removed
    private int rear;          // Next slot to fill
    private int size;          // Number of items in queue   

    /**
     * Constructor.
     *
     * @param capacity The capacity of the queue.
     */
    StringQueue(int capacity) 
    {
        qArray = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * The capacity method returns the length of the array used to implement the
     * queue.
     *
     * @return The capacity of the queue.
     */
    public int capacity() 
    {
        return qArray.length;
    }

    /**
     * The enqueue method adds an element to the queue.
     *
     * @param s The element to be added to the queue.
     * @pre Queue is not full
     */
    public void enqueue(String s) 
    {
        size++;
        qArray[rear] = s;
        rear++;
        if (rear == qArray.length)
            rear = 0;
    }

    /**
     * The peek method returns the item at the front of the queue.
     *
     * @return element at front of queue.
     * @pre Queue is not empty.
     */
    public String peek() 
    {
        return qArray[front];
    }

    /**
     * The dequeue method removes and returns the element at the front of the
     * queue.
     *
     * @return The element at the front of the queue.
     * @pre Queue is not empty.
     */
    public String dequeue() 
    {
        size--;
        // Remove from front
        String value = qArray[front];

        // Facilitate garbage collection  
        qArray[front] = null;

        // Update front
        front++;
        if (front == qArray.length)
            front = 0;

        return value;
    }

    /**
     * The empty method checks to see if this queue is empty.
     *
     * @return true if the queue is empty and false otherwise.
     */
    public boolean isEmpty() 
    {
        return size == 0;
    }
    /**
     * The empty method checks to see if this queue is full.
     *
     * @return true if the queue is full and false otherwise.
     */
 
    public boolean isFull() 
    {
        return size == qArray.length;
    }
    
    /**
     * The toString method returns a readable representation of the contents of
     * the queue.
     *
     * @return The string representation of the contents of the queue.
     */
    public String toString() 
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("front = " + front + "; ");
        sBuilder.append("rear = " + rear + "\n");
        for (int k = 0; k < qArray.length; k++) 
        {
            if (qArray[k] != null) 
                sBuilder.append(k + " " + qArray[k]);
            else
                sBuilder.append(k + " ?");
            sBuilder.append("\n");
        }
        if (isFull())
             sBuilder.append("Queue FULL\n");
         if (isEmpty())
             sBuilder.append("Queue EMPTY\n");
         sBuilder.append("\n\n");
             
        return sBuilder.toString();
    }
}
