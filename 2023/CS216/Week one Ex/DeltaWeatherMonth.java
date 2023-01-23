// Delta College - CST 283 - Klingler
// This program includes hard-coded temperature data from the Delta College
// weather station for August 2015.  The parallel arrays are the daily high
// and low temperatures, respectively.  The program creates a monthly
// climate summary.

import javax.swing.JOptionPane;  

public class DeltaWeatherMonth
{
    public static void main( String args[])
    {
        // Temperature data - arrays are parallel
        int hiTemp[] = {83,86,79,78,76,76,77,75,81,78,78,78,84,87,87,87,
                        87,85,84,73,76,80,77,70,64,65,69,74,68,78,78};
        int loTemp[] = {56,59,59,55,55,55,54,63,64,64,60,55,60,65,61,67,
                        68,67,71,60,56,60,58,54,53,56,55,53,60,64,62};

        int dailyAve;
        double monthlyTotalTemp = 0;
        
        // Declare variables for monthly high and low.  Assign to index zero values.
        int monthlyHi = hiTemp[0]; 
        int monthlyLo = loTemp[0]; 
        
        // Traverse temperature arrays to accumulate total daily averages
        // Seek out monthly high and low temperatures as well.
        for (int i = 0; i < hiTemp.length; i++)
        {
            monthlyTotalTemp += (hiTemp[i] + loTemp[i]) / 2.0;
            if (hiTemp[i] > monthlyHi)
                monthlyHi = hiTemp[i];
            if (loTemp[i] < monthlyLo)
                monthlyLo = loTemp[i];          
        }
        
        // Calculate monthly average temperature
        double averageMonthTemp = monthlyTotalTemp / hiTemp.length;
              
        // Formulate and write output message
        String outputMessage = new String();
        outputMessage += "Summary for August 2015\n";
        outputMessage += String.format("Monthly Average: %5.1f",averageMonthTemp) + "\n";
        outputMessage += String.format("Monthly High: %3d",monthlyHi) + "\n";
        outputMessage += String.format("Monthly Lo:   %3d",monthlyLo);
        JOptionPane.showMessageDialog( null, outputMessage);
   
        System.exit(0);
    }
}