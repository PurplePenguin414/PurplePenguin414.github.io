// Delta College - CST 183 - Klingler
// This application demonstrates a basic Java event-driven application with
// a user interface that allows two numbers to be entered.  It then performs
// arithmetic on the numbers,.

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

public class DoMath extends Application
{
   // Declare objects
   private Label operandLabel1, operandLabel2;
   private TextField operand1, operand2;
   private Button addButton,substractButton,multiplyButton,divideButton,modulusButton;
   private Button clearButton,quitButton;
   
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
      
      // Create buttons for operations
      addButton       = new Button("Add");
      substractButton = new Button("Subtract");
      multiplyButton  = new Button("Multiply");
      divideButton    = new Button("Divide");
      modulusButton   = new Button("Modulus");
      
      // Register the event handler.
      addButton.setOnAction(new ButtonClickHandler());
      substractButton.setOnAction(new ButtonClickHandler());
      multiplyButton.setOnAction(new ButtonClickHandler());
      divideButton.setOnAction(new ButtonClickHandler());
      modulusButton.setOnAction(new ButtonClickHandler());

      // Set up clear and quit buttons and associated actions.
      clearButton = new Button("Clear");
      clearButton.setOnAction(event ->
      {
         operand1.setText("");
         operand2.setText("");
      });
      quitButton  = new Button("Quit");
      quitButton.setOnAction(event ->
      {
         System.exit(0);
      });
      
      // Build formatting GUI
      HBox op1Box  = new HBox(10, operandLabel1, operand1);
      op1Box.setAlignment(Pos.CENTER);
      HBox op2Box  = new HBox(10, operandLabel2, operand2);
      op2Box.setAlignment(Pos.CENTER);
      HBox buttonBox = new HBox(5,addButton,substractButton,multiplyButton,divideButton,modulusButton);
      buttonBox.setAlignment(Pos.CENTER);
      HBox controlButtons = new HBox(10,clearButton,quitButton);
      controlButtons.setAlignment(Pos.CENTER);
      VBox mainBox = new VBox(20,op1Box,op2Box,buttonBox,controlButtons);
      mainBox.setAlignment(Pos.CENTER);
      
      // Set up overall scene
      Scene scene = new Scene(mainBox, 600, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Math Machine");
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
         int solution = 0;
         String operator = " ";

         // Handle operator buttons
         if (event.getSource() == addButton)
         {
            solution = op1 + op2;
            operator = " + ";
         }
         if (event.getSource() == substractButton)
         {
            solution = op1 - op2;
            operator = " - ";
         }
         if (event.getSource() == multiplyButton)
         {
            solution = op1 * op2;
            operator = " * ";
         }
         if (event.getSource() == divideButton)
         {
            solution = op1 / op2;
            operator = " / ";
         }
         if (event.getSource() == modulusButton)
         {
            solution = op1 % op2;
            operator = " % ";
         }

         // Display output
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Math Machine");
         alert.setHeaderText("Solution: " + Integer.toString(op1) + operator + Integer.toString(op2));
         alert.setContentText(Integer.toString(solution));

         alert.showAndWait();
      }
   }
}