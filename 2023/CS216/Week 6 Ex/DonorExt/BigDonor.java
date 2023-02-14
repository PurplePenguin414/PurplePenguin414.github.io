// Delta College - CST 283 - Klingler 
// This class manages the data for a large donor.  It extends the basic
// donor class by adding the gift to be rewarded for the large donation.

public class BigDonor extends Donor
{
    final double BIG_DEDUCTABLE_PCT = 0.75;
    
    // --------------------------------------------------------------

    private String gift;

    // --------------------------------------------------------------
    
    // Constructors
    public BigDonor()
    {
         super();
         gift = "";
    }
    
    public BigDonor(String n, double d, String g)
    {
        super(n,d);
        gift = g;
    }
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setGift(String g)
    {  gift = g; }

    public String getGift()
    { return gift; }
    
    //---------------------------------------------------                
    // Compute and return tax deductable value as percentage of donation.
    // Overrides superclass method with different percentage
    public double getDeductable()
    {
        return BIG_DEDUCTABLE_PCT * donation;
    }     
    // --------------------------------------------------------------

    // Method returns contents of object as string
    public String toString()
    {
        return super.toString() + " Gift: " + gift;
    }

}