// Delta College - CST 183 - Klingler
// This program tests a recursive algorithm for the greatest
// common divisor of two integer values

import javax.swing.JOptionPane;

public class GCD 
{
    public static void main(String[] args) 
    {
        int value1, value2, gcdResult;
        
        // Input
        value1 = Integer.parseInt(
                JOptionPane.showInputDialog("Enter 1st value:"));
        value2 = Integer.parseInt(
                JOptionPane.showInputDialog("Enter 2nd value:"));
        
        // Calculate GCD
        gcdResult = gcd(value1, value2);
        
        // Output results
        String outstring = "The greatest common divisor of: "
                + value1 + " and " + value2 + " is "
                + gcdResult;
        JOptionPane.showMessageDialog(null, outstring);
        
        System.exit(0);
    }

    // This method recursively determines the greatest common
    // divisor between two integer values
    public static int gcd(int x, int y) 
    {
        if (x % y == 0) 
            return y;
        else
            return gcd(y, x % y);
    }
}