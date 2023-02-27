// Delta College - CST 283 - Klingler                          
// This program writes a sales summary to the console based on raw
// sales data read from a file

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class SalesSummary 
{
    // Global constants
    final static int TOTAL_STORES = 4;
    final static int DAYS_IN_WEEK = 5;
    final static String FILENAME = "saledata.txt";

    public static void main(String[] args) 
    {
        int storeData[][] = new int[TOTAL_STORES][DAYS_IN_WEEK];    
    
        buildGrid(storeData);      // Load table of store data to array
        summarizeData(storeData);  // Create totals and write report
    
        System.exit(0);
    }

    // This method reads a sequential file of raw store sales data and
    // builds a two-dimensional array containing the data
    // File format:  {store_number}  {day_of_week (1..5)}  {sales}
    public static void buildGrid(int[][] dataTable)
    {
        int store, day, amount;

        try
        {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(FILENAME);  
            inputFileScanner = new Scanner(inputfile);

            // Read file and populate 2-D array
            int i = 0;
            while (inputFileScanner.hasNext())
            {
                store  = inputFileScanner.nextInt();    
                day    = inputFileScanner.nextInt(); 
                amount = inputFileScanner.nextInt(); 
                dataTable[store-1][day-1] = amount;             
            }
            
            inputFileScanner.close();   
        }
        catch (IOException e) 
        {
            System.out.println("File error");
            System.exit(0);
        }
    }

    // This method creates a summary report for the sales data including totals
    // by store and by day of week
    public static void summarizeData(int[][] dataTable)
    {
        System.out.println("SALES SUMMARY");
        System.out.println("            MON    TUE    WED    THU    FRI  TOTAL");
    
        for (int i = 0; i < TOTAL_STORES; i++)
        {
            int totalRow = 0;
            System.out.print("Store " + (i+1) + " ");
            for (int j = 0; j < DAYS_IN_WEEK; j++)
            {
                System.out.print( String.format("%7d", dataTable[i][j]));
                totalRow += dataTable[i][j];
            }
            System.out.print( String.format("%7d", totalRow));
            System.out.println();
        }   
        System.out.println();
        
        System.out.print("TOTAL   ");
        for (int j = 0; j < DAYS_IN_WEEK; j++)
        {
            int totalCol = 0;
            for (int i = 0; i < TOTAL_STORES; i++)
                totalCol += dataTable[i][j];
            System.out.print( String.format("%7d", totalCol));
        }
        System.out.println("\n\n");
    } 
}

