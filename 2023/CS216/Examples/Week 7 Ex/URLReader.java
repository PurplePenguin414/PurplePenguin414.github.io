// Delta College - CST 283 - Klingler & Oracle, Inc.
// This class opens a URL and reads the contents.  The text is
// send to the output console.

import java.net.*;
import java.io.*;

public class URLReader 
{
    final static String targetURL = "https://www.deltaweather.net/tempTable.js"; 
    
    public static void main(String[] args) throws Exception 
    {
        // Identify target URL
        URL theURL = new URL(targetURL);
        
        // Open input stream to URL and read line-by-line
        BufferedReader inputStream 
            = new BufferedReader(
                  new InputStreamReader(
                       theURL.openStream()));

        String inputLine;
        while ((inputLine = inputStream.readLine()) != null)
            System.out.println(inputLine);
        inputStream.close();
    }
}
