// Delta College - CST 283 - Klingler
// This application reads text document from a file
// and performs a spelling check on the text.  

import javax.swing.JOptionPane; 

public class SpellCheck 
{
    public static void main(String[] args)
    {

        String checkWord;          // Work variable for word list
        int docLength;             // Length of word document
        String outMessage = "";    // Output message string

        // Instantiate Dictionary object  
        Dictionary theDictionary =  new Dictionary();  
        
        // Instantiate document object
        Document theDocument = new Document ("gettysburg.txt");  
 
        // Iterate through word list, retrieve a word, and check spelling
        outMessage = "CHECK SPELLING FOR:\n";

        theDocument.resetWordList();
        docLength = theDocument.getLength();
    
        for (int i = 1; i <= docLength; i++)
        {   
            checkWord = theDocument.getNextWord();
            if (! theDictionary.wordOK(checkWord) )   
                outMessage += checkWord + "\n";
        }
       
        // Output messing words
        JOptionPane.showMessageDialog(null, outMessage);
        System.exit(0);
    }
}

