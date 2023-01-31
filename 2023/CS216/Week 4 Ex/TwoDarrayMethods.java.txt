// Delta College - CST 283 - Klingler                          
// This program demonstrates basic algorithms operating on a 
// two-dimensional array

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class TwoDarrayMethods 
{
    final static int NUM_ROWS = 4;
    final static int NUM_COLS = 4;

    public static void main(String[] args) 
    {
        int i;
        double sum = 0;

        // Declare and initialize array
        double[][] matrix = { {1.2, 2.3, 3.4, 4.5},
                              {6.7, 7.8, 8.9, 9.1},
                              {2.4, 3.5, 4.6, 5.7},
                              {7.9, 8.1, 9.3, 1.4} };
        
        System.out.println("Matrix:\n"                + arraytoString(matrix));
        System.out.println("  Max value: "            + maxValue(matrix));    
        System.out.println("  Min value: "            + minValue(matrix));   
        System.out.println("  Sum of elements: "      + sumElements(matrix));       
        System.out.println("  Sum of row 2: "         + sumRow(matrix,2));     
        System.out.println("  Sum of column 1: "      + sumCol(matrix,1));      
        System.out.println("  Sum of diagonal: "      + sumDiag(matrix)); 
        System.out.println("  Sum of alt. diagonal: " + sumAltDiag(matrix));         
        System.exit(0);
    }
    
    //  sumAll, sumRow, sumCol, sumDiag, sumAltDiag
    
    
    
    // --------------------------------------------------------
    // Method coverts a two-dimensional array of doubles to on
    // String object.  Line breaks for rows are included.
    public static String arraytoString(double[][] matrix)
    {
        String outString = "";
        
        for (int row = 0; row < NUM_ROWS; row++) 
        {
            for (int col = 0; col < NUM_COLS; col++)
               outString += matrix[row][col] + " ";
            outString += "\n";
        }
        
        return outString;
    }

    // --------------------------------------------------------
    // Method determins max value in 2-D array
    public static double maxValue(double[][] matrix)
    {
        double max = Double.MIN_VALUE;      
        for (int row = 0; row < NUM_ROWS; row++) 
        {
            for (int col = 0; col < NUM_COLS; col++) 
                if (matrix[row][col] > max)
                    max = matrix[row][col];
        }  
        return max;
    }
    
    // --------------------------------------------------------
    // Method determins min value in 2-D array
    public static double minValue(double[][] matrix)
    {
        double min = Double.MAX_VALUE;      
        for (int row = 0; row < NUM_ROWS; row++) 
        {
            for (int col = 0; col < NUM_COLS; col++) 
                if (matrix[row][col] < min)
                    min = matrix[row][col];
        }  
        return min;
    }
    
    // --------------------------------------------------------
    // Method sums all elements in 2-D array
    public static double sumElements(double[][] matrix)
    {
        double sum = 0.0;      
        for (int row = 0; row < NUM_ROWS; row++) 
        {
            for (int col = 0; col < NUM_COLS; col++) 
                sum += matrix[row][col];
        }  
        return sum;
    }
    
    // --------------------------------------------------------
    // Method sums all elements in a given row of a 2-D array
    public static double sumRow(double[][] matrix, int rowTarget)
    {
        double sum = 0.0;      
        for (int col = 0; col < NUM_COLS; col++) 
            sum += matrix[rowTarget][col];
        return sum;
    }
    
    // --------------------------------------------------------
    // Method sums all elements in a given column of a 2-D array
    public static double sumCol(double[][] matrix, int colTarget)
    {
        double sum = 0.0;      
        for (int row = 0; row < NUM_ROWS; row++) 
            sum += matrix[row][colTarget];
        return sum;
    }
    
    // --------------------------------------------------------
    // Method sums all elements in the main diagonal of a 2-D array
    // PRE:  Number of rows and columns are the same
    public static double sumDiag(double[][] matrix)
    {
        double sum = 0.0;      
        for (int row = 0; row < NUM_ROWS; row++) 
            sum += matrix[row][row];
        return sum;
    } 
    
    // --------------------------------------------------------
    // Method sums all elements in the opposite diagonal of a 2-D array
    // PRE:  Number of rows and columns are the same
    public static double sumAltDiag(double[][] matrix)
    {
        double sum = 0.0;    
        int col = NUM_COLS-1;
        for (int row = 0; row < NUM_ROWS; row++) 
        {
            sum += matrix[row][col];
            col--;
        }
        return sum;
    }   
}
