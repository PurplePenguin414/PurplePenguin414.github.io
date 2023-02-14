// Delta College - CST 283 - Klingler  
// This appication demonstrates radio buttons by implementing
// an interface for a simple survey or quiz.  An external CSS file
// is used for component formatting.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class RadioButtonQuiz extends Application
{
   private RadioButton options[][];
   private Button submitButton;
   private ToggleGroup questions[];
   private Label questionLabels[];
   private int questionChoice[];
   private HBox titlePanel, buttonPanel;
   private GridPane optionsPanel;
   private Label title;
   private BorderPane mainLayout;

   private final int NUMBER_QUESTIONS = 6;
   private final int NUMBER_OPTIONS   = 6;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Design questions as a grid.
      optionsPanel = new GridPane();
      optionsPanel.setHgap(45);               // Horizontal gap between columns in pixels
      optionsPanel.setVgap(15);               // Vertical gap between rows
      optionsPanel.setAlignment(Pos.CENTER);  // Center entire grid pane container

      // Instantiate questions and question option objects
      options        = new RadioButton[NUMBER_QUESTIONS][NUMBER_OPTIONS];
      questions      = new ToggleGroup[NUMBER_QUESTIONS];
      questionLabels = new Label[NUMBER_QUESTIONS];
      questionChoice = new int[NUMBER_QUESTIONS];
      
      // Ready button handler - this handler will manage all buttons
      RadioButtonHandler optionHandler = new RadioButtonHandler();
      
      // Initiate loop to build grid of questions and associated question options
      // Allow all radio buttons to initialize to default unchecked state.  The
      // questionChoice[] array initialized to -1 to mark unchose.  Otherwise,
      // questionChoice[] stores the indes of the question chosen.
      for (int i = 0; i < NUMBER_QUESTIONS; i++)
      {
          questions[i] = new ToggleGroup();
          questionLabels[i] = new Label("Question " + (i+1));
          questionLabels[i].getStyleClass().add("questionLabel");          // Custom formatting from styles
          optionsPanel.add(questionLabels[i],0,i);
          questionChoice[i] = -1;        
          for (int j = 0; j < NUMBER_QUESTIONS; j++)
          {
             options[i][j] = new RadioButton(Integer.toString(j));
             optionsPanel.add( options[i][j],j+1,i);
             options[i][j].setToggleGroup(questions[i]);
             options[i][j].setOnAction( optionHandler );
          }
      }
      
      // Design title for top  
      titlePanel = new HBox();
      title = new Label("Survey Questions");
      title.getStyleClass().add("mainLabel");          // Custom formatting from styles
      titlePanel = new HBox(title);
      titlePanel.setAlignment(Pos.CENTER);
      
      // Design button panel for bottom
      submitButton = new Button("Submit");       // General formatting from styles
      SubmitButtonHandler buttonHandler = new SubmitButtonHandler();
      submitButton.setOnAction( buttonHandler );
      buttonPanel = new HBox(submitButton);
      buttonPanel.setAlignment(Pos.CENTER);

      // Organize main layout with primary containers
      mainLayout = new BorderPane();
      mainLayout.setTop(titlePanel);
      mainLayout.setCenter(optionsPanel);
      mainLayout.setBottom(buttonPanel);
      mainLayout.setPadding(new Insets(10, 10, 10, 10));

      // Set GUI Window attributes
      Scene scene = new Scene(mainLayout, 800, 400);
      primaryStage.setScene(scene);
      scene.getStylesheets().add("styles.css");
      primaryStage.setTitle("Survey");
      primaryStage.show();
   }

   // Private inner class for ItemListener event handling
   private class RadioButtonHandler implements EventHandler<ActionEvent>
   {
      // Respond to radio button events
      @Override
      public void handle(ActionEvent event)
      {
         for (int i = 0; i < NUMBER_QUESTIONS; i++)
         {
            questions[i] = new ToggleGroup();
            for (int j = 0; j < NUMBER_QUESTIONS; j++)
            {
               if (options[i][j].isSelected() )    
                   questionChoice[i] = j;    
            }
         }
      } 
   } 
   // Private inner class for ItemListener event handling
 //  private class SubmitButtonHandler implements ActionListener
//   {
   class SubmitButtonHandler implements EventHandler<ActionEvent>
   {
      // Respond to button click - calculate and display average of
      // all question responses at time of click.
      @Override
      public void handle(ActionEvent event)
      {
          double sum = 0;
          int zeroCount = 0;
          boolean allAnswered = true;    // Assume all radio buttons clicked

          for (int i = 0; i < NUMBER_QUESTIONS; i++)
          {
             if (questionChoice[i] > 0)
                 sum += questionChoice[i];
             else if (questionChoice[i] == 0)
                zeroCount++;
             else
                allAnswered = false;
          }

         System.out.println(zeroCount);

          // If all radio buttons have been answered, determine average of
          // question values and display
          if (allAnswered)
          {
             double average = sum / NUMBER_QUESTIONS;

             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Quiz Results");
             alert.setContentText("Average of answers: \n" +
                                   String.format("%5.2f", average) + "\n" +
                                   String.format("Number of zeros: %d", zeroCount) );
             alert.showAndWait();
          }
          else
          {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("WARNING");
             alert.setContentText("Please answer all questions");
             alert.showAndWait();
          }

      } 
   }
}
