// Delta College - CST 283 - Klingler
// This program demonstrates various bitwise operations

import java.util.Scanner;

public class TestBitwise {

    public static void main(String args[]) 
    {
        int val1 = 1235;
        int val2 = 19877;
        int val3;

        // Write binary values of test data
        System.out.print("Value 1: " + val1 + "  or ");
        System.out.println(dec_to_bin(val1));
        System.out.print("Value 2: " + val2 + " or ");
        System.out.println(dec_to_bin(val2) + "\n");

        // Test bitwise OR
        val3 = val1 | val2;
        System.out.print("1234 bitwise-or 19876 is: " + val3 + " or ");
        System.out.println(dec_to_bin(val3) + "\n");

        // Test bitwise AND
        val3 = val1 & val2;
        System.out.print("1234 bitwise-and 19876 is: " + val3 + " or ");
        System.out.println(dec_to_bin(val3) + "\n");

        // Test bitwise XOR (Exclusive OR)
        val3 = val1 ^ val2;
        System.out.print("1234 bitwise-XOR 19876 is: " + val3 + " or ");
        System.out.println(dec_to_bin(val3) + "\n");

        // Test bitwise shift right
        val3 = val2 >> 1;
        System.out.print("19876 shift right is: " + val3 + " or ");
        System.out.println(dec_to_bin(val3) + "\n");

        // Test bitwise shift left
        val3 = val2 << 1;
        System.out.print("19876 shift left is: " + val3 + " or ");
        System.out.println(dec_to_bin(val3) + "\n");

        // Test bitwise shift complement
        val3 = ~val2;
        System.out.println("Complement of 19876 is: " + val3+ "\n\n");
        System.exit(0);
    }

// This mwrhos receives an integer and writes the binary equivalent
// to console output.  The strategy includes dividing by successive powers
// of 2 from to build binary number from high-order to low-order digits.
// Precondition:    0  < input value < 32,767 (or 2^16-1)
// Postcondition:   Input value unchanged
    public static String dec_to_bin(int val) 
    {
        int digit;
        String outBitString = "";

        for (int ex = 15; ex >= 0; ex--) 
        {
            digit = val / (int)Math.pow(2.0, ex);  // Divide by current power of 2
            outBitString += digit;
            val = val % (int)Math.pow(2.0, ex);     // Reset number to remainder
                                                    // after extracting power of 2
        }
        return outBitString;
    }
}
