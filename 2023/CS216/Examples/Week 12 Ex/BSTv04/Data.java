//Delta College - CST 283 - Klingler 
// This class manages a simple class to store an integer key and related
// integer data

public class Data implements Comparable<Data>
{
    // --------------------------------------------------------------

    private int key;
    private int data;

    // --------------------------------------------------------------
    
    // Constructors
    public Data()          // No-arg:  Set to sentinel values
    {
        key  = -999;
        data = -999;
    }
    
    public Data(int k, int d)
    {
        key   = k;
        data  = d;
    }

    // --------------------------------------------------------------
    
    // "Get" and "Set" methods
    public void setKey(int k)
    { key = k; }
    public int getKey()
    {  return key;  }
    public void setData(int d)
    {  data = d;}
    public int getData()
    {  return data;  }
    
    // Compares components of two fractions for ordinality.
    // @return Integer: 1
    // the first is greater than the second, zero if the two
    // are equal, and -1 if the first is less than the
    // second.
    public int compareTo(Data data2)
    {
        int returnValue = 0;
       
        if (this.key < data2.key)
            returnValue = -1;
        if (this.key > data2.key)
            returnValue = 1;     
       
       return returnValue;
    }  
   
    // --------------------------------------------------------------

    public String toString()
    {
        return "Key: " + key + ", Data: " + data;
    }
}