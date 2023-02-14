// Delta College - CST 283 - Klingler  
// This program drives a class that searches a field of terrain data to
// identify peaks.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScanForPeaks extends JFrame 
{
    public static void main( String[] args ) 
    {
        Terrain data = new Terrain("colorado.txt");   
        
        data.identifyPeaks();
    }

 }
