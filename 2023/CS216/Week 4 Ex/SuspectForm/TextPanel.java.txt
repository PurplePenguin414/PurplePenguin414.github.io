 // Delta College - CST 283 - Klingler  
// This class defines the component set text fields needed for police form
// including badge number, suspect, description, etc.


 import javafx.scene.control.Label;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.Pane;
 import javafx.scene.layout.VBox;

 public class TextPanel extends Pane
{
    private Label officerBadgeLabel;
    private TextField officerBadge;
    private Label reportLabel;
    private TextArea crimeReport;
    
    private Label suspectLabel;
    private TextField suspectField;


    public TextPanel() 
    {
        // Create text fields and labels
        officerBadgeLabel = new Label("Office Badge Number");
        officerBadgeLabel.getStyleClass().add("headingLabel");
        officerBadge      = new TextField();
        suspectLabel      = new Label("Suspect");
        suspectLabel.getStyleClass().add("headingLabel");
        suspectField      = new TextField();
        reportLabel       = new Label("Crime Report");
        reportLabel.getStyleClass().add("headingLabel");
        crimeReport       = new TextArea();
        
        // Add components to this panel
        HBox badgeBox   = new HBox(10,officerBadgeLabel,officerBadge);
        HBox suspectBox = new HBox(10,suspectLabel,suspectField);
        HBox topLineBox = new HBox(30,badgeBox,suspectBox);
        VBox reportBox = new VBox(reportLabel,crimeReport);

        VBox mainBox = new VBox(30,topLineBox,reportBox);

        this.getChildren().add(mainBox);
    }

    // Return text data when requested
    public String getOfficer()
    {
        return officerBadge.getText();
    }
    public String getSuspect()
    {
        return suspectField.getText();
    }    
    public String getDetailedReport()
    {
        return crimeReport.getText();
    } }
