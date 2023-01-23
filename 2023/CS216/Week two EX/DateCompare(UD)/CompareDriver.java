// Delta College - CST 283 - Klingler
// This application allows a user to enter a calendar date and will return 
// a message declaring if the date is valid or not

import javax.swing.JOptionPane;

public class CompareDriver
{
   public static void main( String args[] )
   {
      String dateString;    // String for coded input date
      String  result = "";  // A string for output message  
           
      // Read two additional dates to test comparison features
      dateString = JOptionPane.showInputDialog( "Enter 1st date (mmddyyyy):" );
      Date date1 = new Date(dateString);
      dateString = JOptionPane.showInputDialog( "Enter 2nd date (mmddyyyy):" );
      Date date2 = new Date(dateString);     
      
      // Compare dates and formulate output message
      if (date1.equals(date2))
          result = date1.toString() + " == " + date2.toString();   
      if (date1.compareTo(date2) > 0)
          result = date1.toString() + " > " + date2.toString();
      if (date1.compareTo(date2) < 0)
          result = date1.toString() + " < " + date2.toString();
     
      // Display results of date comparison
      JOptionPane.showMessageDialog(null, result, "Date Comparison",
         JOptionPane.INFORMATION_MESSAGE );    
      
      // ---------------------------------------------------------
      
      String string1 = "Delta";
      String string2 = "College";      
      
      result =  string1 + " compared to " + string2 +
                " returns: " + string1.compareTo(string2) + "\n";
      result += string2 + " compared to " + string2 +
                " returns: " + string2.compareTo(string1) + "\n";  
      result += string1 + " compared to " + string1 +
                " returns: " + string1.compareTo(string1) + "\n";  
      
      // Display results of string comparison
      JOptionPane.showMessageDialog(null, result, "String Comparison",
         JOptionPane.INFORMATION_MESSAGE );          
      System.exit( 0 );
         
   }  // end main
}  // endl class