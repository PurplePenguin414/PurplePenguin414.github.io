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


public class assignment03 extends Application
{
   readStats playerList;
   public static void main(String[] args) {
     //private Player playerData[];
     launch(args);
   }
   
   @Override
   public void start(Stage primaryStage) {

       readStats playerList = new readStats();

       System.out.println(playerList.toString());

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
       Button AsortButton = new Button("Ascending Sort");
       Button DsortButton = new Button("Descending Sort");
       Button randomizeButton = new Button("Randomize");
   
       // Add functionality to buttons
       searchButton.setOnAction(event -> search());
       addButton.setOnAction(event -> add());
       deleteButton.setOnAction(event -> delete());
       AsortButton.setOnAction(event -> Asort());
       DsortButton.setOnAction(event -> Dsort());
       randomizeButton.setOnAction(event -> randomize());
   
       // Set up layout
       GridPane grid = new GridPane();
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setVgap(8);
       grid.setHgap(10);
   
       //grid.add(nameLabel, 0, 0); 
       //grid.add(nameField, 1, 0); 
       
       grid.add(resultsLabel, 0, 0);
       grid.add(resultsList, 0, 1, 4, 1);
       
       grid.add(nameLabel, 0, 2);
       grid.add(nameField, 1, 2);
       grid.add(avgPointsLabel, 2, 2);
       grid.add(avgPointsField, 3, 2);
       
       grid.add(reboundsLabel, 0, 3);
       grid.add(reboundsField, 1, 3);
       grid.add(assistsLabel, 2, 3);
       grid.add(assistsField, 3, 3);
       
       grid.add(searchButton, 0, 4);
       grid.add(addButton, 1, 4);
       grid.add(deleteButton,2,4);
       
       grid.add(randomizeButton,1,5);
       grid.add(AsortButton,2,5);
       grid.add(DsortButton,3,5);
       
       //Creating a scene object 
      Scene scene = new Scene(grid); 
       
      //Setting title to the Stage 
      primaryStage.setTitle("Player Stat Search"); 
         
      //Adding scene to the stage 
      primaryStage.setScene(scene);
      
      //Displaying the contents of the stage 
      primaryStage.show();


      }
       
      public static void search(){
      
      String n = " ";
      
       //if (nameField.getText() != null){
       //  n = nameField.getText();
      // }else;
      }
       
      public static void add(){
       
      }
       
      public static void delete(){
       
      }
       
      public static void Asort(){
       
      }
      
      public static void Dsort(){
       
      }
       
      public static void randomize(){
       
      }
}  

