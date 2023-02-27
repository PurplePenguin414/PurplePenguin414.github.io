// Delta College - CST 283 - Klingler 
// This class manages the data for communication contact info

public class Communication
{
    // --------------------------------------------------------------

    private String phone1;
    private String phone2;
    private String email;
    private String homepage;
    
    // --------------------------------------------------------------
    
    // Constructors
     public Communication()
    {
        phone1   = "";
        phone2   = "";
        email    = "";
        homepage = "";
    }
    
    public Communication(String p1, String p2, String e, String h)
    {
        phone1   = p1;
        phone2   = p2;
        email    = e;
        homepage = h;
    }
    
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setPhone1(String p1)
    { phone1 = p1; }
    public void setPhone2(String p2)
    { phone2 = p2; }
    public void setEmail(String e)
    { email = e; }
    public void setHomePage(String h)
    { homepage = h; }
    
    public String getPhone1()
    { return phone1; }
    public String getPhone2()
    { return phone2; }
    public String getEmail()
    { return email; }
    public String getHomePage()
    { return homepage; }
    
    // --------------------------------------------------------------

    // This method returns the string data for this object.
    public String toString()
    {
        return "Phone:    " + phone1 + " (primary)"   + "\n" +
               "          " + phone2 + " (secondary)" + "\n" +
               "Email:    " + email  + "\n" +
               "Homepage: " + homepage ;    
    }


}