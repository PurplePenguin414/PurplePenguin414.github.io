// Delta College - CST 183 - Klingler                          
// This program creates a user interface for ordering donuts.  It includes a
// "grid" layout using a 2-D array of data.

import java.awt.*;
import java.util.Scanner;
import java.io.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class DonutOrder extends Application
{
    final int NUM_COLS = 5;
    final String INPUT_FILENAME = "donutData.txt";
    final double DONUT_PRICE = 0.35;
    final double DOZEN_PRICE  = 3.50;
    final double PREF_BUTTON_HEIGHT = 120;
    
    // Declare various interface components, objects, and variables
    private HBox orderSummaryInfoPanel, costPanel, buttonPane,topInfoPanel;
    private GridPane    gridPane;
    private int numRows, numDonuts;
    private String      orderString;
    private BorderPane  mainPane;
    private Image       imageFiles[][];
    private Button      donutButtons[][];
    private String      donutLabel[][];
    private int         donutCount[][];
    private int         totalDonutsInOrder;
    private double      totalOrderCost;
    private Label       costLabel;
    private TextArea    orderSummary;
    private Button      submitOrder;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Get dimension of current device screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Access file of donuts.  Number of columns is a fixed value, but
        // number of rows is calculated based on number of entries in data file.
        try
        {
            // Instantiate objects
            File inFileRef = new File(INPUT_FILENAME);
            Scanner inputFile = new Scanner(inFileRef);

            // Determine number of donuts available (by counting file lines)
            int count = 0;
            String inLine;
            while (inputFile.hasNext())
            {
                inLine   = inputFile.nextLine();
                count++;
            }
            numDonuts = count;    // Capture number of donuts from file test

            // Define 2-D array size based on total number of donuts
            numRows = numDonuts / NUM_COLS;
            if (numDonuts % NUM_COLS > 0)
                numRows++;

            // Instantiate required 2-D data structures and components for interface
            imageFiles   = new Image[numRows][NUM_COLS];
            donutButtons = new Button[numRows][NUM_COLS];
            donutLabel   = new String[numRows][NUM_COLS];
            donutCount   = new int[numRows][NUM_COLS];

            // Ready container panels and layouts
            gridPane     = new GridPane();

            // Ready button handler
            DonutButtonHandler donutHandler = new DonutButtonHandler();

            // Reset input file and re-read from beginning
            StringTokenizer inLineTokenizer;
            inputFile = new Scanner(inFileRef);
            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < NUM_COLS; j++)
                {
                    // Read line of data (checking for end-of-file), tokenize
                    // via comma, instantiate both label and image file for the
                    // given line.  Store in 2-D array.
                    if (inputFile.hasNext())
                    {
                        // Get line of data and tokenize it
                        inLine = inputFile.nextLine();
                        inLineTokenizer    = new StringTokenizer(inLine,",");

                        // Construct button for donut just read in
                        donutLabel[i][j] = inLineTokenizer.nextToken();
                        imageFiles[i][j]   = new Image("images/" + inLineTokenizer.nextToken());
                        donutButtons[i][j] = new Button(donutLabel[i][j],new ImageView(imageFiles[i][j]));
                        donutButtons[i][j].setPrefWidth((int)screenSize.getWidth()/NUM_COLS);
                        donutButtons[i][j].setMinHeight(PREF_BUTTON_HEIGHT);
                        donutButtons[i][j].setOnAction(donutHandler);
                        gridPane.add(donutButtons[i][j],j,i);
                        donutCount[i][j] = 0;                         // Initialize count to zero
                    }
                }
            }
         }

        catch(IOException exception)
        {
            System.out.println("File Exception");
            System.exit(0);
        }

        // Build top left order summary area
        orderSummary =  new TextArea();
        orderSummary.setEditable(false);
        orderSummaryInfoPanel = new HBox(orderSummary);
        orderSummaryInfoPanel.setStyle("-fx-background-color: #0000FF;");

        // Build top center order cost area
        costLabel = new Label("Total Cost: $0.00");
        costLabel.setFont(Font.font("SansSerif", FontWeight.NORMAL, 25));
        costPanel = new HBox(costLabel);
        costPanel.setAlignment(Pos.CENTER);

        // Build top right submit button object
        submitOrder =  new Button("SUBMIT ORDER");
        submitOrder.setOnAction(new SubmitButtonHandler());
        buttonPane = new HBox(submitOrder);
        buttonPane.setAlignment(Pos.CENTER);

        // Put top interface panel together
        topInfoPanel = new HBox(30,orderSummaryInfoPanel,costPanel,buttonPane);
        topInfoPanel.setAlignment(Pos.CENTER);

        // Add major containers to interface
        mainPane = new BorderPane();
        mainPane.setTop(topInfoPanel);
        mainPane.setBottom(gridPane);
        orderString = "";    // Empty string that will contain order data

        // Create a Scene with a GridPane as its root node.
        // Define the size for the scene and center at top.
        Scene scene = new Scene(mainPane, (int)screenSize.getWidth(),(int)screenSize.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delta Donut - Order Screen");
        primaryStage.show();
    }

    // Handle any donut button click
    class DonutButtonHandler implements EventHandler<ActionEvent>
    {
        // When Submit button clicked, display message to simulate submitting
        // donut order to be packaged
        @Override
        public void handle(ActionEvent event)
        {
            // Determine the button clicked, and increment the counter 2-D array
            // synchronized with it.  
            for (int i = 0; i < numRows; i++) 
            {
                for (int j = 0; j < NUM_COLS; j++) 
                {
                    if ( event.getSource() == donutButtons[i][j] )
                    {
                        donutCount[i][j]++;   // Increment count of donut selected
                        totalDonutsInOrder++;  
                    }
                }
            }
            
            // Reset text info displayed for donut order given the new addition.
            orderString = "";
            for (int i = 0; i < numRows; i++) 
            {
                for (int j = 0; j < NUM_COLS; j++) 
                {
                    if ( donutCount[i][j] > 0 )
                    {
                        orderString += donutLabel[i][j];
                        if (donutCount[i][j] > 1)
                            orderString += " (" +donutCount[i][j] + ")";
                        orderString += "\n";
                    }
                    
                    // Calculate cost.  First account for full dozens and then 
                    // add number leftover.
                    int dozens   = totalDonutsInOrder / 12;
                    int leftover = totalDonutsInOrder % 12;
                   
                    totalOrderCost = dozens   * DOZEN_PRICE + 
                                     leftover * DONUT_PRICE;
                    
                    costLabel.setText(String.format("Total Cost: $%1.2f", totalOrderCost));
                }
            }            
 
            // Update text area containing donut order in progress.
            orderSummary.setText(orderString);
        } 
    }

    // Handle submit button click
    class SubmitButtonHandler implements EventHandler<ActionEvent>
    {
        // When Submit button clicked, display message to simulate submitting
        // donut order to be packaged
        @Override
        public void handle(ActionEvent event)
        {
            String outStr = "ORDER:\n";

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Donut Order");
            alert.setHeaderText("ORDER");
            alert.setContentText(outStr+orderSummary.getText());

            orderSummary.setText("");    // Clear order text area

            alert.showAndWait();
        }
   }
}
