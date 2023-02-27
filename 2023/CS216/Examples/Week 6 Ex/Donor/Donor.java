// Delta College - CST 283 - Klingler 
// This class manages the data for one donor to PBS

public class Donor
{
    final double DEDUCTABLE_PCT = 0.85;
    
    // --------------------------------------------------------------

    private String name;
    private double donation;

    // --------------------------------------------------------------
    
    // Constructors
    public Donor()
    {
        name     = "";
        donation = 0.0;
    }
    
    public Donor(String n, double d)
    {
        name      = n;
        donation  = d;
    }
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setName(String n)
    {  name = n; }

    public void setDonation(double d)
    { donation = d; }

    public String getName()
    { return name; }

    public double getDonation()
    { return donation; }
    
    //---------------------------------------------------                
    // Compute and return tax deductable value as percentage of donation
    public double getDeductable()
    {
        return DEDUCTABLE_PCT * donation;
    }       
   
    // --------------------------------------------------------------

    // Method returns contents of object as string
    public String toString()
    {
        return "Name: "   + name      + "  " +
               "Donation: "   + String.format("$%.2f", donation)  + "  " +
               "Deductable: " + String.format("$%.2f", getDeductable());
    }

}