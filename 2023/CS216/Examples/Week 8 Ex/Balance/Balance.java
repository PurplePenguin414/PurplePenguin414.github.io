// Delta College - CST 283 - Klingler
// This program reads an arithmetic expression and tests to determine
// whether or not in includes balanced grouping symbols

// PRE: Expression contains only grouping symbols, operators, and 
// one character numerical operands (for ease of char processing)

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class Balance
{
    // Constants
    public static final String expressionFileName = "balanceTest.txt";

    public static void main(String[] args) throws IOException
    {
        File inputfile;    
        String testExpression;      // Input expression line
        String message = "";        // Output message
   
        // Instantiate required objects
        inputfile = new File(expressionFileName);  // Create file input object
       
        // Check for file existence.  
        if (!inputfile.exists())
        {   
            JOptionPane.showMessageDialog( null, 
               "File was not found", 
               "File Error", 
               JOptionPane.ERROR_MESSAGE );
            System.exit(0);
        }
        
        // Read and process file of expressions one at a time
        Scanner inputAveFile = new Scanner(inputfile);
        while (inputAveFile.hasNext())
        {
            testExpression  = inputAveFile.next();
            message = testExpression;

            if (balanceOK(testExpression))
                message += " ==> balanced";
            else
                message += " ==> not balanced";
            
            System.out.println(message);
        }
        
        // Close input file and close down
        inputAveFile.close();   
        System.exit(0);  
    }

    // This method evaluates an arithmetic expression for balanced 
    // grouping symbols.  Expression is passed in as a string.  The only
    // grouping symbols used will be { }, ( ), or [ ].
    public static boolean balanceOK(String expression) 
    {
        CharStack theStack = new CharStack(50);   // Stack for managing conversion
    
        boolean balancedSoFar = true;        // Assume that expression is balanced

        char checkSymbol;

        int len = expression.length();    // Length of expression string
        int i = 0;

        // Test for balance; exit at end of expression or when found to be 
        // unbalanced.
        while (i < len && balancedSoFar) 
        {
            // Test for open grouping symbol - push onto stack
            if (expression.charAt(i) == '{' || 
                expression.charAt(i) == '(' || 
                expression.charAt(i) == '[') 
            {
                    theStack.push(expression.charAt(i));
            }
            else   // If a closing brace; then pop to find matching symbol (if stack not empty)  
            {
                if (expression.charAt(i)== '}' || 
                    expression.charAt(i) == ')' || 
                    expression.charAt(i) == ']') 
                {
                    if (!theStack.isEmpty()) 
                    {
                        checkSymbol = theStack.pop();

                        // If popped symbol not a match, declare bad
                        if (checkSymbol == '{' && expression.charAt(i) != '}') 
                            balancedSoFar = false;
                        if (checkSymbol == '(' && expression.charAt(i) != ')') 
                            balancedSoFar = false;
                        if (checkSymbol == '[' && expression.charAt(i) != ']') 
                            balancedSoFar = false;
                    } 
                    else 
                    {
                        balancedSoFar = false;      // Nothing matching; declare bad
                    }
                }
            }
            i++;                                    // Advance to next character          
        }
        if (balancedSoFar && theStack.isEmpty()) 
            return true;
        else 
            return false;
    }
    
}
   