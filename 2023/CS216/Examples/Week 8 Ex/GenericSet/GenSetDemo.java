// Delta College - CST 283 - Klingler & Gaddis text
// This program demonstrates the use of the instructor-derived class
// GenSet that implements basic set operations.

public class GenSetDemo
{
    public static void main(String[] args)
    {
        // -----------------------------------------------
        // Create one HashSet to hold names.
        GenSet<String> nameSet1 = new GenSet<String>(); 
        
        nameSet1.add("Maya");
        nameSet1.add("Tim");
        nameSet1.add("Jen");
        
        System.out.println("Set 1: " + nameSet1);
        
        // Create another HashSet to hold names.
        GenSet<String> nameSet2 = new GenSet<String>(); 
        
        nameSet2.add("Tim");
        nameSet2.add("Josh");
        nameSet2.add("Sarah");
        nameSet2.add("Jen"); 
        nameSet2.add("Chloe"); 
        
        System.out.println("Set 2: " + nameSet2);
        
        // -----------------------------------------------
        // Determine set union and intersection
        
        GenSet<String> unionSet = new GenSet<String>();
        unionSet = nameSet1.union(nameSet2);
        System.out.println("Union: " + unionSet);
        
        GenSet<String> intersectSet = new GenSet<String>();
        intersectSet = nameSet1.intersection(nameSet2);
        System.out.println("Intersection: " + intersectSet);        
    }
}
