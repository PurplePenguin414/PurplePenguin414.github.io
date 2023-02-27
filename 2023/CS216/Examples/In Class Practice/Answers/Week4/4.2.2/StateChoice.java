// Delta College - CST 283 - Klingler
// This example demonstrates a common method for selecting
// information from a drop-down menu.  It converts a user
// choice for a state code to the state name.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class StateChoice extends Application
{
   private ComboBox stateChoice;
   private Button convertStateButton;

   private String stateAbbrevs[] =
           {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
           "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
           "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
           "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
           "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

   private String stateNames[]   = {"NONE",
           "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut",
           "District of Columbia", "Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas",
           "Kentucky","Louisiana","Maine","Massachusetts","Maryland","Michigan","Minnesota",
           "Mississippi", "Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey",
           "New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon",
           "Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas",
           "Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming" };

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Ready drop-down list of state codes
      stateChoice = new ComboBox();
      stateChoice.getItems().addAll(stateAbbrevs);

      // Instantiate button.  Assign to listener method.
      convertStateButton =  new Button("Get State");
      convertStateButton.setOnAction(new ButtonClickHandler());

      // Configure GUI
      HBox mainLayout = new HBox(10,stateChoice,convertStateButton);
      Scene scene = new Scene(mainLayout, 400, 150);
      primaryStage.setScene(scene);
      primaryStage.setTitle("State Code Converter");
      primaryStage.show();
   }

   // Handle button click.  Action first checks if a state has been selected
   // (i.e. a non-zero index).  Then, it searches for and returns the state
   // name associated with the selected state code.
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // Access state name associated with selected index
         // Perform basic error check to be sure that a selection was made
         // (index zero will generate an error message)
         SingleSelectionModel selectionModel = stateChoice.getSelectionModel();
         int selectedIndex = selectionModel.getSelectedIndex();
         Alert alert;

         // Check for valid selection.  A -1 is returned for an immediate event
         // with no selection.  Otherwise, the first blank element is index zero.
         // Either triggers an error alert.
         if (selectedIndex == -1 || selectedIndex == 0)
         {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText(String.format("You must make a selection"));
         }
         else
         {
            String outputStr = "You selected: " + stateNames[ selectedIndex ];
            if (stateNames[ selectedIndex ].equals("Michigan"))
               outputStr += "\nThe Great Lakes State";

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("State Decoder");
            alert.setContentText(String.format(outputStr));
         }
         alert.showAndWait();
      }
   }
}

