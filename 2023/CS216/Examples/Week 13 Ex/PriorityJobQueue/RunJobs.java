// Delta College - CST 283 - Klingler             
// This class is a test driver for a priority queue of computer jobs.

import java.util.Scanner;
import java.io.*;

public class RunJobs 
{
    private static PQtype<Job> jobQueue;
    
    public static void main(String[ ] args)
    {          
        jobQueue = new PQtype<Job>();
        Job aJob;
        
        loadData();

        System.out.println(jobQueue.toString());   // Write entire queue

        aJob = jobQueue.dequeue();
        while (!jobQueue.isEmpty() )
        {    
            aJob.toString();
            System.out.println("REMOVE: " + jobQueue.toString());
            aJob = jobQueue.dequeue();
        }

    }
    // Method loads binary search tree from file of data
    public static void loadData()
    {
        String id;
        int priority, time;
        
        // Read file and populate linked list with Data objects
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("jobin.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                id       = inputFileScanner.next();  
                priority = inputFileScanner.nextInt();
                time     = inputFileScanner.nextInt();
                
                // Instantiate object from data line and add to list
                Job newJob = new Job(id, priority, time);
                jobQueue.enqueue(newJob);
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

