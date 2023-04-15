// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree of integers.
// Features testing:  retrieve

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class BinarySearchTreeDemo4
{
    private static BinarySearchTree<Data> theTree;
    
    public static void main(String[ ] args)
    {	        
        // Instantiate search tree and load from file
        theTree = new BinarySearchTree<Data>();  
        loadTree();
        
        String outputMessage = "";
         
        // Get key from user
        String inputStr = JOptionPane.showInputDialog("Enter search key (test with '324'):");
        int key = Integer.parseInt(inputStr);
        
        // Instantiate Data object with key entered from user
        Data searchTarget = new Data(key,-9999);
        
        // Using Data with key, search to find object in tree.  If found,
        // populate remaining info in object.
        Data searchResult = theTree.retrieve(searchTarget);
        if (searchResult != null)
            outputMessage = "For key: " + key +
                             "  Data: " + searchResult.getData();
        else
            outputMessage = "For key: " + key +
                             "  No Data Found";
        
        // Write output message
        JOptionPane.showMessageDialog( null, outputMessage,
            "Tree Depth Analysis", JOptionPane.INFORMATION_MESSAGE );
           
        // --------------------------------------------------------------------------   
            
        // Traverse tree INORDER and flatten into a linear (queue) format
        Data aDataItem;
        
        System.out.println("\nIN-ORDER");
        LinkedQueue<Data> dataSequence = new  LinkedQueue<Data>();
        dataSequence = theTree.traverseInOrder();
        while (!dataSequence.isEmpty())
        {
           aDataItem = dataSequence.dequeue();
           System.out.println(aDataItem);
        }
        
        // Traverse tree PREORDER
        System.out.println("\nPRE-ORDER");
        dataSequence = new  LinkedQueue<Data>();        
        dataSequence = theTree.traversePreOrder();
        while (!dataSequence.isEmpty())
        {
           aDataItem = dataSequence.dequeue();
           System.out.println(aDataItem);
        }
        
        // Traverse tree POSTORDER
        System.out.println("\nPOST-ORDER");
        dataSequence = new  LinkedQueue<Data>();
        dataSequence = theTree.traversePostOrder();
        while (!dataSequence.isEmpty())
        {
           aDataItem = dataSequence.dequeue();
           System.out.println(aDataItem);
        }
                
        System.exit(0);
    }   
    
    // Method loads binary search tree from file of data
    public static void loadTree()
    {
        int key, data;
        
        // Read file and populate linked list with Data objects
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("data.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                key  = inputFileScanner.nextInt();  
                data = inputFileScanner.nextInt();
                
                // Instantiate object from data line and add to list
                Data newDataObj = new Data(key,data);
                theTree.add(newDataObj);
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error");
            System.exit(0);
        }

    }
}