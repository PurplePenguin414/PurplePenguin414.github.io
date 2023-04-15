// Delta College - CST 283 - Klingler                              
// This application utilizes a thread with a timer to access web info 
// at regular intervals.  Specifically, it accesses and parses the JavaScript
// code for real-time temperature information at the Delta weather station.

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimedWebInfo extends Application
{
    private final static String URL_Site = new String("https://www.deltaweather.net/data.js");
    private final static int DATA_UPDATE_DELAY = 30000;  // 30 seconds
    private final static String DEGREE  = "\u00b0";
    
    private static Label deltaLabel;
    private static Label timeLabel;
    private static Label tempLabel;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Ready GUI container
        GridPane appLayout = new GridPane();

        // Ready labels for info, time and temperature
        deltaLabel =  new Label("Delta College");
        deltaLabel.setFont(Font.font("Helvetica", 48));
        deltaLabel.setTextFill(Color.DARKGREEN);
        HBox deltaLabelBox = new HBox(deltaLabel);
        deltaLabelBox.setAlignment(Pos.CENTER);
        appLayout.add(deltaLabelBox, 0, 0);

        timeLabel =  new Label();
        timeLabel.setFont(Font.font("Helvetica", 32));
        HBox timeLabelBox = new HBox(timeLabel);
        timeLabelBox.setAlignment(Pos.CENTER);
        appLayout.add(timeLabelBox, 0, 1);

        tempLabel =  new Label();
        tempLabel.setFont(Font.font("Helvetica", 40));
        tempLabel.setTextFill(Color.RED);
        HBox tempLabelBox = new HBox(tempLabel);
        tempLabelBox.setAlignment(Pos.CENTER);
        appLayout.add(tempLabelBox, 0, 2);

        updateTimeTemp();    // Initialize the labels for the first time.

        // Create a Scene and display it.
        appLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(appLayout, 600, 200);
        primaryStage.setTitle("Time and Temperature");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Launched timer thread to update time and temperature for given refresh cycle time
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(DATA_UPDATE_DELAY), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                updateTimeTemp();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // =========================================================================
    private static void updateTimeTemp()
    {
        // Access web URL and extract current Delta temperature.
        // Set this to label.
        String currentTemperature = parseJSfile();
        tempLabel.setText(currentTemperature + DEGREE);

        // Next, get current clock time.
        Date dateNow = new Date();
        SimpleDateFormat dateFormat
                = new SimpleDateFormat ("E MMMM dd, yyyy hh:mm a zzz");
        timeLabel.setText(dateFormat.format(dateNow));
    }


    // =========================================================================
    // This method opens a URL containing the current temperature at Delta.
    // The data value is embedded within JavaScript code and has to be parsed
    // out before being returned.  This method loads the contents of the file
    // into one String object.
    private static String loadJSfile()
    {
        BufferedReader input;
        String fileContents = "";
        String nextLine = "";

        try
        {
            URL theURL = new URL(URL_Site);
            input = new BufferedReader(new InputStreamReader(theURL.openStream()));

            while ((nextLine = input.readLine()) != null)
            {
                fileContents += nextLine;
            }

            input.close();
        }
        catch (MalformedURLException e)
        {
            System.out.println("MalformedURLException");
        }
        catch (IOException e)
        {
            System.out.println("IOException");
        }
        return fileContents;
    }

    // =========================================================================
    // This method receives a String object containing JavaScript code with
    // real-time weathe data.  It parses out the temperture
    private static String parseJSfile()
    {
        String entireFileContents = loadJSfile();

        // Seek position of JavaScript function call for temperature
        int pos1 = entireFileContents.indexOf("calcTempF");

        // From the function call, seek the "return" statement
        int pos2 = entireFileContents.indexOf("return",pos1);

        // Find the start of the temperature - just after next space
        // Find the end of the temperature - just before semicolon
        int startPos = entireFileContents.indexOf(" ",pos2) + 1;
        int endPos = entireFileContents.indexOf(";",pos2);

        return entireFileContents.substring(startPos,endPos);
    }
}   