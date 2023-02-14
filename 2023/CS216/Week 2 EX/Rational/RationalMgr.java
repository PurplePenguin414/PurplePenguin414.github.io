// Delta College - CST 283 - Klingler
// This application provides a dialog-based user interface for
// basic fraction manipulation

import javax.swing.*;       	// import package javax.swing

public class RationalMgr
{   
   public static void main(String args[]) 
   {
        // -----------------------------------------------------------
        // Test constructors and reducing
        Rational fraction1 = new Rational();    
        Rational fraction2 = new Rational(6,9); 
        System.out.println("Fraction1: " + fraction1.toString());
        System.out.println("Fraction2: " + fraction2.toString());
        fraction2.reduce();
        System.out.println("Fraction2 reduced: " + fraction2.toString());

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
        Rational fractionX = new Rational(3,7);
        System.out.print(fractionX + " reciprocated is ");
        fractionX.reciprocate();
        System.out.println(fractionX);
        
        System.out.println(fractionX + " as a decimal is " + fractionX.toDecimal());
   }

} // end class

