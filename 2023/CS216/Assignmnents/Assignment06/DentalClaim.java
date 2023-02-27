package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public abstract class DentalClaim 
{
    protected String name;
    protected String date;
    protected double cost;
    protected String procedure;

    // Declare constants necessary for salary and tax calculation
    final String EXAM = "E";
    final double EXAM_RATE = 0.95;
    final double OTHER_RATE = 0.80;

    private double insurancePay;
    private double customerPay;

    // No-Arg constructor - initialize to "dummy" values
    public DentalClaim() 
    {
        name = "";
        date = "";
        cost = 0.0;
        procedure = "";
    }

    // Parameterized constructor - initialize to specific values
    public DentalClaim(String n, String d, Double c, String p) 
    {
        name = n;
        date = d;
        cost = c;
        procedure = p;
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

    void setProcedure(String p) {
        procedure = p;
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

    public String getProcedure() {
        return procedure;
    }

    // Method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    public void calcPay() {
        // Get and store tax
        if (procedure.equals(EXAM)) {
            insurancePay = EXAM_RATE * cost;
            customerPay = cost - insurancePay;
        } else {
            insurancePay = OTHER_RATE * cost;
            customerPay = cost - insurancePay;
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
