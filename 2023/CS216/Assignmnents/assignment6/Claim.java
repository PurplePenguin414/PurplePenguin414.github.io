package CS216.Assignmnents.assignment6;

// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public abstract class Claim 
{
    protected String name;
    protected String date;
    protected double cost;
    protected static double insurancePay;
    protected static double customerPay;

    // Declare constants necessary for salary and tax calculation
    final double MAX_HOURS_PER_WEEK = 40.0;
    final double TAX_RATE_LOW = 0.10;
    final double TAX_RATE_MED = 0.15;
    final double TAX_RATE_HI = 0.20;
    final double TAX_TIER_1 = 300.0;
    final double TAX_TIER_2 = 600.0;

    // No-Arg constructor - initialize to "dummy" values
    public Claim() 
    {
        name = "";
        date = "";
        cost = 0.0;
        insurancePay = 0.0;
        customerPay = 0.0;
    }

    // Parameterized constructor - initialize to specific values
    public Claim(String n, String d, Double c, Double ip, Double cp) 
    {
        name = n;
        date = d;
        cost = c;
        insurancePay = ip;
        customerPay = cp;
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

    static void setInsurancePay(Double ip) {
        insurancePay = ip;
    }

    void setCustomerPay(Double cp) {
        customerPay = cp;
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

    public double getInsurancePay() {
        return insurancePay;
    }

    public double getCustomerPay() {
        return customerPay;
    }

    // Abstract method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    abstract double calcPay(); 
    
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
