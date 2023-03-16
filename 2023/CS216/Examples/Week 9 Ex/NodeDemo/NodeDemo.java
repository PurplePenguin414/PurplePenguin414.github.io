// Delta College - CST 283 - Klingler           
// This application demonstrates basic linked node operations

public class NodeDemo 
{
    // -----------------------------------------------------
    // The Node class is used to implement the linked list.
    static class Node 
    {
        String value;
        Node next;

        Node(String val, Node n) 
        {
            value = val;
            next = n;
        }
    }

    public static void main(String[] args) 
    {
        // -----------------------------------------------------

        Node head;
        Node current;

        head = new Node("C", null);
        current = head;

        current.next = new Node("B", null);
        current = current.next;

        current.next = new Node("A", null);

        writeIt(head);

        //------------------------------------
        Node temp;
        current  = head;
        temp  = current.next;
        current.next  = current.next.next;
        temp = null;

        writeIt(head);

        //------------------------------------
        Node newnode  = new Node("B",null);
        newnode.next  = head;
        head  = newnode;

        writeIt(head);
    }

    // Given a linked data structure with a header pointer, write
    // the contents
    public static void writeIt(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.println( "Node at: " + current  );
            System.out.println( "  Info:  " + current.value );
            System.out.println( "  Next:  " + current. next );
            System.out.println( "\n" );

            current = current.next;
        }
        System.out.println( "\n" );
    }
}
