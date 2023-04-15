// Delta College - CST 283 - Klingler                  
// This application performs a large number of insertions, searchs, and
// deletions between a linked list, the Java ArrayList, and a binary search
// tree.  It measures the "work" completed in real-time.

import javax.swing.JOptionPane;
import java.util.*;       

public class DataMeasure
{     
    public static void main(String [] args)
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>();        
        ArrayList<Integer> list2 = new ArrayList<Integer>();    
        BinarySearchTree<Integer> aTree = new BinarySearchTree<Integer>();    
        ChainHashTable<MyInteger> bucketChain = new ChainHashTable<MyInteger>();   
        
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
            if (list1.contains(anInt) == true)
                list1.remove(anInt);
        }

        long stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.\n");

        // -----------------------------------------------------
        
        System.out.println("ArrayList");
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
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.\n");
        
        // -----------------------------------------------------
        
        System.out.println("Binary Search Tree");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) 
        {
            aTree.add(randomNumbers.nextInt());
        }

        for (int i = 1; i <= 10000; i++) 
        {
            Integer anInt = randomNumbers.nextInt();
            if (aTree.contains(anInt))
                aTree.remove(anInt);
        }

        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.\n");

        // -----------------------------------------------------
        
        System.out.println("Chained Hash Table");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) 
        {
            MyInteger newInt = new MyInteger(randomNumbers.nextInt());
            bucketChain.add(newInt);
        }

        for (int i = 1; i <= 10000; i++) 
        {
            MyInteger anInt = new MyInteger(randomNumbers.nextInt());
            if (bucketChain.contains(anInt))
                bucketChain.remove(anInt);
        }

        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.\n");

               
    }  
}
