// This method demonstrates use of the StringBuilder class
// including switching between String and StringBuilder objects

import javax.swing.*;

public class StringBuilderDemo
{

   public static void main( String args[] )
   {
      // Initital string
      String s1 = new String("This is fun");
      
      // Instantiate StringBuilder from String
      StringBuilder sb1 = new StringBuilder(s1);

      // Manipulate StringBuilder object
      sb1.insert(8,"exceptionally ");
      sb1.delete(0,4);
      sb1.insert(0,"Programming");
      sb1.insert(0,"Computer ");
      
      // More StringBuilder back to a String
      s1 = new String(sb1);
      
      // Output results
      System.out.println(s1);
 
      System.exit( 0 );
   }

} 
