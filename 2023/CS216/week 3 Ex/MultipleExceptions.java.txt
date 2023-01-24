import javax.swing.JOptionPane;  

public class MultipleExceptions 
{
   public static void main( String args[] )
   {
        String inputString = JOptionPane.showInputDialog("Enter Value: ");  
        String myString = "DELTA";
        String anotherString;
        int theNum, anotherNum, aPosition;
        int x[] = {7,8,9};
     
        try  // Attempt to perform number conversion
        {
            theNum  = Integer.parseInt(inputString);           
            anotherNum  = 2 / theNum;
            anotherString = myString.substring(theNum);
            theNum  = x[theNum];
            JOptionPane.showMessageDialog(null,"No Problems");
        }
        catch (NumberFormatException e1)
        {
            JOptionPane.showMessageDialog(null,"NumberFormatException");
        }
        catch (ArithmeticException e2)
        {
            JOptionPane.showMessageDialog(null,"ArithmeticException");
        }
        catch (ArrayIndexOutOfBoundsException e3)
        {
            JOptionPane.showMessageDialog(null,"ArrayIndexOutOfBoundsException");
        }
        catch (StringIndexOutOfBoundsException e4)
        {
            JOptionPane.showMessageDialog(null,"StringIndexOutOfBoundsException");
        }
        
        System.exit( 0 );   
    } 
} 
