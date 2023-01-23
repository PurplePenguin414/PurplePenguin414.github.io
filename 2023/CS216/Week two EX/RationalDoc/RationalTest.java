// Delta College - CST 283 - Klingler
// This application provides a dialog-based user interface for
// basic fraction manipulation

import javax.swing.*;       	// import package javax.swing

public class RationalTest
{   
   public static void main(String args[]) 
   {
        // -----------------------------------------------------------
        // Test constructors and reducing
        Rational fractionX = new Rational();    
        Rational fractionY = new Rational(6,9); 
        System.out.println("FractionX: " + fractionX.toString());
        System.out.println("FractionY: " + fractionY.toString());
        fractionY.reduce();
        System.out.println("FractionY reduced: " + fractionY.toString());

        // -----------------------------------------------------------
        // Test arithmetic operations
        Rational fractionA      = new Rational(3,4);       
        Rational fractionB      = new Rational(6,7);
        Rational fractionAnswer = new Rational();
        
        fractionAnswer = fractionA.add(fractionB);
        System.out.println(fractionA.toString() + " + " 
                         + fractionB.toString() + " = " + fractionAnswer);
        fractionAnswer = fractionA.subtract(fractionB);
        System.out.println(fractionA.toString() + " - " 
                         + fractionB.toString() + " = " + fractionAnswer);
        fractionAnswer = fractionA.multiply(fractionB);
         System.out.println(fractionA.toString() + " * " 
                         + fractionB.toString() + " = " + fractionAnswer);
        fractionAnswer = fractionA.divide(fractionB);
        System.out.println(fractionA.toString() + " / " 
                         + fractionB.toString() + " = " + fractionAnswer);
      
        // -----------------------------------------------------------
        // Misc operations
        Rational fractionZ = new Rational(3,7);
        System.out.print(fractionZ + " reciprocated is ");
        fractionZ.reciprocate();
        System.out.println(fractionZ);
        
        System.out.println(fractionZ + " as a decimal is " + fractionZ.toDecimal());
        
        // -----------------------------------------------------------
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

} // end class

