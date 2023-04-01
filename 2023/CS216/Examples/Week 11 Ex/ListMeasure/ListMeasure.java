// Delta College - CST 283 - Klingler                  
// This application performs a large number of insertions, searchs, and
// deletions between a linked list and the Java ArrayList.  It measures
// the "work" completed in real-time.

import javax.swing.JOptionPane;
import java.util.*;       

public class ListMeasure
{     
    public static void main(String [] args)
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>();        
        ArrayList<Integer> list2 = new ArrayList<Integer>();    

        Random randomNumbers = new Random();  

        // -----------------------------------------------------
        
        System.out.println("\nLinked List");
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) 
        {
            list1.add(randomNumbers.nextInt());
        }
        for (int i = 1; i <= 10000; i++) 
        {
            Integer anInt = randomNumbers.nextInt();
            if (list1.find(anInt) == true)
                list1.remove(anInt);
        }

        long stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");

        // -----------------------------------------------------
        
        System.out.println("\nArrayList");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) 
        {
            list2.add(randomNumbers.nextInt());
        }

        for (int i = 1; i <= 10000; i++) 
        {
            Integer anInt = randomNumbers.nextInt();
            if (list2.contains(anInt))
                list2.remove(anInt);
        }

        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");

        
    }  
}
