// Delta College - CST 283 - Klingler  
// This program simulates a music DJ's console to manage 
// a queue of song titles.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DJinterface extends Application
{
    // GUI components
    private TextField fileNameField;
    private HBox topPanel, middlePanel, bottomPanel;
    private Label nowPlayingLabel,currentSongLabel;
    private TextArea songQueueDisplayArea;
    private Button getRandomButton, getRequestButton, playButton;
    BorderPane mainPane;

    private MusicManager songManager;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Instantiate MusicManager object
        songManager = new MusicManager();

        // Initialize label objects for top container.  Set colors.
        nowPlayingLabel   = new Label("Now Playing:");
        nowPlayingLabel.setFont(new Font("Arial", 25));
        nowPlayingLabel.setTextFill(Color.BLACK);
        currentSongLabel = new Label();
        currentSongLabel.setFont(new Font("Arial", 25));
        currentSongLabel.setTextFill(Color.DARKGREEN);
        topPanel = new HBox(5,nowPlayingLabel,currentSongLabel);

        // Set intial default current song message
        currentSongLabel.setText(songManager.getNextSong());

        // Initialize buttons for bottom container
        getRequestButton = new Button("Add Request");
        getRandomButton  = new Button("Add Random");
        playButton       = new Button("Play Next");
        bottomPanel = new HBox(20,getRequestButton,getRandomButton,playButton);

        // Set up one eventhandler for all 3 buttons
        ButtonClickHandler buttonHandler = new ButtonClickHandler();
        getRequestButton.setOnAction(buttonHandler);
        getRandomButton.setOnAction(buttonHandler);
        playButton.setOnAction(buttonHandler);

        // Ready middle text area
        songQueueDisplayArea = new TextArea();
        songQueueDisplayArea.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        middlePanel = new HBox(songQueueDisplayArea);

        mainPane = new BorderPane();
        mainPane.setBottom(bottomPanel);
        mainPane.setCenter(middlePanel);
        mainPane.setTop(topPanel);

        // Create a Scene and display it.
        Scene scene = new Scene(mainPane, 800, 800);
        primaryStage.setTitle("Music Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    } 

    // Handle button clicks for song selection and play
    class ButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if (event.getSource() == getRandomButton)
            {
                songManager.addRandomSong();
                songQueueDisplayArea.setText(songManager.toString());  // Refresh song queue
            }

            if (event.getSource() == getRequestButton)
            {
                ArrayList<String> songList = songManager.getSongList();    // Get list of songs

                Label titleLabel = new Label("Select Song");          // Title label

                // Build list view to enable selection of one song
                ListView<String> listView = new ListView<>();
                listView.setMinSize(250,250);
                listView.getItems().addAll(songList);
                listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                Button selectButton = new Button("Add Selected Song");  // Button to select song

                // Display pop-up window for song selection
                Stage secondStage = new Stage();
                VBox songPickbox = new VBox(4, titleLabel,listView,selectButton);
                Scene songPickScene = new Scene(songPickbox, 500, 500);
                secondStage.setScene(songPickScene);
                secondStage.show();

                // Assign button to collect selected song abd add to song queue
                selectButton.setOnAction(e ->
                {
                    int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                    songManager.addToQueue(songList.get(selectedIndex));
                    secondStage.hide();
                    songQueueDisplayArea.setText(songManager.toString());  // Refresh song queue
                });
            }

            if (event.getSource() == playButton)
            {
                currentSongLabel.setText(songManager.getNextSong());
                songQueueDisplayArea.setText(songManager.toString());   // Refresh song queue
            }
        }
    } 

 }