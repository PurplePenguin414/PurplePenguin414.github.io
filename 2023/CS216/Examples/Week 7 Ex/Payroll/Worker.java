// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public abstract class Worker 
{
    protected String name;
    protected int id;
    protected double grossPay;
    protected double tax;
    protected double netPay;

    // Declare constants necessary for salary and tax calculation
    final double MAX_HOURS_PER_WEEK = 40.0;
    final double TAX_RATE_LOW = 0.10;
    final double TAX_RATE_MED = 0.15;
    final double TAX_RATE_HI = 0.20;
    final double TAX_TIER_1 = 300.0;
    final double TAX_TIER_2 = 600.0;

    // No-Arg constructor - initialize to "dummy" values
    public Worker() 
    {
        name = "";
        id = 0;
    }

    // Parameterized constructor - initialize to specific values
    public Worker(String n, int i) 
    {
        name = n;
        id = i;
    }

    // Get/Set Methods
    public void setName(String n) {
        name = n;
    }

    void setID(int i) {
        id = i;
    }

    void setGross(int g) {
        grossPay = g;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public double getGross() {
        return grossPay;
    }

    public double getTax() {
        return tax;
    }

    public double getNet() {
        return netPay;
    }

    // Method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    public void calcTaxNet() {
        // Get and store tax
        if (grossPay < TAX_TIER_1) {
            tax = TAX_RATE_LOW * grossPay;
        } else if (grossPay <= TAX_TIER_2) {
            tax = TAX_RATE_MED * grossPay;
        } else {
            tax = TAX_RATE_HI * grossPay;
        }

        // Get and store net pay
        netPay = grossPay - tax;

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
