/************************************************************/
/* Delta College - CST 283 - Klingler                       */
/* This program demonstrates basic functionality by driving */
/* an object of the unordered list class                    */
/************************************************************/

import javax.swing.JOptionPane;

public class OrderListDriver 
{
    public static void main( String args[] )
    {
        int commaIndex;
        String currentItem;
        String outputString = "";
        
        OrderList theList = new OrderList("data.txt",OrderList.SortState.UNSORTED);    
                
        // Open list and perform various actions (in ascending order)
        if (theList.statusOK() == true)
        {
            theList.resetList();
            
            while (!theList.atEnd())
            {
                String listItem = theList.getNextItem();
                
                // Extract last name (substring before comma)
                commaIndex = listItem.indexOf(",");
                outputString += listItem.substring(0, commaIndex) + "\n";
            }
             
            // Display list of only last names via output dialog
            JOptionPane.showMessageDialog(null,"Last Names:\n" + outputString);     
        }
        else
             JOptionPane.showMessageDialog(null,"Problem with File");           
        
        System.exit(0);
    }
}
