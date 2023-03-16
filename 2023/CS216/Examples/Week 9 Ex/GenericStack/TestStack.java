// Delta College - CST 283 - Klingler                         
// This program tests a basic integer stack class
// It implements a test plan 

import javax.swing.JOptionPane;

public class TestStack {

    public static void main(String args[]) 
    {
        // --------------------------------------------------------
        // Test a stack of strings - using Integer wrapper class   
        
        ArrayStack<String> stringStack = new ArrayStack<String>(10);

        stringStack.push("Delta");
        stringStack.push("SVSU");
        System.out.println(stringStack.pop());
        
        stringStack.push("MSU");
        stringStack.push("UofM");
        System.out.println(stringStack.peek());
        
        stringStack.push("Oakland");

        stringStack.pop();
        stringStack.push("Northwood");
        
        while (!stringStack.isEmpty()) 
        {
            System.out.println(stringStack.pop());
        }
        
        // --------------------------------------------------------
        // Test a stack of integers - using Integer wrapper class   
        
        ArrayStack<Integer> intStack = new ArrayStack<Integer>(10);

        intStack.push(1);
        intStack.push(2);
        System.out.println(intStack.pop());
        
        intStack.push(3);
        intStack.push(9);
        System.out.println(intStack.peek());
        
        intStack.push(4);

        for (int i = 6; i <= 8; i++) 
            intStack.push(i);

        intStack.pop();
        intStack.push(4);
        
        while (!intStack.isEmpty()) 
        {
            System.out.println(intStack.pop());
        }
    }
}
