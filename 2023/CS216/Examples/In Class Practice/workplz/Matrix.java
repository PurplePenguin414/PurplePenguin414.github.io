/**
   Delta College - CST 283 - Klingler
   This class defines a data type for a  mathematical matrix
   of integers. It includes the ability to create a matrix of
   any size along with the operations transpose, addition,
   and multiplication.

   For simplicity, the data type of matrix elements is limited
   to integer values.
*/

import java.io.*;
import java.util.Scanner; 

public class Matrix
{
   private int numberRows;         // To store dimensions of matrix
   private int numberCols;
   private int elements[][];   // Matrix elements (max 20 rows and columns)

   /**
      Constructor: sets the starting matrix to 3X3 and zeroes elements
   */
   public Matrix()
   {
       elements = new int[3][3];
              
       // Set primary attributes of matrix
       numberRows = 3;
       numberCols = 3;
   
       // Initialize default matrix elements to zero
       for (int i = 0; i < numberRows; i++)
          for (int j = 0; j < numberCols; j++)
             elements[i][j] = 0;
   }
   
   /**
       Constructor: Row and column dimensions passed in as parameters
       Elements of matrix are set to zero
       @param rows    - Number of matrix rows
       @param columns - Number of matrix columns
   */
   public Matrix(int rows, int cols)
   {
       elements = new int[rows][cols];
       
       // Set primary attributes of matrix
       numberRows = rows;
       numberCols = cols;

       // Initialize default matrix elements to zero
       for (int i = 0; i < numberRows; i++)
          for (int j = 0; j < numberCols; j++)
             elements[i][j] = 0;
   }
   
   /**
       Constructor: Row and column dimensions passed in as parameters
       Matrix elements read in from external file (filename passed in).
       If a problem exists with the file (i.e. an exception thrown),
       the processing continues by initializing matrix elements to zero.
       @pre File exists and data pattern matches dimensions of matrix
       @param filename - String containing file name; stored locally
       @param rows     - Number of matrix rows
       @param columns  - Number of matrix columns
   */
   public Matrix(String filename, int rows, int cols)
   {
        elements = new int[rows][cols];

        // Set primary attributes of matrix
        numberRows = rows;
        numberCols = cols;
      
        try
        {
            File inFileRef = new File(filename);
            Scanner inputFile = new Scanner(inFileRef);
        
            // Read-process-write text messages one at a time
            while (inputFile.hasNext())
            {
               for (int i = 0; i < numberRows; i++)
                  for (int j = 0; j < numberCols; j++)
                     elements[i][j] = inputFile.nextInt();
            }
         }
         catch (IOException e)
         {
            // If a file problem, initialize default matrix elements to zero
            for (int i = 0; i < numberRows; i++)
               for (int j = 0; j < numberCols; j++)
                  elements[i][j] = 0;
         } 
   }      

   /**
       Mutator for a specific element
       @param row        - Number of matrix rows
       @param col        - Number of matrix columns
       @param newElement - New value to update at given position
  */
   public void setElement(int row, int col, int newElement)
   {
      elements[row][col] = newElement;
   }

   /**
       Accessor to retrieve a specific element
       @param row  Number of matrix rows
       @param col  Number of matrix columns
       @return     Element at row,column     
  */
   public int getElement(int row, int col)
   {
       return elements[row][col];
   }

   /**
      Perform matrix addition of two available matrix objects.
      @pre             Dimensions of all involved matrices match
      @return          New matrix object that is sum of two inputs 
      @param matrix2   2nd operand in matrix operation
   */
   public Matrix add(Matrix matrix2)
   {
       Matrix result = new Matrix(numberRows,numberCols);      

       for (int i = 0; i < numberRows; i++)      
          for (int j = 0; j < numberCols; j++)  
             result.elements[i][j] = this.elements[i][j] + matrix2.elements[i][j];
       
       return result;      
   }
   
   public Matrix subtract(Matrix matrix2)
   {
       Matrix result = new Matrix(numberRows,numberCols);      

       for (int i = 0; i < numberRows; i++)      
          for (int j = 0; j < numberCols; j++)  
             result.elements[i][j] = this.elements[i][j] - matrix2.elements[i][j];
       
       return result;      
   }


   /**
      Perform matrix transpose of current object
      @return New matrix object that is transpose of "this" object
   */
   public Matrix transpose()
   {
       // Instantiate new matrix with transposed dimensions
       Matrix result = new Matrix(numberCols,numberRows);      

       for (int i = 0; i < numberRows; i++)      
          for (int j = 0; j < numberCols; j++)   
             result.elements[i][j] = this.elements[j][i];
       
       return result;      
   }

   /**
      Perform matrix multiplication of two available matrix objects.
      @pre             Dimensions of all involved matrices match
      @return          New matrix object that is product of two inputs 
      @param matrix2   2nd operand in matrix operation
   */
   public Matrix multiply(Matrix matrix2)
   {
       Matrix result = new Matrix(numberRows,numberCols);      

       for (int i = 0; i < numberRows; i++)      
          for (int j = 0; j < numberCols; j++)   
         {       
            int total = 0;                      
            for (int k = 0; k < numberCols; k++)
               total += this.elements[i][k] * matrix2.elements[k][j];

            result.elements[i][j] = total;
         }

       
       return result;      
   }  
   
   /**
      Return string object with elements of current matrix
      @return  String depiction of matrix         
   */
   public String toString()
   {
      String outString = "";
      for (int i = 0; i < numberRows; i++) 
      {
         for (int j = 0; j < numberCols; j++)  
            outString += String.format("%4d", elements[i][j]) + " ";
         outString += "\n";
      }     
      return outString;
   }

}