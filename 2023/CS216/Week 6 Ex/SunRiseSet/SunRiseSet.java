// Delta College - CST 283 - Klingler  
// This application provides an interface allowing a user to enter a date and a place.
// It then calculates sunrise, sunset, and length-of-day.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SunRiseSet extends Application
{
    private Label dateLabel, zoneLabel;
    private ComboBox month, day, year;
    private ComboBox timeZone;
    private Label latLabel, lonLabel;
    private TextField latitudeField, longitudeField;
    private Button calcButton;
    private TextArea outputArea;

    private HBox datePanel, zonePanel,locationPanel, buttonPanel,bottomHalfGUI;
    private VBox topHalfGUI, mainContainer;

    private final String months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN",
        "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    
    // Time zone for interface parallel to the offset from universal time.
    private final String zoneStrings[] = {"EST","EDT","CST","CDT","MST","MDT","PST","PDT","UTC"};
    private final int zoneOffsets[]    = {5,4,6,5,7,6,8,7,0};
    
    private static int todayMonth, todayDay, todayYear;
    private static final int yearRange = 10;   // Years before and after this year to display
    
    // Initialize starting location to Delta College    
    private final double startLatitude  = 43.559;
    private final double startLongitude = 83.986;

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    @Override
    public void start(Stage primaryStage)
    {
         // Prepare date components
        String days[] = new String[31];       // Generate day array
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", (i + 1));
        }
                               
        this.todayDate();    // Initialize form elements to today at Delta

        int numYears = 2 * yearRange + 1;  // Specified years before and after this year

        String years[] = new String[numYears];      // Generate year array
        int addYear = todayYear - yearRange;
        for (int i = 0; i < numYears; i++) 
        {
            years[i] = Integer.toString(addYear);
            addYear++;
        }

        // Instantiate date interface components
        dateLabel = new Label("Date");
        day = new ComboBox();
        day.getItems().addAll(days);
        month = new ComboBox();
        month.getItems().addAll(months);
        year = new ComboBox();
        year.getItems().addAll(years);
        
        // Initialize date elements to today
        year.getSelectionModel().select(numYears/2);
        month.getSelectionModel().select(todayMonth);
        day.getSelectionModel().select(todayDay-1);
        
        // Add date components
        datePanel = new HBox(15,dateLabel,day,month,year);
        datePanel.setAlignment(Pos.CENTER);
        
        // Add components for time zone.  Set initial time zone to index zero (UTC)
        zoneLabel = new Label("Time Zone");
        timeZone = new ComboBox();
        timeZone.getItems().addAll(zoneStrings);
        timeZone.getSelectionModel().select(0);
        zonePanel = new HBox(zoneLabel,timeZone);
        zonePanel.setAlignment(Pos.CENTER);
        
        // Ready text fields for latitude/longitude.  Set initially to Delta lat/lon.
        latLabel       = new Label("Latitude");
        latitudeField  = new TextField();
        latitudeField.setText(Double.toString(startLatitude));
        lonLabel       = new Label("Longitude");
        longitudeField = new TextField();
        longitudeField.setText(Double.toString(startLongitude));
        locationPanel  = new HBox(15,latLabel,latitudeField,lonLabel,longitudeField);
        locationPanel.setAlignment(Pos.CENTER);
        
        // Ready button and assoicate to listener
        calcButton = new Button("Calculate");
        buttonPanel = new HBox(calcButton);
        buttonPanel.setAlignment(Pos.CENTER);
        ButtonClickHandler handler = new ButtonClickHandler();
        calcButton.setOnAction(handler);
        
        // Prepare output text area
        outputArea = new TextArea();
  
        // Finalize overall GUI
        topHalfGUI    = new VBox(25,datePanel,zonePanel,locationPanel,buttonPanel);
        topHalfGUI.setAlignment(Pos.CENTER);
        
        bottomHalfGUI = new HBox(outputArea);
        bottomHalfGUI.setAlignment(Pos.CENTER);

        mainContainer = new VBox(30,topHalfGUI,bottomHalfGUI);

        // Set up overall scene
        Scene scene = new Scene(mainContainer, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sunrise/Sunset Calculator");
        primaryStage.show();
     }

    // Handle button click event
    class ButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if (event.getSource() == calcButton) 
            {                
                // Collect time from combo boxes
                SingleSelectionModel monthSelection = month.getSelectionModel();
                int mo = monthSelection.getSelectedIndex() + 1;
                SingleSelectionModel daySelection = day.getSelectionModel();
                int da = daySelection.getSelectedIndex() + 1;
                SingleSelectionModel yearSelection = year.getSelectionModel();
                int yr = Integer.parseInt((String)year.getValue());

                // Collect location from text fields
                double la = Double.parseDouble(latitudeField.getText());
                double lo = Double.parseDouble(longitudeField.getText());
                
                // Collect time zone choice from combo box and assign time
                // offset from array
                SingleSelectionModel zoneSelection = timeZone.getSelectionModel();
                int zone = zoneOffsets[zoneSelection.getSelectedIndex()];

                // Instantiate object from input data and make times
                GeoPlaceTime daySunInfo = new GeoPlaceTime(mo,da,yr,la,lo,zone);
                daySunInfo.makeTimes();

                // Set results to output area
                outputArea.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 16));
                outputArea.setText(daySunInfo.getAlmanacData());
            }
        }
    }
    
    // This method sets the variables for today's date.
    private void todayDate()
    {
        GregorianCalendar calendar = new GregorianCalendar();
           
        todayMonth = calendar.get(Calendar.MONTH);
        todayDay   = calendar.get(Calendar.DAY_OF_MONTH);
        todayYear  = calendar.get(Calendar.YEAR);
    }

}

