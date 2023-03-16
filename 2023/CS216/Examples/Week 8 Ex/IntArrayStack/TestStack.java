// Delta College - CST 283 - Klingler                         
// This program tests a basic integer stack class
// It implements a test plan 

import javax.swing.JOptionPane;

public class TestStack {

    public static void main(String args[]) 
    {
        IntStack theStack = new IntStack(30);

        theStack.push(1);
        theStack.push(2);
        System.out.println(theStack.pop());
        
        theStack.push(3);
        theStack.push(9);
        System.out.println(theStack.peek());
        
        theStack.push(4);

        for (int i = 6; i <= 8; i++) 
            theStack.push(i);

        theStack.pop();
        theStack.push(4);
        
        while (!theStack.isEmpty()) 
        {
            System.out.println(theStack.pop());
        }
    }
}
