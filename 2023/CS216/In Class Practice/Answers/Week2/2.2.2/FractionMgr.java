// Delta College - CST 283 - Klingler  
// This program allows the user to enter a fraction and perform
// various manipulations to the fraction.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.Optional;

public class FractionMgr extends Application
{
   // Declare GUI components
   Label numLabel, denomLabel, statusLabel;
   TextField numerator, denominator;
   Button update,reciprocate,decimal,reduce,elevate;
   Rational theFraction;

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Instantiate background fraction object
      theFraction = new Rational();

      // Initialize handler for buttons
      ButtonClickHandler buttonHandler = new ButtonClickHandler();

      // Numerator & denominator text fields and labels.  Initialize to default value
      // of fraction object.
      numLabel = new Label( "Numerator" );
      numerator = new TextField();
      numerator.setText(Integer.toString(theFraction.getNumerator()));
      denomLabel = new Label( "Denominator" );
      denominator = new TextField();
      denominator.setText(Integer.toString(theFraction.getDenominator()));

      // Button to update fraction.  Associate with listener
      update =  new Button("Update Fraction");
      update.setOnAction(buttonHandler);

      // Build horizontal container for numberator/denominator
      HBox numeratorPart   = new HBox(5,numLabel,numerator);
      HBox denominatorPart = new HBox(5,denomLabel,denominator);
      HBox fractionParts   = new HBox(20,numeratorPart,denominatorPart,update);
      fractionParts.setAlignment(Pos.CENTER);

      // Add buttons to:  Reciprocate, Convert to Decimal, Reduce
      reciprocate = new Button( "Reciprocate" );
      reciprocate.setOnAction(buttonHandler);
      decimal = new Button( "To Decimal" );
      decimal.setOnAction(buttonHandler);
      reduce = new Button( "Reduce" );
      reduce.setOnAction(buttonHandler);
      elevate = new Button( "Elevate" );
      elevate.setOnAction(buttonHandler);

      // Build horizontal box container for buttons
      HBox  buttonControls = new HBox(15,reciprocate,decimal,reduce,elevate);
      buttonControls.setAlignment(Pos.CENTER);

      // Create label with current fraction status.  Associate it to its style.
      statusLabel = new Label(theFraction.toString());
      statusLabel.getStyleClass().add("displayLabel");

      // Combine all horizontal box containers in a primary vertical box.
      VBox mainBox = new VBox(20,fractionParts,buttonControls,statusLabel);
      mainBox.setAlignment(Pos.CENTER);

      // Set up overall scene
      Scene scene = new Scene(mainBox, 900, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Fraction Manager");
      scene.getStylesheets().add("style.css");
      primaryStage.show();
   }

   // Handle button click event.  Determine which button was clicked and react
   // accordingly by adjusting fraction object and interface display.
   class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // Handle UPDATE button click.  Collect values in text fields.  Update fraction object.
         // Catch any number format exception with an alert.
         if (event.getSource() == update)
         {
            try
            {
               theFraction.setNumerator(Integer.parseInt(numerator.getText()));
               theFraction.setDenominator(Integer.parseInt(denominator.getText()));
               statusLabel.setText(theFraction.toString());
            }
            catch (NumberFormatException e)
            {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Input Error.");
               alert.setContentText("Please check validity for fraction components.");
               alert.showAndWait();
            }
         }

         // Handle ELEVATE button click
         if (event.getSource() == elevate)
         {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter value to elevate fraction by:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(input -> {
               theFraction.elevate(Integer.parseInt(input));
            });
         }

         // Handle RECIPROCATE button click.
         if (event.getSource() == reciprocate)
         {
            theFraction.reciprocate();
         }

         // Handle REDUCE button click.
         if (event.getSource() == reduce)
         {
            theFraction.reduce();
         }

         // For any action, show fraction for any change.  If choice is conversion to
         // decimal, add decimal value.
         if (event.getSource() == decimal)
            statusLabel.setText(theFraction.toString() + " = " + theFraction.toDecimal());
         else
            statusLabel.setText(theFraction.toString());
      }
   }
}
