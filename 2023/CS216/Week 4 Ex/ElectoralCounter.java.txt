// Delta College - CST 283 - Klingler
// This program displays a 2-D array grid with an abstract via of the
// U.S. states.  It provides a clickable map for marking electoral votes
// by state.  A continuous running tally is provided with labels and a
// status bar.
// Inspiration (and credit):  www.270towin.com

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class ElectoralCounter extends Application
{
    private final int NUM_ROWS      = 8;
    private final int NUM_COLS      = 12;
    private final int SCENE_WIDTH   = 1600;
    private final int SCENE_HEIGHT  = 800;

    final double STATUS_BAR_HEIGHT  = 50;
    final int ELECTORAL_COLLEGE_WINNING_THRESHOLD = 270;

    final DecimalFormat numberFormat =  new DecimalFormat(("##0"));

    private final String filename = "stateGrid.txt";

    private Pane mainGridArea;

    private Rectangle stateGridArray[][];   // 2-D array of rectangles defining drawing area
    private Text      stateIDarray[][];     // State 2-char ID to write in drawing grid
    private String    stateColor[][];       // Array to track and retain color of states
    private int       electoralVotes[][];   // Number of electoral votes for each state

    // Key variables
    int totalelectoralVotesPossible;
    private Rectangle tallyRectangle, blueTallyRectangle, redTallyRectangle;
    private Text redTally, blueTally, winnerMessage;
    double statusBarWidth, statusBarStartX, statusBarStartY;

    final Font stateLabelFont = Font.font("Arial", 24);  // Declare required fonts globally
    Font tallyFont = Font.font("Arial", 48);

    // ---------------------------------------------------------------------------
    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    // ---------------------------------------------------------------------------
    @Override
    public void start(Stage primaryStage)
    {
        mainGridArea = new Pane();           // Main drawing pane for grid

        initializeMapGrid();                 // Set up the arrays and grid elements.
        setUpTallyComponents();              // Set up totals and status rectangle

        // Set up primary scene
        Scene scene = new Scene(mainGridArea, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Election Calculator");
        primaryStage.show();

        // Handle any mouse click
        mainGridArea.setOnMousePressed(event ->
        {
            // Get the mouse cursor's coordinates.
            double x = event.getSceneX();
            double y = event.getSceneY();
            manageMouseClickOnGrid(x, y);
        });
    }

    // ===========================================================================
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // Perform various actions to initialize drqwing grid and U.S. map
    public void initializeMapGrid()
    {
        // Instantiate all 2-D arrays
        stateGridArray =  new Rectangle[NUM_ROWS][NUM_COLS];
        stateIDarray   =  new Text[NUM_ROWS][NUM_COLS];
        stateColor     =  new String[NUM_ROWS][NUM_COLS];
        electoralVotes =  new int[NUM_ROWS][NUM_COLS];

        // Populate base U.S. map with grey background and blank text.
        // State IDs will replace this for relevant grid elements.
        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLS; j++)
            {
                stateIDarray[i][j] = new Text("");
                stateColor[i][j]   = "LIGHTGRAY";
            }

        // Read state placement and electoral vote information from external file
        try
        {
            File inFileRef = new File(filename);
            Scanner inputFile = new Scanner(inFileRef);
            String inputLine, state;
            StringTokenizer lineTokens;
            int row, column, votes;

            // Populate 2-D array from file
            while (inputFile.hasNext())
            {
                // Read input line and initiate a tokenizer for comma-delimited data
                inputLine = inputFile.nextLine();
                lineTokens = new StringTokenizer(inputLine, ",");

                // Break out tokenized data
                state = lineTokens.nextToken();
                row = Integer.parseInt(lineTokens.nextToken());
                column = Integer.parseInt(lineTokens.nextToken());
                votes = Integer.parseInt(lineTokens.nextToken());

                // For a designated state cell, instantiate a Rectangle object for background color drawing.
                // Initialize outside boundary to black.
                stateGridArray[row][column] = new Rectangle(getLeftCellEdge(column),getTopCellEdge(row),
                        getCellWidth(),getCellHeight());
                stateGridArray[row][column].setFill(Color.LIGHTGRAY);
                stateGridArray[row][column].setStroke(Color.BLACK);
                mainGridArea.getChildren().add(stateGridArray[row][column]);

                electoralVotes[row][column]   = votes;  // Capture number of electoral votes per state
                totalelectoralVotesPossible += votes;  // Tally up total electoral votes possible

                // Assign state two-char code to designated Text object and set font
                stateIDarray[row][column].setText(state);
                stateIDarray[row][column].setFont(stateLabelFont);

                // Center text horizontally in cells
                double textWidth = stateIDarray[row][column].getLayoutBounds().getWidth();
                stateIDarray[row][column].setX(getLeftCellEdge(column) + 0.5 * getCellWidth() - 0.5 * textWidth);

                // Center text vertically in cells
                stateIDarray[row][column].setTextOrigin(VPos.CENTER);
                stateIDarray[row][column].setY(getTopCellEdge(row) + getCellHeight() / 2.0);

                // Set text background and edge colors
                stateIDarray[row][column].setStroke(Color.BLACK);
                stateIDarray[row][column].setFill(Color.BLACK);

                // Add state ID label to graphics pane.
                mainGridArea.getChildren().add(stateIDarray[row][column]);
            }
        }
        catch (IOException e)
        {
            // If a file problem, shut program down.
            System.out.println("Problem with Input File");
            System.exit(0);
        }
    }

    // ---------------------------------------------------------------------------
    // Set up status bar, electoral vote count displays and ultimate winner message
    // components.
    public void setUpTallyComponents()
    {
        // Set up positioning for status bar
        statusBarStartX = getLeftCellEdge(2);
        statusBarWidth = getLeftCellEdge(8) - statusBarStartX;
        statusBarStartY = (getCellHeight() - STATUS_BAR_HEIGHT) / 2.0;

        // Center tally status bar within cells (0,2)...(0.7)
        tallyRectangle = new Rectangle(statusBarStartX,statusBarStartY,statusBarWidth,STATUS_BAR_HEIGHT);
        tallyRectangle.setStroke(Color.BLACK);
        tallyRectangle.setFill(Color.LIGHTGRAY);

        // Ready RED rectangle embedded within status bar
        redTallyRectangle  = new Rectangle(statusBarStartX,statusBarStartY,0,STATUS_BAR_HEIGHT);
        redTallyRectangle.setStroke(Color.TRANSPARENT);
        redTallyRectangle.setFill(Color.RED);

        // Ready BLUE rectangle embedded within status bar
        double endX = statusBarStartX + statusBarWidth;
        blueTallyRectangle = new Rectangle(endX,statusBarStartY,0,STATUS_BAR_HEIGHT);
        blueTallyRectangle.setStroke(Color.TRANSPARENT);
        blueTallyRectangle.setFill(Color.BLUE);

        // Center winner message within cells (1,4)...(1,5)
        winnerMessage = new Text("");
        winnerMessage.setFont(tallyFont);
        winnerMessage.setTextOrigin(VPos.CENTER);
        winnerMessage.setX(getLeftCellEdge(4) + ( 2.0 * getCellWidth() - winnerMessage.getLayoutBounds().getWidth()) / 2.0);
        winnerMessage.setY(getCellHeight() + getCellHeight() / 2.0);
        winnerMessage.setStroke(Color.TRANSPARENT);

        // Place RED tally counter in cell (0,1).  Center number within cell.
        redTally = new Text(numberFormat.format(0));
        redTally.setFont(tallyFont);
        redTally.setTextOrigin(VPos.CENTER);
        redTally.setX(getLeftCellEdge(1) +(getCellWidth() - redTally.getLayoutBounds().getWidth()) / 2.0);
        redTally.setY(getCellHeight() / 2.0);
        redTally.setStroke(Color.RED);

        // Place BLUE tally counter in cell (0,8).  Center number within cell.
        blueTally = new Text(numberFormat.format(0));
        blueTally.setFont(tallyFont);
        blueTally.setTextOrigin(VPos.CENTER);
        blueTally.setX(getLeftCellEdge(8) +(getCellWidth() - blueTally.getLayoutBounds().getWidth()) / 2.0);
        blueTally.setY(getCellHeight() / 2.0);
        blueTally.setStroke(Color.BLUE);

        // Add all electoral tally components to drawing area
        mainGridArea.getChildren().add(tallyRectangle);
        mainGridArea.getChildren().add(blueTallyRectangle);
        mainGridArea.getChildren().add(redTallyRectangle);
        mainGridArea.getChildren().add(winnerMessage);
        mainGridArea.getChildren().add(redTally);
        mainGridArea.getChildren().add(blueTally);
    }

    // ---------------------------------------------------------------------------
    // Perform tasks for a given mouse click. Receive pixel coordinates of
    // click and first convert to determine the grid clicked.  Then, Change
    // color of clicked state by cycling WHITE-BLUE-RED-WHITE- ...
    // Be sure to ignore clicks to non-state regions.
    public void manageMouseClickOnGrid(double x, double y)
    {
        // Convert pixel coordinates into row/column grid coordinates
        int row = getRowClicked(y);
        int column = getColumnClicked(x);

        // Cycle through colors for a given click
        if ( ! stateIDarray[row][column].getText().equals("") )
        {
            if (stateColor[row][column].equals("LIGHTGRAY")) {
                stateColor[row][column] = "BLUE";
                stateGridArray[row][column].setFill(Color.BLUE);
                stateGridArray[row][column].setStroke(Color.BLUE);
                stateIDarray[row][column].setStroke(Color.WHITE);
                stateIDarray[row][column].setFill(Color.WHITE);
            } else if (stateColor[row][column].equals("BLUE"))
            {
                stateColor[row][column] = "RED";
                stateGridArray[row][column].setFill(Color.RED);
                stateGridArray[row][column].setStroke(Color.RED);
                stateIDarray[row][column].setStroke(Color.WHITE);
                stateIDarray[row][column].setFill(Color.WHITE);
            } else if (stateColor[row][column].equals("RED"))
            {
                stateColor[row][column] = "LIGHTGRAY";
                stateGridArray[row][column].setFill(Color.LIGHTGRAY);
                stateGridArray[row][column].setStroke(Color.LIGHTGRAY);
                stateIDarray[row][column].setStroke(Color.BLACK);
                stateIDarray[row][column].setFill(Color.BLACK);
            }

            stateGridArray[row][column].setStroke(Color.BLACK);
        }

        // Recalculate RED-BLUE tally
        int blueTotal = 0;
        int redTotal  = 0;
        for (row = 0; row < NUM_ROWS; row++)
            for (column = 0; column < NUM_COLS; column++)
            {
                if (stateColor[row][column].equals("BLUE"))
                    blueTotal += electoralVotes[row][column];
                if (stateColor[row][column].equals("RED"))
                    redTotal += electoralVotes[row][column];
            }

        // Based on potential change in width of text to be displayed, recalculate x-coordinate
        // to be sure text remains centered.
        blueTally.setText( Integer.toString(blueTotal) );
        blueTally.setX(getLeftCellEdge(8) +(getCellWidth() - blueTally.getLayoutBounds().getWidth()) / 2.0);
        redTally.setText( Integer.toString(redTotal) );
        redTally.setX(getLeftCellEdge(1) +(getCellWidth() - redTally.getLayoutBounds().getWidth()) / 2.0);

        // Re-draw status bar - Adjust RED
        double newRedWidth = ((double)redTotal / (double)totalelectoralVotesPossible) * statusBarWidth;
        redTallyRectangle.setWidth(newRedWidth);

        // Re-draw status bar - Adjust BLUE
        double newBlueWidth = ((double)blueTotal / (double)totalelectoralVotesPossible) * statusBarWidth;
        double newBlueX     = statusBarStartX + statusBarWidth - newBlueWidth;
        blueTallyRectangle.setX(newBlueX);
        blueTallyRectangle.setWidth(newBlueWidth);

        // Check to see of either red or blue reaches the winner threshold.  If so, unmask
        // winner message and be sure it's centered.
        if (redTotal >= ELECTORAL_COLLEGE_WINNING_THRESHOLD)
        {
            winnerMessage.setText("Red Wins!");
            winnerMessage.setStroke(Color.RED);
        }
        else if (blueTotal >= ELECTORAL_COLLEGE_WINNING_THRESHOLD)
        {
            winnerMessage.setText("Blue Wins!");
            winnerMessage.setStroke(Color.BLUE);
        }
        else
        {
            winnerMessage.setText("");
            winnerMessage.setStroke(Color.TRANSPARENT);
        }

        // Center message based on text width.
        winnerMessage.setX(getLeftCellEdge(4) + ( 2.0 * getCellWidth() - winnerMessage.getLayoutBounds().getWidth()) / 2.0);
    }

    // ---------------------------------------------------------------------------
    // Various set/get actions required for working grid

    public int getRowClicked(double x)
    {  return (int) Math.floor(x / SCENE_HEIGHT * NUM_ROWS); }

    public int getColumnClicked(double y)
    {  return (int) Math.floor(y / SCENE_WIDTH * NUM_COLS); }

    public int getLeftCellEdge(int column)
    {  return (SCENE_WIDTH / NUM_COLS) * column; }

    public int getTopCellEdge(int row)
    {  return (SCENE_HEIGHT / NUM_ROWS) * row; }

    public int getCellWidth()
    {  return SCENE_WIDTH / NUM_COLS; }

    public int getCellHeight()
    {  return SCENE_HEIGHT / NUM_ROWS; }
}
