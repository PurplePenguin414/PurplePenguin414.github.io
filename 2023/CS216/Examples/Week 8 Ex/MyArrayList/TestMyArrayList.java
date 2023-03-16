// Delta College - CST 283 - Klingler                       
// This program tests various features of the MyArrayList class built to mimic
// the Java ArrayList class which demonstrates an abstraction of an array-based
// list manager class.

import java.util.*;

public class TestMyArrayList {
    public static void main(String[] args)
    {
        MyArrayList<Integer> list1 = new MyArrayList<Integer>();   // Create list objects

        Random randomGenerator = new Random();               // Random numbers for testing

        // --------------------------------------------------------------------------------

        // Verify initial list capacity - from constructor
        System.out.println("Initial list capacity: " + list1.getListCapacity());

        // Test list by adding random random integers.  Numbers added to end of list.
        // This will force several capacity changes for the array.
        for (int i = 1; i <= 100000; i++)
            list1.add(new Integer(randomGenerator.nextInt()));

        // Check updated list capacity - after numerous inserts
        System.out.println("Updated list capacity: " + list1.getListCapacity());

        // Test indexing for searching
        Integer searchTarget = list1.get(99999999);
        if (searchTarget == null)
            System.out.println("Index 99999999 NOT available");

        searchTarget = list1.get(999);
        if (searchTarget != null)
            System.out.println("Index 999 IS available: " + searchTarget + " stored there.");

        // Various tests for insertions
        Integer testTarget = new Integer(123456);
        list1.add(123456);

        System.out.println("At index 55: " + list1.get(55));
        list1.set(55, 999);
        System.out.println("Now at index 55: " + list1.get(55));
        System.out.println(list1.indexOf(123456));

        // Various tests for removals
        list1.remove(100000);
        list1.remove(0);
        list1.remove(100001);
        list1.remove(testTarget);
        System.out.println(list1.indexOf(testTarget));

        // ---------------------------------------------------------------------

        // Test String list to verify generic behavior.  Create an array-based list
        // of String objects.
        MyArrayList<String> list2 = new MyArrayList<String>();

        // Add strings to list
        list2.add("Hello");
        list2.add("Delta");
        list2.add("College");

        // Traverse list of Strings and write to console.
        for (int i = 0; i < list2.getListSize(); i++)
            System.out.print(list2.get(i) + " ");
        System.out.println();
    }
}