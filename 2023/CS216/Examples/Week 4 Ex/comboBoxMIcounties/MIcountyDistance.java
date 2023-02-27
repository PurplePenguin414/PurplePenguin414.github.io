// Delta College - CST 283 - Klingler
// This application demonstrates a drop-down list selection with a choice
// of Michigan counties.  Upon selection, the distance from Delta College to
// a central county location is calculated.

import java.util.Scanner;
import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MIcountyDistance extends Application
{
    private ComboBox countyDropList;
    private Button doItButton;

    private int selectedIndex;    // Maintain index of current county selected

    private int    countyCode[];  // Manage solution with parallel arrays
    private String miCounties[];  // of Michigan county data
    private double latitude[];
    private double longitude[];

    private final String MI_COUNTY_DATA_FILENAME = "miCounties.txt";
    private final int TOTAL_MI_COUNTIES  = 83;
    private final double DELTA_LATITUDE  = 43.55660;
    private final double DELTA_LONGITUDE = -83.99430;

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    // Build interface and set up listeners
    @Override
    public void start(Stage primaryStage)
    {
        // Instantiate file object and invoke method to load parallel
        //arrays from file.
        File inputfile = new File(MI_COUNTY_DATA_FILENAME);
        loadCountiesFromFile(inputfile);
    
        // set up ComboBox and register its event handler
        countyDropList  = new ComboBox();
        countyDropList.getItems().addAll((Object[])miCounties);

        // Set up selection button
        doItButton = new Button( "Get Info" );
        doItButton.setOnAction(new ButtonClickHandler());

        // Configure GUI and apply to stage
        VBox mainLayout = new VBox(20,countyDropList,doItButton );
        mainLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainLayout, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Michigan County Distance");
        primaryStage.show();
    }

    // This method builds four parallel arrays using data from a file containing
    // Michigan county trivia.
    public void loadCountiesFromFile(File inputFile)
    {
        // Instantiate required arrays - number of MI counties plus one blank
        countyCode = new int[TOTAL_MI_COUNTIES + 1 ];
        miCounties = new String[TOTAL_MI_COUNTIES + 1 ];
        latitude   = new double[TOTAL_MI_COUNTIES + 1 ];
        longitude  = new double[TOTAL_MI_COUNTIES + 1 ];

        final String delimiter = ",";    // Comma separated content

        try
        {
            // Asserting file found, instantiate scanner object for input
            Scanner inputFileScanner = new Scanner(inputFile);

            // Set up first element in array to be blank with null data
            int i = 0;
            countyCode[i] = -9999;
            miCounties[i] = "";
            latitude[i]   = -99.99;
            longitude[i]  = -99.99;

            // File processing loop - Continue while not empty
            // Read file element and store in array
            i++;
            while (inputFileScanner.hasNext())
            {

                String inputLine = inputFileScanner.next();
                StringTokenizer tokens = new StringTokenizer(inputLine, delimiter);

                countyCode[i] = Integer.parseInt(tokens.nextToken());
                miCounties[i] = tokens.nextToken();
                latitude[i]   = Double.parseDouble(tokens.nextToken());
                longitude[i]  = Double.parseDouble(tokens.nextToken());
                i++;
            }
            inputFileScanner.close();

        } catch (IOException e)
        {
            System.out.println("Problem with file - Shutting down.");
            System.exit(0);
        }
    }

        // Process button click.  Collect info for selected county and display
        // via an alert box.
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                // Get index of selected county.  This will further be used to get the lat/lon
                // coordinates for the county to be used in the subsequent calculation.
                SingleSelectionModel selectionModel = countyDropList.getSelectionModel();
                int selectedIndex = selectionModel.getSelectedIndex();

                // Manage selected combo box item
                if (selectedIndex == -1 || selectedIndex == 0)    // If nothing selected
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("State Decoder");
                    alert.setContentText("You must make a selection");
                    alert.showAndWait();
                }
                else   // Otherwise, process selected county.
                {
                    // Calculate distance from Delta to selected county
                    double distance =  GeoCalc.calcGreatCircleDist(
                            DELTA_LATITUDE,DELTA_LONGITUDE,
                            latitude[selectedIndex],longitude[selectedIndex]);

                    // Generate output alert message
                    String outputStr = miCounties[ selectedIndex ] + " County is " +
                            String.format("%6.2f", distance) + " miles from Delta";

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("State Decoder");
                    alert.setContentText(String.format(outputStr));
                    alert.showAndWait();
                }
            }
        }
}

