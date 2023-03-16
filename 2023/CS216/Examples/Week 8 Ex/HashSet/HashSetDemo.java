// Delta College - CST 283 - Klingler & Gaddis text
// This program creates a HashSet with names in it, gets an iterator for
// the set, and searches the set for names

import java.util.*;

public class HashSetDemo
{
    public static void main(String[] args)
    {
        // Create a HashSet to hold names.
        List<String> nameList =  Arrays.asList("Chris", "David", "Katherine", "Kenny");
        HashSet<String> nameSet = new HashSet<String>(nameList);       

        // Get an iterator for the set.
        Iterator<String> it = nameSet.iterator();

        // Display the elements in the set.
        System.out.println("Here are the names in the set.");
        while (it.hasNext())  
        {
            System.out.println(it.next());
        }
        System.out.println();
        
        // Search for "Katherine". We should find this name in the set.
        if (nameSet.contains("Katherine"))
        {
            System.out.println("Katherine is in the set.");
        } 
        else
        {
            System.out.println("Katherine is NOT in the set.");
        }

        // Search for "Bethany". We should not find this name in the set.
        if (nameSet.contains("Bethany"))
        {
            System.out.println("Bethany is in the set.");
        } 
        else
        {
            System.out.println("Bethany is NOT in the set.");
        }
    }
}
