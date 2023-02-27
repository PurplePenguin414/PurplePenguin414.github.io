// Delta College - CST 283 - Klingler & Gaddis text
// This application demonstrates recursion using circle drawing.
// Radius is initialized and then reduced for each recursive call
// until a base case is reached.

import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ConcentricCircles extends Application
{
    final double SCENE_WIDTH      = 600.0;
    final double SCENE_HEIGHT     = 600.0;
    final double CIRCLE_CENTER_X  = 300.0;
    final double CIRCLE_CENTER_Y  = 300.0;

    final int    NUMBER_CIRCLES   = 10;
    final double INITIAL_RADIUS   = 250;
    final double RADIUS_REDUCTION = 25;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Designate the primary drawing pane.
        Pane drawingPane = new Pane();

        // Initiate recursive call to draw concentric circles.
        drawCircles(drawingPane, NUMBER_CIRCLES, CIRCLE_CENTER_X, CIRCLE_CENTER_Y, INITIAL_RADIUS);

        // Create a Scene and display drawing
        Scene scene = new Scene(drawingPane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Concentric Circles");
        primaryStage.show();
    }

     // The drawCircles method draws concentric circles.
     // Paramaters included:
     // * Drawing pane
     // * Circle counter utilized for recursive counting.
     // * Center and radius of circle
    private void drawCircles(Pane pane, int n, double centerX, double centerY, double radius)
    {
        if (n > 0)    // Base case - count toward zero fro start count
        {
            Circle aCircle = new Circle(centerX, centerY, radius);
            aCircle.setStroke(Color.MAGENTA);
            pane.getChildren().add(aCircle);

            // Recursive call with reduced radius
            drawCircles(pane, n - 1, centerX, centerY, radius - RADIUS_REDUCTION);
        }
    }
}




