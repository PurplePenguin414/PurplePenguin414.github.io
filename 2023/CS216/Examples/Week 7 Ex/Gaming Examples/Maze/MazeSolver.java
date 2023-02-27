// Delta College - CST 283 - Klingler          =
// This application solves five mazes.  Each maze is derived from a file
// including a 2-D array of characters.  The object of each is to move
// from the upper-left to the lower-right without making contact with
// and obstruction.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MazeSolver extends JFrame
{
    private JTextArea startMazeDisplay, solvedMazeDisplay;
    private JPanel topPanel, bottomPanel;
    private JButton nextButton;
    private int currentMaze;
    
    private String mazeFiles[] = {"maze1.txt", "maze2.txt", "maze3.txt",
                                  "maze4.txt", "maze5.txt"};

    public MazeSolver()
    {        
        // Get content pane and set its layout
        Container container = getContentPane();
        container.setLayout( new GridLayout( 2,2 ) );
        
        // Ready font for output
        Font outputFont = new Font("monospaced", Font.PLAIN, 16);

        // Set up top panel with text areas
        topPanel = new JPanel();
        topPanel.setLayout( new FlowLayout() );
        startMazeDisplay = new JTextArea( 15, 15 );
        startMazeDisplay.setEditable( false );
        startMazeDisplay.setFont(outputFont);
        topPanel.add( startMazeDisplay );

        solvedMazeDisplay = new JTextArea( 15, 15 );
        solvedMazeDisplay.setEditable( false );
        solvedMazeDisplay.setFont(outputFont);
        topPanel.add( solvedMazeDisplay );
        // For five mazes defined in files, build the maze object, solve
        // it and display the results via a dialog box.   
        
        // Set up bottom panel with interation button
        bottomPanel = new JPanel();
        bottomPanel.setLayout( new FlowLayout() );
        nextButton  = new JButton("Next Maze");
        bottomPanel.add( nextButton ); 
        nextButton.addActionListener(
            new ActionListener()      // Anonymous inner class to manage button click
            {   
                public void actionPerformed( ActionEvent event )
                {
                    // Button click advances to next maze file.  Maze is
                    // is instantiated, displayed, solved, and redisplayed.
                    // If files remain, advance iteration marker.  Otherwise,
                    // prevent it and offer a completion message.
                    if (currentMaze < mazeFiles.length)
                    {
                        Maze theMaze = new Maze(mazeFiles[currentMaze]);  
                        startMazeDisplay.setText(theMaze.toString() );  
                        theMaze.SolveMaze();         
                        solvedMazeDisplay.setText(theMaze.toString() );  
                        
                        currentMaze++;
                    }
                    else
                        JOptionPane.showMessageDialog( null, "All Files Processed" ); 
                }
            }  
        ); 

        container.add(topPanel);
        container.add(bottomPanel);
        
        currentMaze = 0;    // Set maze iterator to beginning
   }
    
       public static void main( String args[] )
   {
      MazeSolver application = new MazeSolver();
      
      // Set attributes of application
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setSize( 450, 450 );
      application.setVisible( true );
      application.setTitle( "Maze Solver" );
   }

}

