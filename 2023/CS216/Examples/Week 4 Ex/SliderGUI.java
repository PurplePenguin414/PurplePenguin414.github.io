/**
 * Delta College - CST 283 - Klingler This class defines a user interface with a
 * dedicated drawing panel along with an interface panel containing slider
 * objects. The graphics drawn are dynamically changed as the user changes the
 * slider.
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SliderGUI extends Application
{
    private Slider widthChanger, heightChanger;

    private VBox sliderPane;      // Container for slider objects
    private Pane drawingPane;     // Dedicated drawing pane
    private BorderPane mainPane;  // Primary container for app components

    private Rectangle blueRectangle;
    private Ellipse redEllipse;

    private double RECT_UPLEFT_CORNER_PIX_X    = 50.0;
    private double RECT_UPLEFT_CORNER_PIX_Y    = 50.0;
    private double ELLIPSE_UPLEFT_CORNER_PIX_X = 50.0;
    private double ELLIPSE_UPLEFT_CORNER_PIX_Y = 250.0;
    private double INITIAL_SHAPE_DIMENSIONS    = 100.0;
    private double MAX_DIMENSION               = 200.0;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        widthChanger = new Slider();
        heightChanger = new Slider();

        // Set up Slider object to control width
        widthChanger = new Slider(0, MAX_DIMENSION, INITIAL_SHAPE_DIMENSIONS);
        widthChanger.setShowTickMarks(true);
        widthChanger.setMajorTickUnit(20);
        widthChanger.setShowTickLabels(true);
        heightChanger.setMaxWidth(300);     // Max pixels of slider bar

        // Set up Slider object to control height
        heightChanger = new Slider(0, MAX_DIMENSION, INITIAL_SHAPE_DIMENSIONS);
        heightChanger.setOrientation(Orientation.VERTICAL);
        heightChanger.setShowTickMarks(true);
        heightChanger.setMajorTickUnit(20);
        heightChanger.setShowTickLabels(true);
        heightChanger.setMinHeight(300);   // Min pixels of slider bar

        // Set action for movement of sliders.  Note that any change to either
        // slider will trigger a call to the drawing manager and update the images.
        widthChanger.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {
                 double newWidth = newVal.doubleValue();
                 blueRectangle.setWidth(newWidth);
                 redEllipse.setRadiusX(newWidth / 2.0);
                 redEllipse.setCenterX(ELLIPSE_UPLEFT_CORNER_PIX_X + newWidth / 2.0);
            }
        });

        heightChanger.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {
                double newHeight = newVal.doubleValue();
                blueRectangle.setHeight(newHeight);
                redEllipse.setRadiusY(newHeight / 2.0);
                redEllipse.setCenterY(ELLIPSE_UPLEFT_CORNER_PIX_Y + newHeight / 2.0);
            }
        });
        
        // Add sliders to container
        sliderPane = new VBox(40,widthChanger,heightChanger);

        // Create the drawing panel.  Note that the sliders are passed to
        // the panel to allow panel to react to change events
        drawingPane = new Pane();
        drawingPane.setMinWidth(400);

        blueRectangle = new Rectangle(RECT_UPLEFT_CORNER_PIX_X,RECT_UPLEFT_CORNER_PIX_Y,
                                      INITIAL_SHAPE_DIMENSIONS,INITIAL_SHAPE_DIMENSIONS);
        blueRectangle.setFill(Color.BLUE);
        redEllipse    = new Ellipse(ELLIPSE_UPLEFT_CORNER_PIX_X + INITIAL_SHAPE_DIMENSIONS / 2.0,
                                    ELLIPSE_UPLEFT_CORNER_PIX_Y + INITIAL_SHAPE_DIMENSIONS / 2.0,
                INITIAL_SHAPE_DIMENSIONS / 2.0,INITIAL_SHAPE_DIMENSIONS / 2.0);
        redEllipse.setFill(Color.RED);

        // Add intial shapes to drawing area
        drawingPane.getChildren().add(blueRectangle);
        drawingPane.getChildren().add(redEllipse);

        // Set up main pane with slider controls on right and drawing area left
        mainPane = new BorderPane();
        mainPane.setLeft(drawingPane);
        mainPane.setCenter(sliderPane);
        mainPane.setPadding(new Insets(10, 10, 10, 10));

        // Create a Scene and display it.
        Scene scene = new Scene(mainPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
