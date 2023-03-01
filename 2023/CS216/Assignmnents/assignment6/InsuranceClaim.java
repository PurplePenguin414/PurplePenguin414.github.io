package CS216.Assignmnents.assignment6;

// Delta College - CST 283 - Klingler 
// This class manages a list of Worker objects that randomly include
// salaried and hourly workers.  It calculates total payroll and tax amounts
// for both salaried and hourly employees.  The final payroll report
// is sorted by descending net pay.

import java.util.Scanner;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;

public class InsuranceClaim 
{
    public final int MAX_CLAIMS = 50;
    public final String FILENAME1 = "2023/CS216/Assignmnents/Assignment06/insuranceclaims.txt";
    
    Claim InsuranceClaim;    // List of Claim objects
    int numElems;           // Number of claims detected in file
   
    // ----------------------------------------------------------------
    // Constructor:  Load data from file into list of Worker objects
    public InsuranceClaim() 
    {        
        InsuranceClaim = new Claim();
        
        String name, date, type, med, network;
        double cost, insurancePay, customerPay, rate;

        // Open file.  Process in batch format line-by-line
        try
        {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(FILENAME1);  
            inputFileScanner = new Scanner(inputfile);   
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                // Read first data tokens - name, id, employee type
                name = inputFileScanner.next();                 
                date   = inputFileScanner.next(); 
                
                // Medical Claim detected - create object and add to list 
                if (name.equals("M")) 
                {
                    type = inputFileScanner.next();
                    network = inputFileScanner.next();
                    cost = inputFileScanner.nextDouble();

                    MedicalClaim claim = new MedicalClaim(name, date, cost, type, network); 
                    claimList[i] = claim;
                }
                
                // Dental Claim detected - create object and add to list 
                if (name.equals("D")) 
                {
                    type = inputFileScanner.next();
                    cost  = inputFileScanner.nextDouble();
                    DentalClaim claim = new DentalClaim(name, date, type, cost); 
                    claimList[i] = claim;                                      
                }    
                
                // Perscription Claim detected - create object and add to list 
                if (name.equals("P")) 
                {
                    med = inputFileScanner.next();
                    cost  = inputFileScanner.nextDouble();
                    PerscriptionClaim claim = new PerscriptionClaim(name, date, med, cost); 
                    claimList[i] = claim.;                                      
                }  
                i++;
                
            }
            numElems = i;
        
            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, reset list status flag
        {
            System.out.println("Problem with File - Shutting Down");
            System.exit(0);
        }
    }
    
    // ----------------------------------------------------------------
    // Calculate gross pay, tax, and net pay for all Worker objects
    // in list.
    public void prepareClaim()
    {
        for (int i = 0; i < numElems; i++)
        {
            claimList[i].calcPay();   // This is POLYMORPHISM This is a standard method call from superclass
        }    
    }

    // ----------------------------------------------------------------
    // Prepare a formatted payroll report as one string object
    public String toString()
    {
        // Initializes totals
        String code, date, type, procedure, med, network;
        double cost, insurancePay, customerPay;
         
        // Set up output string - initialize with table headings
        String outString = "Type    Date    Service    Medication    Cost    In/Out of Netowrk    Insurance Payment    Customer Payment\n";
        
        // Loop through all payroll data and format data for each element
        for (int i = 0; i < numElems; i++)
        {
            
            // Format line for output
            outString += String.format("%-12s", claimList[i].getCode());
            outString += String.format("%8d",   claimList[i].getDate());
            outString += String.format("%9.2f", claimList[i].getService());
            outString += String.format("%9.2f", claimList[i].getMed());
            outString += String.format("%9.2f", claimList[i].getCost());
            outString += String.format("%9.2f", claimList[i].getNetwork());
            outString += String.format("%9.2f", claimList[i].getInsurancePay());
            outString += String.format("%9.2f", claimList[i].getCustomerPay());
            outString += "\n"; 
        } 
                
        return outString;
    }

}
