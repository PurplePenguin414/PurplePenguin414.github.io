// Delta College - CST 283 - Klingler
// This class manages a simple dictionary of words for
// basic spell checking

import java.util.Scanner;
import java.io.*;

class Dictionary
{
    BinarySearchTree<String> wordTree;     // Tree of string objects

    // Constructor:  build tree structure of dictionary words from file
    public Dictionary()  
    {
        wordTree = new BinarySearchTree<String>();
        String aWord;        // Work variable for input

        // File loop to populate binary search tree
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("wordList.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            while (inputFileScanner.hasNext())
            {
                // Read word and add to tree
                aWord  = inputFileScanner.next();  
                wordTree.add(aWord);
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: Problem opening dictionary file");
            System.exit(0);
        }
    }

    // Test to see if word in in word data set
    boolean wordOK(String wordIn)
    { 
        wordIn = wordIn.toLowerCase();    // Be sure word in lower case before search

        // If not in main list (tree), return false
        if (wordTree.contains(wordIn))
            return true;
        else
            return false;
    }
};