// Delta College - CST 283 - Klingler
// This application demonstrates swapping between multiple scenes.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MultiViews extends Application
{
    private Scene scene1, scene2;

    private int SCENE_WIDTH  = 400;
    private int SCENE_HEIGHT = 300;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Scene 1
        Label label1 = new Label("Scene 1");
        label1.setStyle("-fx-font-size: 24px;-fx-text-fill:white;");
        Button button1 = new Button("Go to Scene 2");
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        HBox buttonBox1 = new HBox(button1);
        buttonBox1.setAlignment(Pos.CENTER);

        BorderPane scene1Pane = new BorderPane();
        scene1Pane.setStyle("-fx-background-color: red;");
        scene1Pane.setBottom(buttonBox1);
        scene1Pane.setTop(label1);
        scene1 = new Scene(scene1Pane,SCENE_WIDTH,SCENE_HEIGHT ,Color.RED);

        // -------------------------------------------------------------------
        // Scene 2
        Label label2 = new Label("Scene 2");
        label2.setStyle("-fx-font-size: 24px;-fx-text-fill:white;");
        Button button2 = new Button("Go to Scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        HBox buttonBox2 = new HBox(button2);
        buttonBox2.setAlignment(Pos.CENTER);

        BorderPane scene2Pane = new BorderPane();
        scene2Pane.setStyle("-fx-background-color: blue;");
        scene2Pane.setBottom(buttonBox2);
        scene2Pane.setTop(label2);
        scene2 = new Scene(scene2Pane,SCENE_WIDTH,SCENE_HEIGHT, Color.BLUE);

        // -------------------------------------------------------------------
        // Create primary stage.  Set Scene1 as initial default.
        primaryStage.setTitle("Scene Swapping");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}

