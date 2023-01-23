// Delta College - CST 283 - Klingler  
// This application demonstrates drawing lines, rectangles, and ovals,
// arcs, polygons, and text.

import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawGraphics extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Constants for the scene size
      final double SCENE_WIDTH = 500.0;
      final double SCENE_HEIGHT = 600.0;

      // Designate the primary drawing pane.  Drawing objects added
      // subsequently to this pane below.
      Pane pane = new Pane();

      Line redLine = new Line(5, 30, 400, 30);          // Line
      redLine.setStroke(Color.RED);
      pane.getChildren().add(redLine);

      Rectangle blueRect1 = new Rectangle (5, 40, 90, 60);    // Rectangles
      blueRect1.setStroke(Color.BLUE);
      blueRect1.setFill(Color.TRANSPARENT);
      pane.getChildren().add(blueRect1);
      Rectangle blueRect2 = new Rectangle (100, 40, 90, 60);
      blueRect2.setFill(Color.DARKGREEN);
      pane.getChildren().add(blueRect2);

      Circle aCircle = new Circle(225, 70, 30);           // Circle & ellipse
      aCircle.setFill(Color.MAGENTA);
      pane.getChildren().add(aCircle);

      Ellipse anEllipse = new Ellipse(320, 70, 60, 30);
      anEllipse.setStroke(Color.FIREBRICK);
      anEllipse.setFill(Color.TRANSPARENT);
      pane.getChildren().add(anEllipse);

      Line purpleLine = new Line(5, 110, 400, 110);          // Another line
      purpleLine.setStroke(Color.BLUEVIOLET);
      pane.getChildren().add(purpleLine);

      Text textObject1 = new Text( 5, 135,"Serif 16 point extra bold");    // Text objects
      textObject1.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 16));
      textObject1.setFill(Color.DARKTURQUOISE);
      pane.getChildren().add(textObject1);

      Text textObject2 = new Text( 5, 160,"Monospaced 24 point italic");    // Text objects
      textObject2.setFont(Font.font("Monospaced", FontPosture.ITALIC, 24));
      textObject2.setFill(Color.DARKORCHID);
      pane.getChildren().add(textObject2);

      Color myColor1 = Color.rgb(130, 90, 240);                       // Customer colors
      Text colorText1 = new Text(5,190,"Color:  R=130 G=90 B=240");
      colorText1.setFont(Font.font("Helvetica", FontWeight.MEDIUM,FontPosture.REGULAR, 20));
      colorText1.setFill(myColor1);
      pane.getChildren().add(colorText1);

      Polygon aPolygon                                                                // Polygons/polylines
              = new Polygon(20.0,220.0,40.0,250.0,50.0,210.0,90.0,280.0,20.0,280.0,15.0, 260.0);
      aPolygon.setFill(Color.TRANSPARENT);
      aPolygon.setStroke(Color.MISTYROSE);
      aPolygon.setStrokeWidth(5);
      pane.getChildren().add(aPolygon);

      double coordinates[] = {150.0, 220.0, 170.0, 270.0, 200.0, 240.0, 190.0, 230.0 };
      Polyline aPolyline = new Polyline(coordinates);
      aPolygon.setStroke(Color.TEAL);
      aPolygon.setStrokeWidth(4);
      pane.getChildren().add(aPolyline);
                                                                                      // Arcs
      Arc arc1 = new Arc(60, 400, 80, 80, 0, 110);
      arc1.setStroke(Color.DARKGRAY);
      arc1.setFill(Color.TRANSPARENT);
      arc1.setStrokeWidth(8);
      pane.getChildren().add(arc1);

      Arc arc2 = new Arc(250, 400, 80, 80, 0, -270);
      arc2.setStroke(Color.RED);
      arc2.setFill(Color.YELLOW);
      pane.getChildren().add(arc2);
      
      // Create a Scene and display drawing
      Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Drawing");
      primaryStage.show();
   }
}
