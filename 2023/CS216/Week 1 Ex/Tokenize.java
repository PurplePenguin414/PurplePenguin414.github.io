// Delta College - CST 183 - Klingler                              
// This application demonstrates tokenizing a comma-delimited string of data
// using various techniques.

import java.util.*;
import javax.swing.JOptionPane;

public class Tokenize 
{
   public static void main( String args[] )
   {       
        String infoString = "Delta,College,University Center,MI";
        final String delimiter = ",";    // Comma separated content
        
        // --------------------------------------------------------------------
        // STRINGTOKENIZER 
               
        String outputMessage = "StringTokenizer\n";
        String aToken        = "";
        
        StringTokenizer tokens = new StringTokenizer( infoString, delimiter );

        // Tokenizing loops.  Use iterator 'hasMoreTokens' to advance through
        // string and extract data.
        while ( tokens.hasMoreTokens() )
        {
            aToken = tokens.nextToken();
            outputMessage += aToken + "\n"; 
        }
        
         // Write tokens via a dialog box
        JOptionPane.showMessageDialog( null, outputMessage);
        
        
        // --------------------------------------------------------------------
        // STRING SPLIT METHOD 
               
        outputMessage = "String Split Method\n";
        
        // Get the tokens from the string.
        String[] tokenSet = infoString.split(delimiter);
        
        // Display each token.
        for (String atoken : tokenSet)
            outputMessage += atoken + "\n";     
        
         // Write tokens via a dialog box
        JOptionPane.showMessageDialog( null, outputMessage);
              
        
        // --------------------------------------------------------------------
        // MANUAL PARSING
        
        outputMessage = "Parsing Manually\n";
        String aWord         = "";
        
        // Tokenizing loop.  Strings are bracketed between start and end positions
        // determined by indexing on the delimiter.  Substrings are used to extract
        // tokens.  This continues through nexzt-to-last token.
        int startPos = 0;
        int endPos   = infoString.indexOf(delimiter,startPos);
        while (endPos > 0)
        {
            aWord = infoString.substring(startPos,endPos);   // Extract current bracketed token
            outputMessage += aWord + "\n";                   // Add to output string
            startPos = endPos + 1;                           // Leapfrog start pos past end pos
            endPos = infoString.indexOf(delimiter,startPos); // Seen next end position
        }
        
        // After last delimiter, mark end of string as end point and extract
        // last string token.
        endPos = infoString.length();
        aWord = infoString.substring(startPos,endPos);
        outputMessage += aWord + "\n";
        
       // Write tokens via a dialog box
        JOptionPane.showMessageDialog( null, outputMessage);
      
        
   }

}
