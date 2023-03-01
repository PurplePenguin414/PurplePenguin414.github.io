package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Gibbs 
// This file define a class to manage data and information for a claim.

public abstract class claim {

    //declare variables needed
    protected String type, service;
    protected int date;
    private double cost, insurancePay, customerPay;

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

    // Abstract method to calculate insurance payment - determines amount insurance would pay.  Sets
    // them to class variables.
    abstract double calcInsurancePay(); 
    
    public String toString() 
    {
        return "";
    }

    public void calcPay() {
        customerPay = cost - insurancePay;
    }


}
