import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class LoginGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // create labels and text fields for username and password
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // create a login button and set its action
        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {

				Label secondLabel = new Label("Results");

				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(secondLabel);
               
           // create a search bar to filter the table data
           TextField searchField = new TextField();
           searchField.setPromptText("Search");
   
           // create a dropdown select to sort the table data
           ComboBox<String> sortSelect = new ComboBox<>();
           sortSelect.getItems().addAll("First Name", "Last Name", "Email");
           sortSelect.setValue("Select State");
           
           // Create the text area to display the simulation results
           TextArea resultsTextArea;resultsTextArea = new TextArea();
           resultsTextArea.setEditable(false);
           
           LotteryCustomer aCust;
           LinkedQueue<LotteryCustomer> dataSequence = new  LinkedQueue<LotteryCustomer>();
           dataSequence = theTree.traverseInOrder();
           // display the simulation results in the GUI
           
            while (!dataSequence.isEmpty()) {
              resultsTextArea.setText(
                 aCust = dataSequence.dequeue();
                 System.out.println(aCust);
              );
            }
           
           
           // create a edit button and set its action
            Button editButton = new Button("Edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
               public void handle(ActionEvent event) {
                 // create a new window to edit customer information
                 Stage editStage = new Stage();
                 editStage.setTitle("Edit Customer Information");
         
                 // create a grid pane to hold the text fields for customer information
                 GridPane gridPane = new GridPane();
                 gridPane.setPadding(new Insets(10, 10, 10, 10));
                 gridPane.setVgap(5);
                 gridPane.setHgap(5);
         
                 // create the labels and text fields for customer information
                 Label customerIdLabel = new Label("Customer ID:");
                 TextField customerIdField = new TextField();
                 Label firstNameLabel = new Label("First Name:");
                 TextField firstNameField = new TextField();
                 Label lastNameLabel = new Label("Last Name:");
                 TextField lastNameField = new TextField();
                 Label addressLabel = new Label("Address:");
                 TextField addressField = new TextField();
                 Label cityLabel = new Label("City:");
                 TextField cityField = new TextField();
                 Label stateLabel = new Label("State:");
                 TextField stateField = new TextField();
                 Label zipLabel = new Label("ZIP:");
                 TextField zipField = new TextField();
                 Label phoneLabel = new Label("Phone:");
                 TextField phoneField = new TextField();
                 Label emailLabel = new Label("Email:");
                 TextField emailField = new TextField();
                 Label ticketListLabel = new Label("Ticket List:");
                 TextField ticketListField = new TextField();
                 
                 // create a button to save changes and update the database
                 Button saveButton = new Button("Save");
                 saveButton.setOnAction(e2 -> {
                     // get the new customer information from the text fields
                     String newCustomerId = customerIdField.getText();
                     String newFirstName = firstNameField.getText();
                     String newLastName = lastNameField.getText();
                     String newAddress = addressField.getText();
                     String newCity = cityField.getText();
                     String newState = stateField.getText();
                     String newZip = zipField.getText();
                     String newPhone = phoneField.getText();
                     String newEmail = emailField.getText();
                     String newTicketList = ticketListField.getText();
                     
                     System.out.println("Customer ID: " + newCustomerId + "\nFirst Name: " + newFirstName + "\nLast Name: " + newLastName + "\nAddress: " + newAddress 
                     + "\nCity: " + newCity + "\nState: " + newState + "\nZIP: " + newZip + "\nPhone: " + newPhone + "\nEmail:" + newEmail + "\nTicket List: " + newTicketList);
                      
                      editStage.close();
                  });

         
                 // add the labels and text fields to the grid pane
                 gridPane.add(customerIdLabel, 0, 0);
                 gridPane.add(saveButton, 2, 0);
                 gridPane.add(customerIdField, 1, 0);
                 gridPane.add(firstNameLabel, 0, 1);
                 gridPane.add(firstNameField, 1, 1);
                 gridPane.add(lastNameLabel, 0, 2);
                 gridPane.add(lastNameField, 1, 2);
                 gridPane.add(addressLabel, 0, 3);
                 gridPane.add(addressField, 1, 3);
                 gridPane.add(cityLabel, 0, 4);
                 gridPane.add(cityField, 1, 4);
                 gridPane.add(stateLabel, 0, 5);
                 gridPane.add(stateField, 1, 5);
                 gridPane.add(zipLabel, 0, 6);
                 gridPane.add(zipField, 1, 6);
                 gridPane.add(phoneLabel, 0, 7);
                 gridPane.add(phoneField, 1, 7);
                 gridPane.add(emailLabel, 0, 8);
                 gridPane.add(emailField, 1, 8);
                 gridPane.add(ticketListLabel, 0, 9);
                 gridPane.add(ticketListField, 1, 9);
         
                                           
                 // create a border pane to hold the table view and grid pane
                 BorderPane borderPane = new BorderPane();
                 borderPane.setTop(gridPane);
                 Scene secondScene = new Scene(borderPane, 800, 400);
                 // New window (Stage)
         		  editStage.setScene(secondScene);
         
         		  editStage.show();
      

               }});
   
           // create a grid pane to organize the controls
           GridPane gridPane = new GridPane();
           gridPane.setPadding(new Insets(10, 10, 10, 10));
           gridPane.setVgap(5);
           gridPane.setHgap(5);
           gridPane.add(searchField, 0, 0);
           gridPane.add(sortSelect, 1, 0);
           gridPane.addRow(2, secondLabel);
           gridPane.addRow(3, resultsTextArea, editButton);
   
           // create a border pane to hold the table view and grid pane
           BorderPane borderPane = new BorderPane();
           borderPane.setTop(gridPane);
           Scene secondScene = new Scene(borderPane, 800, 400);
           // New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Admin Screen");
				newWindow.setScene(secondScene);

				newWindow.show();

			}
		}); 
      StackPane root = new StackPane();
		root.getChildren().add(loginButton); 
   
    // create a grid pane to organize the labels and text fields
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        // create a scene and add the grid pane to it
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}