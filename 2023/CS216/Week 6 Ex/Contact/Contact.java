// Delta College - CST 283 - Klingler 
// This class manages the data for a simple contact

public class Contact
{
    // --------------------------------------------------------------

    private String name;
    private String phone;
    private Date   birthDate;

    // --------------------------------------------------------------
    
    // Constructors
    public Contact()
    {
        name      = "";
        phone     = "";
        birthDate = new Date();
    }
    
    public Contact(String n, String p, int m, int d, int y)
    {
        name      = n;
        phone     = p;
        birthDate = new Date(m, d, y);
    }
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setName(String n)
    {  name = n; }

    public void setPhone(String p)
    { phone = p; }

    public void setDate(Date d)
    {
        birthDate = d;
    }

    public String getName()
    { return name; }

    public String getPhone()
    { return phone; }

    public Date getDate()
    {
        return birthDate;
    }
    // --------------------------------------------------------------
    // This method returns string rendering of object data
    public String toString()
    {
        return name  + "\n" +
               phone + "\n" +
               birthDate.toString();
    }


}