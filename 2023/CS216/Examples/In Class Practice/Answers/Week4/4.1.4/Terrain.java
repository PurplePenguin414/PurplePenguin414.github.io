// Delta College - CST 283 - Klingler  
// This class utilizes a two-dimensional array to store
// and manage a grid of elevation data for terrain field.

import java.io.*;
import java.util.Scanner; 

public class Terrain
{
    private final int MAXROWS = 480;
    private final int MAXCOLS = 480;
    
    private int elevationData[][];

    // Build terrain grid
    public Terrain(String starFileName)
    {
        elevationData = new int[MAXROWS][MAXCOLS];
        try
        {
            File inFileRef = new File(starFileName);
            Scanner inputFile = new Scanner(inFileRef);
        
            // Read-process-write text messages one at a time
            while (inputFile.hasNext())
            {
               for (int i = 0; i < MAXROWS; i++)
                  for (int j = 0; j < MAXCOLS; j++)
                     elevationData[i][j] = inputFile.nextInt();
            }
        }
        catch (IOException e)
        {
            System.out.println("Problem with file - Shutting down.");
            System.exit(0);
        } 
   }      

    // Scan data field for ridges or mountain peaks.  Assume any value greater
    // than all 8 adjacent points will be a peak.  The method scans the file
    // and writes the grid coordinates (i,j) to the output console.
    public void identifyPeaks()
    {

        for (int i=1; i<MAXROWS-1; i++)
        {
            for (int j=1; j<MAXCOLS-1; j++)
            {         
                // Check the grid points E,SE,S,SW,W,NW,N,NE of this point 
                // searching for a peak
                if (elevationData[i][j] > elevationData[i][j+1]   &&
                    elevationData[i][j] > elevationData[i+1][j+1] &&
                    elevationData[i][j] > elevationData[i+1][j]   &&
                    elevationData[i][j] > elevationData[i-1][j+1] &&
                    elevationData[i][j] > elevationData[i-1][j]   &&
                    elevationData[i][j] > elevationData[i-1][j-1] &&
                    elevationData[i][j] > elevationData[i-1][j]   &&
                    elevationData[i][j] > elevationData[i-1][j+1] &&
                    elevationData[i][j] > 4250)
                        System.out.println(i + ", " + j);
            }
            
        }
    }

}