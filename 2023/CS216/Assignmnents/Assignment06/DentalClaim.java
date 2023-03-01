package CS216.Assignmnents.Assignment06;
// Delta College - CST 283 - Gibbs 
// This file define a class to manage data and information for a claim specific to a dental visit.


public class dentalClaim extends claim
{
    protected String type, service;
    protected int date;
    private double cost, customerPay, insurancePay;

    // Declare constants necessary for determining exams and payment %
    final String EXAM = "E";
    final double EXAM_RATE = 0.95;
    final double OTHER_RATE = 0.80;

    // No-Arg constructor - initialize to "dummy" values
    public dentalClaim() 
    {
        type = "";
        date = 0;
        cost = 0.0;
        service = "";
    }

    // Parameterized constructor - initialize to specific values
    public dentalClaim(String t, int d, String s, double c, double cp, double ip) 
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
        service = m;
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
        return service;
    }

    
    double calcInsurancePay() {
        if (service.equals(EXAM)) {
            insurancePay = EXAM_RATE * cost;
            customerPay = cost - insurancePay;
        } else {
            insurancePay = OTHER_RATE * cost;
            customerPay = cost - insurancePay;
        }

        // Get and store insurance payment amount
        return (insurancePay);
    }

}
