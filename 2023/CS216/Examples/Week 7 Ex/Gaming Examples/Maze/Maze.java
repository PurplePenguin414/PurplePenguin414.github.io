// Delta College - CST 283 - Klingler                               */
// This file provides the specification for one maze object
// consisting of a 7 X 7 2-D array.  A path will be found from
// the upper left character to the lower right character.

import java.io.*;
import java.util.Scanner; 

public class Maze 
{
    private final int MAZEROWS = 7;
    private final int MAZECOLS = 7;

    private final char BARRICADE = '*';
    private final char UNMARKED = '.';

    private char theMaze[][];        // 2-D array of characters
    private boolean searchStarted;   // Flag indicating if search has commenced
    private boolean pathFound;       // Flag indicating if path found or not
    
    //---------------------------------------------------------------------//
    // This constructor builds the maze from a file.                       //
    //---------------------------------------------------------------------//
    public Maze(String inFilename)
    {
        theMaze = new char[MAZEROWS][MAZECOLS];   // Primary 2-D array
        
        searchStarted = false;                    // Declare search not started yet
        
        try
        {
            File inFileRef = new File(inFilename);
            Scanner inputFile = new Scanner(inFileRef);
        
            // Read-process-write text messages one at a time
            while (inputFile.hasNext())
            {
                for (int i = 0; i < MAZEROWS; i++)
                {
                    String oneLine = inputFile.next();
                    for (int j = 0; j < MAZECOLS; j++)
                         theMaze[i][j] = oneLine.charAt(j);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Problem with file - Closing Down");
            System.exit(0);
        } 
        catch (Exception e)
        {
            System.out.println("Problem with file - Closing Down");
            System.exit(0);
        }
    }

    //---------------------------------------------------------------------
    // This method controls the solution for a complete path thru the   
    // maze.    
    //---------------------------------------------------------------------
    public void SolveMaze()
    {
        pathFound     = false; // Set internal switch to false - assume no path found
        searchStarted = true;  // For display, determine if search has started

        // BEGIN RECURSION with initial call
        // Start search at upper left position [0][0]
        // First position marker will be 'a'
        // Set switch to FALSE indicating we have not yet found the path
        TryToEscape(0,0,'a');
    }

    //---------------------------------------------------------------------
    // Return maze as a string formatted as 2-D arrays.     
    //---------------------------------------------------------------------
    public String toString()
    {
        String output = "\n";              // Blank line
        for (int i = 0; i < MAZEROWS; i++)
        {
            for (int j = 0; j < MAZECOLS;j ++)   // Write one row of maze
                output += theMaze[i][j] + " ";
            output += "\n";                      // Add newline character
        }

        output += "\n";                  // Blank line
         
        // Only is search has completed:  add path status
        if (searchStarted)
        {
            if (pathFound)
                output += "Path Found\n";
            else
                output += "No Path Found\n";
        }  
        else
            output += "\n";
        return output;
    }

    //---------------------------------------------------------------------
    // This function uses recursion to solve for a complete path thru a  
    // maze.  It drives the recursive behavior and path searching strategy
    // including necessary backtracking.  ASCII (UNICODE) codes are used
    // to assist in managing the char markers.
    //---------------------------------------------------------------------
    private void TryToEscape(int row, int col, char mark)
    {
        if (atEnd(row,col) && !barricaded(row,col))
        {
            pathFound = true;
            theMaze[row][col] = mark;
        }
        else
        {
            if (inRange(row,col)      &&            // If not a barricaded space     AND
                !used(row,col)        &&            // If not already visited        AND
                !barricaded(row,col)  &&            // If not outside maze boundary  AND
                !pathFound)                         // If not path already found
                {                                   //    Then 
                    theMaze[row][col] = mark;       //        mark it as next item
                    mark++;                         //        increment marker for next time
                    if  (mark > 122)                //        if mark == 'z', make it 'a'
                        mark = 97;
                                                    //        Recursively search
                    TryToEscape(row-1,col,mark);    //             Try UP
                    TryToEscape(row,col+1,mark);    //             Try RIGHT
                    TryToEscape(row+1,col,mark);    //             Try DOWN
                    TryToEscape(row,col-1,mark);    //             Try LEFT

                    if (!pathFound)                      // If return from recursion without
                        theMaze[row][col] = UNMARKED;    // a find, return to unmarked
                }
        }

    }

    //---------------------------------------------------------------------
    // This function determines if a maze space has a barricade '*' on it 
    //---------------------------------------------------------------------
    private boolean barricaded(int r, int c)
    {        
        if (theMaze[r][c] == BARRICADE)                    
            return true;                                
        else
            return false;
    }

    //---------------------------------------------------------------------
    // This function determines if a maze space has been used (contains 
    // an alphabetic letter).            
    //---------------------------------------------------------------------
    private boolean used(int r, int c)
    {
        if (theMaze[r][c] >= 97 && theMaze[r][c] <= 122)    // Check ASCII range                
            return true;                                    // for lower case letters
        else
            return false;
    }

    //---------------------------------------------------------------------
    // This function determines if a maze position is inside the valid   
    // range of subscript values.
    //---------------------------------------------------------------------
    private boolean inRange(int r, int c)
    {
        if ((r >= 0 && r < MAZEROWS) && (c >= 0 && c < MAZECOLS))    
            return true;                                    
        else
            return false;
    }

    //---------------------------------------------------------------------
    // This function determines if a maze position is the lower right or 
    // ending position of a maze       
    //---------------------------------------------------------------------
     private boolean atEnd(int r, int c)
    {
        if ((r == MAZEROWS - 1) && (c == MAZECOLS - 1))    
            return true;                                    
        else
            return false;
    }
}
