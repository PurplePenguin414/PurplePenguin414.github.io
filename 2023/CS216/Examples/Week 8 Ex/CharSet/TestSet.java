// Delta College - CST 283 - Klingler
// This application class is a test driver for the CharSet class

import javax.swing.JOptionPane;

public class TestSet 
{
    public static void main( String args[] )
    {
        String outputString = "";
        
        // Set 1 i
        CharSet set1 = new CharSet();
        set1.insert('A');
        set1.insert('B');
        outputString += "Set 1: " + set1.toString() + "\n";

        // Set 2 
        CharSet set2 = new CharSet();
        set2.insert('B');
        outputString += "Set 2: " + set2.toString() + "\n";

        // Test insert
        set2.insert('C');
        outputString += "Set 2 updated: " + set2.toString() + "\n\n";
        
        // Test intersection
        CharSet set3 = new CharSet();
        set3 = set1.intersect(set2);
        outputString += "Intersection: " + set3.toString() + "\n";
        
        // Test union
        CharSet set4 = new CharSet();
        set4 = set1.union(set2);
        outputString += "Union: " + set4.toString() + "\n";
         
        // Display results
        JOptionPane.showMessageDialog(null, outputString, "Character Set Test",
           JOptionPane.INFORMATION_MESSAGE );

         System.exit(0);
    }
}

 
