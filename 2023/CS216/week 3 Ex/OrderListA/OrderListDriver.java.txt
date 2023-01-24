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
        OrderList theList = new OrderList("data.txt",OrderList.SortState.UNSORTED);    
                
        // Open list and perform various actions (in ascending order)
        if (theList.statusOK() == true)
        {
            JOptionPane.showMessageDialog(null,"Initial list:\n" + theList.toString());
            
            theList.delete("Field,Gwendolyn");
            JOptionPane.showMessageDialog(null,"After delete:\n" + theList.toString());
            
            theList.insert("Doe,Jane");
            JOptionPane.showMessageDialog(null,"After insert:\n" + theList.toString());            
            
            String targetString = "Hayes,Anita";
            int position = theList.search(targetString);
            JOptionPane.showMessageDialog(null,targetString + " found at position " +
                                               position);
            
            theList.writeToFile("listoutput.txt");
        }
        else
             JOptionPane.showMessageDialog(null,"Problem with File");           

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        
        // Reopen list, reorder it,  and perform various actions (in descendig order)
        
        theList = new OrderList("listoutput.txt",OrderList.SortState.ASCENDING);    
                
        // Open list and perform various actions (in ascending order)
        if (theList.statusOK() == true)
        {
            theList.sortList(OrderList.SortState.DESCENDING);           
            
            theList.insert("Field,Gwendolyn");
            JOptionPane.showMessageDialog(null,"After delete:\n" + theList.toString());
            
            theList.delete("Doe,Jane");
            JOptionPane.showMessageDialog(null,"After insert:\n" + theList.toString());            
            
            String targetString = "Hayes,Anita";
            int position = theList.search(targetString);
            JOptionPane.showMessageDialog(null,targetString + " found at position " +
                                               position);            
        }
         else
             JOptionPane.showMessageDialog(null,"Problem with File");           
       
        
        
        System.exit(0);
    }
}
