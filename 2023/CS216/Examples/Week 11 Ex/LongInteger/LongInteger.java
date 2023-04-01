// Delta College - CST 283 - Klingler
// This class defines a mechanism to perform arithmetic (addition) on
// extremely long integers stored as linked lists.  Numbers are stored
// from low order digits to high order digits (i.e. in reverse) to
// facilitate addition.  Input and output of the number will be via file
// transfer with digits in the correct order and separated by white space.

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class LongInteger
{
    // --------------------------------------------------------------

    private LinkedList<Integer> theNumber;

    // --------------------------------------------------------------
    // CONSTRUCTORS

    // No-arge constructor
    public LongInteger()
    {
        theNumber = new LinkedList<Integer>();
    }

    // Parameterized constructor.  Read from file and store in reverse order.
    public LongInteger(String filename)
    {
        theNumber = new LinkedList<Integer>();

        int aDigit;

        // File processing to build linked list of digits
        try
        {
            Scanner inputFileScanner;
            File inputfile;

            inputfile = new File(filename);
            inputFileScanner = new Scanner(inputfile);

            while (inputFileScanner.hasNext())
            {
                // Read a digit and add to front of linked list
                aDigit = new Integer(Integer.parseInt(inputFileScanner.next()));
                theNumber.add(new Integer(aDigit));
            }

            inputFileScanner.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: Problem opening input file" + filename);
            System.exit(0);
        }
    }

    // --------------------------------------------------------------
    // METHODS

    // Perform addition by traversing low-order digits to high-order.  Carry
    // number is brought forward.
    public LongInteger addTo(LongInteger number2)
    {
        int num1, num2, temp;
        int carry = 0;

        LongInteger result = new LongInteger();

        // Reset both linked lists
        this.theNumber.resetList();
        number2.theNumber.resetList();

        // Subsequent additions after first read.  Loop always reads ahead.
        while (!this.theNumber.atEnd() && !number2.theNumber.atEnd())
        {
            num1 = this.theNumber.getNextItem();
            num2 = number2.theNumber.getNextItem();

            temp = num1 + num2 + carry;
            result.theNumber.append(new Integer(temp % 10));
            carry = temp / 10;
        }

        // Assuming second number exhausted, append first number to result.
        while (!this.theNumber.atEnd())
        {
            num1 = theNumber.getNextItem();
            temp = num1 + carry;
            result.theNumber.append(new Integer(temp % 10));
            carry = temp / 10;
        }

        // Assuming first number exhausted, append second number to result.
        while (!number2.theNumber.atEnd())
        {
            num2 = number2.theNumber.getNextItem();
            temp = num2 + carry;
            result.theNumber.append(new Integer(temp % 10));
            carry = temp / 10;
        }

        return result;
    }

    // This method reverses the long integer and sends it to a String.
    public String toString()
    {
        String outString = "";
        int oneDigit;
        this.theNumber.resetList();
        while (!this.theNumber.atEnd())
        {
            oneDigit = this.theNumber.getNextItem();;
            outString = Integer.toString(oneDigit) + outString;
        }
        return outString;
    }

    // Write number to file.  Utilize a stack to reverse the number
    // to write in the correct order
    public void writeToFile(String outputFilename)
    {
        // Push entire linked list onto stack for later reversal
        LinkedStack<Integer> tempStack = new LinkedStack<Integer>();
        this.theNumber.resetList();
        while (!this.theNumber.atEnd())
        {
            tempStack.push(this.theNumber.getNextItem());
        }

        try
        {
            PrintWriter outputfileWriter;
            outputfileWriter = new PrintWriter(outputFilename);

            // Traverse stack, pop element and write to file.
            while (!tempStack.isEmpty())
            {
                outputfileWriter.println(tempStack.pop());
            }

            outputfileWriter.close();   // Close file
        }
        catch (IOException e)  // If file error, report to console and crash
        {
            System.out.println("ERROR: Problem opening output file" + outputFilename);
            System.exit(0);
        }
    }
}