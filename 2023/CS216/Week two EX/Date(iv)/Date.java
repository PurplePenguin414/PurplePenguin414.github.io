// Delta College - CST 283 - Klingler
// This class includes functionality to manage a calendar date object

public class Date
{
   //-----------------------------------------------------------------  
   // PRIVATE Instance Variables
   //-----------------------------------------------------------------  
   private int month;
   private int day;
   private int year;

   //-----------------------------------------------------------------  
   // PUBLIC Methods
   //-----------------------------------------------------------------  

   //-----------------------------------------------------------------  
   // Default constructor - default date is 1/1/1900
   public Date()
   {
      month = 1;
      day = 1;
      year = 1900;
   }
      
   //-----------------------------------------------------------------  
   // Constructor for user initialization
   // No error-checking is performed
   public Date(int m, int d, int y)
   {   
      month = m;
      day = d;
      year = y;
   }
      
   //-----------------------------------------------------------------  
   // Constructor for coded string input in form "mmddyyyy".  Date
   // components are parsed and assigned.  No error-checking is performed
   public Date(String dateString)
   {   
      // convert numbers from type String to type int
      int dateVals = Integer.parseInt( dateString );
         
      // Extract date information from text input
      // Integer division and modulus operations utilized
      month = dateVals / 1000000;       // Get month
      dateVals = dateVals % 1000000; 
      day = dateVals / 10000;          // Get day
      year = dateVals % 10000;          // Get year
   }
      
   //-----------------------------------------------------------------  
   // Accessor and mutator methods
   // No error-checking is performed

   public int getMonth()
   { return month; }
      
   public int getDay()
   { return day; }
      
   public int getYear()
   { return year; }
      
   public void setMonth(int m)
   { month = m; }
      
   public void setDay(int d)
   { day = d; }
      
   public void setYear(int y)
   { year = y; }
   
   //-----------------------------------------------------------------  
   // This method returns a String of the form month/day/year  
   public String toString()
   {
      return month + "/" + day + "/" + year; 
   }

   //-----------------------------------------------------------------  
   // This method returns true if the year is a leap year and 
   // false otherwise.  It assumes a valid date.
   public boolean leapYear()
   {
      if ( year % 400 == 0 ||
         ( year % 4 == 0 && year % 100 != 0 ) )
         return true;
      else
         return false;
   }  // end leapYear
   
   //-----------------------------------------------------------------  
   // This method  returns an integer of the number of days in the month.
   // Leap years are factored into the value. It assumes a valid date.
   public int DaysInMonth()
   {
      int daysIn = 0;;      
      // 31 Day months
      if (month == 1 || month == 3 || month == 5 ||
          month == 7 || month == 8 || month == 10 ||
          month == 12 ) 
             daysIn = 31;
                
      // 30 Day months
      else if (month == 4 || month == 6 || month == 9 ||
               month == 11 ) 
             daysIn = 30;
                
      // February
      else   //month == 2
         if ( this.leapYear() )
            daysIn = 29;
         else 
            daysIn = 28; 
      return daysIn;
   }  // end DaysInMonth
   
   //-----------------------------------------------------------------  
   // This method returns the Julian date (the day number of the date
   // in that year).  It assumes a valid date.
   public int julianDate()
   {
      int dayCnt = 0;
      // Temporary date to vary month - initialize to same day 
      Date tempDate = new Date(this.getMonth(),this.getDay(),this.getYear());      
      
      for (int mon = 1; mon < month; mon++)
      {
         tempDate.setMonth(mon);
         dayCnt += tempDate.DaysInMonth();
      }
      dayCnt += day;
      return dayCnt;
   
   }  // endl julianDate
   
   //-----------------------------------------------------------------  
   // This method  returns a boolean value defining the validity of
   // the date.  It assumes a valid date.
   public boolean validDate()
   {
       boolean valDate = true;   // Assume a good date
       
       // Test for conditions that would make the date validity false
       if (year < 1900)
         valDate = false;
       if ((month < 1) || (month > 12) || (day < 1) || (day > 31))
         valDate = false;
       else if (((month == 4) || (month == 6) || (month == 9) || 
                (month == 11)) && (day == 31))
          valDate = false;
       else if ((month == 2)  && this.leapYear() && (day > 29))
         valDate = false;
       else if ((month == 2)  && ! this.leapYear() && (day > 28))
         valDate = false;
          
      return valDate;
   }  // endl validDate
   
   //-----------------------------------------------------------------  
   // This method returns a date code for the day of the week.  It counts
   // the number of days since 1/1/1900 which was on a Sunday.  
   // Output is: 0=Sun,1=Mon, ..., 6=Sat
   // Precondition(s):   Date is VALID
   // Postcondition(s):  mon,day,year are unchanged
   public int weekDay()
   {      
      int DayCnt;
      int daynum,i;

      DayCnt = (year - 1900) * 365;   
      DayCnt += ((year - 1900) / 4) + 1;
      for (i=1; i<=month-1; i++)
      switch(i)
      {
         case 2:    DayCnt +=28; break;
         case 4:
         case 6:
         case 9:
         case 11:    DayCnt +=30; break;
         default:   DayCnt +=31; 
      };
      
      if (((year - 1900) % 4 == 0) && (month <= 2))
         DayCnt--;
      DayCnt += day;
      daynum = (DayCnt - 1) % 7;
      
      return daynum;
   } // end weekDay 


   //-----------------------------------------------------------------  
   // This method returns a string containing the name of the day of
   // week that it falls on.
   public String dayOfWeekCode()
   {
      int dayCode = weekDay();
   
      String result = "";
      switch(dayCode)
      {
         case 0: result = result + "Sunday"; break;
         case 1: result = result + "Monday"; break;
         case 2: result = result + "Tuesday"; break;
         case 3: result = result + "Wednesday"; break;
         case 4: result = result + "Thursday"; break;
         case 5: result = result + "Friday"; break;
         case 6: result = result + "Saturday"; break;
      }
      return result;
   } // end dayOfWeekCode

}  // end date class