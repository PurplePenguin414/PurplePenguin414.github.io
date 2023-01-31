// Delta College - CST 283 - Klingler
// This application is a test driver for the Matrix class.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MatrixDriver 
{
   public static void main( String[] args ) 
   {
      // Test matrix constructor
   
      Matrix matrix1 = new Matrix();   
      System.out.println(matrix1.toString());
      
      // Load matrices from files

      Matrix matrix2 = new Matrix("matrix1",4,4); 
      System.out.println(matrix2.toString());
      
      Matrix matrix3 = new Matrix("matrix2",4,4);
      System.out.println(matrix3.toString());
      
      // Perform matrix operations
      
      Matrix matrix4 = matrix2.multiply(matrix3);
      System.out.println(matrix4.toString());
      
      Matrix matrix5 = matrix2.add(matrix3);
      System.out.println(matrix5.toString());  
      
      Matrix matrix7 = matrix2.subtract(matrix3);
      System.out.println(matrix5.toString());  
          
      Matrix matrix6 = matrix2.transpose();
      System.out.println(matrix6.toString());    
        
   }
}
