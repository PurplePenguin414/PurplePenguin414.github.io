/************************************************************/
/* Delta College - CST 283 - Klingler                       */
/* This program demonstrates basic functionality by driving */
/* an object of the unordered list class                    */
/************************************************************/

import javax.swing.JOptionPane;

public class UnorderListDriver 
{
    public static void main( String args[] )
    {
        UnorderList theList = new UnorderList("data.txt");    
                
        // Check of list constructored OK and report
        if (theList.statusOK() == true)
        {
            JOptionPane.showMessageDialog(null,"Initial list:\n" + theList.toString());
            
            theList.delete("Field,Gwendolyn");
            JOptionPane.showMessageDialog(null,"After delete:\n" + theList.toString());
            
            theList.insert("Doe,Jane");
            JOptionPane.showMessageDialog(null,"After insert:\n" + theList.toString());            
            
            String targetString = "Barnett,Peter";
            int position = theList.search(targetString);
            JOptionPane.showMessageDialog(null,targetString + " found at position " +
                                               position);
            
            theList.writeToFile("listoutput.txt");
        }
        else
             JOptionPane.showMessageDialog(null,"Problem with File");           
        
    
        System.exit(0);
    }
}
