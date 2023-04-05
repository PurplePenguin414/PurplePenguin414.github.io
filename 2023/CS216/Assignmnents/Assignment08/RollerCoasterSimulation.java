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
        RadioButton twelveCarsRadio = new RadioButton("1");
        twelveCarsRadio.setToggleGroup(numCarsGroup);
        twelveCarsRadio.setSelected(true);
        RadioButton twentyFourCarsRadio = new RadioButton("2");
        twentyFourCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton thirtySixCarsRadio = new RadioButton("3");
        thirtySixCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton fortyEightCarsRadio = new RadioButton("4");
        fortyEightCarsRadio.setToggleGroup(numCarsGroup);
        RadioButton sixtyCarsRadio = new RadioButton("5");
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
        Scene scene = new Scene(layout, 800, 800);

        // Set the stage title and show the scene
        primaryStage.setTitle("Roller Coaster Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startSimulation() {
        // initialize variables and constants
        int rideTime = 240; // seconds
        int unloadTime = 20; // seconds
        int loadTime = 30; // seconds
        int carsToAdd = 12; // default value
        int maxCars = 60;
        int ridersPerCar = 12;
        int queueSize = 0;
        int totalTimeWaited = 0;
        int totalRiders = 0;
        int simulationTime = 0;
        int simulationDuration = 16 * 60 * 60; // 16 hours in seconds
        int rideCapacity = 0;
        int totalWaitTime =0;
        int avgWaitTime =0;
        double arrivalProb = 0.0;
        // get the selected number of cars to add from the GUI
        // and set the capacity of the ride accordingly
        // code to get selected number of cars from GUI
        RadioButton selectedRadioButton = (RadioButton) numCarsGroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        carsToAdd = Integer.parseInt(toogleGroupValue);
        rideCapacity = carsToAdd * ridersPerCar;
        // set up a timer to simulate the ride queue
        while (simulationTime < simulationDuration) {
            // calculate the probability that a rider arrives during this second
            arrivalProb = ((int)arrivalFrequencySlider.getValue()); // code to calculate probability based on rider arrival frequency from GUI
            
            queueSize = (simulationDuration/(int)arrivalProb);
            // a new rider has arrived            
        
            // check if there are riders waiting in the queue and the ride is available
            if (queueSize > 0 && queueSize >= rideCapacity) {
                // the ride is full and ready to go
                // remove riders from the queue and add them to the ride
                queueSize -= rideCapacity;
                totalRiders += rideCapacity;
        
                // calculate the time each rider waited in line
                totalWaitTime = ((queueSize + rideCapacity) * (loadTime + unloadTime));
                avgWaitTime += (totalWaitTime / totalRiders);
        
                // simulate the ride
                simulationTime += rideTime;
        
                // unload the riders from the ride
                simulationTime += unloadTime;
        
                // load new riders onto the ride
                simulationTime += rideCapacity * loadTime;
            } else {
                // the ride is not full or there are no riders waiting
                simulationTime++;
            }
        }
        
        // calculate the average rider wait time
        avgWaitTime = (totalTimeWaited / totalRiders);
        
        // display the simulation results in the GUI
        resultsTextArea.setText(
           resultsTextArea.getText() + "\nArrival: " + arrivalProb + "\nCapasity: " + 
           rideCapacity + "\nTotal Wait time: " + totalWaitTime + "\nTotal riders: " + totalRiders + "\nAvg Wait time: " + avgWaitTime + "\n _______________________"
        );
        // including the summary of simulation settings and average rider wait time
    }

    public static void main(String[] args) {
        launch(args);
    }
}
