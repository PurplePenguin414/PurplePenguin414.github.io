package CS216.Assignmnents.Assignment06;


public class medicalClaim extends claim {

    private double cost, insurancePay, customerPay;
    private String network, service;

    final String IN_NETWORK = "N";
    final String OUT_NETWORK = "O";
    final String SURGERY = "SU";
    final String HOSPITAL = "HO";
    final double IN_SURG_RATE = 0.95;
    final double OUT_SURG_RATE = 0.75;
    final double IN_RATE = 0.80;
    final double OUT_RATE = 0.60;


    // No-Arg constructor - initialize to "dummy" values
    public medicalClaim() 
    {
        super();
        type = "";
        date = 0;
        cost = 0.0;
        service = "";
        network = "";
    }

    public medicalClaim(String t, int d, double c, String s, String n, double cp, double ip) 
    {
        super(t,d,c,ip,cp);   // Pass type, date, cost along to superclass constructor
        insurancePay = ip; 
        customerPay = cp;  
    }

    // Accessors/mutators
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

    void setService(String s) {
        service = s;
    }

    void setNetwork(String net) {
        network = net;
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

    public String getService() {
        return type;
    }

    public String getNetwork() {
        return network;
    }

    
    double calcInsurancePay() {
        if (network.equals(IN_NETWORK) && service.equals(SURGERY)) {
            insurancePay = IN_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        } else if (network.equals(OUT_NETWORK) && service.equals(SURGERY)) {
            insurancePay = OUT_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        } else if (network.equals(IN_NETWORK) && service.equals(HOSPITAL)) {
            insurancePay = IN_SURG_RATE * cost;
            customerPay = cost - insurancePay;
        }else if (network.equals(OUT_NETWORK) && service.equals(HOSPITAL)) {
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

        // Get and store insurance payment amount
        return (insurancePay);
    }
    
}
