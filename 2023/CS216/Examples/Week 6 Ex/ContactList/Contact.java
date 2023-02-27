// Delta College - CST 283 - Klingler 
// This class manages the data for a simple contact

import java.util.*;

public class Contact
{
    // --------------------------------------------------------------

    private String        firstName;
    private String        lastName;
    private String        company;
    private Address       contactAddress;
    private Communication contactComms;
    private Date          contactBirthDate;
    
    // --------------------------------------------------------------
    // Constructor - Build contact object by tokenizing raw data file
    // Relevant data passed on to component objects.
    
    public Contact(String rawDataLine)
    {
        String county;
        StringTokenizer tokens = new StringTokenizer( rawDataLine, "," );

        // Name & company data
        this.firstName = tokens.nextToken(); 
        this.lastName  = tokens.nextToken();  
        this.company   = tokens.nextToken();      
        
        // Address data
        contactAddress =  new Address(); 
        contactAddress.setAddress(tokens.nextToken());
        contactAddress.setCity(tokens.nextToken());        
        county = tokens.nextToken();                  // Discard county data; unneeded           
        contactAddress.setState(tokens.nextToken());  
        contactAddress.setZip(tokens.nextToken());  
        
        // Contact info data
        contactComms = new Communication();
        contactComms.setPhone1(tokens.nextToken());
        contactComms.setPhone2(tokens.nextToken());
        contactComms.setEmail(tokens.nextToken());
        contactComms.setHomePage(tokens.nextToken());
        
        // Birthdate data
        String tempDate;
        int tempMo, tempDa, tempYr;
        tempDate = tokens.nextToken();           // Get data in form: yyy-mm-dd
        
        StringTokenizer dateTokens = new StringTokenizer( tempDate, "-" );
        tempYr = Integer.parseInt(dateTokens.nextToken());
        tempMo = Integer.parseInt(dateTokens.nextToken());       
        tempDa = Integer.parseInt(dateTokens.nextToken());   
                
        contactBirthDate =  new Date(tempMo, tempDa, tempYr);
    }
    // --------------------------------------------------------------

    // "Get" and "Set" methods
    public void setFirstName(String f)
    {  firstName = f; }
    public void setLastName(String la)
    {  firstName = la; }
    public void setCompany(String c)
    {  company = c; }
        
    public String getFirstName()
    { return firstName; }
    public String getLastName()
    { return lastName; }
    public String getCompany()
    { return company; }

    // --------------------------------------------------------------

    // This method receives a month and day.  It compares these to the
    // birth day of this object and returns true if it matches.
    public boolean matchesBirthDate(int month, int day)
    {
        if (this.contactBirthDate.getMonth() == month &&
            this.contactBirthDate.getDay()   == day)
            return true;
        else
            return false;
    } 

    // --------------------------------------------------------------
    
    // This method returns the string data for this object.
    public String toString()
    {
        return firstName + " " + lastName  + "\n" +
                contactAddress.toString()  + "\n" + 
                "Company: " + company      + "\n" + 
                contactComms.toString()    + "\n" + 
                "Birthday: " + contactBirthDate.toString() + "\n\n";
    }


}