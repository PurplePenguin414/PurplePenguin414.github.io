// Delta College - CST 283 - Klingler             
// This class is a test driver for a simple priority queue of integers.

import java.util.Scanner;
import java.io.*;

public class TestPQ 
{
    private static PQtype<Integer> thePQ;
    
    public static void main(String[ ] args)
    {          
        thePQ = new PQtype<Integer>();

        // Complete test plan
        thePQ.enqueue(15);
        thePQ.enqueue(24);
        thePQ.enqueue(65);
        thePQ.enqueue(10);
        thePQ.enqueue(88);
        
        System.out.println("AFTER ENQUEUE SET 1");
        System.out.println(thePQ.toString());   // Write entire queue
        
        thePQ.enqueue(11);
        thePQ.enqueue(25);
        thePQ.enqueue(55);
        thePQ.enqueue(77);        
        
        System.out.println("AFTER ENQUEUE SET 2");
        System.out.println(thePQ.toString());   // Write entire queue
               
        System.out.println("DEQUEUE");
        System.out.println(thePQ.dequeue());   
        System.out.println(thePQ.dequeue());           
        System.out.println(thePQ.dequeue());          
    }

}

