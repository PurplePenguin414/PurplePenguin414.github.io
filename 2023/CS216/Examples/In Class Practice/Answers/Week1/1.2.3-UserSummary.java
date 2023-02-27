// Delta College - CST 183 - Klingler
// This application reads a data file containing raw data relative to
// usage of an online system.  Each line indicates a daily number of:
//    { day number}   { individual users }   { total system transations }
// The program summrarizes the data in a report delivered via a dialog box.

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class UserSummary
{
    final static int MAXSIZE = 20;             // Max size of dataset (and array)

    public static void main( String args[] ) throws IOException
    {
         String[] day       = new String[MAXSIZE]; 
         int[] users        = new int[MAXSIZE]; 
         int[] transactions = new int[MAXSIZE];
         int numElems;
         
         int allTrans    = 0;      // To accumulate transations total time period
         int maxTrans    = 0;      // To retain max transactons value
         int minTrans    = 9999;   // To retain min transactons value
         String maxTransDay = "";  // To mark day of max transactions
         String minTransDay = "";  // To mark day of min transactions
         
         String outMessage = "";
       
         File fileIn = new File ("usagedata.txt");
 
         // Check for file existence.  If not found, display error and crash
         if (!fileIn.exists())
         {   
             JOptionPane.showMessageDialog( null, 
               "File was not found",  "File Error", 
               JOptionPane.ERROR_MESSAGE );
             System.exit(0);
         }
             
        Scanner inputFile = new Scanner(fileIn);
        
        int i = 0;
        while (inputFile.hasNext() && i < MAXSIZE)
        {
            day[i]          = inputFile.next();
            users[i]        = inputFile.nextInt();
            transactions[i] = inputFile.nextInt(); 
            i++;
        }
        numElems = i;       // Capture number in array

        inputFile.close();  // Close input file - done with it
        
        int totalUsers = 0;
        int totalTrans = 0;
        for (i = 0; i < numElems; i++)
        {
            totalTrans += transactions[i];
            totalUsers += users[i];
            allTrans   += transactions[i];
            
            if (transactions[i] > maxTrans)
            {
                maxTrans    = transactions[i];
                maxTransDay = day[i];
            }
            if (transactions[i] < minTrans)
            {
                minTrans    = transactions[i];
                minTransDay = day[i];
            }
       }
        double aveTrans = (double)totalTrans / numElems;
        double aveUsers = (double)totalUsers / numElems;
        double aveTransPerUser = aveTrans / aveUsers;
           
        // If file not empty, calculate statistics and prepare output
        if (numElems > 0)
        {

            // Formulate output message
            outMessage += String.format("Ave. Transactions/day: %5.1f", aveTrans) + "\n";
            outMessage += String.format("Ave. Users/day: %4.1f", aveUsers) + "\n";
            outMessage += String.format("Total transations: %4d", allTrans) + "\n";
            outMessage += String.format("Most transactions on: " + maxTransDay) + "\n";       
            outMessage += String.format("Fewest transactions on: " + minTransDay) + "\n";     
            outMessage += String.format("Ave Transactions/User/Day: " + aveTransPerUser); 
        }
        else
             outMessage = "ERROR:  No data processed";
            
        // Display the results
        JOptionPane.showMessageDialog( null, 
             outMessage, "Statistical Summary", 
             JOptionPane.INFORMATION_MESSAGE );

        System.exit(0);
    }

 

}