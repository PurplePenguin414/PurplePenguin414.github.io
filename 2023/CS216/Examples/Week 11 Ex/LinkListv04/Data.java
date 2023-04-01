//Delta College - CST 283 - Klingler 
// This class manages a simple class to store an integer key and related
// integer data

public class Data
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
     
    // --------------------------------------------------------------
    // Override equals method to enable searching
    public boolean equals(Object obj) 
    {
        if (obj instanceof Data) 
        {
            return this.getKey() == ((Data)obj).getKey();
        }
        return false;
    }
   
    // --------------------------------------------------------------

    public String toString()
    {
        return "Key: " + key + ", Data: " + data;
    }
}