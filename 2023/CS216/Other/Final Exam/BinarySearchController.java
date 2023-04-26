// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree of integers.
// Features testing:  size and depth

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class BinarySearchController {

    private static int MAX_TREE_SIZE = 1000; // 1000
    private static BinarySearchTree<String> theTree;
    private static LinkedStack<String> stringStack = new LinkedStack<String>();
    private static LinkedQueue queue = new LinkedQueue();
    private static LinkedList<String> theList = new LinkedList<String>();

    public static void main(String[] args) {
        // Instantiate search tree and load from file
        theTree = new BinarySearchTree<String>();
        String temp = "";

        System.out.println("\n\nThe original words---------------------------------------------------");
        loadTree();

        System.out.println("\n\nThe myWords words------------------------------------------------------");
        loadMyTree();

        
        System.out.println("\n\nThe Queue words------------------------------------------------------");
        while (!stringStack.isEmpty()) {
            temp = stringStack.pop();
            queue.enqueue(temp);
        }
        System.out.println(queue);

        System.out.println("\n\nThe LinkedList words------------------------------------------------------");
        while(!queue.isEmpty()){
            temp = (String) queue.peek();
            queue.dequeue();
            theList.add(temp);
        }
        System.out.println(theList);
        String outputMessage = "The First 20 Words From the LinkedList Are: ";
        System.out.println(outputMessage);
        for(int i = 0; i<20;i++){
            temp = (String) theList.getNextItem();
            System.out.println(temp);
        }
    }

    // Method loads binary search tree from file of data
    public static void loadTree() {
        String data = "";

        // Read file and populate linked list with Data objects
        try {
            Scanner inputFileScanner;
            File inputfile;

            inputfile = new File("2023/CS216/Other/Final Exam/allwords.txt");
            inputFileScanner = new Scanner(inputfile);

            int i = 0;
            while (inputFileScanner.hasNext()) {
                data = inputFileScanner.nextLine();

                // Instantiate object from data line and add to list
                String newDataObj = new String(data);
                System.out.println(newDataObj);
                theTree.add(newDataObj);
            }

            inputFileScanner.close(); // Close file
        } catch (IOException e) // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error");
            System.exit(0);
        }

    }

    // Method loads binary search tree from file of data
    public static void loadMyTree() {
        String data2 = "";

        // Read file and populate linked list with Data objects
        try {
            Scanner inputFileScanner2;
            File inputfile;

            inputfile = new File("2023/CS216/Other/Final Exam/mywords.txt");
            inputFileScanner2 = new Scanner(inputfile);

            int i = 0;
            while (inputFileScanner2.hasNext()) {
                data2 = inputFileScanner2.nextLine();

                // Instantiate object from data line and add to list
                String newDataObj1 = new String(data2);
                System.out.print(newDataObj1);
                if (theTree.contains(newDataObj1)){
                    stringStack.push(newDataObj1);
                    System.out.print("\t\tAdded");
                    System.out.println();
                }else{
                    System.out.print("\t\tNot found");
                    System.out.println();
                };
            }

            inputFileScanner2.close(); // Close file
        } catch (IOException e) // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error");
            System.exit(0);
        }

    }
}
