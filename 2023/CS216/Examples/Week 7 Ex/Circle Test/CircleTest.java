// Delta College - CST 283 - Klingler & Former Deitel text
// This application tests various features of the Circle class
// Circle inherits from Point.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CircleTest 
{
   public static void main( String[] args ) 
   {
      // instantiate Circle object
      Circle circleObj = new Circle( 37, 43, 2.5 ); 

      // get Circle4's initial x-y coordinates and radius
      String output = "X coordinate is " + circleObj.getX() +
                    "\nY coordinate is " + circleObj.getY() +
                    "\nRadius is "       + circleObj.getRadius();

      circleObj.setX( 35 );         // set new x-coordinate
      circleObj.setY( 20 );         // set new y-coordinate
      circleObj.setRadius( 4.25 );  // set new radius

      // get String representation of new circle value
      output += "\n\nThe new location and radius of circle are\n" +
         circleObj.toString();

      // format floating-point values with 2 digits of precision
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      // get Circle's diameter
      output += "\nDiameter is " + 
         twoDigits.format( circleObj.getDiameter() );

      // get Circle's circumference
      output += "\nCircumference is " +
         twoDigits.format( circleObj.getCircumference() );

      // get Circle's area
      output += "\nArea is " + twoDigits.format( circleObj.getArea() );

      JOptionPane.showMessageDialog( null, output ); // display output

      System.exit( 0 );

   } // end main

} // end class CircleTest

