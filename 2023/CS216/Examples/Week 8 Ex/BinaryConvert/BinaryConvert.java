// Delta College - CST 283 - Klingler  
// This program reads an integer and converts it to a bit string.

import javax.swing.JOptionPane;

public class BinaryConvert 
{
    public static void main( String args[] )
    {
        int inputNumber;
        inputNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter integer"));
        
        // Instantiate stack necessary for algorithm
        IntStack theStack = new IntStack(80);
    
        // Convert to bitstream using repetitive division by 2
        int number = inputNumber;
        int leftover, remainder;
        while (number >= 1)    
        {
            leftover = number / 2;
            remainder = number % 2;
            theStack.push(remainder);
            number = leftover;
        }
    
        // Binary number is generated in reverse.  Dump stack to display.
        String outputString = Integer.toString(inputNumber) + " is binary ";
        while (!theStack.isEmpty())
        {
            outputString += Integer.toString(theStack.pop());
        }
        
        JOptionPane.showMessageDialog(null, outputString);
        
        System.exit(0);
    }
}

