package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This file define a class to manage data and information for an employee.


public abstract class MedicalClaim 
{
    public final String FILENAME2 = "2023/CS216/Assignmnents/Assignment06/medicalCategories.txt";

    protected String name;
    protected String date;
    protected double cost;
    protected String type;
    protected String network;

    // Declare constants necessary for salary and tax calculation
    final String IN_NETWORK = "N";
    final String OUT_NETWORK = "O";
    final String SURGERY = "SU";
    final String HOSPITAL = "HO";
    final double IN_SURG_RATE = 0.95;
    final double OUT_SURG_RATE = 0.75;
    final double IN_RATE = 0.80;
    final double OUT_RATE = 0.60;


    private double insurancePay;
    private double customerPay;


    // No-Arg constructor - initialize to "dummy" values
    public MedicalClaim() 
    {
        name = "";
        date = "";
        cost = 0.0;
        type = "";
        network = "";
    }

    // Parameterized constructor - initialize to specific values
    public MedicalClaim(String n, String d, Double c, String t, String net) 
    {
        name = n;
        date = d;
        cost = c;
        type = t;
        network = net;
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

    void setType(String t) {
        type = t;
    }

    void setNetwork(String net) {
        network = net;
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

    public String getType() {
        return type;
    }

    public String getNetwork() {
        return network;
    }

    // Method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    public void calcPay() {
        // Get and store tax
        if (network.equals(IN_NETWORK) && type.equals(SURGERY)) {
            insurancePay = IN_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        } else if (network.equals(OUT_NETWORK) && type.equals(SURGERY)) {
            insurancePay = OUT_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        } else if (network.equals(IN_NETWORK) && type.equals(HOSPITAL)) {
            insurancePay = IN_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        }else if (network.equals(OUT_NETWORK) && type.equals(HOSPITAL)) {
            insurancePay = OUT_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        }else {
            if (network.equals(IN_NETWORK)){
                insurancePay = IN_RATE * cost;
                customerPay = cost - insurancePay;
            }else{
                insurancePay = OUT_RATE * cost;
                customerPay = cost - insurancePay;
            }
        }

        // Get and store net pay
        Claim.insurancePay = insurancePay;
        Claim.customerPay = customerPay;

    }

    // Abstract method to calculate tax - determines tax and net pay.  Sets
    // them to class variables.
    // Precondition:  Gross pas yas been determined
    abstract double calcTotalPay(); 
    
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
