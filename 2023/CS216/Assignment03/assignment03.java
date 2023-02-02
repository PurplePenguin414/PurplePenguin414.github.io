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
      final Label resultsLabel = new Label("Results:");
      final ListView<Player> resultsList = new ListView<>();
      final Label nameLabel = new Label("Name:");
      final TextField nameField = new TextField();
      final Label avgPointsLabel = new Label("Avg Points:");
      final TextField avgPointsField = new TextField();
      final Label reboundsLabel = new Label("Rebounds:");
      final TextField reboundsField = new TextField();
      final Label assistsLabel = new Label("Assists:");
      final TextField assistsField = new TextField();
      final Button searchButton = new Button("Search");
      final Button addButton = new Button("Add");
      final Button deleteButton = new Button("Delete");
      final Button AsortButton = new Button("Ascending Sort");
      final Button DsortButton = new Button("Descending Sort");
      final Button randomizeButton = new Button("Randomize");
   
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
       
      public void search(){
      
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
         
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
       
      public static void add(){
      
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
         
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
       
      public static void Asort(){
         
         String n = " ";
         double av = 0.0;
         double r = 0.0;
         double as = 0.0;
      
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
      
         Arrays.sort(Players,(p1, p2) -> p1.getPpg);
         for (int i; i < numElems; i++){
            resultsList.setItems(playerData.toString);
         }
      }
      
      public static void Dsort(){
    
      String n = " ";
      double av = 0.0;
      double r = 0.0;
      double as = 0.0;
   
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
      
      Arrays.sort(Players, (a,b) -> b - a);
      for (int i; i < numElems; i++){
            resultsList.setItems(playerData.toString);
         }
      }
       
      public static void randomize(){
       
      }
}  

