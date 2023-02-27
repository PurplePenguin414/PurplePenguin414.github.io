// Delta College - CST 283 - Klingler 
// This program drives a statistical dataset object responsible for
// calculations on a file of integers.

import java.io.*;
import javax.swing.JOptionPane;

public class DataAppDriver 
{
    public static void main( String args[] )
    {
        StatsDataset myData;        // Object to store and manage stats data
        String outputMessage;       // String to be displayed at end
        int sum, max, min;      
        double average;
 
        // Construct object and initialize with input values
        myData = new StatsDataset("statdata.txt");
        
                // Initiate output message
        outputMessage = "Statistical Summary" +  "\n";
        
             // Peform method calls to determine statistical parameters
        sum     = myData.calcSum();       
        average = myData.calcAverage();   
        max     = myData.getMax();
        min     = myData.getMin();
           
        // Forulate output message string for good results
        outputMessage += "Sum of all data: " + sum + "\n";
        outputMessage += "Max value:       " + max + "\n";
        outputMessage += "Min value:       " + min + "\n";
        outputMessage += String.format("Average of numbers is: %5.1f",average);

        // Show final output dialog
        JOptionPane.showMessageDialog( null, outputMessage);

        System.exit(0);
    
    }
}  

