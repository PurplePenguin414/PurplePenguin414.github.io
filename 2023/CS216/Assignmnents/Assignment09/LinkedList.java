import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Delta College - CST 283 - gibbs           
// This runs an election

public class LinkedList<Vote> {

    // --------------------------------------------------------------
    // Private inner class definition of standard data node
    private class Node {
        Node next;

        // Construct node with data null sucessor
        Node(int id2, boolean v)
        {
           this(id2, v,null);            
        }
        // Construct node with data and reference to successor
        Node(int id2, boolean v, Node n) {
            this(id2, v, n);
            next = n;
        }

        
    }
    // --------------------------------------------------------------

    private Node first; // list head
    private Node last; // last element in list

    private Node currentPos; // Current position for iterator action
    private int numElems;

    // --------------------------------------------------------------
    // No-arg constructor for linked list. Declare empty; null out pointers
    public LinkedList policy101() {
        first = null;
        last = null;
        return null;
    }

    public void policy101(File fileName) {
        addVotes(fileName);
    }


    public LinkedList() {
        first = null;
        last = null;
    }

    // --------------------------------------------------------------
    // Observer to determine if list empty
    public boolean isEmpty() {
        return first == null;
    }

    // -------------------------------------------------------------
    // Get current (integer) length of list
    public int size() {
        int count = 0;
        Node currNode = first;
        while (currNode != null) {
            count++; // Increment counter
            currNode = currNode.next; // Advance to next node
        }
        return count;
    }

    // --------------------------------------------------------------
    // Method adds an element to the front of the list
    public void addVotes(File fileName) {
        // Open file. Process in batch format line-by-line
        LinkedList<Vote> policy101 = new LinkedList<Vote>();
        try {
            // read data from file
            Scanner scanner = new Scanner(fileName);

            // read each line and create Vote object
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");

                int voterId = Integer.parseInt(fields[0]);
                int vote = Integer.parseInt(fields[1]);

                boolean voteBoolean = false;
                if (vote == 1) {
                    voteBoolean = true;
                }

                Vote v = new Vote(voterId, voteBoolean);
                policy101.add(v);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    // --------------------------------------------------------------
    // Method removes an element by searching for and matching the value
    public void removeVotes(String fileName) {
        // Open file. Process in batch format line-by-line
        Node nodePtr;
        resetList();
        nodePtr = first; 
        // Start search from head of list
        try {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(fileName);
            inputFileScanner = new Scanner(inputfile);
            
            int id, v = 0;
            boolean vb = false;
            int i = 0;
            while (inputFileScanner.hasNext()) {
                // Read first data tokens - type of claim, date
                id = inputFileScanner.nextInt();
                v = inputFileScanner.nextInt();
                if (v == 0){
                    ((Vote) this.Votes).setID(vb);
                }else if (v == 1){
                    vb = true;
                    this.setVote(vb);
                }else;
                i++;
                System.out.println(this.toString());
                // Special case: empty list - do nothing

                // Special case: element matched for deletion is first element
                if (first.ID.equals(id)) {
                    first = first.next;
                    if (first == null){
                        last = null;
                    }else;
                }else;

                // Find the predecessor of the element to remove
                Node pred = first;
                while (pred.next != null && !pred.next.ID.equals(id)) {
                    pred = pred.next;
                }

                // If not found return false
                if (pred.next == null)
                    System.out.println("Not found");

                // Otherwise, element found and pred.next.value is element
                pred.next = pred.next.next; // Bypass element to delete it

                // Special case: check if pred is now last
                if (pred.next == null)
                    last = pred;

                System.out.println("Found and removed");
            }
            inputFileScanner.close(); // Close file
        } catch (IOException e) // If file error, reset list status flag
        {
            System.out.println("Problem with File - Shutting Down");
            System.exit(0);
        }

    }

    // --------------------------------------------------------------
    public void removeDuplicates() {
        boolean moreToSearch;
        Node nodePtr;

        nodePtr = first; // Start search from head of list
        boolean found = false; // Assume value not found
        int id = 0;
        boolean v = false;
        moreToSearch = (nodePtr != null);
        int i = 0;
        while (moreToSearch) {
            if (nodePtr.ID.equals(id)) {
                // Special case: remove element at front of list
                Votes element; // The element to return
                if (nodePtr.next.ID.equals(null)) {
                    i++;
                    // Adjust reference pointers at front
                    element = first.v;
                    first = first.next;
                    if (first == null)
                        last = null;
                } else {
                    i++;
                    // To remove an element other than the first, find the predecessor
                    // of the element to be removed by marching variable pred
                    // forward index - 1 times
                    Node pred = first;
                    for (int k = 1; k <= i - 1; k++)
                        pred = pred.next;

                    element = pred.next.ID; // Capture return value

                    pred.next = pred.next.next; // Bypass element to be removed

                    // Special case: check if pred is now last; adjust if necessary
                    if (pred.next == null)
                        last = pred;
                }
            } else {
                i++;
                nodePtr = nodePtr.next;
                moreToSearch = (nodePtr != null);
            }
        }
        System.out.println("Duplicates removed ");
    }

    // --------------------------------------------------------------
    public boolean didVotePass() {
        int yesCount = 0;
        int noCount = 0;
        Votes currentItem;

        // Utilize iterators to navigate through list and count
        resetList();
        while (!atEnd()) {
            currentItem = getNextItem();
            if (currentItem.equals(true))
                yesCount++;
            else if (currentItem.equals(false))
                noCount++;
        }
        if (yesCount > noCount)
            return true;
        else
            return false;
    }


    // --------------------------------------------------------------
    // Observer function to return current list length
    public void resetList() {
        currentPos = first;
    }

    // --------------------------------------------------------------
    // Function: Gets the next element in list as
    // referenced by currPtr
    // Pre: Current position is defined.
    // Post: Current position is updated to next position.
    // item is a copy of element at current position.
    public Votes getNextItem() {
        Votes item;

        if (currentPos == null)
            currentPos = first; // Wrap if position is at end

        item = currentPos.vote; // Get item at current position
        currentPos = currentPos.next; // Advance to next position

        return item; // Return item
    }

    // --------------------------------------------------------------
    // Observer function to determine if current
    // is the end of the list
    public boolean atEnd() {
        if (currentPos == null)
            return true;
        else
            return false;
    }

    // --------------------------------------------------------------
    // The toString method computes the string representation of the list.
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use currPos to walk down the linked list
        Node currPos = first;
        while (currPos != null) {
            strBuilder.append(currPos.vote + "\n");
            currPos = currPos.next;
        }
        return strBuilder.toString();
    }

    // --------------------------------------------------------------
    // Method counts number of occurrences of target item in list
    public int countItems(Votes target) {
        int returnCount = 0;
        Votes currentItem;

        // Utilize iterators to navigate through list and count
        resetList();
        while (!atEnd()) {
            currentItem = getNextItem();
            if (currentItem.equals(target))
                returnCount++;
        }
        return returnCount;
    }
}
