// Delta College - CST 283 - Klingler 
// This file define a class to store information about
// an salaried employee.

class SalariedWorker extends Worker 
{
    private double salary;

    // No-Arg constructor - initialize to "dummy" value
    public SalariedWorker() 
    {
        super();       // Invoke no-arg constructor of superclass
        salary = 0.00;
    }

    // Parameterized constructor - initialize to parameter values
    public SalariedWorker(String na, int id, double sal) 
    {
        super(na,id);   // Pass name/id along to superclass constructor
        salary = sal;   
    }

    // Accessors/mutators
    public void setSalary(double s) 
    {  salary = s; }
    public double getSalary() 
    {  return salary; }
    
    // Method to calculate gross pay.  Will "set" grossPay variable
    // and return it.
    // Assumes annual salary stored and employee has 52 pay periods
    public void calcGrossPay() 
    {
        setGross(salary / 52.0);
    }

}
