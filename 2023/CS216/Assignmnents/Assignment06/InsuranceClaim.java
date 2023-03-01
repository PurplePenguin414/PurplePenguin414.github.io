package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This class manages a list of Worker objects that randomly include
// salaried and hourly workers.  It calculates total payroll and tax amounts
// for both salaried and hourly employees.  The final payroll report
// is sorted by descending net pay.

import java.util.Scanner;
import java.io.*;

public class insuranceClaim {

    public final int MAX_ICLAIMS = 50;
    public final String ICLAIMS_FILE = "2023/CS216/Assignmnents/Assignment06/insuranceclaims.txt";
    
    claim claimList[];    // List of claim objects
    int numElems;         // Number of claims detected in file
   
    // ----------------------------------------------------------------
    // Constructor:  Load data from file into list of Worker objects
    public insuranceClaim() 
    {        
        claimList = new claim[MAX_ICLAIMS];
        
        String type, service, network, med;
        int date;
        double cost, insurancePay, customerPay;     

        // Open file.  Process in batch format line-by-line
        try
        {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(ICLAIMS_FILE);  
            inputFileScanner = new Scanner(inputfile);   
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                // Read first data tokens - name, id, employee type
                type = inputFileScanner.next();                 
                date   = inputFileScanner.nextInt();  
                
                // Medical claim detected - create object and add to list 
                if (type.equals("M")) 
                {
                    service = inputFileScanner.next();
                    network = inputFileScanner.next();
                    cost = inputFileScanner.nextDouble();

                    medicalClaim claim = new medicalClaim(type,date,cost,service,network,customerPay,insurancePay); 
                    claimList[i] = claim;
                }
                
                // Perscription claim detected - create object and add to list 
                if (type.equals("P")) 
                {
                    med = inputFileScanner.next();
                    cost  = inputFileScanner.nextDouble();
                    perscriptionClaim claim = new perscriptionClaim(type, date, cost, med, customerPay, insurancePay); 
                    claimList[i] = claim;                                      
                } 

                // Dental claim detected - create object and add to list 
                if (type.equals("D")) 
                {
                    service = inputFileScanner.next();
                    cost  = inputFileScanner.nextDouble();
                    dentalClaim claim = new dentalClaim(type, date, service, cost, customerPay, insurancePay); 
                    claimList[i] = claim;                                      
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
         String type, date, service, med, network;
         double cost, insurancePay, customerPay;
          
         // Set up output string - initialize with table headings
         String outString = "Type    Date    Service    Medication    Cost    In/Out of Netowrk    Insurance Payment    Customer Payment\n";
         
         // Loop through all payroll data and format data for each element
         for (int i = 0; i < numElems; i++)
         {
             
             // Format line for output
             outString += String.format("%-12s", claimList[i].getType());
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
