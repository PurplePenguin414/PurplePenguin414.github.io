// Delta College - CST 283 - Klingler
// This application demonstrates a Java Map as it stores 2015 state populations
// using the state code as the key.

import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class GetStatePop extends Application
{
    Map<String, Double> populationData;   // Hash map for data storage
    String stateList[];                   // Array of states for combo box list

    final int NUM_STATE_ITEMS = 52;

    private ComboBox stateDropList;
    private Button doIt;

    DecimalFormat formatter;

    private final String MI_COUNTY_DATA_FILENAME = "statePop2015.txt";

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    // Build interface and set up listeners
    @Override
    public void start(Stage primaryStage)
    {
        formatter = new DecimalFormat("###,###,###");

        File inputfile = new File(MI_COUNTY_DATA_FILENAME);
        final String delimiter = " ";    // Comma separated content

        populationData = new HashMap<String, Double>();    // Instantiate primary associative array
        stateList = new String[NUM_STATE_ITEMS];                        // Instantiate array for combo box label

        // Populate array of data from file
        int i = 0;
        double data;
        try
        {
            Scanner inputFileScanner = new Scanner(inputfile);
            while (inputFileScanner.hasNext()) {
                String inputLine = inputFileScanner.nextLine();

                StringTokenizer tokens = new StringTokenizer(inputLine, delimiter);

                stateList[i] = tokens.nextToken();
                data = Double.parseDouble(tokens.nextToken());

                // Add data for given state to data map
                populationData.put(stateList[i], new Double(data));

                i++;
            }
            inputFileScanner.close();

        }
        catch (IOException e)
        {
            System.out.println("Problem with file - Shutting down.");
            System.exit(0);
        }

        // Set up JComboBox and register its event handler.
        stateDropList = new ComboBox();
        stateDropList.getItems().addAll((Object[])stateList);

        // Set up selection button
        doIt = new Button("Get Population");

        // Manage button click - If no state selection made, provide error, else return data
        // from hash map
        doIt.setOnAction(selectionEvent ->
        {
            // Get selection from combo box
            SingleSelectionModel selectionModel = stateDropList.getSelectionModel();
            int selectedIndex = selectionModel.getSelectedIndex();
            String selectedItem = (String) selectionModel.getSelectedItem();

            if (selectedIndex < 0 )
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setContentText("You must make a selection");
                alert.showAndWait();
            }
            else
            {
                double population = populationData.get(selectedItem);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Population Summary");
                alert.setContentText("2015 Population for " + selectedItem + " is " + formatter.format(population));
                alert.showAndWait();
            }
        });

        // Configure GUI and apply to stage
        VBox mainLayout = new VBox(20, stateDropList,doIt);
        mainLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainLayout, 350, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2015 State Populations");
        primaryStage.show();
    }
}

 