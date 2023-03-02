package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Gibbs 
// This class manages a list of claim objects that randomly include
// dental, medical and perscription visits.  It calculates total payment and
// compiles The final claims report.

import java.util.Scanner;
import java.io.*;

public class insuranceClaim {

    public final int MAX_ICLAIMS = 50;
    public final String ICLAIMS_FILE = "2023/CS216/Assignmnents/Assignment06/insuranceclaims.txt";
    
    claim claimList[];    // List of claim objects
    int numElems;         // Number of claims detected in file
   
    String type, service, network;
    int date;
    double cost, insurancePay, customerPay; 
    // ----------------------------------------------------------------
    // Constructor:  Load data from file into list of claim objects
    public insuranceClaim() 
    {        
        claimList = new claim[MAX_ICLAIMS];

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
                // Read first data tokens - type of claim, date
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
                    service = inputFileScanner.next();
                    cost  = inputFileScanner.nextDouble();
                    perscriptionClaim claim = new perscriptionClaim(type, date, cost, service, customerPay, insurancePay); 
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
    public void prepareClaim()
    {
        for (int i = 0; i < numElems; i++)
        {
            claimList[i].calcPay();   // This is POLYMORPHISM This is a standard method call from superclass
        }    
    }

    // ----------------------------------------------------------------
    // Prepare a formatted claim report as one string object
    public String toString()
    {
          
         // Set up output string - initialize with table headings
         String outString = "Type    Date    Service    Cost    Insurance Payment    Customer Payment\n";
         
         // Loop through all payroll data and format data for each element
         for (int i = 0; i < numElems; i++)
         {
             
             // Format line for output
             outString += String.format("%-12s", claimList[i].getType());
             outString += String.format("%8d",   claimList[i].getDate());
             outString += String.format("%-12s", claimList[i].getService());
             outString += String.format("%9.2f", claimList[i].getCost());
             outString += String.format("%9.2f", claimList[i].getInsurancePay());
             outString += String.format("%9.2f", claimList[i].getCustomerPay());
             outString += "\n"; 
         } 
                 
         return outString;
     }

}
