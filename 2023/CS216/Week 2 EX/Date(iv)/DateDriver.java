// Delta College - CST 283 - Klingler
// This application allows a user to enter a calendar date and will return 
// a message declaring if the date is valid or not

import javax.swing.JOptionPane;

public class DateDriver
{
   public static void main( String args[] )
   {
      String dateString;    // String for coded input date
      String  result;       // A string for output message
      
      // Read date as one integer
      dateString = JOptionPane.showInputDialog( "Enter date (mmddyyyy):" );

      // Create data object instance from coded string entered by user
      Date theDate = new Date(dateString);
                          
      // Show entered date
      result = theDate.getMonth() + "/" 
             + theDate.getDay()   + "/" 
             + theDate.getYear()  + "\n";
      
      // Write analyis info on date
      if ( theDate.validDate() )
      {
         result = "is VALID\n";         
         result = result + "* Falls on a " 
                + theDate.dayOfWeekCode() + "\n";
         result = result + "* Is day number " + theDate.julianDate()  
                + " of the year\n";
         result = result + "* Is in month with " 
                + theDate.DaysInMonth() + " days\n";
         if (theDate.leapYear() )
            result = result + "* Falls in a leap year\n";
         else
            result = result + "* Falls in a non leap year\n";
      }
      else 
         result = "is INVALID";
         
     // Display results
      JOptionPane.showMessageDialog(
         null, result, "Date Info:",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
         
   }  // end main
}  // endl class