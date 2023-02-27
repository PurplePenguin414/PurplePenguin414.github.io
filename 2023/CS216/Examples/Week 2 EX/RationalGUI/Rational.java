// Delta College - CST 283 - Klingler
// This class implements a data type for storage and manipulation of fractions

public class Rational
{
   private int numerator;
   private int denominator;

   //-------------------------------------------------------------------------
   // Default constructor - set fraction to 1/1
   public Rational(  )
   {
      numerator = 1;
      denominator = 1;
   }

   // Parameterized constructor - set fraction to user data
   public Rational( int n, int d )
   {
      numerator = n;
      denominator = d;
   }

   //-------------------------------------------------------------------------
   /**
    *  "get" method to access the fraction numerator
    *  @return integer numerator
    */
   public int getNumerator( )
   {
      return numerator;
   }

   /**
    *  "get" method to access the fraction denominator
    *  @return integer denominator
    */
   public int getDenominator( )
   {
      return denominator;
   }
   
   //-------------------------------------------------------------------------
   /**
    *  "set" method to change the fraction numerator
    *  @param n numerator
    */
   public void setNumerator( int n )
   {
      numerator = n;
   }

   /**
    *  "set" method to change the fraction denominator
    *  @param d denominator
    */
   public void setDenominator( int d )
   {
      denominator = d;
   }

   //-------------------------------------------------------------------------
   /**
    *  Calculates the decimal equivalent of a fraction
    *  @return current numerator divided by denominator
    */
   public double toDecimal( )
   {
      return (double) numerator / (double) denominator;
   }

   //-------------------------------------------------------------------------
   /**
    *  Reciprocate the current fraction object in place
    */
   public void reciprocate( )
   {
     int temp = this.numerator;
     this.numerator = this.denominator;
     this.denominator = temp;
   }
       
   //-------------------------------------------------------------------------
   /**
    *  reduce the current fraction by dividing numerator and denominator by GCD
    */
   public void reduce( )
   {
      int divisor = gcd(numerator,denominator);
      numerator = numerator / divisor;
      denominator = denominator / divisor;
   }
   
   //-------------------------------------------------------------------------
   /**
    *  Multiple components of two fraction objects to produce a product object.
    *  @param  operand2 Rational object with 2nd operand
    *  @return Object containing product of two objects.
    */
   public Rational multiply( Rational operand2 )
   {
       Rational product = new Rational();
       product.numerator   = this.numerator * operand2.numerator;
       product.denominator = this.denominator * operand2.denominator;
       product.reduce();
       return product;
   }
   
   /**
    *  Divide components of two fraction objects to produce a quotient object.
    *  @param  operand2 Rational object with 2nd operand
    *  @return Object containing quotient of two objects.
     */
   public Rational divide( Rational operand2 )
   {
       Rational quotient    = new Rational();
       quotient.numerator   = this.numerator * operand2.denominator;
       quotient.denominator = this.denominator * operand2.numerator;
       quotient.reduce();
       return quotient;
   }
    
   /**
    *  Add two fraction objects together to produce a quotient object.
    *  @param  operand2 Rational object with 2nd operand
    *  @return Object containing sum of two objects.  
    */
    public Rational add( Rational operand2 )
    {
        Rational sum  = new Rational();

        // Get common demominator (not necessarily the lowest); find mulipliers
        int commonDenomiator = this.denominator * operand2.denominator;    
        int multiplier1 = commonDenomiator / denominator;
        int multiplier2 = commonDenomiator / operand2.denominator;
    
        // Elevate both fractions to common denominator
        int tempNum1 = this.numerator       * multiplier1;
        int tempDen1 = this.denominator     * multiplier1;
        int tempNum2 = operand2.numerator   * multiplier2;
        int tempDen2 = operand2.denominator * multiplier2;
    
        // Perform addition and reduce  
        sum.numerator   = tempNum1 + tempNum2;
        sum.denominator = commonDenomiator;
        sum.reduce();

        return sum;
   }
    /**
    *  Add two fraction objects together to produce a quotient object.
    *  @param  operand2 Rational object with 2nd operand
    *  @return Object containing sum of two objects.  
    */
   public Rational subtract( Rational operand2 )
   {
        Rational difference  = new Rational();

        // Get common demominator (not necessarily the lowest); find mulipliers
        int commonDenomiator = this.denominator * operand2.denominator;    
        int multiplier1 = commonDenomiator / denominator;
        int multiplier2 = commonDenomiator / operand2.denominator;
    
        // Elevate both fractions to common denominator
        int tempNum1 = this.numerator       * multiplier1;
        int tempDen1 = this.denominator     * multiplier1;
        int tempNum2 = operand2.numerator   * multiplier2;
        int tempDen2 = operand2.denominator * multiplier2;
    
        // Perform addition and reduce  
        difference.numerator = tempNum1 - tempNum2;
        difference.denominator = commonDenomiator;
        difference.reduce();

        return difference;
   }
 
    /**
    *  Private utility function to return greatest common divisor for two integers
    *  @return Integer with greatest common denominator of current fraction 
    *          numerator and denominator.
    */
    private int gcd(int m, int n)
    {
       boolean done = false;
       int r;
       
       if (n  > m)                     // m  must be larger value
       {
          int temp = m;
          m = n;
          n = temp;
       }
         
       // Algorithm to calculate GCD      
       do
       {
          r  = m % n;
          if (r == 0)
            done = true;
          else
          {
            m  = n;
            n  = r;
          }
       } while ( r != 0 && ! done ); 
        
       return n;    // Variable n emerges are GCD
   }
         
   /**
   *  Compares components of two fractions and returns true
   * if the object invoking the method is arithmetically equal to the
   * parameterized object.
   *  @return Boolean: true if fractions are equal arithmetically; false otherwise
   */
   public boolean equals(Rational fraction2)
   {
       // Convert to 
       
       
       if (this.toDecimal() == fraction2.toDecimal())
           return true;
       else
           return false; 
   } 

   /**
   *  Compares components of two fractions for ordinality.
   *  @return Interger: 1
   * if the first is greater than the second, zero if the two
   * are equal, and -1 if the first is less than the
   * second.
   */
   public int compareTo(Rational fraction2)
   {
       int returnValue = 0;
       
       if (this.toDecimal() < fraction2.toDecimal())
           returnValue = -1;
       if (this.toDecimal() > fraction2.toDecimal())
           returnValue = 1;     
       
       return returnValue;
       
   } // end compareTo

    
   /**
    *  Return string with current numerator and denominator
    *  @return String with fraction in form:  "num / denom"
    */
   public String toString( )
   {
       return numerator + "/" + denominator;
   }
   
}  // end Rational class
