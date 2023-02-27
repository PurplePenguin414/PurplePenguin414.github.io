// Delta College - CST 183 - Klingler
// This application demonstrates a basic Java event-driven application with
// a user interface that allows two number to be entered.  When the button
// is pressed, the numbers are added and the sum displayed via an output dialog
// box.

// NOTE: Button listener interface implemented as an inner class

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Addition extends Application
{
   // Declare objects
   private Label operandLabel1, operandLabel2;
   private TextField operand1, operand2;
   private Button addButton;
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Create descriptive labels
      operandLabel1 = new Label("First Number");
      operandLabel2 = new Label("Second Number");
      
      // Initialize text field objects
      operand1 = new TextField();
      operand2 = new TextField();
      
      // Create a Button control
      addButton = new Button("Add");
      
      // Register the event handler.
      addButton.setOnAction(new ButtonClickHandler());
      
      // Build formatting GUI
      HBox op1Box  = new HBox(10, operandLabel1, operand1);
      op1Box.setAlignment(Pos.CENTER);
      HBox op2Box  = new HBox(10, operandLabel2, operand2);
      op2Box.setAlignment(Pos.CENTER);
      VBox mainBox = new VBox(10,op1Box,op2Box,addButton);
      mainBox.setAlignment(Pos.CENTER);
      
      // Set up overall scene
      Scene scene = new Scene(mainBox, 600, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Adding Machine");
      primaryStage.show();
   }
   
   // Handle button click event.  Collect values in operand text fields, add
   // them, and display them via a JavaFX Alert dialog box.
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         int op1 = Integer.parseInt(operand1.getText());
         int op2 = Integer.parseInt(operand2.getText());
         int sum = op1 + op2;

         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Adding Machine");
         alert.setHeaderText("The sum of " + Integer.toString(op1) + " and "+ Integer.toString(op2));
         alert.setContentText(Integer.toString(sum));

         alert.showAndWait();
      }
   }
}
