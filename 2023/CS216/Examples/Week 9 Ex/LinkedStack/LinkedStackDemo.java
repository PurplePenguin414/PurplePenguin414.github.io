/** 
   This class demonstrates the use of the 
   LinkedStack class.
*/

public class LinkedStackDemo 
{
   public static void main(String [ ] args)   
   {
        // ----------------------------------------------------------
        LinkedStack<String> stringStack = new LinkedStack<String>();
       
        System.out.println("Contents of String Stack:");
        stringStack.push("Blue");
        stringStack.push("Red");
        String name = stringStack.pop();
        System.out.println("Popped: " + name + "\n");
        stringStack.push("Green");
        stringStack.push("Orange");        
        System.out.println("Contents of Stack:");
        System.out.println(stringStack); 
        System.out.println("\n\n\n");
        
        // ----------------------------------------------------------
        LinkedStack<Rational> fractionStack = new LinkedStack<Rational>();
        
        Rational fraction;
        
        System.out.println("Contents of Fraction Stack:");
        fraction = new Rational(4,5);
        fractionStack.push(fraction);
        fraction = new Rational(2,3);
        fractionStack.push(fraction);
        Rational fractionOut = fractionStack.pop();
        System.out.println("Popped: " + fractionOut + "\n");
        fraction = new Rational(1,8);
        fractionStack.push(fraction);
        fraction = new Rational(5,9);
        fractionStack.push(fraction);
        
        System.out.println("Contents of Stack:");
        System.out.println(fractionStack); 
        System.out.println("\n\n\n");
   }    
}