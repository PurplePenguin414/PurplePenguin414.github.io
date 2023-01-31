// Delta College - CST 283 - Klingler  
// This program performs a search for stars on a digitized field of
// light information.  It marks a star if a pixel averaged with its
// four neighbors is greater that the value of 6.0

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class CheckStars extends Application
{
    // Class wide component declarations
    private TextField fileNameField;
    private Label fileNameLabel;
    private Label starOutputLabel;
    private TextArea starDisplayArea;
    private Button goButton;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Initialize label objects
        fileNameLabel = new Label("Data Filename");
        starOutputLabel = new Label("Star Field");

        // Initialize text field objects
        fileNameField = new TextField();
        fileNameField.setText("inStar.txt");

        // Set up text area
        starDisplayArea = new TextArea();
        starDisplayArea.setFont(Font.font("Monospaced", FontWeight.BOLD, 25));

        // Initialize button and its label.  Register handler for button.
        goButton = new Button("Determine Star Field");
        goButton.setOnAction(new ButtonClickHandler());

        // Add components to vertical containers
        VBox fileInputBox   = new VBox(5,fileNameLabel,fileNameField);
        fileInputBox.setAlignment(Pos.CENTER);
        VBox starDisplayBox = new VBox(5,starOutputLabel,starDisplayArea);
        starDisplayBox.setAlignment(Pos.CENTER);
        VBox mainBox = new VBox(20,fileInputBox,starDisplayBox,goButton);
        mainBox.setAlignment(Pos.CENTER);

        // Set up overall scene
        Scene scene = new Scene(mainBox, 270, 380);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Star Field Analyzer");
        primaryStage.show();
    }
    // Private inner class for event handling.
    // At "Convert" button click, collect input and validate.
    class ButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            StarField theStars;

            String inputFile = fileNameField.getText();
            theStars = new StarField(inputFile);
            theStars.ScanForStars();

            starDisplayArea.setText(theStars.toString());
        }
    }
 }
