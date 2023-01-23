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
         miles = covertKMtoMiles(kilometers);    // Perform conversion
         writeOutput(miles, kilometers);         // Write output
      }
      else  // Otherwise an error - display error message
         JOptionPane.showMessageDialog( null, "Number Out of Range",
            "ERROR", JOptionPane.ERROR_MESSAGE );

      
      System.exit(0);
      
   }  // end main
   
   // Covert kilometers to miles
   public static double covertKMtoMiles(double km)
   {
       return km * KM_TO_MILES;
   }
   
   // Write output conversion message
   public static void writeOutput(double miles, double kilometers)
   {
      String milesFormatted = String.format("%6.1f miles", miles);
      String kmFormatted    = String.format("%6.1f km", kilometers);
         
      String outputString   = kmFormatted + " = " + milesFormatted;
      
      JOptionPane.showMessageDialog( null, outputString,
         "Output", JOptionPane.INFORMATION_MESSAGE );
   }
      
}  




