// Delta College - CST 283 - Klingler & Former Deitel text
// This application tests use of the Cylinder class which
// is created using a chain of inheritance.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CylinderTest 
{

   public static void main( String[] args ) 
   {
      // create Cylinder object
      Cylinder cylinder = new Cylinder( 12, 23, 2.5, 5.7 );

      // get Cylinder's initial x-y coordinates, radius and height
      String output = "X coordinate is " + cylinder.getX() +
         "\nY coordinate is " + cylinder.getY() + "\nRadius is " + 
         cylinder.getRadius() + "\nHeight is " + cylinder.getHeight();

      cylinder.setX( 35 );          // set new x-coordinate
      cylinder.setY( 20 );          // set new y-coordinate
      cylinder.setRadius( 4.25 );   // set new radius
      cylinder.setHeight( 10.75 );  // set new height

      // get String representation of new cylinder value
      output += 
         "\n\nThe new location, radius and height of cylinder are\n" + 
         cylinder.toString();

      // format floating-point values with 2 digits of precision
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      // get Cylinder's diameter
	   output += "\n\nDiameter is " + 
         twoDigits.format( cylinder.getDiameter() );

      // get Cylinder's circumference
      output += "\nCircumference is " +
         twoDigits.format( cylinder.getCircumference() );

      // get Cylinder's area
      output += "\nArea is " + twoDigits.format( cylinder.getArea() );

      // get Cylinder's volume
      output += "\nVolume is " + twoDigits.format( cylinder.getVolume() );

      JOptionPane.showMessageDialog( null, output ); // display output

      System.exit( 0 );

   } // end main

} 

