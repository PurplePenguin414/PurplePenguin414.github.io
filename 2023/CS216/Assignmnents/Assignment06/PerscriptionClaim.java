package CS216.Assignmnents.Assignment06;
// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public class perscriptionClaim extends claim
{
    protected String type, med;
    protected int date;
    protected double cost, customerPay, insurancePay;

    // Declare constants necessary for salary and tax calculation
    final String GEN = "G_";
    final double GEN_PRICE = 20;
    final double OTHER_RATE = 0.95;

    // No-Arg constructor - initialize to "dummy" values
    public perscriptionClaim() 
    {
        type = "";
        date = 0;
        cost = 0.0;
        med = "";
    }

    // Parameterized constructor - initialize to specific values
    public perscriptionClaim(String t, int d, Double c, String m, double cp, double ip) 
    {
        super(t,d,c,cp,ip);   // Pass type, date, cost along to superclass constructor
        insurancePay = ip; 
        customerPay = cp;
    }

    // Get/Set Methods
    public void setType(String n) {
        type = n;
    }

    public void setDate(int d) {
        date = d;
    }

    void setCost(Double c) {
        cost = c;
    }

    void setMed(String m) {
        med = m;
    }

    public String getType() {
        return type;
    }

    public int getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public String getMed() {
        return med;
    }

    
    double calcInsurancePay() {
        if (med.startsWith(GEN)) {
            insurancePay = OTHER_RATE * cost;
            customerPay = cost - insurancePay;
        } else {
            insurancePay = cost - GEN_PRICE;
            customerPay = GEN_PRICE;
        }

        // Get and store insurance payment amount
        return (insurancePay);
    }



}
