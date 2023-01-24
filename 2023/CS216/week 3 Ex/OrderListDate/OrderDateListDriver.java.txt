/************************************************************/
/* Delta College - CST 283 - Klingler                       */
/* This program demonstrates an ordered list of Date        */
/* objects.                                                 */
/************************************************************/

import javax.swing.JOptionPane;

public class OrderDateListDriver 
{
    public static void main( String args[] )
    {
        int commaIndex;
        String currentItem;
        String outputString = "";
        
        OrderDateList theList = new OrderDateList("dates.txt",OrderDateList.SortState.UNSORTED);    
                
        // Open list and perform various actions (in ascending order)
        if (theList.statusOK() == true)
        {
            theList.resetList();
            
            // Iterate through ordered list and write each element to console
            while (!theList.atEnd())
            {
                Date listItem = theList.getNextItem();
                outputString += listItem.toString() + "\n";
            }
             
            // Display list of only last names via output dialog
            JOptionPane.showMessageDialog(null,"Dates in order:\n" + outputString);     
        }
        else
             JOptionPane.showMessageDialog(null,"Problem with File");           
        
        System.exit(0);
    }
}
