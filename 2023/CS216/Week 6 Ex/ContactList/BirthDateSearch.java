// Delta College - CST 283 - Klingler
// This application builds one contact list object and then searches it to
// determine if any birthdays fall on this date.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BirthDateSearch extends Application
{
   // Class wide component declarations
   private ComboBox monthList, dayList;
   private Label monthLabel, dayLabel;
   private Button goButton;
   
   private final String months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                                    "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
   ContactList allContacts;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      allContacts = new ContactList();    // Create contact list object

      // Initialize month and date drop boxes
      String days[] = new String[31];       // Generate day array
      for (int i = 0; i < 31; i++)
         days[i] = String.format("%02d", (i + 1));

      // Initialize GUI objects
      monthLabel = new Label("Month");
      monthList = new ComboBox();
      monthList.getItems().addAll(months);
      dayLabel = new Label("Day");
      dayList = new ComboBox();
      dayList.getItems().addAll(days);

      // Add commponents to horizontal container
      HBox topRow = new HBox(15,monthLabel, monthList, dayLabel, dayList);
      topRow.setAlignment(Pos.CENTER);

      // Initialize button and its label
      goButton = new Button("Go");
      HBox bottomRow = new HBox(goButton);
      bottomRow.setAlignment(Pos.CENTER);

      // Register event handler for button
      ButtonClickHandler handler = new ButtonClickHandler();
      goButton.setOnAction(handler);

      // Set up overall scene
      VBox mainLayout = new VBox(25,topRow,bottomRow);
      Scene scene = new Scene(mainLayout, 300, 200);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Contact List - Birthday Check");
      primaryStage.show();

   } // end constructor ButtonTest

   // Private inner class for event handling
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // If user clicks button collect the birthday info and search
         if (event.getSource() == goButton)
         {
            SingleSelectionModel monthSelection = monthList.getSelectionModel();
            int month = monthSelection.getSelectedIndex() + 1;
            SingleSelectionModel daySelection = dayList.getSelectionModel();
            int day = daySelection.getSelectedIndex() + 1;

            // Search for birthdays matching this date.
            String outputString = allContacts.searchContactsByBirthDate(month, day);

            // Process results of search
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Birthdays on " + months[month-1] + " " + day);
            alert.setTitle("Friend Birthday Search");

            if (outputString.equals(""))      // Handle no birthdays found
            {
               alert.setContentText("No birthdays found.");
            }
            else     // Display contact data via new window
            {
               alert.setContentText(outputString);

               // Add font formatting to alert information area
               DialogPane dialogPane = alert.getDialogPane();
               dialogPane.getStylesheets().add(
                       getClass().getResource("dialogFormatting.css").toExternalForm());
               dialogPane.getStyleClass().add("myDialog");
            }

            alert.showAndWait();    // Display alert and wait for user acknowledgement
         }

      }
   }
}
