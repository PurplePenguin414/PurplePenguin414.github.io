// Delta College - CST 283 - Klingler  
// This program manages a 2-D array of buttons to offer the user an interface
// for entry of a string one character at a time.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class CharPicker extends Application
{
   // Constants for 2-D array dimensions
   private final int NUM_ROWS = 4;
   private final int NUM_COLS = 13;
    
   // Applet GUI components
   Label numLabel, denomLabel;
   TextField stringField;
   Button buttonGrid[][];
   Button transmitButton, clearButton;
   GridPane charGrid;
   String messageString;
   
   String buttonChars[][]
        = {{"A","B","C","D","E","F","G","H","I","J","K","L","M"},
           {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"},
           {"!", "@", "#", "$", "%", "^", "&","*", "(",")", "-", "=","+"},
           {"0","1","2","3","4","5","6","7","8","9","_","<==","SP"}
           };

   public static void main(String[] args)
   {
       // Launch the application.
       launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
       // Prepare hander for all buttons
       CharButtonHandler clickHandler = new CharButtonHandler();

       // Build array of character buttons.
       charGrid     = new GridPane();
       buttonGrid = new Button[NUM_ROWS][NUM_COLS];
       for (int i = 0; i < NUM_ROWS; i++)
       {
          for (int j = 0; j < NUM_COLS; j++)
          {
              // Set up a button and add to grid.  Set preferred button size.
              // Associate each button individually to listener.
              buttonGrid[i][j] = new Button(buttonChars[i][j]);
              buttonGrid[i][j].setPrefSize(70,35);
              charGrid.add(buttonGrid[i][j],j,i);
              buttonGrid[i][j].setOnAction (clickHandler);
          }
       }
 
       // Ready string text field panel
       stringField = new TextField();
       stringField.setFont(Font.font("SansSerif", FontWeight.BOLD, 64));
       HBox stringPanel = new HBox(stringField);
       stringPanel.setAlignment(Pos.CENTER);
 
       // Ready bottom action button panel
       clearButton    = new Button("Clear");
       clearButton.setOnAction (clickHandler);
       transmitButton = new Button("Send");
       transmitButton.setOnAction (clickHandler);
       HBox buttonBox  = new HBox(20,clearButton,transmitButton);
       buttonBox.setAlignment(Pos.CENTER);
      
       // Assemble GUI
       VBox mainPane = new VBox(20,charGrid,stringPanel,buttonBox);

       // Set application window attributes
       Scene scene = new Scene(mainPane, 900,500);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Character Picker");
       primaryStage.show();

       // Set up message string
       messageString =  new String("");
       stringField.setText(messageString + "_");
   }

    class CharButtonHandler implements EventHandler<ActionEvent> {
        // When Submit button clicked, display message to simulate submitting
        // donut order to be packaged
        @Override
        public void handle(ActionEvent event)
        {
            // Scan array of character buttons.  Match button pressed and concatenate to growing
            // string.  If a space or backspace, react accordingly
            for (int i = 0; i < NUM_ROWS; i++)
            {
                for (int j = 0; j < NUM_COLS; j++)
                {
                    // Check for backspace event, then blank event, and finally
                    // the addition of a new character
                    if (event.getSource() == buttonGrid[i][j])
                    {
                        if (buttonChars[i][j].equals("<=="))        // Backspace
                        {
                            if (messageString.length() > 0)
                                messageString = messageString.substring(0, messageString.length() - 1);
                        }
                        else if (buttonChars[i][j].equals("SP"))    // Add a space
                            messageString += " ";
                        else
                            messageString += buttonChars[i][j];     // Otherwise, add character
                    }
                }
            }

            // Manage clearing message and sending message
            if (event.getSource() == clearButton)
                messageString = "";

            // Handle transmit button.  Simulate with an alert box.  Then, clear message
            // for new input.
            if (event.getSource() == transmitButton)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("MESSAGE");
                alert.setContentText(messageString);
                alert.showAndWait();

                messageString = "";
            }

            // Update displayed message
            stringField.setText(messageString + "_");
        }
    }
}
