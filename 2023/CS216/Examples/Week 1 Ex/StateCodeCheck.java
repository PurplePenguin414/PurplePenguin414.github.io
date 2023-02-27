// Delta College - CST 283 - Klingler
// This program reads a string from the user and reports back whether
// or not the string represents a valid two-character state code.

import javax.swing.JOptionPane;
 
class StateCodeCheck
{
    final static String codeList[] 
         = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    
   public static void main(String[] args) 
   {
      String inState;
      String outputMessage = "State code ";
      
      inState = JOptionPane.showInputDialog("Enter state code ");
      outputMessage += inState;
      
      // Validate code
      boolean valid = false;                     // Assume an invalid input code
      for (int i = 0; i < codeList.length; i++)
          if ( inState.equalsIgnoreCase(codeList[i]) )
              valid = true;                      // Until detected otherwise

      if (valid)
          outputMessage += " is VALID";
      else
          outputMessage += " is INVALID";
          

      JOptionPane.showMessageDialog(null, outputMessage);
   }
}