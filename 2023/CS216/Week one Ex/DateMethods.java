// Delta College - CST 283 - Klingler                               */
// This application allows a user to enter a calendar date and will return 
// a message declaring if the date is valid or not

import javax.swing.JOptionPane;

public class DateMethods
{
   public static void main( String args[] )
   {
      // Declarations
      String monString,dayString,yearString;  // String with date code
      int month,day,year;                     // Date components
      String  outputString;                   // A string for output message
      
      // Read date components
      monString  = JOptionPane.showInputDialog( "Enter month" );
      dayString  = JOptionPane.showInputDialog( "Enter day  " );
      yearString = JOptionPane.showInputDialog( "Enter year " );

      // Convert numbers from type String to type int
      month = Integer.parseInt( monString  );
      day   = Integer.parseInt( dayString  );
      year  = Integer.parseInt( yearString );
           
      // Formulate output string
      outputString = formulateOutputString(month,day,year);  
      
     // Display results
      JOptionPane.showMessageDialog(
         null, outputString, "Date Info:",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
         
   }  // end main

 
   //-----------------------------------------------------------------  
   // This method receives integers for month, day, and year.  It then
   // forumlates a string that will be passed back to the main driver
   // to be integrated as the final output message
   public static String formulateOutputString(int mon, int day, int year)
   {
      boolean leapYear;       // Leap year flag
      boolean valDate;        // Date validity flag
      String  result;         // A string for output message

      // Start result message with date
      result = mon + "/" + day + "/" + year + "\n";

      // Validate and add attributes of the date
      if ( validDate(mon,day,year) )
      {
         result += "  falls on a ";
         result += dayOfWeekCode( weekDay(mon,day,year) ) + "\n";
         result += "  is day number ";
         result += julianDate(mon,day,year)  + " of the year\n";
         result += "  is in month with ";
         result += DaysInMonth(mon,year) + " days\n";
         if (leapYear(year) )
             result += "  falls in a leap year\n";
         else
             result += "  falls in a non leap year\n";
      }
      else  // If not valid, add appropriate suffix to final message
         result += "  is INVALID";
      
      return result;
   }

   //-----------------------------------------------------------------  
   // This method receives an integer year and returns true if the
   // year is a leap year and false otherwise
   public static boolean leapYear(int theYear)
   {
      if ( theYear % 400 == 0 ||
         ( theYear % 4 == 0 && theYear % 100 != 0 ) )
         return true;
      else
         return false;
   }  // end leapYear
   
   //-----------------------------------------------------------------  
   // This method receives an integer month and year and returns an 
   // integer of the number of days in the month.  Leap years are
   // considered.
   public static int DaysInMonth(int theMonth, int theYear)
   {
      int days = 0;
      // 31 Day months
      if (theMonth == 1 || theMonth == 3 || theMonth == 5 ||
          theMonth == 7 || theMonth == 8 || theMonth == 10 ||
          theMonth == 12 ) 
             days = 31;
                
      // 30 Day months
      else if (theMonth == 4 || theMonth == 6 || theMonth == 9 ||
           theMonth == 11 ) 
             days = 30;
                
      // February
      else  // month == 2
         if ( leapYear(theYear) )
            days = 29;
         else 
            days = 28; 
            
      return days;
   }  // end DaysInMonth
   
   //-----------------------------------------------------------------  
   // This method receives a valid calendar date and returns the Julian
   // date (the day number of the date in that year)
   public static int julianDate(int theMonth, int theDay, int theYear)
   {
      int dayCnt = 0;
      for (int mon = 1; mon < theMonth; mon++)
         dayCnt += DaysInMonth(mon,theYear);
      dayCnt += theDay;
      return dayCnt;
   
   }  // end julianDate
   
   //-----------------------------------------------------------------  
   // This method receives a calendar date and returns a boolean value
   // defining the validity of the date.  
   public static boolean validDate(int mon, int day, int yr)
   {
       boolean valDate = true;   // Assume a good date
       
       // Test for conditions that would make the date validity false
       if (yr < 1900)
          valDate = false;
       if ((mon < 1) || (mon > 12) || (day < 1) || (day > 31))
          valDate = false;
      else if (((mon == 4) || (mon == 6) || (mon == 9) 
             || (mon == 11)) && (day == 31))
          valDate = false;
      else if ((mon == 2)  && leapYear(yr) && (day > 29))
         valDate = false;
      else if ((mon == 2)  && ! leapYear(yr) && (day > 28))
         valDate = false;
          
      return valDate;
   }  // end validDate
   
   //-----------------------------------------------------------------  
   // This method receives a valid date and returns a date code for the
   // day of the week.  It counts the number of days since 1/1/1900
   // which was on a Sunday.  Output is: 0=Sun,1=Mon, ..., 6=Sat
   public static int weekDay(int mon, int day, int year)
   {        
        int DayCnt;
        int daynum,i;

        DayCnt = (year - 1900) * 365;    
        DayCnt += ((year - 1900) / 4) + 1;
        for (i=1;i<=mon-1;i++)
        switch(i)
        {
            case 2:     DayCnt +=28; break;
            case 4:
            case 6:
            case 9:
            case 11:    DayCnt +=30; break;
            default:    DayCnt +=31; 
        };
        
        if (((year - 1900) % 4 == 0) && (mon <= 2))
            DayCnt--;
        DayCnt += day;
        daynum = (DayCnt - 1) % 7;
        
        return daynum;
   } // end weekDay 

   //-----------------------------------------------------------------  
   // This method receives a day-of-the-week code and returns a
   // string containing the name of the day (0=SUN ... 6 = SAT)   
   public static String dayOfWeekCode(int dayCode)
   {
      String result = "";
      switch(dayCode)
      {
         case 0: result = result + "Sunday";    break;
         case 1: result = result + "Monday";    break;
         case 2: result = result + "Tuesday";   break;
         case 3: result = result + "Wednesday"; break;
         case 4: result = result + "Thursday";  break;
         case 5: result = result + "Friday";    break;
         case 6: result = result + "Saturday";  break;
      }
      return result;
   } // end dayOfWeekCode
   
} // end dateMethods application
