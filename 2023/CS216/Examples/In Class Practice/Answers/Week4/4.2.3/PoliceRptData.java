// Delta College - CST 283 
// This class is the "back end" for a police crime reporting applicaiton.  It
// includes fields to collect and capture all reports submitted via the form.

import java.util.Scanner;
import java.io.*;

public class PoliceRptData
{
    // --------------------------------------------------------------
    private String badgeNumber;
    private String suspect;
    private String crimeReport;
    
    private String category;
    private String priority;
    private String dateTime;   
    
    private int age;
    private int height;
    private int weight;
    
    private String specialNotification;

          
    public static final String datafilename = "xxxxxxx.txt";
    
    // --------------------------------------------------------------
    
    // Constructors
    public PoliceRptData()
    {
        // Allow default values
    }
    
    // --------------------------------------------------------------
    
    // "Set" methods
    public void setAge(int a)
    { age = a; }
    public void setHeight(int h)
    { height = h; }
    public void setWeight(int w)
    { weight = w; }
    public void setDateTime(String dt)
    { dateTime = dt; }
    public void setOfficer(String b)
    { badgeNumber = b; }
    public void setSuspect(String s)
    { suspect = s; }
    public void setDescription(String r)
    { crimeReport = r; }
    public void setCategory(String c)
    { category = c; }
    public void setNotifications(String n)
    { specialNotification = n; }
    public void setPriority(String p)
    { priority = p; }

    public int getAge()
    { return age; }
    public int getHeight()
    { return height; }
    public int getWeight()
    { return weight; }
    public String getDateTime()
    { return dateTime; }
    public String getOfficer()
    { return badgeNumber; }
    public String getSuspect()
    { return suspect; }
    public String getDescription()
    { return crimeReport; }
    public String getCategory()
    { return category; }
    public String getNotifications()
    { return specialNotification; }
    public String getPriority()
    { return priority; }
    
    
    // --------------------------------------------------------------
    // Method adds this report to a data log (text file)
    public void logReport()
    {    
        String existingLog = "";    // Store contents of file
        String aLine;
        
        try
        {
            String filename= "PoliceLog.txt";
            
            // Open a file to append.  Add "this" report to end of log file.
            FileWriter outFile = new FileWriter(filename,true); 
            outFile.write(this.toString());
            outFile.close();
        }
            catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
            System.exit(0);
        }
    }
    
    // --------------------------------------------------------------
    public String toString()
    {
        String outString = "INCIDENT REPORT\n\n"    + 
                "Officer: "   + badgeNumber  + "\n" +
                "Date/Time: " + dateTime     + "\n" +
                "Category: "  + category     + "\n" +
                "Priority: "  + priority     + "\n" +
                "Suspect: "   + suspect      + "\n"+
                "Age: "       + age          +  
                "  Height: "  + height       + 
                "  Weight: "  + weight       + "\n" +   
                "Special Unit Alerts: "      + 
                specialNotification          + "\n" +                  
                "Details: "    + crimeReport + "\n" ;
        return outString;
   }

}