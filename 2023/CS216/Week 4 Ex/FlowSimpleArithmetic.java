// Delta College - CST 283 - Klingler  
// This application provides a simple integer arithmetic calculator.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SimpleArithmetic extends Application
{
   // Class wide component declarations
   private TextField operand1;
   private TextField operand2;
   private Label operandLabel1;
   private Label operandLabel2;
   private Button calcButton;
   
   private RadioButton  addChoice;
   private RadioButton  subtractChoice;
   private RadioButton  multiplyChoice;
   private RadioButton  divideChoice;
   private RadioButton  modulusChoice;
   private ToggleGroup  operationGroup;
   
   private final int WINDOW_WIDTH = 600;
   private final int WINDOW_HEIGHT = 300;

   public static void main(String[] args) {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Initialize label objects
      operandLabel1 = new Label("First Number");
      operandLabel2 = new Label("Second Number");
      
      // Initialize text field objects
      operand1 = new TextField();
      operand2 = new TextField();
      
      // Add radio buttons and group - for operation choice
      // Set up behavior of buttons.
      addChoice      = new RadioButton("Add" );
      subtractChoice = new RadioButton("Subtract");
      multiplyChoice = new RadioButton("Multiply");
      divideChoice   = new RadioButton("Divide");
      modulusChoice  = new RadioButton("Mod");
      addChoice.setSelected(true);      // Make addition the default
      operationGroup = new ToggleGroup();
      addChoice.setToggleGroup(operationGroup);
      subtractChoice.setToggleGroup(operationGroup);
      multiplyChoice.setToggleGroup(operationGroup);
      divideChoice.setToggleGroup(operationGroup);
      modulusChoice.setToggleGroup(operationGroup);

      // Initialize button and its label. Register event handler for button
      calcButton = new Button("Calculate");
      CalcButtonClickHandler handler = new CalcButtonClickHandler();
      calcButton.setOnAction( handler );

      // Add commponents to container
      HBox firstNumBox = new HBox(10,operandLabel1,operand1);
      HBox secondNumBox = new HBox(10,operandLabel2,operand2);
      HBox numberBox = new HBox(30,firstNumBox,secondNumBox);
      numberBox.setAlignment(Pos.CENTER);
      HBox operationsBox = new HBox(20,addChoice,subtractChoice,multiplyChoice,divideChoice,modulusChoice);
      operationsBox.setAlignment(Pos.CENTER);
      HBox buttonBox = new HBox(calcButton);
      buttonBox.setAlignment(Pos.CENTER);
      VBox mainLayout = new VBox(20,numberBox,operationsBox,buttonBox);

      // Set up overall scene and attributes
      Scene scene = new Scene(mainLayout, WINDOW_WIDTH, WINDOW_HEIGHT );
      primaryStage.setScene(scene);
      primaryStage.setTitle("My Calculator");
      primaryStage.show();
   }

   // Inner class to handle button click and perform arithmetic operation.
   class CalcButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {

         // If user clicks button, grab text currently stored
         // in text field and display it in a dialog
         if ( event.getSource() == calcButton )
         {
            String outcome = "";
            int op1=0,op2=0;
            boolean inputOK = true;
            try
            {
               op1 = Integer.parseInt(operand1.getText());
               op2 = Integer.parseInt(operand2.getText());
            }
            catch (NumberFormatException e)
            {
               outcome = "Invalid Operand(s)";
               inputOK = false;
            }
            
            if (inputOK)
            {
               // Determine selected arithmetic result based on state of
               // radio button
               int result;

               if (addChoice.isSelected() == true)
                  outcome = op1 + " + " + op2 + " = " + (op1 + op2);
               if (subtractChoice.isSelected() == true)
                  outcome = op1 + " - " + op2 + " = " + (op1 - op2);
               if (multiplyChoice.isSelected() == true)
                  outcome = op1 + " * " + op2 + " = " + (op1 * op2);
               if (divideChoice.isSelected() == true)
                  if (op2 != 0)
                     outcome = op1 + " / " + op2 + " = " + (op1 / op2);
                  else
                     outcome = "Zero Divisor - Invalid Operation";
               if (modulusChoice.isSelected() == true)
                  if (op2 != 0)
                     outcome = op1 + " % " + op2 + " = " + (op1 % op2);
                  else
                     outcome = "Second Operand Zero - Invalid Operation";
            }
            
            // Display via alert box
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Arithmetic");
            alert.setHeaderText("Solution:");
            alert.setContentText(outcome);
            alert.showAndWait();
         }
      
      }
   }
} 

