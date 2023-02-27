// Delta College - CST 283 - Klingler  
// This application demonstrates use of check boxes for management
// of "on/off" decisions.  It simulates descisions based on requests
// for seasonal travel documents.

import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class CheckBoxTest extends Application
{
   private TextField nameField;
   private CheckBox spring, summer, fall, winter;
   private Button goButton;
   
   private boolean springState,summerState,fallState,winterState;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   // Prepare GUI.
   @Override
   public void start(Stage primaryStage)
   {
      // Set up text field
      nameField = new TextField( "Enter a name here" );
      HBox nameBox = new HBox( nameField );
      nameBox.setAlignment(Pos.CENTER);

      // Create checkbox objects
      spring = new CheckBox( "Spring" );
      summer = new CheckBox( "Summer" );
      fall   = new CheckBox( "Fall" );
      winter = new CheckBox( "Winter" );
      HBox checkBoxBox = new HBox( 20,spring, summer, fall, winter );
      checkBoxBox.setAlignment(Pos.CENTER);

      // Initialize all check box variables to default "unchecked"
      springState = false;
      summerState  = false;
      fallState = false;
      winterState = false;

      // Set up button
      goButton = new Button( "Evaluate" );
      HBox buttonBox = new HBox( goButton );
      buttonBox.setAlignment(Pos.CENTER);

      // register listeners for JCheckBoxes
      CheckBoxHandler theHandler = new CheckBoxHandler();
      spring.setOnAction( theHandler );
      summer.setOnAction( theHandler );
      fall.setOnAction( theHandler );
      winter.setOnAction( theHandler );
      
      // register listeners for  JButton
      ButtonHandler theButtonHandler = new ButtonHandler();
      goButton.setOnAction( theButtonHandler );

      // Combine containers and set up overall scene
      VBox mainLayout = new VBox(30,nameBox,checkBoxBox,buttonBox);
      Scene scene = new Scene(mainLayout, 500, 140);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Travel Brochures");
      primaryStage.show();
   }

   // Private inner class for checkbox event handling
   private class CheckBoxHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         if (spring.isSelected() )
            springState = true;
         else
            springState = false;
               
         if (summer.isSelected() )
            summerState = true;
         else
            summerState = false;
               
         if (fall.isSelected() )
            fallState = true;
         else
            fallState = false;

         if (winter.isSelected() )
            winterState = true;
         else
            winterState = false;
       }

   } // end private inner class CheckBoxHandler

   // Private inner class for button event handling
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         String message = nameField.getText() + ", ";

         // Count number boxes checked
         int numChecked = 0;
         if (springState)
            numChecked++;
         if (summerState)
            numChecked++;
         if (fallState)
            numChecked++;
         if (winterState)
            numChecked++;

         if (numChecked == 0)
            message += "please return and check at least one box";
         else if (numChecked > 1)
            message += "you will be mailed the annual travel guide";
         else
         {
            String seasonPicked = "";

            if (springState)
               seasonPicked = "Spring";
            if (summerState)
               seasonPicked = "Summer";
            if (fallState)
               seasonPicked = "Fall";
            if (winterState)
               seasonPicked = "Winter";
            message += "the travel guide for " + seasonPicked +
                    " will be mailed to you shortly";
         }

         // Show alert with contents of text field and state of checkboxes.
         Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
         aboutAlert.setTitle("Outcome");
         aboutAlert.setContentText(message);
         aboutAlert.showAndWait();
      }
   }
}