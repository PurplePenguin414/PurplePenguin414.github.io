// Delta College - CST 283 - Klingler
// This program is a test driver to demonstrate the String class.  Various
// features of the class are tested.

import javax.swing.JOptionPane;

public class DemoString {

    final static int NUMBER_THROWS = 100;

    public static void main(String[] args) 
    {
        //--------------------------------------------------------------------
        // Test constructors and length operator
        String string1 = "Delta College";
        String string2 = "Experience the Delta Difference";
        String string3 = new String();

        System.out.println("String 1 is: " + string1);
        System.out.println(" and is " + string1.length() + " characters long");
        System.out.println();

        System.out.println("String 2 is: " + string2);
        System.out.println(" and is " + string2.length() + " characters long");
        System.out.println();

        System.out.println("String 3 has length: ");
        System.out.println(string3.length() + " characters long");
        System.out.println();

        //--------------------------------------------------------------------
        // Assignment and character retrieval
        string1 = "Detroit Red Wings";
        char start, end;

        int len = string1.length();

        start = string1.charAt(0);
        end = string1.charAt(len - 1);

        System.out.println("String 1 is: " + string1);
        System.out.println(" It starts with ");
        System.out.println(" ands ends with " + end);
        System.out.println();

    //--------------------------------------------------------------------
        // Comparision
        string1 = "ONE";
        string2 = "TWO";
        string3 = "THREE";

        if (string2.compareTo(string3) > 0) {
            System.out.println(string2 + " > " + string3);
        } else {
            System.out.println(string2 + " < " + string3);
        }

        if (string3.equals("THREE")) {
            System.out.println(string3 + " == THREE");
        } else {
            System.out.println(string3 + " != THREE");
        }

        System.out.println();

        //--------------------------------------------------------------------
        // String indexing and substring  
        int pos;
        string1 = "Delta College";

        pos = string1.indexOf("College");

        string2 = string1.substring(pos);     // Substring from position to end
        string3 = string1.substring(0, pos); // Substring from beginning to position

        System.out.println(string2);
        System.out.println(string3);
        System.out.println();

        //--------------------------------------------------------------------
        // Erasing characters and number conversion
        int numStart, numLen;
        String numberString;
        int number;

        // Seek all digits
        string1 = "Enrollment: 10,345 students";

        pos = string1.indexOf(":");             // Mark position of semicolon
        numStart = pos + 2;                     // Number begins 2 chars after ':'
        pos = string1.indexOf(" ", numStart);   // Mark position of last blank
        numberString                            // Extract number string
                = string1.substring(numStart, pos);

        pos = numberString.indexOf(",");      // Find comma position
        StringBuilder tempString = new StringBuilder(numberString);
        tempString.deleteCharAt(pos);           // Delete comma
        numberString = new String(tempString);  // Reinstate string from temp StringBuilder

        number = Integer.parseInt(numberString);

        System.out.println("Enrollment is: " + number);
        number *= 2;
        System.out.println("Enrollment doubled is: " + number);

        System.out.println();

    //--------------------------------------------------------------------
        // String arrays and input
        String stateCodes[] = {"MI", "OH", "IN"};
        String stateNames[] = {"Michigan", "Ohio", "Indiana"};
        String inState;

        // Test test matching parallel arrays
        inState = JOptionPane.showInputDialog("Enter state code: ");

        for (int i = 0; i < stateCodes.length; i++) {
            if (stateCodes[i].equals(inState)) 
            {
                System.out.println("That stands for: " + stateNames[i]);
            }
        }

        System.exit(0);
    }
}