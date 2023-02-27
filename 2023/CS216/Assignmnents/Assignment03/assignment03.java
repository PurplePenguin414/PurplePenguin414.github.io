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
      //search based on information given 
      public void search(){
         
         //set variables to be used temp
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
         
         //this assigns what was entered to the variables
         if (nameField.getText() != null){
            n = nameField.getText();
         }
         else if (avgPointsField.getText() != null){
            av = Double.parseDouble(avgPointsField.getText());
         }
         else if (reboundsField.getText() != null){
            r = Double.parseDouble(reboundsField.getText());
         }
         else if (assistsField.getText() != null){
            as = Double.parseDouble(assistsField.getText());
         }else;
         
         //this should display all that fit the search into resultsList
         for (int i; i < 10; i++){
            if (playerData(i).getName() == n){
               resultsList.setItems(playerData.toString);
            }
            else if(playerData(i).getPpg() == av){
               resultsList.setItems(playerData.toString);
            }
            else if(playerData(i).getReb() == r){
               resultsList.setItems(playerData.toString);
            }
            else if(playerData(i).getAst() == as){
               resultsList.setItems(playerData.toString);
            }else;
         }
      
      }
      
      //This method should add an element
      public static void add(){
      
         //set variables to be used temp
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
         
         //this assigns what was entered to the variables
         if (nameField.getText() != null){
            playerData.setName(nameField.getText());
         }
         else if (avgPointsField.getText() != null){
            av = Double.parseDouble(avgPointsField.getText());
         }
         else if (reboundsField.getText() != null){
            r = Double.parseDouble(reboundsField.getText());
         }
         else if (assistsField.getText() != null){
            as = Double.parseDouble(assistsField.getText());
         }else;
      }
       
      public static void delete(){
       
      }
      
      //This method does accending sorting
      public static void Asort(){
         
         //set variables to be used temp
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
      
         //this assigns what was entered to the variables
         if (nameField.getText() != null){
            n = nameField.getText();
         }
         else if (avgPointsField.getText() != null){
            av = Double.parseDouble(avgPointsField.getText());
         }
         else if (reboundsField.getText() != null){
            r = Double.parseDouble(reboundsField.getText());
         }
         else if (assistsField.getText() != null){
            as = Double.parseDouble(assistsField.getText());
         }else;
      
         //this sorts the array and displayes based on what was given for ppg in accending order
         Arrays.sort(Players,(p1, p2) -> p1.getPpg);
         for (int i; i < numElems; i++){
            resultsList.setItems(playerData.toString);
         }
      }
      
      //this method does deccending sorting
      public static void Dsort(){
      
      //set variables to be used temp
      String n = " ";
      double av = 0.0;
      double r = 0.0;
      double as = 0.0;
   
      //this assigns what was entered to the variables
      if (nameField.getText() != null){
         n = nameField.getText();
      }
      else if (avgPointsField.getText() != null){
         av = Double.parseDouble(avgPointsField.getText());
      }
      else if (reboundsField.getText() != null){
         r = Double.parseDouble(reboundsField.getText());
      }
      else if (assistsField.getText() != null){
         as = Double.parseDouble(assistsField.getText());
      }else;
      
      //this sorts the array and displayes based on what was given for ppg in decending order
      Arrays.sort(Players, (a,b) -> b - a);
      for (int i; i < numElems; i++){
            resultsList.setItems(playerData.toString);
         }
      }
       
      public static void randomize(){
       
      }
}  

