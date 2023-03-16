// Delta College - CST 283 - Klingler
// This program reads a file of infix expressions (as strings) and
// converts them to postfix expressions
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class InPost 
{
    public static final String expressionFileName = "infix.txt";
    
    public static void main(String[] args) throws IOException
    {
        File inputfile;    
        String inputExpression;     // Input expression line
        String message = "";        // Output message
        String outExpression;
   
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
            inputExpression  = inputAveFile.next();
            message = inputExpression;

            outExpression = Infix_to_Postfix(inputExpression);   

            message = message + " ==> " + outExpression + "\n\n";
            
            System.out.println(message);
        }
        
        // Close input file and close down
        inputAveFile.close();   
        System.exit(0);  
}

    /*****************************************************************/
    // This method receives a string representing an infix 
    // arithmetic expression.  It converts the expression to the 
    // equivalent postfix expression and returns as a string.
    // PRE: expression is valid and parentheses are balanced
    /*****************************************************************/
    public static String Infix_to_Postfix(String inString)
    {
        String outString = "";
        int len = inString.length();

        int i;
        char symbol,addSym,atTop,justPopped;
        CharStack theStack = new CharStack(50);

        // Iterate through infix string - one char at a time
        for (i = 0; i < len; i++)
        {
            // Read next symbol
            symbol = inString.charAt(i);

            // Handle variables
            if (aVariable(symbol))
                outString += symbol;

            // Handle operators
            if (anOperator(symbol))
            {
                while (!theStack.isEmpty() && theStack.peek() != '(' && 
                        Precedence(theStack.peek()) >= Precedence(symbol) )
                {
                    addSym = theStack.pop();
                    outString += addSym;
                }
                theStack.push(symbol);
            }

            // Handle open parenthesis
            if (symbol == '(')
                theStack.push(symbol);

            // Handle close parenthesis
            if (symbol == ')')
            {
                while (theStack.peek() != '(' )
                {
                    addSym = theStack.pop();
                    outString += addSym;
                }
                justPopped = theStack.pop();
            }
        } 

        // Handle remaining stack (if necessary)
        while(!theStack.isEmpty())
        {
            addSym = theStack.pop();
            outString += addSym;
        }

        return outString;

    }

    /*****************************************************************/
    // Deterimine if a char is an arithmetic operator.
    public static boolean anOperator (char charVal)
    {
        if (charVal == '*' || charVal == '/' ||
            charVal == '+' || charVal == '-')
            return true;
        else
            return false;
    }

    /*****************************************************************/
    // Deterimine if a char is a variable.
    public static boolean aVariable (char charVal)
    {
        if ((charVal >= 65 && charVal <= 90) ||
            (charVal >= 97 && charVal <= 122))
            return true;
        else
            return false;
    }

    /*****************************************************************/
    // Define multiplication/division as a higher precedence (returning 2)
    // than addition/substraction (returning 1)
    public static int Precedence (char charVal)
    {
        if (charVal == '*'|| charVal == '/')
            return 2;
        else if (charVal == '+'|| charVal == '-')
            return 1;
        else 
            return 0;
    }
}

