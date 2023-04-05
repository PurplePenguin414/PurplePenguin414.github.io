import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RollerCoasterSimulation extends Application {

    private Slider arrivalFrequencySlider;
    private ToggleGroup numCarsGroup;
    private TextArea resultsTextArea;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the arrival frequency slider
        arrivalFrequencySlider = new Slider(10, 600, 10);
        arrivalFrequencySlider.setShowTickLabels(true);
        arrivalFrequencySlider.setShowTickMarks(true);
        arrivalFrequencySlider.setMajorTickUnit(100);
        arrivalFrequencySlider.setMinorTickCount(5);

        // Create the radio buttons to select the number of cars
        numCarsGroup = new ToggleGroup();
        RadioButton twelveCarsRadio = new RadioButton("12");
        twelveCarsRadio.setToggleGroup(numCarsGroup);
        twelveCarsRadio.setSelected(true);
        RadioButton twentyFourCarsRadio = new RadioButton("24");
        twentyFourCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton thirtySixCarsRadio = new RadioButton("36");
        thirtySixCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton fortyEightCarsRadio = new RadioButton("48");
        fortyEightCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton sixtyCarsRadio = new RadioButton("60");
        sixtyCarsRadio.setToggleGroup(numCarsGroup);

        // Create the text area to display the simulation results
        resultsTextArea = new TextArea();
        resultsTextArea.setEditable(false);

        // Create the start simulation button
        Button startSimulationButton = new Button("Start Simulation");
        startSimulationButton.setOnAction(event -> startSimulation());

        // Create the layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.addRow(0, new Label("Arrival Frequency"), arrivalFrequencySlider);
        layout.addRow(1, new Label("Number of Cars"), twelveCarsRadio, twentyFourCarsRadio, thirtySixCarsRadio,
                fortyEightCarsRadio, sixtyCarsRadio);
        layout.addRow(2, new Label("Results"), resultsTextArea);
        layout.addRow(3, startSimulationButton);

        // Create the scene
        Scene scene = new Scene(layout, 500, 500);

        // Set the stage title and show the scene
        primaryStage.setTitle("Roller Coaster Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startSimulation() {
        // TODO: Implement simulation logic here
    }

    public static void main(String[] args) {
        launch(args);
    }
}
