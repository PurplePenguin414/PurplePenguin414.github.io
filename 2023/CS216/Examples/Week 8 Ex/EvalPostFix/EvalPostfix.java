
// Delta College - CST 283 - Klingler
/// This program reads and evaluates a sequence of postfix arithmetic
// expressions.
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class EvalPostfix 
{
    public static final String expressionFileName = "postfix.txt";
    
    public static void main(String[] args) throws IOException
    {
        File inputfile;    
        String inputExpression;     // Input expression line
        String message = "";        // Output message
        double answer;
   
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

            answer = evalPostfix(inputExpression);   // Convert postfix expression

            message = message + " evaluates to: " + answer + "\n\n";
            
            System.out.println(message);
        }
        
        // Close input file and close down
        inputAveFile.close();   
        System.exit(0);  
    }

    /*****************************************************************/
    // This function accepts a string containing a postfix arithmetic
    // expression.  It then evaluates and returns it.
    // PRE: Only single-digit, integer numbers are used as operands
    // division by zero cannot occur

    public static double evalPostfix(String expression)
    {
        StackDouble theStack = new StackDouble(50);     // Stack for managing conversion
        char operation = ' ';
        double operand1, operand2, result;

        int len = expression.length();       // Get length of string

        int i = 0;
        while (i < len)
        {
            if (Character.isDigit(expression.charAt(i)))       // If token a number, push onto stack
                theStack.push(Double.parseDouble(expression.substring(i,i+1)));
            else                                  // if token is operator
            {
                operation = expression.charAt(i);  //     keep required operation
                operand2 = theStack.pop();         //     pop a number from stack
                operand1 = theStack.pop();         //     pop a number from stack
                result = arithOperation(operand1,operation,operand2);         
                theStack.push(result);             // Push result onto stack
            }     
            i++;
        }
        return theStack.pop();               // Last element on stack is answer
    }

    /*****************************************************************/
    // This method accepts two floating point values and a char representing
    // an arithmetic operator.  It performs the give operation and returns
    // the result
    public static double arithOperation(double operand1, char token, double operand2)
    {
       double answer = 0;
       
       System.out.println( operand1 + " " + token + " " + operand2);

       switch (token)
       {
          case '+': answer = operand1 + operand2; break;
          case '-': answer = operand1 - operand2; break;
          case '*': answer = operand1 * operand2; break;
          case '/': answer = operand1 / operand2; break;  
       };
       return answer;
    }

    /*****************************************************************/
    // This method converts a char value '0' ... '9'to a double value
    public static double charToDouble(char inChar)
    {
       return Double.parseDouble(Character.toString(inChar));
    }

}
