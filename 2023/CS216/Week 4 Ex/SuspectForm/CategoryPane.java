// Delta College - CST 283 - Klingler  
// This class defines:
// 1) Radio buttons defining the criticality level of the report.
// 2) The component set check boxes that define whether special
// departments are required to be notified for a crime.  Array of check boxes
// utilized.  Dimension of array derived form labels declared with "alertLabels".

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CategoryPane extends Pane
{
    private CheckBox specialAlerts[];
    private String alertLabels[] = {"Fire Marshall", "Special Victims Unit", "Bomb Squad", "SWAT"};
   
    private Label responseLevel;
    private RadioButton lowButton;
    private RadioButton medButton;
    private RadioButton hiButton;
    private Label specialUnitsLabel;
    private ToggleGroup responseButtonGroup;

    private VBox responseButtonBox, specialUnitsBox;
    private GridPane mainContainer;

    public CategoryPane()
    {
        // Ready criticality radio buttons
        responseLevel = new Label("Criticality");
        responseLevel.getStyleClass().add("headingLabel");
        lowButton = new RadioButton("Low");
        medButton   = new RadioButton("Med");
        hiButton   = new RadioButton("High");
        responseButtonGroup = new ToggleGroup();
        lowButton.setToggleGroup(responseButtonGroup);
        medButton.setToggleGroup(responseButtonGroup);
        hiButton.setToggleGroup(responseButtonGroup);
        responseButtonBox = new VBox(15,responseLevel,lowButton,medButton,hiButton);

        // Add check boxes for special notifications
        specialAlerts    = new CheckBox[alertLabels.length];
         
        // Add label and checkboxes for special units
        specialUnitsBox = new VBox(20);
        specialUnitsLabel = new Label("Special Units to Notify");
        specialUnitsLabel.getStyleClass().add("headingLabel");
        specialUnitsBox.getChildren().add(specialUnitsLabel);
        for (int i = 0; i < alertLabels.length; i++)
        {
            specialAlerts[i] = new CheckBox(alertLabels[i]);
            specialUnitsBox.getChildren().add(specialAlerts[i]);
        }

        // Build this container totally.  Add it to "this" Pane to be used by the primary
        // form in the PoliceReportForm class.
        mainContainer = new GridPane();
        mainContainer.add(responseButtonBox,0,0);
        mainContainer.add(specialUnitsBox,1,0);
        mainContainer.setHgap(50);

        this.getChildren().add(mainContainer);
    }

    // Return special category data as string
    public String getSpecialUnitNotifications()
    {
        String returnString = "";
        for (int i = 0; i < alertLabels.length; i++)
        {
            if (specialAlerts[i].isSelected())
                returnString += ( "\n  - " + alertLabels[i] );
        }
         
        return returnString;
    }

    // Return priority as string
    public String getPriorityData()
    {
        String returnString = "";
        if (lowButton.isSelected() )   
            returnString += "Low";
        if (medButton.isSelected() )   
            returnString += "Medium";
        if (hiButton.isSelected() )   
            returnString += "High";
        
        return returnString;
    }
    
}
