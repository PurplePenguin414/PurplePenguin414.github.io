
import java.util.ArrayList;
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

