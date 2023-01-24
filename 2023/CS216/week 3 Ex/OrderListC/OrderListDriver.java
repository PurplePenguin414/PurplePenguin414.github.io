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
        
        OrderList list1 = new OrderList("list1.txt",OrderList.SortState.UNSORTED);    
        OrderList list2 = new OrderList("list2.txt",OrderList.SortState.ASCENDING);    
        OrderList list3 = new OrderList();    
                
        // Open list and perform various actions (in ascending order)
        if (list1.statusOK() == true && list2.statusOK() == true)
        {
             list1.sortList(OrderList.SortState.ASCENDING);   // Sort list 1
             list2.removeDuplicates();                        // Eliminate list 2 duplicates
             list3 = list1.mergeLists(list2);                         // Merge both lists      
            
            // Send merged list of integers to output
            list1.resetList();           
            while (!list1.atEnd())
            {
                int listItem = list1.getNextItem();
                outputString += listItem + "\n";
            }
             
            // Display list of only last names via output dialog
            JOptionPane.showMessageDialog(null,"Integer List:\n" + outputString);     
        }
        else
             JOptionPane.showMessageDialog(null,"Problem with Input File");           
        
        System.exit(0);
    }
}
