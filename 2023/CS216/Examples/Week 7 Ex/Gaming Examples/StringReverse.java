// Delta College - CST 183 - Klingler
// This program tests a recursive algorithm that writes a
// character string in reverse order

import javax.swing.JOptionPane;

public class StringReverse {

    public static void main(String[] args) 
    {
        String inputString = "EGELLOC ATLED";

        // Write string in reverse - using recursive call
        stringReverse(inputString);

        System.exit(0);
    }

    // This method receives a string and writes it in reverse.
    public static void stringReverse(String currentString) 
    {
        if (currentString.length() > 0) 
        {
            stringReverse(currentString.substring(1, currentString.length()));
            System.out.println(currentString.charAt(0));
        }
        // Base case: empty string; do nothing
    }
   
}
