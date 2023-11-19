/**
 * import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    int exponent;
    int coefficient;
    Node nextNode;

    public Node(int exponent, int coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = null;
    }
}

public class proj2 {
    private static final char[] toString = null;
    private Node head;

    // Constructors and other methods go here...

    public proj2(String polynomialString) {
    }

    public static proj2 add(proj2 poly1, proj2 poly2) {
        // Implementation to add two proj2s and return a new proj2
        // This involves combining like terms and creating a new proj2
        // with the result of the addition.
        // You'll need to iterate through both proj2s and add corresponding terms.
        // Your implementation here...
        return null;  // Replace this with the actual result
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<proj2> polynomials = new ArrayList<>();

        // Read polynomials from file and add them to the ArrayList
        File file = new File("2023\\CIS2353\\Assignments\\proj2\\polynomials.txt");

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String polynomialString = scanner.nextLine().trim();

                System.out.println(polynomialString);

                proj2 polynomial = new proj2(polynomialString);

                System.out.println(proj2.toString);

                polynomials.add(polynomial);
            }

            // Continue with the rest of your program logic...

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        // Print the list of polynomials
        System.out.println("List of Polynomials:");
        for (int i = 0; i < polynomials.size(); i++) {
            System.out.println(i + ": " + polynomials.get(i));
        }
        

        int choice;
        do {
            System.out.println("Which do you wish to add? Press -1 to Exit.");
            choice = scanner.nextInt();

            if (choice == -1) {
                break;
            }

            if (choice < 0 || choice >= polynomials.size()) {
                System.out.println("Invalid input. Please enter a valid index.");
                continue;
            }

            System.out.println("Enter the index of the second polynomial to add:");
            int secondIndex = scanner.nextInt();

            if (secondIndex < 0 || secondIndex >= polynomials.size()) {
                System.out.println("Invalid input. Please enter a valid index.");
                continue;
            }

            // Add the selected polynomials and print the updated list
            proj2 result = proj2.add(polynomials.get(choice), polynomials.get(secondIndex));
            polynomials.add(result);

            System.out.println("List of Polynomials:");
            for (int i = 0; i < polynomials.size(); i++) {
                System.out.println(i + ": " + polynomials.get(i));
            }

        } while (choice != -1);

        class polynomials{
        String x;
    
        @Override
        public String toString() {
            return  x;    // print out a formatted ordered pair
        }
    }
    }
    
}
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Node {
    String exponent;
    String coefficient;

    int ex;
    int co;

    Node nextNode;

    public Node(String exponent, String coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = null;
    }

    public Node(int ex, int co) {
        this.ex = ex;
        this.co = co;
        this.nextNode = null;
    }
}

public class proj2 {
    private Node head;  // head of the linked list representing the polynomial

    // No-argument constructor
    public proj2() {
        this.head = null;
    }

    // Constructor to create Polynomial from a string
    public proj2(String poly) {
        // Split the input string into individual terms
        String[] termStrings = poly.split("\\+");

        // Iterate through each term and create a Node for it
        for (String termString : termStrings) {
            // Remove any leading or trailing spaces
            termString = termString.trim();

            // Split the term into coefficient and exponent
            String[] parts = termString.split("x\\^");

            String coefficient;
            String exponent;

            // Handle the case where the coefficient is missing
            if (parts.length == 1) {
                coefficient = (parts[0].trim());
                exponent = "1"; // Assume the exponent is 1 when not explicitly given
            } else {
                coefficient = (parts[0].trim());
                exponent = (parts[1].trim());
            }

            // Create a new Node for the term
            Node termNode = new Node(exponent, coefficient);

            // Add the termNode to the linked list
            if (head == null) {
                // If the linked list is empty, set the new node as the head
                head = termNode;
            } else {
                // Otherwise, find the last node and link the new node
                Node current = head;
                while (current.nextNode != null) {
                    current = current.nextNode;
                }
                current.nextNode = termNode;
            }
        }
    }

    // Copy constructor
    public proj2(proj2 otherPoly) {
        if (otherPoly.head == null) {
            // If the other polynomial is empty, set head to null
            this.head = null;
        } else {
            // Perform a deep copy of the linked list
            Node otherCurrent = otherPoly.head;
            Node newCurrent = new Node(otherCurrent.exponent, otherCurrent.coefficient);
            this.head = newCurrent;

            // Iterate through the rest of the linked list and copy each node
            while (otherCurrent.nextNode != null) {
                otherCurrent = otherCurrent.nextNode;
                newCurrent.nextNode = new Node(otherCurrent.exponent, otherCurrent.coefficient);
                newCurrent = newCurrent.nextNode;
            }
        }
    }

    // Method to print the polynomial
    public void print() {
        Node current = head;
        while (current != null) {
            // Print the term represented by the current node
            System.out.print(current.coefficient + "x^" + current.exponent);

            // Move to the next node
            current = current.nextNode;

            // If there's another term, print a "+"
            if (current != null) {
                System.out.print(" + ");
            }
        }
        System.out.println();  // Move to the next line after printing the polynomial
    }

    // Static method to add two polynomials and return a new polynomial
    public static proj2 add(proj2 poly1, proj2 poly2) {
        proj2 result = new proj2();

        Node current1 = poly1.head;
        Node current2 = poly2.head;
        Node currentResult = null;

        while (current1 != null || current2 != null) {
            
            int coeff1 = (current1 != null) ? current1.coefficient.charAt(0) : 0;
            int exp1 = (current1 != null) ? current1.exponent.charAt(1) : Integer.MIN_VALUE;

            int coeff2 = (current2 != null) ? current2.coefficient.charAt(0) : 0;
            int exp2 = (current2 != null) ? current2.exponent.charAt(1) : Integer.MIN_VALUE;

            int sumCoeff = coeff1 + coeff2;

            // Create a new node for the result
            Node resultNode = new Node(Math.max(exp1, exp2), sumCoeff);

            if (result.head == null) {
                // If it's the first node, set it as the head
                result.head = resultNode;
                currentResult = result.head;
            } else {
                // Link the new node to the previous one
                currentResult.nextNode = resultNode;
                currentResult = currentResult.nextNode;
            }

            // Move to the next nodes in both polynomials
            if (current1 != null) {
                current1 = current1.nextNode;
            }
            if (current2 != null) {
                current2 = current2.nextNode;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<proj2> polynomials = new ArrayList<>();

        // Read polynomials from file and add them to the ArrayList
        File file = new File("2023\\CIS2353\\Assignments\\proj2\\polynomials.txt");

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String polynomialString = scanner.nextLine();

                System.out.println(polynomialString);

                proj2 polynomial = new proj2(polynomialString);

                System.out.println(polynomial);

                polynomials.add(polynomial);
            }

            // Continue with the rest of your program logic...

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        // Print the list of polynomials
        System.out.println("List of Polynomials:");
        for (int i = 0; i < polynomials.size(); i++) {
            System.out.println(i + ": " + polynomials.get(i));
        }

        // User input loop
        int choice;
        do {
            System.out.println("Which do you wish to add? Press -1 to Exit.");
            choice = scanner.nextInt();

            if (choice >= 0 && choice < polynomials.size()) {
                int choice2 = scanner.nextInt();

                if (choice2 >= 0 && choice2 < polynomials.size()) {
                    // Add the selected polynomials and print the updated list
                    proj2 result = proj2.add(polynomials.get(choice), polynomials.get(choice2));
                    polynomials.add(result);

                    System.out.println("List of Polynomials:");
                    for (int i = 0; i < polynomials.size(); i++) {
                        System.out.println(i + ": " + polynomials.get(i));
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid index.");
                }
            } else if (choice != -1) {
                System.out.println("Invalid input. Please enter a valid index.");
            }

        } while (choice != -1);

        scanner.close();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Node current = head;
        while (current != null) {
            result.append(current.coefficient).append("x^").append(current.exponent);

            current = current.nextNode;

            if (current != null) {
                result.append(" + ");
            }
        }

        return result.toString();
    }

}
