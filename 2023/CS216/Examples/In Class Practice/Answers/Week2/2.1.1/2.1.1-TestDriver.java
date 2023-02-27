// Delta College - CST 283 - Klingler
// This application is a test driver for a RightTriangle object.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class TestDriver 
{
   public static void main( String[] args ) 
   {
      // instantiate Circle object
      RightTriangle myTriangle = new RightTriangle( 5.0,7.5 ); 

      // Calculate and return the area
      String output = "Area is " + myTriangle.getArea() + "\n";

      myTriangle.setBase( 4.25 );   // Set new base
      myTriangle.setHeight( 9.5 );  // Set new height
           
      // Calculate and return the perimeter
      output += "Perimeter is " + myTriangle.calcPerimeter() + "\n";

      // Get String representation of updated right triangle object 
      output += myTriangle.toString();

      JOptionPane.showMessageDialog( null, output );    // Display output

      System.exit( 0 );

   } // end main

} // end class CircleTest

