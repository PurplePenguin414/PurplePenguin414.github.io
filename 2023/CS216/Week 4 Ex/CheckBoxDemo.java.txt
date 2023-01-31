// Delta College - CST 283 - Klingler  
// This application demonstrates use of check boxes for management
// of "on/off" decisions.  A variety of management techniques are
// included for each set of three buttons.

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class CheckBoxDemo extends Application
{
   private Label dataLabel;
   private CheckBox decision1,decision2,decision3;
   private CheckBox decisionA,decisionB,decisionC;
   private CheckBox decisionX,decisionY,decisionZ;
   private Button goButton;
   private boolean status1, status2, status3;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   // Prepare GUI.
   @Override
   public void start(Stage primaryStage)
   {
      // Create a set of 3 checkbox objects
      decisionA = new CheckBox( "A" );
      decisionB = new CheckBox( "B" );
      decisionC = new CheckBox( "C" );
      HBox abcBoxes = new HBox(25,decisionA,decisionB,decisionC);
      abcBoxes.setAlignment(Pos.CENTER);

      // Register listeners for JCheckBoxes.  Any change of state for a checkbox
      // will trigger an action event.
      CheckBoxHandler theHandler = new CheckBoxHandler();
      decisionA.setOnAction( theHandler );
      decisionB.setOnAction( theHandler );
      decisionC.setOnAction( theHandler );

      // Create checkbox objects - One set to "checked"
      decision1 = new CheckBox( "One" );
      decision2 = new CheckBox( "Two" );
      decision3 = new CheckBox( "Three" );
      decision3.setSelected(true);
      HBox numberBoxes = new HBox(25,decision1,decision2,decision3);
      numberBoxes.setAlignment(Pos.CENTER);

      // Set up boolean flags to mirror check box state for 1,2,3 boxes
      status1 = false;
      status2 = false;
      status3 = true;

      // Manage checkbox objects with use of booleans.  Any change of state will
      // trigger examination of boolean values that are matched and assigned
      // to the checkbox state.
      decision1.setOnAction(event ->
      {
         if (decision1.isSelected())
            status1 = true;
         else
            status1 = false;
      });

      decision2.setOnAction(event ->
      {
         if (decision2.isSelected())
            status2 = true;
         else
            status2 = false;
      });

      decision3.setOnAction(event ->
      {
         if (decision3.isSelected())
            status3 = true;
         else
            status3 = false;
      });


      decisionX = new CheckBox( "X" );
      decisionY = new CheckBox( "Y" );
      decisionZ = new CheckBox( "Z" );
      HBox xyzBoxes = new HBox(25,decisionX,decisionY,decisionZ);
      xyzBoxes.setAlignment(Pos.CENTER);
       
      // Set up JButton and register with handler
      goButton = new Button( "Go" );
      HBox buttonBox = new HBox(goButton);
      ButtonHandler buttonHandler = new ButtonHandler();
      goButton.setOnAction( buttonHandler );
      buttonBox.setAlignment(Pos.CENTER);
       
      // Set up and add info text field to GUI 
      dataLabel = new Label();
      HBox labelBox = new HBox(dataLabel);
      labelBox.setAlignment(Pos.CENTER);

      VBox mainLayout = new VBox(20,abcBoxes,labelBox,numberBoxes,xyzBoxes,buttonBox);

      // Set up overall scene
      Scene scene = new Scene(mainLayout, 300, 400);
      primaryStage.setScene(scene);
      primaryStage.setTitle("CheckBox Demo");
      primaryStage.show();
   }

   // ------------------------------------------------------
   // This handler will update a label for any checkbox event.
   class CheckBoxHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // Ready message for label
         String message = "Checked: ";

         if (decisionA.isSelected())
            message += " A ";
         if (decisionB.isSelected())
            message += " B ";
         if (decisionC.isSelected())
            message += " C ";

         dataLabel.setText(message);
      }

   }

   // ------------------------------------------------------
   // This method will fire for a button click and query the states
   // of two sets of three checkboxes.  Checked boxes are then listed
   // in an alert box.  One set of checkboxes are mirrored by boolean
   // values are the others are queried for their selection state.
   class ButtonHandler implements EventHandler<ActionEvent>
   {
      // Respond to button event
      @Override
      public void handle(ActionEvent event)
      { 
          // Build output message
          String message = "Checked: ";

         // Ready message for dialog box
         if (status1 == true)
            message += " One ";
         if (status2 == true)
            message += " Two ";
         if (status3 == true)
            message += " Three";
          
          // Ready message for dialog box
          if (decisionX.isSelected())
             message += " X ";
          if (decisionY.isSelected())
             message += " Y ";
          if (decisionZ.isSelected())
             message += " Z ";
          
          // Show dialog with contents of text field and state of
          // checkboxes
         Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
         aboutAlert.setTitle("Checkbox States");
         aboutAlert.setContentText(message);
         aboutAlert.showAndWait();
      }
   }
}
