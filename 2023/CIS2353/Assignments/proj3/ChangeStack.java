// Megan Gibbs
// Project 3
// CIS 2353
// Fall 2023
// Prof. John P. Baugh

import java.util.Scanner;  // Import the Scanner class

public class ChangeStack {
    private Node top;
    private static int numElements;
    private static boolean Empty;

    // Constructor
    public ChangeStack() {
        this.numElements = 0;
        this.top = null;
    }

    // Node class
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Custom exception for empty stack
    public static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String message) {
            super(message);
        }
    }

    // Push method
    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        numElements++;
    }

    // Pop method
    public int pop() {
        if (!isEmpty()) {
            throw new StackEmptyException("Cannot pop from an empty stack.");
        }

        int poppedValue = top.data;
        top = top.next;
        numElements--;
        return poppedValue;
    }

    // PeekTop method
    public int peekTop() {
        if (!isEmpty()) {
            throw new StackEmptyException("Cannot peek on an empty stack.");
        }

        return top.data;
    }

    // IncreaseValues method
    public void increaseValues(int k, int amount) {
        Node current = top;
        for (int i = 0; i < k && current != null; i++) {
            current.data += amount;
            current = current.next;
        }
    }

    // DecreaseValues method
    public void decreaseValues(int k, int amount) {
        Node current = top;
        for (int i = 0; i < k && current != null; i++) {
            current.data -= amount;
            current = current.next;
        }
    }

    // Helper method to check if the stack is empty
    private static boolean isEmpty() {
        if (numElements == 0){
            return Empty == true;
        }else
            return Empty == false;
    }

    //Main method
    public static void main(String[] args) {
        int end = 1;
        while (end != 0){
            Scanner scanner = new Scanner(System.in);
            ChangeStack stack = new ChangeStack();

            System.out.println("_______________________________________________________________");
            
            // Push some starter elements onto the stack
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Print the original stack
            System.out.println("Original Stack:");
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());

            stack.push(1);
            stack.push(2);
            stack.push(3);

            //User directions
            System.out.println("Enter e to exit the program");
            System.out.println("Enter 1 to push, 2 to pop, 3 to peek, Enter i to increase, d to decrease values");
            String user1 = scanner.nextLine();

            if (user1.equalsIgnoreCase("e")){
                end = 0;
                break;
            }

            int temp = 0;
            String t = "00";
            while (temp >= 0) {
                //depending on input complete desired actions
                if (user1.contains("1")){
                    System.out.println("Enter each number one by one that you want to push (enter 00 to end)");
                    String user1a = scanner.nextLine();

                    if (user1a.equalsIgnoreCase("e")){
                        end = 0;
                    }   

                    while (!(user1a.contains(t))) {
                        stack.push(Integer.parseInt(user1a));
                        user1a = scanner.next(); 
                    }
                    temp = -1;
                }else if (user1.contains("2")) {
                    System.out.println("***POP***");

                    System.out.println(stack.pop());
                    
                    temp = -1;
                }else if (user1.contains("3")) {
                    System.out.println("***PEEK***");

                    System.out.println(stack.peekTop());
                    temp = -1;
                }else if (user1.contains("i")){
                    System.out.println("Should increase the bottom k elements in the stack by the amount. "+'\n'+
                    "Enter two parameters: an integer k "+'\n'+ "and then an integer a");
                    String user2a = scanner.next();
                    String user2b = scanner.next();
                    stack.increaseValues(Integer.parseInt(user2a),Integer.parseInt(user2b));
                    temp = -1;
                }else if (user1.contains("d")){
                    System.out.println("Should decrease the bottom k elements in the stack by the amount. "+'\n'+
                    "Enter two parameters: an integer k "+'\n'+ "and then an integer a");
                    String user2a = scanner.next();
                    String user2b = scanner.next();
                    stack.decreaseValues(Integer.parseInt(user2a),Integer.parseInt(user2b));
                    temp = -1;
                }else{
                    System.out.println("Invalid Entry, Please try again");
                    temp++;
                }
            }
            temp = 0;
            
            //Print stack after changes
            int i = 1;
            System.out.println("\nStack after:");
            while (i != 0){
                if ( isEmpty())
                    System.out.println(stack.pop());
                else
                    i = 0;
            }
        } //Return to begining
    }
}
