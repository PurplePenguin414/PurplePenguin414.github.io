// Delta College - CST 283 - Klingler                 
// This class parses out words from a text document (read in from a file) 
// and stores the words in an unordered linked list.  The iterators of the
// linked list class are used to provide access to each word, one at a time.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Document
{
    private LinkedList<String> wordList;     // Uunordered linked list of words      
  
    // -------------------------------------------------------------------------
    // Constructor:  build Document object given name of text file containing words.
    public Document(String wordListFile)  
    {
        String aWord;
        wordList =  new LinkedList<String>();

        // File loop to populate word linked list
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File(wordListFile);  
            inputFileScanner = new Scanner(inputfile); 
            
            while (inputFileScanner.hasNext())
            {
                // Read word and add to linked list
                aWord = inputFileScanner.next();  
                aWord = removeNonAlphas(aWord);      // Remove punctuation
                wordList.add(aWord);
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: Problem opening dictionary file");
            System.exit(0);
        }        
    }

    // This function remove all punctuation (non-alpha)
    // characters from a string object and converts it to lower case.
    private String removeNonAlphas(String aWord)
    {
        aWord = aWord.toLowerCase();
        return aWord.replaceAll("[^a-z0-9\n]", "");
    } 

    // This function returns the length of word list
    int getLength()
    {
       return wordList.size();
    }            

    // Set up for iteration - set "pointer" to front of word list
    void resetWordList()
    {
       wordList.resetList();
    }

    // Get next list item
    String getNextWord()
    {
       return wordList.getNextItem();
    } 
}