// Delta College - CST 283 - Klingler  
// This class defines drop-down lists for the following:
// 1) General category of polic report
// 1) Date and time of incident


import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DateTimePane extends Pane
{
    private Label dateLabel, timeLabel, incidentLabel;
    private HBox dateBox, timeBox;
    private VBox mainBox, incidentBox;
    private ComboBox hour, minute, second;
    private ComboBox month, day, year;
    private ComboBox reportCategory;
    
    private final String months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                                     "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    private final int baseYear = 2018;
    private final int numYears = 10;

    private final String categoryLabels[] = {"Traffic Accident", "Domestic",
                                    "Theft", "Break-In", "Criminal Investigation"};

    public DateTimePane()
    {
        dateLabel = new Label("Date");
        dateLabel.getStyleClass().add("headingLabel");
        timeLabel = new Label("Time");
        timeLabel.getStyleClass().add("headingLabel");
         
        // Prepare date components
        String days[] = new String[31];       // Generate day array
        for (int i = 0; i < 31; i++)
            days[i] = String.format("%02d",(i+1));
        
        String years[] = new String[10];      // Generate year array
        int addYear = baseYear;
        for (int i = 0; i < numYears; i++)
        {
            years[i] = Integer.toString(addYear);
            addYear++;
        }

        // Set up date drop-down lists
        day   = new ComboBox();
        day.getItems().addAll((Object[])days);
        month = new ComboBox();
        month.getItems().addAll((Object[])months);
        year  = new ComboBox();
        year.getItems().addAll((Object[])years);

        // Prepare time components
        String hours[] = new String[24];       // Generate hours array
        for (int i = 0; i <= 23; i++)
            hours[i] = String.format("%02d",i);
        
        String minSecs[] = new String[60];      // Generate min/sec array
        for (int i = 0; i < 60; i++)
            minSecs[i] = String.format("%02d", i);

        // Set up time drop-down lists
        hour   = new ComboBox();
        hour.getItems().addAll((Object[])hours);
        minute = new ComboBox();
        minute.getItems().addAll((Object[])minSecs);
        second = new ComboBox();
        second.getItems().addAll((Object[])minSecs);

        // Add general report incident category choices
        incidentLabel = new Label("Incident Category");
        incidentLabel.getStyleClass().add("headingLabel");
        reportCategory = new ComboBox();
        reportCategory.getItems().addAll((Object[])categoryLabels);

        // Combine all components into three rows
        dateBox = new HBox(20,dateLabel,month,day, year);
        dateBox.setAlignment(Pos.CENTER);
        timeBox = new HBox(20,timeLabel,hour,minute,second);
        timeBox.setAlignment(Pos.CENTER);
        incidentBox =  new VBox(10,incidentLabel,reportCategory);
        incidentBox.setAlignment(Pos.CENTER);

        mainBox = new VBox(25,dateBox,timeBox,incidentBox);

        this.getChildren().add(mainBox);
    }
    
    // Build date and time into one string and return
    public String getDateTime()
    {
        String returnString = "Date Incomplete";

        if (year.getValue() != null && month.getValue() != null && day.getValue() != null &&
                hour.getValue() != null && minute.getValue() != null && second.getValue() != null)
        {
            returnString = year.getValue().toString() + "-" +
                    month.getValue().toString() + "-" +
                    day.getValue().toString() + " " +
                    hour.getValue().toString() + ":" +
                    minute.getValue().toString() + ":" +
                    second.getValue().toString();
        }

        return returnString;
    }
    
    // Return selected category
    public String getCrimeCategory()
    {
        if (reportCategory.getValue() != null)
            return reportCategory.getValue().toString();
        else
            return "Not Selected";
    }
}
