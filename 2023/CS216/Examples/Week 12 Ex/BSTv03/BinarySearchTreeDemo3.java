// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree of integers.
// Features testing:  size and depth

import javax.swing.*;
import java.util.Random;

public class BinarySearchTreeDemo3
{
    private static int MAX_TREE_SIZE = 10000000;   // 10 million
    
    public static void main(String[ ] args)
    {	        
         BinarySearchTree<Integer> theTree;  
         
         Random randomNumbers = new Random(); 
         int valueToAdd;
         String outputMessage = "";
         
         // Generate random inserts of integers into tree and measure size and depth
         for (int numberInserts = 1; numberInserts <= MAX_TREE_SIZE; numberInserts *= 10)
         {
             // Regenerate new tree
             theTree = new BinarySearchTree<Integer>();  

             // Insert random integers
             for (int i = 1; i <= numberInserts; i++)
             {
                valueToAdd = randomNumbers.nextInt();    
                theTree.add(valueToAdd);
             }

             // Add results to output message
             outputMessage += "Inserts: " + theTree.size() 
                       + "     Depth: "   + theTree.treeDepth() + "\n";
         }
         
         // Write output message
         JOptionPane.showMessageDialog( null, outputMessage,
            "Tree Depth Analysis", JOptionPane.INFORMATION_MESSAGE );

    }   
}