// Delta College - CST 283 - Klingler
// This program demonstrates various capabilities of
// the Java Random class

import javax.swing.JOptionPane;
import java.util.Random;        // Required to enable Random class

public class RandomExamples 
{
    public static void main( String args[] )
    {
        String outString = "";
        
        // Create object instance of Random class
        Random randomNumbers = new Random();    
        
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        // Simulate a sequence of 10 die throws
        outString += "10 Die Throws: ";
        int dieVal;
        for (int i = 1; i <= 10; i++)
        {
            dieVal = randomNumbers.nextInt(6) + 1;
            outString += dieVal + "  ";  
        }
        outString += "\n\n";
        
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        // Simulate picking lottery numbers (without replacement)
        //  Michigan Lottery - Lotto 47 Game -  Pick 6 numbers 1...47
        outString += "Lotto 47 Picks: ";
        boolean pickerMarker[] = new boolean[80];
        int numSelected = 0;
        int thisPick;
        do
        {
            thisPick = randomNumbers.nextInt(47) + 1;  // Rand int 0..46
            if (pickerMarker[thisPick] == false)       // If not picked
            {
                pickerMarker[thisPick] = true;         // Mark it picked
                outString += (thisPick+1) + "  ";      // Add to message
                numSelected++;                         // Increment number picked
            }                        
        } while (numSelected < 6);
        outString += "\n\n";
    
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        // Simulate 5 high resolution mathematical random numbers 
        // between 0.0 <= , < 1.0;
        outString += "Mathematical Random Values: " +"\n";;
        for (int i = 1; i <= 5; i++)
            outString += randomNumbers.nextDouble() +"\n";

        
        // Show dialog box with accumulated output info
        JOptionPane.showMessageDialog( null, 
            "Examples of Random Values" + "\n\n" + outString );

        System.exit( 0 );  

    } 

} 
