// Delta College - CST 283 - Klingler
// This class tests a regular expression intended to validate a social
// security number.
// Source:  www.ocpsoft.org
import java.util.ArrayList;
import java.util.List;

public class ValidateSSNDemo 
{
    public static void main(String[] args) 
    {
        List<String> input = new ArrayList<String>();

        // Test cases for possible SSNs
        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (my SSN)");
        input.add("987-65-4321 ");
        input.add("192-83-745");
        input.add("192_83_7465");
        input.add("192837465");

        // Traverse test strings for valid SSNs matching pattern
        for (String ssn : input) 
        {
            if (ssn.matches("^\\d{3}-?\\d{2}-?\\d{4}$")) 
                System.out.println("VALID:   |" + ssn + "|");
            else
                System.out.println("invalid: |" + ssn + "|");
        }       
        
    }
}
