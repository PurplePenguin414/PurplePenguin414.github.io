// Delta College - CST 283 - Klingler
// This application defines a very primitive computer dating service.  An
// applicant enters their own attributes & interests via check box selections.
// This is then matched up to a client database of others.  The maximum match
// is selected.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DatingMatch extends Application
{
    private final static int MAX_ATTRIBUTES   = 26;
    private final static int MAX_CLIENT_COUNT = 300;

    private final String attributeFileName = "datingAttributes.txt";
    private final String clientDataFileName = "clientDB.txt";

    private static char     attributeCharList[];
    private static String   attributeNamesList[];
    private static CheckBox attributeChecks[];
    private static String   clientData[];
    private static CharSet2 clientDataSet[];

    private static int numClients = 0;     // Count number of clients in file and return

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    // ----------------------------------------------------------------------------
    // Prepare GUI.
    @Override
    public void start(Stage primaryStage)
    {
        // Instantiate required data structures
        attributeCharList   = new char[MAX_ATTRIBUTES];
        attributeNamesList  = new String[MAX_ATTRIBUTES];
        clientDataSet   = new CharSet2[MAX_CLIENT_COUNT];
        attributeChecks = new CheckBox[MAX_ATTRIBUTES];

        buildAttributeArrays(attributeFileName);        // Collect required information for files

        buildClientAttributeSets(clientDataFileName);   // Read client attribute data and build sets

        // Build checkbox array to be added to GUI
        VBox checkBoxContainerLeft = new VBox(10);
        VBox checkBoxContainerRight = new VBox(10);
        for (int i = 0; i < MAX_ATTRIBUTES; i++)
        {
            attributeChecks[i] = new CheckBox(attributeNamesList[i]);

            // Add half of check boxes to left box and theother half to right
            if (i < MAX_ATTRIBUTES / 2)
                checkBoxContainerLeft.getChildren().add(attributeChecks[i]);
            else
                checkBoxContainerRight.getChildren().add(attributeChecks[i]);
        }

        HBox checkBoxContainer = new HBox(20,checkBoxContainerLeft,checkBoxContainerRight);
        checkBoxContainer.setAlignment(Pos.CENTER);

        // Set up JButton and register with handler
        Button getMatchButton = new Button("Get Matches");
        HBox buttonBox = new HBox(getMatchButton);
        ButtonHandler buttonHandler = new ButtonHandler();
        getMatchButton.setOnAction(buttonHandler);
        buttonBox.setAlignment(Pos.CENTER);

        // Ready label and formatting for main layout
        Label instructionLabel = new Label("My Personal Interests");
        instructionLabel.setFont(new Font("Arial", 20));
        instructionLabel.setStyle("-fx-font-weight: bold");
        VBox mainLayout = new VBox(40, instructionLabel,checkBoxContainer, buttonBox);
        mainLayout.setPadding(new Insets(20, 0,0,0));
        mainLayout.setAlignment(Pos.CENTER);

        // Set up overall scene
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delta Dating Service");
        primaryStage.show();
    }

    // ----------------------------------------------------------------------------
    // This method
    class ButtonHandler implements EventHandler<ActionEvent>
    {
        // Respond to button event
        @Override
        public void handle(ActionEvent event)
        {
            // Build set of desired attributes from user check box selectoions
            CharSet2 userAttributes = new CharSet2();
            for (int i = 0; i < MAX_ATTRIBUTES; i++)
            {
                if (attributeChecks[i].isSelected())
                    userAttributes.insert(attributeCharList[i]);
            }

            // Scan client data and seek maximum set intersection with user and client
            // attribute selections
            CharSet2 setIntersection;
            int setIntersectionSize;
            int maxSetIntersectionSize   = 0;
            String maxSetIntersectionUserID = "0";
            CharSet2 maxIntersectionSet = new CharSet2();
            for (int i = 0; i < numClients; i++)
            {
                setIntersection = userAttributes.intersect(clientDataSet[i]);
                setIntersectionSize = setIntersection.cardinality();

                // Retain the max set intersection cardinality.  Also not user ID
                if (setIntersectionSize > maxSetIntersectionSize)
                {
                    // If not largest found, retain size of set, associated client ID, and set itself
                    maxSetIntersectionSize = setIntersectionSize;
                    maxSetIntersectionUserID = clientData[i];
                    maxIntersectionSet = setIntersection;
                }
            }

            // Construct output message with all matched attributes
            String outputMessage = "Customer: " + maxSetIntersectionUserID + "\n";
            for (int i = 0; i < MAX_ATTRIBUTES; i++)
            {
                if (maxIntersectionSet.isElement(attributeCharList[i]))
                    outputMessage += attributeNamesList[i] + "\n";
            }


            // Show dialog with contents of text field and state of
            // checkboxes
            Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
            aboutAlert.setTitle("Best Match");
            aboutAlert.setContentText(outputMessage);
            aboutAlert.showAndWait();
        }
    }

    // ----------------------------------------------------------------------------
    // This method receives a local file name (as a String) and a String array.
    // It populates the array with the information from the file one line at a time.
    // RETURN:  Number of elements in file
    // PRE:  Array is adequately sized to handle file contents.
    public static void buildAttributeArrays(String filename)
    {
        int numElementsInFile = 0;
        int commaPos;

        // General file loop
        try
        {
            File inputfile;
            inputfile = new File(filename);
            Scanner inputFileScanner = new Scanner(inputfile);

            // Read contents of file int array; count words as it processes
            int i = 0;
            while (inputFileScanner.hasNext() && i < MAX_ATTRIBUTES)
            {
                // Extract data tokens for one attribute from input line
                String theNextLine = inputFileScanner.nextLine();
                commaPos = theNextLine.indexOf(",");
                attributeCharList[i]  = theNextLine.charAt(0);
                attributeNamesList[i] = theNextLine.substring(commaPos + 1);
                i++;
            }
        }
        catch (IOException e)
        {
            System.out.println("ERROR: File Error: " + filename);
            System.exit(0);
        }
    }

    // ----------------------------------------------------------------------------
    // This method reads the client data file that contains their ID number and
    // a set of attributes.  Parallel arrays are build in this method:
    //     {Array of customer IDs}    {Array of attributes (char) sets}
    public static void buildClientAttributeSets(String filename)
    {
        // General file loop
        try
        {
            File inputfile;
            inputfile = new File(filename);
            Scanner inputFileScanner = new Scanner(inputfile);

            // Read contents of file int array; count words as it processes
            clientData = new String[MAX_CLIENT_COUNT];
            int i = 0;
            while (inputFileScanner.hasNext() && i < MAX_ATTRIBUTES)
            {
                // Extract data tokens for one attribute from input line
                String lineOfClientData = inputFileScanner.nextLine();
                StringTokenizer dataTokens = new StringTokenizer(lineOfClientData,",");

                clientData[i]                = dataTokens.nextToken();   // Read first token into ID array

                // Read remainder of tokens into related attribute set
                clientDataSet[i] = new CharSet2();
                while(dataTokens.hasMoreTokens())    // Walk down comma-delimited string list, extract one char
                {                                    // at a time, and insert into set of char.
                    char nextAttribute = dataTokens.nextToken().charAt(0);
                    clientDataSet[i].insert(nextAttribute);
                }

                i++;   // Count number of clients
            }
            numClients = i;    // Capture number of clients in static (global) variable
        }
        catch (IOException e)
        {
            System.out.println("ERROR: File Error: " + filename);
            System.exit(0);
        }
    }

}
