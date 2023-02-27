// Delta College - CST 183 - Klingler
// This application prompts the user for a string and tests to determine if
// it is a palindrome or not.

import javax.swing.JOptionPane;

public class PalindromeDemo 
{
   public static void main( String args[] )
   {
      String theWord;  
      String outcomeMessage = "";

      // read first number from user as a string
      theWord = JOptionPane.showInputDialog( "Enter a word:" );
      theWord = theWord.toLowerCase();

      // Ready output message
      outcomeMessage = "The word " + theWord + " is \n";
      
      // Test two iterative approaches and one recursive approach
      if (isPalindrome1(theWord))
          outcomeMessage += "a palindrome.\n";
      else
          outcomeMessage += "not a palindrome.\n";
      
      if (isPalindrome2(theWord))
          outcomeMessage += "a palindrome.\n";
      else
          outcomeMessage += "not a palindrome.\n";
    
      if (isPalindromeRecurse(theWord))
          outcomeMessage += "a palindrome.";
      else
          outcomeMessage += "not a palindrome.";
     
      // Display results
      JOptionPane.showMessageDialog(null, outcomeMessage );

      System.exit( 0 );
   }
  
   //******************************************************************
   // This method tests a string to determine if it is a palindrome
   // by comparing characters from front to back.
   // PRE:  All characters are the same case
   public static boolean isPalindrome1(String testWord)
   {
      int len = testWord.length();
      boolean outcome = true;              
      for (int i = 0; i < len/2; i++)
         if (testWord.charAt(i) != testWord.charAt(len-i-1))
         outcome = false;
         
      return outcome;
   }
   
   //******************************************************************
   // This method tests a string to determine if it is a palindrome
   // by reversing and comparing it to itself.
   // PRE:  All characters are the same case
   public static boolean isPalindrome2(String testWord)
   {
       StringBuilder theWord = new StringBuilder(testWord); 
       String reversedString = new String(theWord.reverse());
       
       if (testWord.equals(reversedString))
           return true;
       else
           return false;
   }
   
    //******************************************************************
    // This function tests a string to see if it is a palindrome
    public static boolean isPalindromeRecurse( String str )
    {
        int len = str.length();  

        // Base case
        // A string of length 0 or 1 is always a palindrome
        if( len == 0 || len == 1 )
            return true;

        if( str.charAt(0) == str.charAt(len-1) )
            return ( isPalindromeRecurse(str.substring(1, len-1)));

        return false;
    }


}

