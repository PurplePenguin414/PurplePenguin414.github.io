// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.

public class Worker 
{
    private String name;
    private int id;
    private double grossPay;
    private double tax;
    private double netPay;

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

    void setGross(double g) {
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
    
    // Method to collect all worker data and format a line of info destined
    // for the output report.
    public String writeFormattedLine()
    {
        String outString = "";
        
        outString += String.format("%-12s", this.getName());
        outString += String.format("%d8",   this.getID());
        outString += String.format("%9.2f", this.getGross());
        outString += String.format("%9.2f", this.getTax());
        outString += String.format("%9.2f", this.getNet());
        outString += "\n"; 
        
        return outString;
    }
    
    // Method to write basic employee info to console output
    public String toString() 
    {
        return "";
    }
}
