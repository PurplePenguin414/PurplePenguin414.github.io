// Delta College - CST 283 - Klingler
// This application converts temperature Fahrenheit to Celsius.

import javax.swing.JOptionPane;
 
class WindChill 
{
    public static void main(String args[]) 
    {
        // Variable declarations
        double tempCels, windMetric;
        int windChill;
        double tempFahr, windMPH;
        String outString;
        
        // Input   
        tempCels   = Double.parseDouble(
                    JOptionPane.showInputDialog("Enter temperature (deg C):"));
        windMetric = Double.parseDouble(
                    JOptionPane.showInputDialog("Enter wind speed (m/s):"));

        // Call methods to do the math
        tempFahr  = convertCelsToFahr(tempCels);
        windMPH   = convertToMPH(windMetric);
        windChill = calcWindChill(tempFahr, windMPH);
        
        // Formulate output string and display output dialog.  Concatenate
        // wind chill info only for colder temperatures.
        outString = "Wind Chill Summary:\n";
        outString += "    Temperature: " + Math.round(tempFahr) + " deg F\n";
        outString += "    Wind:        " + Math.round(windMPH)  + " mph\n";
        if (tempFahr <= 40.0)
            outString += "    Wind Chill:  " + windChill + " deg F";
        JOptionPane.showMessageDialog(null, outString);
    }
  
    // ------------------------------------------------------------------
    // This method converts an air temperature from degrees Celsius to 
    // Fahrenheit.
    public static int convertCelsToFahr(double degC)
    {
        return (int)Math.round(9.0/5.0 * degC + 32.0);
    }
  
    // ------------------------------------------------------------------
    // This method converts a speed from meters per second to miles per hour.
    public static double convertToMPH(double mps)
    {
        return mps * 2.236936;
    }

    // ------------------------------------------------------------------
    // This method receives an air temperature and wind speed in U.S. units
    // and returns the wind chill temperature in degrees Fahrenheit.
    // Output value is rounded to the nearest integer temperature
    public static int calcWindChill(double temp, double wind)
    {    
        int chill = (int)Math.round(35.74 + 0.6215 * temp - 35.75 
                     * Math.pow(wind, 0.16) + 0.4275 * temp * Math.pow(wind, 0.16));
        return chill;
    }

}