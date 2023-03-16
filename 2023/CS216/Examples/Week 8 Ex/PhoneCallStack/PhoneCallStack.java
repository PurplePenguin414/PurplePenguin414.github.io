// Delta College - CST 283 - Klingler                         
// This app demos a simple stack of string objects.  Hypothetical
// phone calls are acquired from a file but displayed in reverse.

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class PhoneCallStack 
{
    public static void main(String args[]) 
    {
        StringStack callStack = new StringStack(100);

        // Read file of phone calls and populate stack
        File inputfile = new File("calls.txt");
        try 
        {
            Scanner inputFileScanner = new Scanner(inputfile);
            while (inputFileScanner.hasNext()) 
            {
                // Read a phone number on a line, display it on the 
                // output console and push onto stack
                String inputLine = inputFileScanner.nextLine();  
                System.out.println(inputLine);
                callStack.push(inputLine);
            }
            inputFileScanner.close();
            System.out.println("\n\n\n");

        } catch (IOException e) 
        {
            System.out.println("Problem with file - Shutting down.");
            System.exit(0);
        }
        
        // Dump stack to output console
        while (!callStack.isEmpty())
            System.out.println(callStack.pop());
        System.out.println("\n\n\n");
    }
}
