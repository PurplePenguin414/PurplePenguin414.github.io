/**
 * This class manages an interface for searching student data
 * 
 * @author      Delta College - CST 283 - Klingler
 * @version     1.0                 
 * @since       2015-10-18          
 */

import javax.swing.JOptionPane;

public class StudentSearch
{
    private static GradeDB studentDatabase;
    
    public static void main( String args[] )
    {
        studentDatabase = new GradeDB();
        int response, targetID;
        
        // Process loop - Terminate with Yes/No continuation option
        do
        {
            // Capture target student ID
            targetID = Integer.parseInt(
                       JOptionPane.showInputDialog(null, "Enter Student ID"));
            
            // Write output message
            String feedbackInfo = studentDatabase.getDataforID(targetID);        
            JOptionPane.showMessageDialog(null, feedbackInfo);
           
            // Determine continuation
            response = JOptionPane.showConfirmDialog(null,
                    "Do you want to continue?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           

        } while (response == JOptionPane.YES_OPTION );
       
       
       
       
   }

}
