// Delta College - CST 283 - Klingler 
// This application opens, reads, and displays a large data file containing
// weather data to the output console.

import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

public class GreatLakesWx {

    final static String targetURL = "https://coastwatch.glerl.noaa.gov/marobs/today.lmd.txt";

    public static void main(String[] args) 
    {
        try 
        {
             // Identify target URL
            URL theURL = new URL(targetURL);

            // Open input stream to URL and read line-by-line
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(
                        theURL.openStream()));

            // Read all lines.  Extract the temperature token only for MBS
            String inputLine;
            while ((inputLine = inputStream.readLine()) != null) 
            {       
                System.out.println(inputLine);        
            }
            
            inputStream.close();     
        } 
        catch (MalformedURLException e) 
        {
            System.out.println("Invalid URL");
        } 
        catch (IOException e) 
        {
            System.out.println("IO Exception");
        }
        catch (Exception e) 
        {
            System.out.println("Unknown Exception");
        }
    }
}
