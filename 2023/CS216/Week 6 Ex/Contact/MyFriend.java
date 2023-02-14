// Delta College - CST 283 - Klingler
// This application allows a user to enter a calendar date and will return 
// a message declaring if the date is valid or not

import javax.swing.JOptionPane;

public class MyFriend
{
   public static void main( String args[] )
   {
      Contact myFriend = new Contact("Jane Doe", "989-555-1212", 8, 25, 1962);
      
      // Display results of string comparison
      JOptionPane.showMessageDialog(null, "My One Friend:\n" + myFriend.toString() );          
      System.exit( 0 );
         
   }  // end main
}  // endl class