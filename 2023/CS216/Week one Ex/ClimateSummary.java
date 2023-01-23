// Delta College - CST 283 - Klingler
// This program processes an entire year of data from the Delta College
// weather and writes a climate summary.

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class ClimateSummary
{
    // Constants
    public static final String datafilename = "delta1999.txt";

    public static void main(String[] args) throws IOException
    {
        File inputfile;               // Reference for input file
        int month, day, year;
        int prevMonth;                // To detect a change in month
        double hiTemp, loTemp, precip;
        int numDays           = 0;    // Number of days in current monthy   
        double monthPrecip    = 0;
        double dailyAveTemp   = 0;
        double monthTotalTemp = 0;    // Accumulator necessary for averaging
  
        // Instantiate required objects
        inputfile = new File(datafilename);  // Create file input object
       
        // Check for file existence.  If not found, display error and crash
        if (!inputfile.exists())
        {   
            JOptionPane.showMessageDialog( null, 
               "File was not found", 
               "File Error", 
               JOptionPane.ERROR_MESSAGE );
            System.exit(0);
        }
        
         // Asserting file found, instantiate scanner object for input
        Scanner inputAveFile = new Scanner(inputfile);  
      
        // Declare and instantiate output writer object
        PrintWriter outputfileWriter;      
        outputfileWriter = new PrintWriter("climateReport.txt"); 
        
        // Write report headers
        outputfileWriter.println("DELTA COLLEGE\n1999 CLIMATE SUMMARY\n");
        outputfileWriter.println("Month    Ave Temp   Total Precip");
        
        prevMonth = 1;    // Assume current month January to start
                
        // File processing loop - Continue while not empty
        while (inputAveFile.hasNext())
        {
            month  = inputAveFile.nextInt();
            day    = inputAveFile.nextInt();
            year   = inputAveFile.nextInt();
            hiTemp = inputAveFile.nextDouble();            
            loTemp = inputAveFile.nextDouble();            
            precip = inputAveFile.nextDouble();   
            
            // If month changes, summarize, write a line and reset for next month
            if (month != prevMonth)
            {
                double aveMonthTemp = monthTotalTemp/numDays;
                outputfileWriter.println(String.format("%2d" ,prevMonth) +
                        String.format("%13.1f" ,aveMonthTemp)        +
                        String.format("%13.2f" ,monthPrecip));
                        
                numDays        = 0;
                monthPrecip    = 0;
                monthTotalTemp = 0;
            }

            // Process data for this line
            dailyAveTemp = (hiTemp + loTemp) / 2.0;  // Calc daily average
            monthTotalTemp += dailyAveTemp;          // Accumuldate temp
            monthPrecip += precip;                   // Accumulate precip
            numDays++;                               // Increment days in month counter
            
            prevMonth = month;                       // Grab month for comparison
        }
        
        // Handle December summary
        double aveMonthTemp = monthTotalTemp/numDays;
        outputfileWriter.println(String.format("%2d" ,prevMonth) +
                String.format("%13.1f" ,aveMonthTemp)        +
                String.format("%13.2f" ,monthPrecip));
               
        // Close files
        inputAveFile.close();                    
        outputfileWriter.close(); 

        System.exit(0);        
    }
}