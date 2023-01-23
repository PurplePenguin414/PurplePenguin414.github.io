// Delta College - CST 283 - Klingler  
// This application allows a user to read a distance and time.  It validates
// the input and then converts to various units.

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SpeedCalc extends Application
{
    // Declare objects
    private TextField distanceField, timeField;
    private Label distanceLabel, timeLabel,speedStatusLabel;
    private TextArea messageArea;
    private Button calcButton, clearButton;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Initialize label objects
        distanceLabel = new Label("Distance");
        timeLabel = new Label("Time");

        // Initialize text field objects
        distanceField = new TextField();
        timeField = new TextField();
        speedStatusLabel = new Label();

        // Set up text area
        messageArea = new TextArea();

        // Define "convert" button and register button event handler
        calcButton = new Button("Calculate");
        calcButton.setOnAction(new ConvertButtonClickHandler());

        // Define "clear" button and register button event handler
        clearButton = new Button("Clear");
        clearButton.setOnAction(event ->
        {
            distanceField.setText("");
            timeField.setText("");
            speedStatusLabel.setText("");
            messageArea.setText("");
        });

        // Construct GUI by layering containers
        HBox distanceBox  = new HBox(10, distanceLabel, distanceField);
        distanceBox.setAlignment(Pos.CENTER);
        HBox timeBox  = new HBox(10, timeLabel, timeField);
        timeBox.setAlignment(Pos.CENTER);
        HBox statusBox  = new HBox(speedStatusLabel);
        statusBox.setAlignment(Pos.CENTER);
        HBox buttonBox  = new HBox(10, calcButton, clearButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Combine all horizontal rows of interface components in a primary vertical box.
        VBox mainBox = new VBox(10,distanceBox,timeBox,statusBox,buttonBox);
        mainBox.setAlignment(Pos.CENTER);

        // Set up overall scene
        Scene scene = new Scene(mainBox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Speed Converter");
        primaryStage.show();
    }

    // Handle button click event.  Collect values in operand text fields, add
    // them, and display them via a JavaFX Alert dialog box.
    class ConvertButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            String distanceStr = distanceField.getText();
            String timeStr = timeField.getText();
            double distance = 0, time = 0, speedMPH;

            boolean inputOK = true;

            // Perform input number format check
            try
            {
                distance = Double.parseDouble(distanceStr);
                time     = Double.parseDouble(timeStr);
            }
            catch (NumberFormatException e)
            {
                inputOK = false;
            }

            // Perform input range check
            if (distance <= 0 || time <= 0)
            {
                inputOK = false;
            }

            // Perform calculations.  Set values in fields
            if (inputOK == true)
            {
                speedMPH = distance / time;

                speedStatusLabel.setText(String.format("Speed: %6.1f mph", speedMPH));

                // Calculate alternate speed values
                double kph = mphTOkph(speedMPH);
                double knots = mphTOknots(speedMPH);
                double mPs = mphTOmps(speedMPH);

                // Set other speed values in text area
                messageArea.setText("Speed:"                       + "\n" +
                        String.format("       %6.1f kph",   kph)   + "\n" +
                        String.format("       %6.1f knots", knots) + "\n" +
                        String.format("       %6.1f m/s",   mPs));
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error.");
                alert.setContentText("Please check distance and/or time input");
                alert.showAndWait();
            }
        }
    }

    // Convert miles/hour to kilometers/hour
    private double mphTOkph(double inMPH)
    {
        return inMPH * 1.60934;
    }

    // Convert miles/hour to knots
    private double mphTOknots(double inMPH)
    {
        return inMPH * 0.868976;
    }

    // Convert miles/hour to meters/second
    private double mphTOmps(double inMPH)
    {
        return inMPH * 0.44704;
    }

}