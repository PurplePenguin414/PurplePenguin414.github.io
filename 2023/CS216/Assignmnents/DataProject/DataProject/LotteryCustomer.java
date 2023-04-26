//Delta College - CST 283 - Klingler 
// This class manages a simple class to store an integer key and related
// integer data

public class LotteryCustomer implements Comparable<LotteryCustomer> {
    // --------------------------------------------------------------

    String ID;
    String Fname;
    String Lname;
    String Addy;
    String City;
    String State;
    String Zip;
    String Phone;
    String Email;
    String Tickets;

    // --------------------------------------------------------------

    // Constructors

    public LotteryCustomer() {
        String ID = "00-00-00-00-00-00";
        String Fname = "none";
        String Lname = "none";
        String Addy = "none";
        String City = "none";
        String State = "none";
        String Zip = "none";
        String Phone = "none";
        String Email = "none";
        String Tickets = "none";
    }

    public LotteryCustomer(String id, String fname, String lname, String addy, String city, String state, String zip,
            String phone, String email, String tickets) // No-arg: Set to sentinel values
    {
        String ID = id;
        String Fname = fname;
        String Lname = lname;
        String Addy = addy;
        String City = city;
        String State = state;
        String Zip = zip;
        String Phone = phone;
        String Email = email;
        String Tickets = tickets;
    }

    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setId(String id) {
        ID = id;
    }

    public String getId() {
        return ID;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFname() {
        return Fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getLname() {
        return Lname;
    }

    public void setAddy(String addy) {
        Addy = addy;
    }

    public String getAddy() {
        return Addy;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCity() {
        return City;
    }

    public void setState(String state) {
        State = state;
    }

    public String getState() {
        return State;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getZip() {
        return Zip;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setTickets(String tickets) {
        Tickets = tickets;
    }

    public String getTickets() {
        return Tickets;
    }

    // --------------------------------------------------------------

    public String toString() {
        return "ID: " + ID +
                "\nFirst Name: " + Fname +
                "\tLast Name: " + Lname +
                "\nAddress: " + Addy +
                "\tCity: " + City +
                "\tState: " + State +
                "\tZip Code: " + Zip +
                "\nPhone Number: " + Phone +
                "\nEmail: " + Email +
                "\nTickets: " + Tickets;
    }

    // Compares components of two fractions for ordinality.
    // @return Integer: 1
    // the first is greater than the second, zero if the two
    // are equal, and -1 if the first is less than the
    // second.
    public int compareTo(LotteryCustomer LotteryCustomer2) {
        int returnValue = 0;

        if (returnValue > this.ID.compareTo(LotteryCustomer2.ID)) {
            returnValue = -1;
        } else if (returnValue > this.ID.compareTo(LotteryCustomer2.ID)) {
            returnValue = 1;
        } else;

        return returnValue;
    }
}