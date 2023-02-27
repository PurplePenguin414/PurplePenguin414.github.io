// Delta College - CST 283 - Klingler  
// This application draws random circles of random colors.

import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;

public class RandomCircles extends Application
{
    final static int SCENE_WIDTH    = 1200;
    final static int SCENE_HEIGHT   = 800;
    final static int MIN_RADIUS     = 20;
    final static int MAX_RADIUS     = 50;
    final static int NUMBER_CIRCLES = 40;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Designate the primary drawing pane.  Drawing objects added
        // subsequently to this pane below.
        Pane pane = new Pane();

        Random randomNumbers = new Random();

        // Variables for random elements
        int redComponent, greenComponent, blueComponent;
        int xPix, yPix, radius;

        // Repeat circle process by given total count
        for (int i = 1; i <= NUMBER_CIRCLES; i++)
        {
            // Random color
            redComponent   = randomNumbers.nextInt(256);
            greenComponent = randomNumbers.nextInt(256);
            blueComponent  = randomNumbers.nextInt(256);

            // Random radius between set min and max
            radius = randomNumbers.nextInt((MAX_RADIUS - MIN_RADIUS) + 1) + MIN_RADIUS;

            // Random position
            xPix = randomNumbers.nextInt(SCENE_WIDTH);
            yPix = randomNumbers.nextInt(SCENE_HEIGHT);

            Circle newCircle = new Circle(xPix, yPix, radius);
            newCircle.setFill(Color.rgb(redComponent, greenComponent, blueComponent));
            pane.getChildren().add(newCircle);
        }

        // Create a Scene and display drawing
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Circles");
        primaryStage.show();
    }
}


