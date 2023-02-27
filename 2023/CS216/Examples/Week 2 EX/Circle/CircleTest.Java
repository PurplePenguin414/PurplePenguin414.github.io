// Delta College - CST 283 - Klingler
// This application is a test driver for a Circle object.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CircleTest 
{
   public static void main( String[] args ) 
   {
      // instantiate Circle object
      Circle circleObj = new Circle( 2.5 ); 

      // Get Circle's radius
      String output = "Radius is " + circleObj.getRadius();

      circleObj.setRadius( 4.25 );  // Set new radius

      // Get String representation of new circle value
      output += "\n\nThe new location and radius of circle are\n" +
                 circleObj.toString();

      // Format floating-point values with 2 digits of precision
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      // Get Circle's diameter
      output += "\nDiameter is " + 
                 twoDigits.format( circleObj.getDiameter() );

      // Get Circle's circumference
      output += "\nCircumference is " +
                 twoDigits.format( circleObj.calcCircumference() );

      // Get Circle's area
      output += "\nArea is " + twoDigits.format( circleObj.calcArea() );

      JOptionPane.showMessageDialog( null, output );    // Display output

      System.exit( 0 );

   } // end main

} // end class CircleTest
