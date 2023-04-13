import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Delta College - CST 283 - gibbs           
// This runs an election

public class Election<Votes> {

    // --------------------------------------------------------------
    // Private inner class definition of standard data node
    private class Node {
        Votes ID, vote;
        Node next;

        // Construct node with data null sucessor
        Node(Votes id, Votes val)
        {
           this(id, val,null);            
        }
        // Construct node with data and reference to successor
        Node(Votes id, Votes val, Node n) {
            ID = id;
            vote = val;
            next = n;
        }

        
    }
    // --------------------------------------------------------------

    private Node first; // list head
    private Node last; // last element in list

    private Node currentPos; // Current position for iterator action
    private int voterID;
    private boolean vote;
    private int numElems;

    // --------------------------------------------------------------
    // No-arg constructor for linked list. Declare empty; null out pointers
    public Election() {
        first = null;
        last = null;
    }

    public Election(String fileName) {
        Election<Vote> bill = new Election<Vote>();
        // Open file. Process in batch format line-by-line
        try {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(fileName);
            inputFileScanner = new Scanner(inputfile);

            int i = 0;
            while (inputFileScanner.hasNext()) {
                // Read first data tokens - type of claim, date
                bill.voterID = inputFileScanner.nextInt();
                bill.vote = inputFileScanner.nextBoolean();
                i++;

            }
            numElems = i;

            inputFileScanner.close(); // Close file
        } catch (IOException e) // If file error, reset list status flag
        {
            System.out.println("Problem with File - Shutting Down");
            System.exit(0);
        }
    }

    // --------------------------------------------------------------
    // Observer to determine if list empty
    public boolean isEmpty() {
        return first == null;
    }

    // --------------------------------------------------------------
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
    public void addVotes(String fileName) {
        // Open file. Process in batch format line-by-line
        try {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(fileName);
            inputFileScanner = new Scanner(inputfile);
            Election v, I;

            int i = 0;
            while (inputFileScanner.hasNext()) {
                // Read first data tokens - type of claim, date
                voterID = inputFileScanner.nextInt();
                vote = inputFileScanner.nextBoolean();
                I = parseInt(voterID);
                v.setVote(vote);
                i++;

                if (isEmpty()) // If list empty, simply add new element
                {
                    first = new Election.Node(I, v);
                    last = first;
                } else // Otherwise, add parameter element to front of list
                {
                    Node newNode = new Node(I, v);
                    first.next = first;
                    first = newNode;
                }
            }
            inputFileScanner.close(); // Close file
        } catch (IOException e) // If file error, reset list status flag
        {
            System.out.println("Problem with File - Shutting Down");
            System.exit(0);
        }

    }

    // --------------------------------------------------------------
    // Method removes an element by searching for and matching the value
    public void removeVotes(String fileName) {
        // Open file. Process in batch format line-by-line
        try {
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(fileName);
            inputFileScanner = new Scanner(inputfile);

            int i = 0;
            while (inputFileScanner.hasNext()) {
                // Read first data tokens - type of claim, date
                this.voterID = inputFileScanner.nextInt();
                this.vote = inputFileScanner.nextBoolean();
                i++;
                // Special case: empty list - do nothing

                // Special case: element matched for deletion is first element
                if (first.ID.equals(voterID)) {
                    first = first.next;
                    if (first == null)
                        last = null;
                }

                // Find the predecessor of the element to remove
                Node pred = first;
                while (pred.next != null && !pred.next.ID.equals(voterID)) {
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
        moreToSearch = (nodePtr != null);
        int i = 0;
        while (moreToSearch) {
            if (nodePtr.ID.equals(voterID)) {
                // Special case: remove element at front of list
                Votes element; // The element to return
                if (nodePtr.next.ID.equals(null)) {
                    i++;
                    // Adjust reference pointers at front
                    element = first.ID;
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
        System.out.println("Duplicates removed for ");
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
    // Method adds an element to the end of the list
    public void append(Votes newElementData) {
        if (isEmpty()) // If list empty, simply add new element
        {
            first = new Node(voterID, vote);
            last = first;
        } else // Otherwise, add parameter element to end of list
        {
            last.next = new Node(voterID, vote);
            last = last.next;
        }
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
