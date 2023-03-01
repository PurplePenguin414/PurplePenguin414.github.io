// Delta College - CST 283 - Klingler 
// This class manages a list of Worker objects that randomly include
// salaried and hourly workers.  It calculates total payroll and tax amounts
// for both salaried and hourly employees.  The final payroll report
// is sorted by descending net pay.

import java.util.Scanner;
import java.io.*;

public class Payroll 
{
    public final int MAX_WORKERS = 50;
    public final String FILENAME = "inpay.txt";
    
    Worker workerList[];    // List of worker objects
    int numElems;           // Number of workers detected in file
   
    // ----------------------------------------------------------------
    // Constructor:  Load data from file into list of Worker objects
    public Payroll() 
    {        
        workerList = new Worker[MAX_WORKERS];
        C:\Users\megan\Documents\GitHub\PurplePenguin414.github.io\2023\CS216\Assignmnents\assignment6\InsuranceClaim.java
        String name;
        int id;
        double salary, hours, rate;
        String code;      // Employee type code:  H-hourly  S-salaried

        // Open file.  Process in batch format line-by-line
        try
        {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(FILENAME);  
            inputFileScanner = new Scanner(inputfile);   
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                // Read first data tokens - name, id, employee type
                name = inputFileScanner.next();                 
                id   = inputFileScanner.nextInt();  
                code = inputFileScanner.next();
                
                // Salaried worker detected - create object and add to list 
                if (code.equals("S")) 
                {
                    salary = inputFileScanner.nextDouble();
                    SalariedWorker newWorker = new SalariedWorker(name, id, salary); 
                    workerList[i] = newWorker;
                }
                
                // Hourly worker detected - create object and add to list 
                if (code.equals("H")) 
                {
                    hours = inputFileScanner.nextDouble();
                    rate  = inputFileScanner.nextDouble();
                    HourlyWorker newWorker = new HourlyWorker(name, id, hours, rate); 
                    workerList[i] = newWorker;                                      
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
    public void preparePayroll()
    {
        for (int i = 0; i < numElems; i++)
        {
            workerList[i].calcGrossPay();   // This is POLYMORPHISM
            workerList[i].calcTaxNet();     // This is a standard method call from superclass
        }    
    }
        
    // ----------------------------------------------------------------
    // Sort list of Worker objects by descending net pay
    // Precondition:  Gross pay, tax, and net pay have been calculated for list
    //                elements.
    public void sortByNetPay()
    {
        int lastPos;     
        int index;       
        Worker tempObj;    
      
        for (lastPos = numElems - 1; lastPos >= 0; lastPos--)
        {
            for (index = 0; index <= lastPos - 1; index++)
            {
                if (workerList[index].getNet() < workerList[index + 1].getNet())
                {
                   tempObj = workerList[index];
                   workerList[index] = workerList[index + 1];
                   workerList[index + 1] = tempObj;
                }
             }
        }
    }

    // ----------------------------------------------------------------
    // Prepare a formatted payroll report as one string object
    public String toString()
    {
        // Initializes totals
        double tot_gross, tot_net, tot_tax;
        tot_gross = 0;
        tot_net = 0;
        tot_tax = 0;
         
        // Set up output string - initialize with table headings
        String outString = "NAME            ID     GROSS      TAX     NET\n";
        
        // Loop through all payroll data and format data for each element
        for (int i = 0; i < numElems; i++)
        {
            // Increment totals
            tot_gross += workerList[i].getGross();
            tot_tax   += workerList[i].getTax();
            tot_net   += workerList[i].getNet();
            
            // Format line for output
            outString += String.format("%-12s", workerList[i].getName());
            outString += String.format("%8d",   workerList[i].getID());
            outString += String.format("%9.2f", workerList[i].getGross());
            outString += String.format("%9.2f", workerList[i].getTax());
            outString += String.format("%9.2f", workerList[i].getNet());
            outString += "\n"; 
        }  
        
        // Add totals to output line
        outString += "\nTOTAL               ";
        outString += String.format("%9.2f", tot_gross);
        outString += String.format("%9.2f", tot_tax);
        outString += String.format("%9.2f", tot_net);
                
        return outString;
    }

}
