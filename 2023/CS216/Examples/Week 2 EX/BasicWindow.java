// Delta College - CST 283 - Klingler  
// This program opens an empty JavaFX application window.  

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BasicWindow extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch();
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      primaryStage.setTitle("A Simple JavaFX Window");
      primaryStage.show();
   }
}