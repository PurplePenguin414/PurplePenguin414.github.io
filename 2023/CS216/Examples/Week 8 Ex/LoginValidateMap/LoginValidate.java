// Delta College - CST 283 - Klingler  
// This application demonstrates generation of action events via text fields
// and buttons

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class LoginValidate extends Application
{
   // Class wide component declarations
   private TextField userNameField;
   private PasswordField passwordField;
   private Label userLabel, passLabel;
   private Button quitButton, loginButton;
   
   LoginDataMgr userData;   // Password manager object

   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   // set up GUI
   @Override
   public void start(Stage primaryStage)
   {
      // Construct login ID text field and its label
      userLabel = new Label("Enter Username");
      userNameField = new TextField();
      HBox usernameRow = new HBox( 20,userLabel,userNameField );
      usernameRow.setAlignment(Pos.CENTER);
      
      // Construct password text field and its label
      passLabel = new Label("Enter Password");
      passwordField = new PasswordField();
      HBox passwordRow = new HBox( 20,passLabel,passwordField );
      passwordRow.setAlignment(Pos.CENTER);

      // Instantiate and add two buttons
      quitButton  = new Button("Quit");
      loginButton = new Button("Login");
      HBox buttonRow = new HBox( 20,quitButton,loginButton );
      buttonRow.setAlignment(Pos.CENTER);

      // Register event handler for buttons
      EventHandler handler = new PasswordButtonClickHandler();
      loginButton.setOnAction( handler );
        
      // Define anonymous inner class for Quit button
      quitButton.setOnAction(event ->
      {
         System.exit(0);
      });

      // Instantiate data manager for user IDs and passwords
      userData =  new LoginDataMgr();

      // Set up overall scene
      VBox mainBox = new VBox(30,usernameRow,passwordRow,buttonRow);
      Scene scene = new Scene(mainBox, 300, 280);
      primaryStage.setScene(scene);
      primaryStage.setTitle("System Login");
      primaryStage.show();

   } // end constructor TextFieldTest

   // Private inner class for event handling login action
   class PasswordButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // Collect data from interface.  Note:  password collection must
         // include a char array due to security reasons.  This typecasted to
         // String object.
         String username = userNameField.getText();
         char passwordChars[] = passwordField.getText().toCharArray();
         String password = new String(passwordChars);
         
         // Check for existence of user ID first.  If non existent, provide
         // error dialog.  If OK, continue to test for password.
         if (userData.containsUsername(username))
         {
            if (userData.passwordOK(username, password))
            {
               setAlert("Login Information Correct",Alert.AlertType.CONFIRMATION);
            }
            else
            {
               setAlert("Invalid Password",Alert.AlertType.ERROR);
            } 
         }
         else
         {
            setAlert("Invalid Username",Alert.AlertType.ERROR);
         } 
      }

      // Method receives a string message and displays an error
      // alert message.
      public void setAlert(String alertMessage, Alert.AlertType aType)
      {
         Alert alert = new Alert(aType);
         alert.setTitle("Error.");
         alert.setContentText(alertMessage);
         alert.showAndWait();
      }
   }
} 
