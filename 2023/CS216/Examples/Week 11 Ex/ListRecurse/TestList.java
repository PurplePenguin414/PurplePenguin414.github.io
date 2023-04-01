// Delta College - CST 283 - Klingler                  
// This application demonstrates basic linked list operations
// Version 2

public class TestList
{     
    public static void main(String [] args)
    {
        LinkedList<String> theList = new LinkedList<String>();

        theList.add("Harry");
        theList.add("Hermione");
        theList.add("Ron");
        theList.add("Voldemort");
        theList.add("Dumbledore");        
        
        // Use iterators to traverse list in order
        System.out.println("The members of the list in order are:");
        theList.resetList();
        while (!theList.atEnd())
        {
            String listItem = theList.getNextItem();
            System.out.println(listItem);    
        }  
        
        // Demonstrate list in reverSe order
        System.out.println("\nThe members of the list in reverse order are:");
        System.out.println(theList.reverseToString());
        
        // Count the list elements recursively
        System.out.print("\nNumber of elements in list: ");
        System.out.println(theList.sizeRecurse());  
    }  
}
