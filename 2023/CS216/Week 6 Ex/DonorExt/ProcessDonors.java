// Delta College - CST 283 - Klingler 
// This program manages a very simple list of donors.  It writes
// the list and calculates the amount of the donation that is
// tax deductable (a contrived value of 85%)

import java.util.Scanner;
import java.io.*;

public class ProcessDonors
{        
    public static final String DONOR_FILE = "donations2.txt";
    
    public static void main( String args[] )
    {
        Donor oneDonor;
        BigDonor oneBigDonor;
        
        String code;
        String tempName;
        double tempDonation;
        String tempGift;
        
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File(DONOR_FILE);  
            inputFileScanner = new Scanner(inputfile);
            
            while (inputFileScanner.hasNext())
            {
                code         = inputFileScanner.next();   
                tempName     = inputFileScanner.next();   
                tempDonation = inputFileScanner.nextDouble(); 
                
                // If an asterisk code, data line is big donor.  Read
                // gift to be given and instantiate appropriate object
                if (code.equals("*"))
                {
                   tempGift = inputFileScanner.next();  
                   oneBigDonor = new BigDonor(tempName,tempDonation,tempGift);
                   System.out.println(oneBigDonor.toString());
                }
                // If an dash code, data line is normal donor.  Write object
                // contents.
                if (code.equals("-"))
                {
                    oneDonor = new Donor(tempName,tempDonation);
                    System.out.println(oneDonor.toString());
                }
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