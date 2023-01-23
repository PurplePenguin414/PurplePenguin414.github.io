// Delta College - CST 283 - Klingler  
// This program prompts the user for a number and validates that it is 
// a valid number as well as in the range 0 <= n <= 100.0

import javax.swing.JOptionPane;  

public class InputException 
{
   // main method begins execution of Java application
   public static void main( String args[] )
   {
      String theNumberStr; // First string entered by user
 
      double theNumber = 0;   

      // Read in first numbers from user as strings
      theNumberStr = JOptionPane.showInputDialog( "Enter a number 0...100" );
 
      boolean numberValid = true;     // Assume no error
     
      try  // Attempt to perform number conversion
      {
         theNumber = Double.parseDouble( theNumberStr );     
      }
      // Catch any number format exception.  Display error message
      // for invalid numbers.
      catch (NumberFormatException theException)
      {
         JOptionPane.showMessageDialog(
             null, "Invalid input format", "ALERT",
             JOptionPane.WARNING_MESSAGE );
         numberValid = false;                 // Mark an error detected
      }
      
      // Asserting valid integers, check to insure they are in range.
      if (theNumber < 0.0 || theNumber > 100.0)
      {
         JOptionPane.showMessageDialog(
             null, "Numbers must be 0...100", "ALERT",
             JOptionPane.WARNING_MESSAGE );
         numberValid = false;                 // Mark an error detected
      }
         
      // If no error detected, calculate and display sum
      if ( numberValid )
      {  
         JOptionPane.showMessageDialog( null, "The number " + theNumber +
                                        " is in range.");         
      }

      System.exit( 0 );   
   } 
} 

