// Delta College - CST 283 - Klingler
// This class demonstrates various regular expressions and test them
import java.util.ArrayList;
import java.util.List;

public class RegExExamples 
{
    public static void main(String[] args) 
    {
        List<String> input;
        
        // --------------------------------------------------
        // Test a password such that it has:
        //  - 8-15 characters
        //  - characters a-z, A-Z, 0-9, an underscore, or hyphen
        input = new ArrayList<String>();

        // Test cases for possible SSNs
        input.add("12ABC#");
        input.add("12ABC-aB7_");
        input.add("12abcxyzABC-aB7_");
        input.add("XYZ12_abCD");
        
        // Traverse tests for valid passwords
        for (String password : input) 
        {
            if (password.matches("^[a-zA-Z0-9_-]{8,15}$")) 
                System.out.println("VALID:   |" + password + "|");
            else
                System.out.println("invalid: |" + password + "|");
        }       
        System.out.println("\n\n");
        
        // -------------------------------------------------------------
        // Validate that a time has a valid 24-hour format hh:mm 
        //        
        // Expression:  ([01]?[0-9]|2[0-3]):[0-5][0-9]
        //
        //  (              start of group #1
        //  [01]?[0-9]     start with 0-9,1-9,00-09,10-19
        //  |                  or
        //  2[0-3]         start with 20-23
        //  )              end of group #1
        //  :              follow by a semi colon (:)
        //  [0-5][0-9]     follow by 0..5 and 0..9, which means 00 to 59
        
        input = new ArrayList<String>();

        // Test cases for possible times
        input.add("23:59");
        input.add("03:03");
        input.add("03:3");
        input.add("5:5");        
        input.add("12:98");
        input.add("25:45");         
        
        // Traverse tests for valid times
        for (String time : input) 
        {
            if (time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) 
                System.out.println("VALID:   |" + time + "|");
            else
                System.out.println("invalid: |" + time + "|");
        }       
        System.out.println("\n\n");               
        
        // --------------------------------------------------
        // Test a password such that it has:
        //  - 6-20 characters
        //  - must contains one digit from 0-9
        //  - must contains one lowercase characters
        //  - must contains one uppercase characters
        //  - must contains one special symbols in the list "@#$%"
        input = new ArrayList<String>();

        // Test cases for possible passwords
        input.add("12AbC&aB7$");
        input.add("abc123XYZ");
        input.add("abcdef1234$@#5678WXYZ");        
        input.add("abef14$@#58XYZ");  
        
        // Traverse tests for valid passwords
        for (String password : input) 
        {
            if (password.matches("^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})$")) 
                System.out.println("VALID:   |" + password + "|");
            else
                System.out.println("invalid: |" + password + "|");
        }       
        System.out.println("\n\n");    
        
        // --------------------------------------------------
        // Validate that a given file name is a properly formated graphic
        // file in one or four accepted formats (extensions)
        //
        //   (                start of the group #1
        //   [^\s]+           must contains one or more anything (except white space)
        //   (                start of the group #2
        //   \.               follow by a dot "."
        //   (?i)             ignore the case sensitive checking
        //   (                start of the group #3
        //   jpg|png|gif|bmp  contains characters "jpg", "png", "gif", or "bmp"
        //   )                end of the group #3
        //   )                end of the group #2    
        //   $                end of the string
        //   )                end of the group #1
         
         input = new ArrayList<String>();

        // Test cases for possible files
        input.add("graphics.gif");
        input.add("words.doc"); 
        input.add("file1,jpg"); 
        input.add(".jpg"); 
        input.add("file2."); 
        input.add("file3jpg"); 
        input.add("file4.png"); 
        
        // Traverse tests for valid files
        for (String filename : input) 
        {
            if (filename.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)")) 
                System.out.println("VALID:   |" + filename + "|");
            else
                System.out.println("invalid: |" + filename + "|");
        }       
        System.out.println("\n\n");    
       
        

      
        
        
        
        
        
        
        
    }
}
