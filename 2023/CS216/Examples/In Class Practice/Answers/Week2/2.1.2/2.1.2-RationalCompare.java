// Delta College - CST 283 - Klingler
// This application demonstrates comparison methods for the
// Rational class.

import javax.swing.*;       	// import package javax.swing

public class RationalCompare
{   
   public static void main(String args[]) 
   {

        Rational fraction1 = new Rational(2,3);    
        Rational fraction2 = new Rational(3,4); 
        Rational fraction3 = new Rational(6,8); 
        Rational fraction4 = new Rational(6,7); 
        
        System.out.println(fraction1.toString() + " compared to " 
                         + fraction2.toString() + " returns " 
                         + fraction1.compareTo(fraction2));
        
         
        System.out.println(fraction2.toString() + " compared to " 
                         + fraction3.toString() + " returns " 
                         + fraction2.compareTo(fraction3));       
         
        System.out.println(fraction4.toString() + " compared to " 
                         + fraction3.toString() + " returns " 
                         + fraction4.compareTo(fraction3));
      
   }

} 
