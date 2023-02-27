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

class DoMath extends Application
{
   // Declare objects
   private Label operandLabel1, operandLabel2;
   private TextField operand1, operand2;
   private Button addButton, subButton, MultiButton, DivideButton, ModButton;
   
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
      subButton = new Button("subtract");
      MultiButton = new Button("mutiply");
      DivideButton = new Button("divide");
      ModButton = new Button("remainder");
      
      // Register the event handler.
      addButton.setOnAction(new ButtonClickHandler());
      subButton.setOnAction(new ButtonClickHandler());
      MultiButton.setOnAction(new ButtonClickHandler());
      DivideButton.setOnAction(new ButtonClickHandler());
      ModButton.setOnAction(new ButtonClickHandler());
      
      // Build formatting GUI
      HBox op1Box  = new HBox(10, operandLabel1, operand1);
      op1Box.setAlignment(Pos.CENTER);
      HBox op2Box  = new HBox(10, operandLabel2, operand2);
      op2Box.setAlignment(Pos.CENTER);
      VBox mainBox = new VBox(10,op1Box,op2Box,addButton);
      mainBox.setAlignment(Pos.CENTER);
      VBox mainBox1= new VBox(10,subButton,MultiButton, DivideButton, ModButton);
      mainBox1.setAlignment(Pos.CENTER);

      
      // Set up overall scene
      Scene scene = new Scene(mainBox, 600, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("calculator");
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
         int sub = opt1 - op2;
         int mult = op1 * op2;
         int div= op1 / op2;
         int mod = op1 % op2;

         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Math Machine");
         alert.setHeaderText("Solution: " + Integer.toString(op1) + " + " + Integer.toString(op2));
         alert.setContentText(Integer.toString(sum,sub, mult, div, mod));

         alert.showAndWait();
      }
   }
}