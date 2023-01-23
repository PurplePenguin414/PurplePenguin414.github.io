package In Class Practice;

// Delta College - CST 283 - Klingler 
// This program converts kilometers to miles.

import javax.swing.*;            

public class ConvertKMmiles
{   
   public static final double KM_TO_MILES = 0.621371;
    
   public static void main(String args[]) 
   {
      // Variable declaration
      String inputKiloString;  
      double kilometers, miles;
      char finalGrade;

      // Input
      inputKiloString = JOptionPane.showInputDialog( "Enter kilometers" );
      kilometers = Double.parseDouble( inputKiloString );      
      
      // Test for a valid input number.  If OK, convert and output results.
      if (kilometers > 0)
      {
         miles = kilometers * KM_TO_MILES;    // Perform conversion
         
         String milesFormatted = String.format("%6.1f miles", miles);
         String kmFormatted    = String.format("%6.1f km", kilometers);
         
         String outputString   = kmFormatted + " = " + milesFormatted;
      
         JOptionPane.showMessageDialog( null, outputString,
            "Output", JOptionPane.INFORMATION_MESSAGE );
      }
      else  // Otherwise an error - display error message
         JOptionPane.showMessageDialog( null, "Number Out of Range",
            "ERROR", JOptionPane.ERROR_MESSAGE );

      
      System.exit(0);
      
   }  // end main
   
  
      
}  
