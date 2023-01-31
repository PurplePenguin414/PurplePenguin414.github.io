// Delta College - CST 283 
// This class defines a user interface for police report data entry.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class PoliceReportForm extends Application
{
    // Declare primary subpanels
    private TextPanel textDataPanel;
    private InfoPanel nameAgeWeightPanel;
    private CategoryPane specialUnitPanel;
    private DateTimePane dateTimePanel;

    HBox buttonBox;
    GridPane interfacePane;
    BorderPane mainContainer;
    
    private Button generateButton;
     
    PoliceRptData crimeData;   // Object for "back end" data collection

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    @Override
    public void start(Stage primaryStage)
    {
        crimeData = new PoliceRptData();     // Object to manage data();
        
        // Instantiate primary component subpanels
        textDataPanel      = new TextPanel();
        specialUnitPanel   = new CategoryPane();
        nameAgeWeightPanel = new InfoPanel();
        dateTimePanel       = new DateTimePane();
        
        generateButton = new Button("Generate Report");
        buttonBox = new HBox(generateButton);
        buttonBox.setAlignment(Pos.CENTER);
        ButtonHandler buttonListener = new ButtonHandler();
        generateButton.setOnAction(buttonListener);

        // Build four quadrants of overall form from subpanel objects
        interfacePane = new GridPane();
        interfacePane.add(textDataPanel,0,0);
        interfacePane.add(nameAgeWeightPanel,0,1);
        interfacePane.add(specialUnitPanel,1,1);
        interfacePane.add(dateTimePanel,1,0);

        // Set some gap between primary panels
        interfacePane.setHgap(40);
        interfacePane.setVgap(40);

        // Construct main container for overall scene
        mainContainer = new BorderPane();
        mainContainer.setTop(interfacePane);
        mainContainer.setBottom(buttonBox);
        mainContainer.setPadding(new Insets(20, 20, 20, 20));

        // Set up overall scene
        Scene scene = new Scene(mainContainer, 950, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("styles.css");
        primaryStage.setTitle("Delta College Police - Reporting");
        primaryStage.show();
    } 
    
    // ---------------------------------------------------------------------
    // Handle button click to generate report.
    class ButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            // Collect data from all component panels and "set" into report object
            crimeData.setAge(nameAgeWeightPanel.getSuspectAge());
            crimeData.setHeight(nameAgeWeightPanel.getSuspectHeight());            
            crimeData.setWeight(nameAgeWeightPanel.getSuspectWeight());

            crimeData.setNotifications(specialUnitPanel.getSpecialUnitNotifications());
            crimeData.setPriority(specialUnitPanel.getPriorityData());

            crimeData.setDateTime(dateTimePanel.getDateTime());
            crimeData.setCategory(dateTimePanel.getCrimeCategory());

            crimeData.setOfficer(textDataPanel.getOfficer());
            crimeData.setSuspect(textDataPanel.getSuspect());             
            crimeData.setDescription(textDataPanel.getDetailedReport());               

            // Collect report text from data object and display in alert.
            // Report formatting initiated within data object toString() method.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delta College Police");
            alert.setHeaderText("Police Report");
            alert.setContentText(crimeData.toString());
            alert.showAndWait();
            
            // Append contents of report to log
            crimeData.logReport();
        }
    }

}

