// This simple class inherits from the Java Integer class simply
// to incorporate a specific hashing method.

public class MyInteger
{   
    int theInteger;
    
    // Constructor
    public MyInteger(int i)
    {
        theInteger = i;
    }
   
    // This method performs a basic numerical hash function.  It mods the
    // student ID value to produce a hash value of 0...99.  Since negative
    // integers are possible, only a positive is returned.
    public int hashCode()
    {
         return Math.abs(theInteger % 100);
    }
   
    // Return object contents to string object
    public String toString()
    {
        return Integer.toString(theInteger);
    }
  
}