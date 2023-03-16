
/**   Delta College - CST 283 - Gibbs
 *    This application intends to assist a writer with version control on their written works. Allowing the user to
 *    commit, undo, save, and load a version of their currnet work providing date and time last saved
 **/

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WriterVersionControl extends Application {

    private final Stack<Version> versionStack = new Stack<>();
    private final TextArea textArea = new TextArea();
    private final Label infoLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Set up the interface
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        // Add text area
        textArea.setPrefHeight(300);
        root.getChildren().add(textArea);

        // Add buttons
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        root.getChildren().add(buttons);

        Button commitBtn = new Button("Commit");
        commitBtn.setOnAction(event -> commit());
        buttons.getChildren().add(commitBtn);

        Button undoBtn = new Button("Undo");
        undoBtn.setOnAction(event -> undo());
        buttons.getChildren().add(undoBtn);

        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(event -> save());
        buttons.getChildren().add(saveBtn);

        Button loadBtn = new Button("Load");
        loadBtn.setOnAction(event -> load());
        buttons.getChildren().add(loadBtn);

        // Add information label
        root.getChildren().add(infoLabel);

        primaryStage.show();
    }

    private void commit() {
        // Capture the text and create a new Version object
        String text = textArea.getText();
        LocalDateTime dateTime = LocalDateTime.now();
        Version version = new Version(text, dateTime);

        // Push the Version object onto the stack
        versionStack.push(version);

        // Clear the text area and update the information label
        textArea.clear();
        infoLabel.setText("Committed version " + dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    private void undo() {
        // Pop the top Version object from the stack
        if (versionStack.isEmpty()) {
            infoLabel.setText("Cannot undo: stack is empty");
            return;
        }
        Version version = versionStack.pop();

        // Replace the text in the text area with the text from the Version object
        textArea.setText(version.getText());

        // Update the information label
        infoLabel.setText("Undid version " + version.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    private void save() {
        // Prompt the user to choose a file to save to
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showSaveDialog(null);
        if (file == null) {
            return;
        }

        try {
            // Write the text in the text area to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(textArea.getText());
            writer.close();

            // Write the Version stack to the file
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getPath() + ".stack"));
            objectOutputStream.writeObject(versionStack);
            objectOutputStream.close();

            // Update the information label
            infoLabel.setText("Saved version " + version.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME));
            
            } catch (IOException e) {
            e.printStackTrace();
        }
   }

    private void load() {
        try {
            // Prompt the user to choose a file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load File");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
            File file = fileChooser.showSaveDialog(null);
            if (file == null) {
                try {
                    // Write the text in the text area to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    writer.close();
        
                    // Write the Version stack to the file
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getPath() + ".stack"));
                    objectOutputStream.writeObject(versionStack);
                    objectOutputStream.close();
        
                    // Update the information label
                    infoLabel.setText("Loaded version " + version.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME));
                    
                    } catch (IOException e) {
                    e.printStackTrace();
                }
            }else;
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
