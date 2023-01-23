// Delta College - CST 283 - Klingler
// This application converts temperature Fahrenheit to Celsius

import java.util.Scanner;  
 
class FahrenheitToCelsiusConsole 
{
   public static void main(String[] args) 
   {
      double tempF, tempC;
      
      Scanner keyboard = new Scanner(System.in);

      System.out.print("Enter Fahrenheit temperature: ");
      tempF = keyboard.nextDouble();
      
      tempC = 5.0 / 9.0 * (tempF - 32);

      System.out.println(tempF + " deg F = " + tempC + " deg C");
   }
}