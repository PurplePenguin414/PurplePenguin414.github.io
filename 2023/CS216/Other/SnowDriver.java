// Delta College - CST 283 - Gibbs  
// This program allows the user to enter a route to be plowed and perform adding it to the opject to create a log


import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SnowDriver extends Application
{
   // Declare GUI components
   Label routeLabel, milesLabel, logLabel;
   TextField routeName, milesField;
   Button update,show,clear;
   TextArea dataArea;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      
      // Set up info label and add to a container
      logLabel = new Label("Miles Log");
      HBox labelBox = new HBox(logLabel);
      labelBox.setAlignment(Pos.CENTER);

      // Initialize handler for buttons
      ButtonClickHandler buttonHandler = new ButtonClickHandler();

      //  text fields and labels.  Initialize to default value
      // of fraction object.
      routeLabel = new Label( "Route Name:" );
      routeName = new TextField();
      routeName.setText(SnowPlowLog.getName());
      milesLabel = new Label( "Miles:" );
      milesField = new TextField();
      milesField.setText(Integer.toString(SnowPlowLog.getMiles()));

      // Button to update fraction.  Associate with listener
      update =  new Button("Update");
      update.setOnAction(buttonHandler);
      
      // Add text area and set font
      dataArea = new TextArea();
      dataArea.setFont(Font.font("Monospaced", FontWeight.NORMAL, 20));


      // Add buttons to:  Reciprocate, Convert to Decimal, Reduce
      show = new Button( "show" );
      show.setOnAction(buttonHandler);
      clear = new Button( "clear" );
      clear.setOnAction(buttonHandler);

      // Build horizontal box container for buttons
      HBox  buttonControls = new HBox(15,update,show,clear);
      buttonControls.setAlignment(Pos.CENTER);

      // Combine all horizontal box containers in a primary vertical box.
      VBox mainBox = new VBox(20,dataArea,buttonControls);
      mainBox.setAlignment(Pos.CENTER);

      // Set up overall scene
      Scene scene = new Scene(mainBox, 500, 400);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Log Summary");
      primaryStage.show();

   }

   // Handle button click event.  Determine which button was clicked and react
   // accordingly by adjusting fraction object and interface display.
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      
      @Override
      public void handle(ActionEvent event)
      {
         // Handle UPDATE button click.  Collect values in text fields.  Update fraction object.
         // Catch any number format exception with an alert.
         if (event.getSource() == update)
         {
            try
            {
               SnowPlowLog.setName(name.getText());
               SnowPlowLog.setMiles(Integer.parseInt(miles.getText()));
               SnowPlowLog.update();
            }
            catch (NumberFormatException e)
            {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Input Error.");
               alert.setContentText("Please check validity");
               alert.showAndWait();
            }
            
         }

         // Handle show button click.
         if (event.getSource() == show)
         {
            SnowPlowLog.show();
         }
         
         // Handle clear button click.
         if (event.getSource() == clear)
         {
            SnowPlowLog.clear();
         }

      }
   }
}
