// Delta College - CST 283 - Klingler                       
// This program use of the ArrayList class for an array of fractions

import java.util.*;
import javax.swing.JOptionPane;

public class FractionArrayList
{
   public static void main(String[] args)
   {
      int num[] = { 5, 6, 3,  8,  2};
      int den[] = {10, 7, 9, 12, 10};
   
      // Create an ArrayList to store Strings
      List<Rational> fractions = new ArrayList<Rational>();
      
      // Add fractions to list
      for (int i = 0; i < num.length; i++)
      {
         fractions.add(new Rational(num[i],den[i]));
      }

      // -------------------------------------------------------
      // Display the items in list via enhanced for-loop
      
      String output = "My Favorite Fractions\n(via ehanced for-loop)\n\n";
      
      for (Rational aFraction : fractions)
         output += aFraction.toString() + "\n";
         
      JOptionPane.showMessageDialog(null,output);  
      
      // -------------------------------------------------------
      // Display items using iterator
            
      output = "My Favorite Fractions\n(via iterator)\n\n";
             
      // Get a new  ListIterator for traversal
      Iterator<Rational> it = fractions.iterator();

      // Traverse and write list elements
      while (it.hasNext())
         output += it.next() + "\n";  
         
      JOptionPane.showMessageDialog(null, output);    

   }
}