import java.util.Scanner;  // Import the Scanner class

public class ChangeStack {
    private Node top;
    private static int numElements;

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
        if (isEmpty()) {
            throw new StackEmptyException("Cannot pop from an empty stack.");
        }

        int poppedValue = top.data;
        top = top.next;
        numElements--;
        return poppedValue;
    }

    // PeekTop method
    public int peekTop() {
        if (isEmpty()) {
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
        return numElements == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChangeStack stack = new ChangeStack();

        // Push some elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print the original stack
        System.out.println("Original Stack:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Enter 1 to push, 2 to pop, 3 to peek");
        String user1 = scanner.nextLine();

        if (user1 == "1"){
            System.out.println("Enter each number seperated by a space that you want to push");
            String user1a = scanner.nextLine();
            String[] elements = user1a.split(" ");

            int i = -1;
            stack.push(Integer.parseInt(elements[i++]));
        }

        // Increase values of the bottom 2 elements by 5
        stack.increaseValues(2, 5);

        // Print the modified stack
        System.out.println("\nStack after increaseValues:");
        System.out.println("Top: " + stack.peekTop());
    }
}
