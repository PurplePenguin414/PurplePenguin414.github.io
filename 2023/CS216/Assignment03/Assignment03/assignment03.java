/**
 * This class manages an interface for searching Player Stats data
 * 
 * @author      Delta College - CST 283 - Gibbs
 * @version     1.0                          
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class assignment03
{
 
   public static void main(String[] args) {
     //private Player playerData[];
     launch(args);
   }
   
   @Override
   public static void start(Stage primaryStage) {
       // Create UI components
       Label resultsLabel = new Label("Results:");
       ListView<Player> resultsList = new ListView<>();
       Label nameLabel = new Label("Name:");
       TextField nameField = new TextField();
       Label avgPointsLabel = new Label("Avg Points:");
       TextField avgPointsField = new TextField();
       Label reboundsLabel = new Label("Rebounds:");
       TextField reboundsField = new TextField();
       Label assistsLabel = new Label("Assists:");
       TextField assistsField = new TextField();
       Button searchButton = new Button("Search");
       Button addButton = new Button("Add");
       Button deleteButton = new Button("Delete");
       Button sortButton = new Button("Sort");
       Button randomizeButton = new Button("Randomize");
   
       // Add functionality to buttons
       searchButton.setOnAction(event -> search());
       addButton.setOnAction(event -> add());
       deleteButton.setOnAction(event -> delete());
       sortButton.setOnAction(event -> sort());
       randomizeButton.setOnAction(event -> randomize());
   
       // Set up layout
       GridPane grid = new GridPane();
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setVgap(8);
       grid.setHgap(10);
   
       GridPane.setConstraints(resultsLabel, 0, 0);
       GridPane.setConstraints(resultsList, 0, 1, 4, 1);
       GridPane.setConstraints(nameLabel, 0, 2);
       GridPane.setConstraints(nameField, 1, 2);
       GridPane.setConstraints(avgPointsLabel, 2, 2);
       GridPane.setConstraints(avgPointsField, 3, 2);
       GridPane.setConstraints(reboundsLabel, 0, 3);
       GridPane.setConstraints(reboundsField, 1, 3);
       GridPane.setConstraints(assistsLabel, 2, 3);
       GridPane.setConstraints(assistsField, 3, 3);
       GridPane.setConstraints(searchButton, 0, 4);
       GridPane.setConstraints(addButton, 1, 4);
       GridPane.setConstraints(deleteButton,2,4);
       GridPane.setConstraints(sortButton,3,4);
       }
       
       public static void search(){
       
       }
       
       public static void add(){
       
       }
       
       public static void delete(){
       
       }
       
       public static void sort(){
       
       }
       
       public static void randomize(){
       
       }
}  

