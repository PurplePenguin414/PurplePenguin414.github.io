// Delta College - CST 283 - Klingler 
// This program manages a very simple list of donors.  It writes
// the list and calculates the amount of the donation that is
// tax deductable (a contrived value of 85%)

import java.util.Scanner;
import java.io.*;

public class ProcessDonors
{        
    public static final String DONOR_FILE = "donations.txt";
    
    public static void main( String args[] )
    {
        Donor oneDonor;
        String tempName;
        double tempDonation;
        
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File(DONOR_FILE);  
            inputFileScanner = new Scanner(inputfile);
            
            while (inputFileScanner.hasNext())
            {
                tempName     = inputFileScanner.next();   
                tempDonation = inputFileScanner.nextDouble();   
                
                oneDonor = new Donor(tempName,tempDonation);
                System.out.println(oneDonor.toString());
            }
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error");
            System.exit(0);
        }
    }
  

}