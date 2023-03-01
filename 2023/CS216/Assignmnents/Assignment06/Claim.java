package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public abstract class claim {

    protected String type, service;
    protected int date;
    private double cost, insurancePay, customerPay;

    // Declare constants necessary for salary and tax calculation
    final double MAX_HOURS_PER_WEEK = 40.0;
    final double TAX_RATE_LOW = 0.10;
    final double TAX_RATE_MED = 0.15;
    final double TAX_RATE_HI = 0.20;
    final double TAX_TIER_1 = 300.0;
    final double TAX_TIER_2 = 600.0;

    // No-Arg constructor - initialize to "dummy" values
    public claim() 
    {
        type = "";
        date = 0;
        cost = 0.0;
        service = "";
        insurancePay = 0.0;
        customerPay = 0.0;
    }

    // Parameterized constructor - initialize to specific values
    public claim(String t, int d, Double c, Double ip, Double cp) 
    {
        type = t;
        date = d;
        cost = c;
        insurancePay = ip;
        customerPay = cp;
    }

    // Get/Set Methods
    public void setType(String t) {
        type = t;
    }

    public void setDate(int d) {
        date = d;
    }

    void setCost(Double c) {
        cost = c;
    }

    void setInsurancePay(Double ip) {
        insurancePay = ip;
    }

    void setCustomerPay(Double cp) {
        customerPay = cp;
    }

    void setService(String s) {
        service = s;
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

    public double getInsurancePay() {
        return insurancePay;
    }

    public double getCustomerPay() {
        return customerPay;
    }

    public String getService() {
        return type;
    }

    // Abstract method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    abstract double calcInsurancePay(); 
    
    
    // Method to write basic employee info to console output
    public String toString() 
    {
        return "";
    }

    public void calcPay() {
        customerPay = cost - insurancePay;
    }


}
