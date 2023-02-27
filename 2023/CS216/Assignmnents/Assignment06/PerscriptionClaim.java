package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public abstract class PerscriptionClaim 
{
    protected String name;
    protected String date;
    protected double cost;
    protected String med;

    // Declare constants necessary for salary and tax calculation
    final String GEN = "G_";
    final double GEN_PRICE = 20;
    final double OTHER_RATE = 0.95;

    private double insurancePay;
    private double customerPay;

    // No-Arg constructor - initialize to "dummy" values
    public PerscriptionClaim() 
    {
        name = "";
        date = "";
        cost = 0.0;
        med = "";
    }

    // Parameterized constructor - initialize to specific values
    public PerscriptionClaim(String n, String d, Double c, String m) 
    {
        name = n;
        date = d;
        cost = c;
        med = m;
    }

    // Get/Set Methods
    public void setName(String n) {
        name = n;
    }

    public void setDate(String d) {
        date = d;
    }

    void setCost(Double c) {
        cost = c;
    }

    void setMed(String m) {
        med = m;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public String getMed() {
        return med;
    }

    // Method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    public void calcTaxNet() {
        // Get and store tax
        if (med.startsWith(GEN)) {
            insurancePay = OTHER_RATE * cost;
            customerPay = cost - insurancePay;
        } else {
            insurancePay = cost - GEN_PRICE;
            customerPay = GEN_PRICE;
        }

        // Get and store net pay
        Claim.insurancePay = insurancePay;
        Claim.customerPay = customerPay;

    }

    // Abstract method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    abstract double calcGrossPay(); 
    
    // Abstract method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    public double calcTax()
    {
        return 0;
    }
    
    // Method to write basic employee info to console output
    public String toString() 
    {
        return "";
    }



}
