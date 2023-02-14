
// Delta College - CST 283 - Klingler  
// This class defines the component set for the name, age, and weight of
// of a suspect.  It utilizes slider components for these fields

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class InfoPanel extends Pane
{
    private Slider ageSlider, heightSlider, weightSlider;
    private Label ageField, heightField, weightField;
    private Label ageLabel, heightLabel, weightLabel;

    private double MIN_SLIDER_WIDTH = 300;

    public InfoPanel() 
    {
       // Build slider labels
        ageLabel    = new Label("Age");
        ageLabel.getStyleClass().add("headingLabel");
        heightLabel = new Label("Height");
        heightLabel.getStyleClass().add("headingLabel");
        weightLabel = new Label("Weight");
        weightLabel.getStyleClass().add("headingLabel");

        // Build slider components
        ageSlider    = new Slider(10, 100, 25);
        heightSlider = new Slider(40, 90, 60);
        weightSlider = new Slider(50, 400, 150);

        ageSlider.setShowTickMarks(true);
        ageSlider.setMajorTickUnit(10);
        ageSlider.setShowTickLabels(true);
        ageSlider.setMinWidth(MIN_SLIDER_WIDTH);
        heightSlider.setShowTickMarks(true);
        heightSlider.setMajorTickUnit(10);
        heightSlider.setShowTickLabels(true);
        heightSlider.setMinWidth(MIN_SLIDER_WIDTH);
        weightSlider.setShowTickMarks(true);
        weightSlider.setMajorTickUnit(50);
        weightSlider.setShowTickLabels(true);
        weightSlider.setMinWidth(MIN_SLIDER_WIDTH);

        // Ready text fields
        ageField    = new Label("25");
        heightField = new Label("60");
        weightField = new Label("150");

        // Set up sliders to dynamically update label
        ageSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {   ageField.setText(Integer.toString(newVal.intValue()));  }
        });
        heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {   heightField.setText(Integer.toString(newVal.intValue()));  }
        });
        weightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {   weightField.setText(Integer.toString(newVal.intValue()));  }
        });
        // Set up layouts of three individual rows
        HBox ageBox    = new HBox(20,ageLabel,ageSlider,ageField);
        HBox heightBox = new HBox(20,heightLabel,heightSlider,heightField);
        HBox weightBox = new HBox(20,weightLabel,weightSlider,weightField);

        // Center slider boxes
        ageBox.setAlignment(Pos.CENTER);
        heightBox.setAlignment(Pos.CENTER);
        weightBox.setAlignment(Pos.CENTER);

        // Combine all components rows and set the overall pane
        VBox mainPane = new VBox(40,ageBox,heightBox,weightBox);
        this.getChildren().add(mainPane);
    }

    // Accessors for outside classes to access data from GUI
    public int getSuspectAge()
    {
        return (int)ageSlider.getValue();
    }
    public int getSuspectHeight()
    {
        return (int)heightSlider.getValue();
    }
    public int getSuspectWeight()
    {
        return (int)weightSlider.getValue();
    }
}
                
