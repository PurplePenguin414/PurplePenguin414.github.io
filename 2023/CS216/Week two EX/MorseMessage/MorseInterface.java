 // Delta College - CST 283 - Klingler  
// This application manages an interface allowing a user to enter clear text
// and then seeing the text converted to Morse Code.

 import javafx.application.Application;
 import javafx.scene.control.*;
 import javafx.scene.layout.HBox;
 import javafx.scene.text.Font;
 import javafx.scene.text.FontWeight;
 import javafx.stage.Stage;
 import javafx.scene.Scene;
 import javafx.geometry.Pos;

 public class MorseInterface extends Application
 {
    // Declare GUI component objects
    private TextArea textArea1, textArea2;
    private Button copyButton;
    private MorseMessage theMessage;

    public static void main(String[] args)
    {
       // Launch the application.
       launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
       // Instantiate more code message
       theMessage = new MorseMessage();

       // Instantiate, configure, and initialize plain text area
       textArea1 = new TextArea();
       textArea1.setPrefColumnCount(25);
       textArea1.setPrefRowCount(50);
       textArea1.setWrapText(true);
       textArea1.setText("Enter message.");

       // Set up button to convert message to Morse code.  Define listener that
       // will get the plain text message and set the Morse code equivalent.
       copyButton = new Button("Convert >>>");
       copyButton.setOnAction(e ->
       {
          theMessage.setMessage(textArea1.getText());
          textArea2.setText(theMessage.getMorseMessage());
       });

       // Instantiate, configure, and initialize Morse code text area
       textArea2 = new TextArea();
       textArea2.setPrefColumnCount(25);
       textArea2.setPrefRowCount(50);
       textArea2.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
       textArea2.setWrapText(false);

       // Finalize GUI set up with main container
       HBox mainBox = new HBox(10, textArea1, copyButton, textArea2);
       mainBox.setAlignment(Pos.CENTER);

       // Set up overall scene
       Scene scene = new Scene(mainBox, 1000, 600);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Morse Code Converter");
       primaryStage.show();
    }
 }
