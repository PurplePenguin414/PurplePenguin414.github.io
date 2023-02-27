// Delta College - CST 283 - Klingler 
// This class manages the data for a simple address

public class Address
{
    // --------------------------------------------------------------

    private String address;
    private String city;
    private String state;
    private String zip;
    
    // --------------------------------------------------------------
    
    // Constructors
    public Address()
    {
        address = "";
        city    = "";
        state   = "";
        zip     = "";
    }
    
    public Address(String a, String c, String s, String z)
    {
        address = a;
        city    = c;
        state   = s;
        zip     = z;
    }
    
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setAddress(String a)
    {  address = a; }
    public void setCity(String c)
    { city = c; }
    public void setState(String s)
    { state = s; }
    public void setZip(String z)
    { zip = z; }
    
    public String getAddress()
    { return address; }
    public String getCity()
    { return city; }
    public String getState()
    { return state; }
    public String getZip()
    { return zip; }
    
    // --------------------------------------------------------------

    // This method returns the string data for this object.
    public String toString()
    {
        return address  + "\n" +
               city + ", " + state + "  " + zip;
    }

}