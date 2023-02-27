// Delta College - CST 283 - Klingler
// This application converts temperature Fahrenheit to Celsius

import javax.swing.JOptionPane;
 
class FahrenheitToCelsiusDialog 
{
   public static void main(String[] args) 
   {
      double tempF, tempC;
      String inputTemp;
      
      inputTemp = JOptionPane.showInputDialog("Enter temperature in Fahrenheit");
      tempF = Double.parseDouble(inputTemp);
      
      while (tempF < -40 || tempF > 140)
      {
            JOptionPane.showMessageDialog(null, "Invalid Temperature");        
          
            inputTemp = JOptionPane.showInputDialog("Enter temperature in Fahrenheit");
            tempF = Double.parseDouble(inputTemp);
      }

      tempC = 5.0 / 9.0 * (tempF - 32);

      JOptionPane.showMessageDialog(null, tempF + " deg F = " + tempC + " deg C");
   }
}