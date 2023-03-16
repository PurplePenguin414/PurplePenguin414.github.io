// Delta College - CST 283 - Klingler
// This program reads a string object from the user and determines
// if the word stored within is a palindrome or not

import javax.swing.*;

public class Palindrome 
{
    public static void main(String[] args) 
    {

        String theWord = JOptionPane.showInputDialog(null, "Enter a string: ");

        if (isPalindrome(theWord)) {
            JOptionPane.showMessageDialog(null, theWord + " is a palindrome");
        } else {
            JOptionPane.showMessageDialog(null, theWord + " is not a palindrome");
        }

        System.exit(0);
    }

    // This method receives a string object and returns TRUE
    // if the object represents a palindrom and FALSE otherwise
    public static boolean isPalindrome(String word) 
    {
        StringQueue charQueue = new StringQueue(50);
        StringStack charStack = new StringStack(50);
         
        boolean palindromeOK = true;       // Assume a palindrom until detecting otherwise

        // Traverse characters of word, In sequence, push into a stack
        // and enqueue into a queue.
        int len = word.length();
        for (int i = 0; i < len; i++) 
        {
            charStack.push(word.substring(i,i+1));
            charQueue.enqueue(word.substring(i,i+1));
        }

        // Pop and access characters in reverse order.  Match with
        // corresponding character in queue.  Any mismatch would
        // disqualify string as a palindrome
        String fromQueue, fromStack;
        while (!charStack.isEmpty()) {
            // Get next characters from queue and stack
            fromStack = charStack.pop();
            fromQueue = charQueue.dequeue();

            // Test for mismatch
            if (! fromStack.equalsIgnoreCase(fromQueue))
                palindromeOK = false;
        }

        return palindromeOK;
    }
}