// Delta College - CST 283 - Klingler             
// This program drives a test plan for a chained hash table data structure

import java.util.Scanner;
import java.io.*;

public class TestChainedData 
{
    private static ChainHashTable<Student> studentDB;    // Chained has table object
    
    public static void main(String[ ] args)
    { 
	studentDB = new ChainHashTable<Student>();

        loadData();   // Load data from file
        
        // Write data within linked hash table for display
        System.out.println(studentDB.toString());
        
    }
    // Method loads binary search tree from file of data
    public static void loadData()
    {
        int id;
        String name;
        double gpa;
        
        Student newStudent;            // Working student object
        
        // Read file and populate linked list with Data objects
        try
        {
            Scanner inputFileScanner;
            File inputfile;
        
            inputfile = new File("gradeData.txt");  
            inputFileScanner = new Scanner(inputfile); 
            
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                id     = inputFileScanner.nextInt();  
                name   = inputFileScanner.next();
                gpa    = inputFileScanner.nextDouble();
                
                // Instantiate object from data line and add to list
                newStudent = new Student(id, name, gpa);
                studentDB.add(newStudent);
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

