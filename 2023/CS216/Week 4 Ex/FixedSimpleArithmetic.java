// Delta College - CST 283 - Klingler
// This application provides a simple integer arithmetic calculator.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
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

   private final int WINDOW_WIDTH = 700;
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

      Pane mainLayout = new Pane();   // Primary pane

      // Position operation input labels/text fields and add to form
      operandLabel1.setLayoutX(40);
      operandLabel1.setLayoutY(25);
      operand1.setLayoutX(150);
      operand1.setLayoutY(20);
      operandLabel2.setLayoutX(340);
      operandLabel2.setLayoutY(25);
      operand2.setLayoutX(450);
      operand2.setLayoutY(20);
      mainLayout.getChildren().addAll(operandLabel1,operand1,operandLabel2,operand2);

      // Position all operation components precisely and add to form
      addChoice.setLayoutX(100);
      addChoice.setLayoutY(80);
      subtractChoice.setLayoutX(200);
      subtractChoice.setLayoutY(80);
      multiplyChoice.setLayoutX(300);
      multiplyChoice.setLayoutY(80);
      divideChoice.setLayoutX(400);
      divideChoice.setLayoutY(80);
      modulusChoice.setLayoutX(500);
      modulusChoice.setLayoutY(80);
      mainLayout.getChildren().addAll(addChoice,subtractChoice,multiplyChoice,divideChoice,modulusChoice);

      // Position button and add to form
      calcButton.setLayoutX(300);
      calcButton.setLayoutY(180);
      mainLayout.getChildren().add(calcButton);

      // Set up overall scene and attributes
      Scene scene = new Scene(mainLayout, WINDOW_WIDTH, WINDOW_HEIGHT );
      primaryStage.setResizable(false);
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

