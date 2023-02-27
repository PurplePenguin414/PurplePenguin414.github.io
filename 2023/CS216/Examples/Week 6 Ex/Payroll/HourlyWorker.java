// Delta College - CST 283 - Klingler 
// This file implements functions for the hourly employee class
// This file define a class to store information about
// an hourly employee

class HourlyWorker extends Worker
{
    private double hoursWorked;
    private double payRate;
    
    private final double MAX_HOURS_PER_WEEK = 40.0;

    // No-Arg constructor - initialize to "dummy" values
    HourlyWorker()
    {    
        super();          // Invoke no-arg constructor of superclass
        hoursWorked = 0;
        payRate     = 0;
    }                

    // Parameterized constructor - initialize to parameter values
    HourlyWorker(String na, int id, double hr, double rate) 
    {    
        super(na,id);   // Pass name/id along to superclass constructor
        hoursWorked = hr;
        payRate = rate;
    }   
    
    // Accessors/mutators
    public void setRate(double rate)
    { payRate = rate; }
    public void setHours(double hours)
    { hoursWorked = hours; }
    public double getRate()
    { return payRate; }
    public double getHours()
    { return hoursWorked; }

    // Method to calculate gross pay.  Will "set" grossPay variable
    // Includes capability for "time-and-a-half" for hours over 40.
    // Precondition:  hours worked and pay rate have valid, meaningful values
    public void calcGrossPay() 
    {
        // Get and store gross pay
        if (hoursWorked <= MAX_HOURS_PER_WEEK)
            setGross(payRate * hoursWorked);
        else
            setGross(payRate * MAX_HOURS_PER_WEEK 
                       + (hoursWorked - MAX_HOURS_PER_WEEK) * 1.5 * payRate);
    }
}
