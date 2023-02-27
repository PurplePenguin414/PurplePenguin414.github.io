package CS216.Assignmnents.Assignment06;

// Delta College - CST 283 - Klingler 
// This program processes payroll by instantiating an object of the
// Payroll class.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ClaimDriver extends Application
{
    private TextArea outputTextArea;
    private static ClaimDriver theClaim;
    private String outputReport;
    private double VIEW_HEIGHT = 400;
    private double VIEW_WIDTH  = 500;

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Process payroll via object
        theClaim = new ClaimDriver();
        theClaim.prepareClaim();
        theClaim.processClaim();
        outputReport = theClaim.toString();
        
        // Send output to text area
        // Set up overall scene with text area.
        outputTextArea = new TextArea(outputReport);
        outputTextArea.setPrefHeight(VIEW_HEIGHT);
        outputTextArea.setPrefWidth(VIEW_WIDTH);
        HBox mainContainer = new HBox(outputTextArea);
        outputTextArea.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 16));

        // Finalize set-up of overall scene
        Scene scene = new Scene(mainContainer, VIEW_WIDTH, VIEW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Claims");
        primaryStage.show();
    }

}
