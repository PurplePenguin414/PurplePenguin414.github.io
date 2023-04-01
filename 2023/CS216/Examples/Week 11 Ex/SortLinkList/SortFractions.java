// Delta College - CST 283 - Klingler                  
// This application demonstrates basic operations for an ordered linked list

import java.util.Scanner; 
import java.io.*;      

public class SortFractions
{     
    private static final String inputFilename = "fractData.txt";
    
    public static void main(String [] args)
    {
        LinkedList<Rational> theList = new LinkedList<Rational>();

        int num1,den1,num2,den2;
        String slash;
        
        try
        {
            File inFileRef = new File(inputFilename);
            Scanner inputFile = new Scanner(inFileRef);

            while (inputFile.hasNext())
            {
                // Read elements of fractions from file
                num1  = inputFile.nextInt();
                slash  = inputFile.next();
                den1  = inputFile.nextInt();
                
                num2  = inputFile.nextInt();
                slash  = inputFile.next();
                den2  = inputFile.nextInt();
                
                // Instantiate fractions and multiply
                Rational fraction1 = new Rational(num1,den1);
                Rational fraction2 = new Rational(num2,den2);
                Rational fractionResult = fraction1.multiply(fraction2);
                
                // Add fractions to ordered linked list
                theList.add(fractionResult);   
            }
        }   
        catch (IOException e)
        {
            System.out.println("Input File Error");
        }
                
        // Write fractions in input order
        System.out.println("\n\n");   
        System.out.println("Before:");
        theList.resetList();
        while (!theList.atEnd())
        {
            Rational listItem = theList.getNextItem();
            System.out.println(listItem);    
        }    
        
        theList.sortList();
        
         // Write fractions in sorted order
        System.out.println("\n\n");   
        System.out.println("After:");
        theList.resetList();
        while (!theList.atEnd())
        {
            Rational listItem = theList.getNextItem();
            System.out.println(listItem);    
        }    
               
    }  
}
