//******************************************************************************
// Delta College - CST 283 - Klingler
// This program reads Lincoln's Gettysburg Address and converts it to Morse Code
//******************************************************************************
import java.util.Scanner;
import java.io.*;

public class MorseConvert 
{
    public static final String morsefilename = "morse.txt";
    public static final String wordsfilename = "gettysburg.txt";
    public static final int ALPHA_SIZE = 26;
    public static final int MAX_WORDS = 1000;  // Max words to convert
    
    public static void main(String[] args) throws IOException
    {
        String outputString = new String();            // For output message;
        
        String[] morseList  = new String[ALPHA_SIZE];  // Array of morse code pattern
        char alphaList[]    = new char[ALPHA_SIZE];    // Array containing alphabet (all caps)
        String[] wordList   = new String[MAX_WORDS];
    
        // Build arrays from file
        BuildAlphaMorseList(alphaList,morseList);
        
         // Build array of words to convert
        BuildWordList(wordList);
   
        outputString = wordsToMorse(wordList,alphaList,morseList);
    
        System.out.println(outputString);

        System.exit( 0 );

    }  // end main

    //**************************************************************************
    // This method builds arrays containing the alphabet and matching
    // Morse code pattern.  If file not found, program is crashed.
    //**************************************************************************
    public static void BuildAlphaMorseList(char alpha[], String morse[]) throws IOException
    {
        File inputfile;       
        inputfile = new File(morsefilename); 
                            
        if (!inputfile.exists())
        {
            System.out.println("ERROR: Morse Code File Not Found");
            System.exit(0);
        }
            
        // File exists and OK; instantiate Scanner object to read
        Scanner inputFileScanner = new Scanner(inputfile);  

        // Read contents of file into parallel arrays
        for (int i=0; i < ALPHA_SIZE; i++)
        {
            alpha[i]  = inputFileScanner.next().charAt(0);
            morse[i]  = inputFileScanner.next();

        }
    }  // end BuildAlphaMorseList
    
    //**************************************************************************
    // This method builds arrays containing the alphabet and matching
    // Morse code pattern.  If file not found, program is crashed.
    //**************************************************************************
    public static void BuildWordList(String words[])
    {
        // Encapsulate file input into exception-handling routine
        try
        {
            File inputfile;       
            inputfile = new File(wordsfilename); 
                            
            if (!inputfile.exists())
            {
                System.out.println("ERROR: Words File Not Found");
                System.exit(0);
            }
            
            // File exists and OK; instantiate Scanner object to read
            Scanner inputFileScanner = new Scanner(inputfile);  

            // Read contents of file int array; count words as it processes
            int i = 0;    
            while (inputFileScanner.hasNext() && i < MAX_WORDS)
            {
                 words[i]  = inputFileScanner.next();
                 i++;
            }
            words[i] = null;   // Null out next string to be a sentinel
        }
        catch ( IOException e )
        {
            System.out.println("ERROR: Words File Error");
            System.exit(0);
        }       
       
    }  // end BuildWordList

    //**************************************************************************
    // This method builds arrays containing the alphabet and matching
    // Morse code pattern.
    //**************************************************************************
    public static String wordsToMorse(String[] words, char[] alpha, String[] morse)
    {
        String outputString = new String();   // For output
        
        // Process array of words while String reference not null
        int i = 0;
        while (words[i] != null)
        {
             // Move one char at a tine and replace with Morse Code string
             for (int j = 0; j < words[i].length(); j++)
             {
                 for (int k=0; k < ALPHA_SIZE; k++)
                     if (alpha[k] == words[i].charAt(j))
                         outputString += (morse[k] + "  ");
             } 
             outputString += "\n";
             i++;
        }
        return outputString;

    }  // end wordsToMorse
}