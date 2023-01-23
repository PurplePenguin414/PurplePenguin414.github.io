// This application displays academic data pulled from an external file.
// It allows various sorting patterns for better analysis.

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;

public class StudentSort extends Application
{
   private Label sortLabel;
   private TextArea dataArea;

   // Buttons for sorting choices
   private Button sortNameAsc;
   private Button sortGPADesc;
   private Button sortGradeAsc;
   private Button sortIDAsc;

   // Parallel data arrays
   private String name[];
   private int    ID[];
   private char   grade[];
   private double gpa[];

   GradeDB studentDatabase;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Set up info label and add to a container
      sortLabel = new Label("Sort by ...");
      HBox labelBox = new HBox(sortLabel);
      labelBox.setAlignment(Pos.CENTER);

      // Instantiate buttons and combine into horizontal box
      sortIDAsc    = new Button("ID");
      sortNameAsc  = new Button("Name");
      sortGPADesc  = new Button("GPA");
      sortGradeAsc = new Button("Grade");
      HBox buttonSet = new HBox(10,sortIDAsc,sortNameAsc,sortGPADesc,sortGradeAsc);
      buttonSet.setAlignment(Pos.CENTER);

      // Combine label and buttons set into one container
      VBox bottomBox = new VBox(20,labelBox,buttonSet);

      // Associate buttons to listener
      ButtonClickHandler eventManager = new ButtonClickHandler();
      sortIDAsc.setOnAction( eventManager );
      sortNameAsc.setOnAction( eventManager );
      sortGPADesc.setOnAction( eventManager );
      sortGradeAsc.setOnAction( eventManager );

      // Add text area and set font
      dataArea = new TextArea();
      dataArea.setFont(Font.font("Monospaced", FontWeight.NORMAL, 20));

      // Create a BorderPane with a node in the center.
      // Add the buttons to the BorderPane regions
      BorderPane mainGUIpane = new BorderPane();
      mainGUIpane.setBottom(bottomBox);
      mainGUIpane.setCenter(dataArea);

      // Set up overall scene
      Scene scene = new Scene(mainGUIpane, 500, 400);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Student Summary");
      primaryStage.show();

      // Instantiate student data object
      studentDatabase = new GradeDB();
   }

   // -------------------------------------------------------------
   // Private inner class for event handling
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // If user clicks button, grab text currently stored
         // in text field and display it in a dialog
         if ( event.getSource() == sortIDAsc )
            studentDatabase.sortIDAsc();
         if ( event.getSource() == sortNameAsc )
            studentDatabase.sortNameAsc();
         if ( event.getSource() == sortGradeAsc )
            studentDatabase.sortGradeAsc();
         if ( event.getSource() == sortGPADesc )
            studentDatabase.sortGPADesc();

         // Write updated data to the text area
         dataArea.setText(studentDatabase.toString());
      }
   }
}
