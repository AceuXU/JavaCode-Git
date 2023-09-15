import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class NoteTakingApp extends Application {
    private TextArea noteTextArea;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("NOTE TAKING APP");

        noteTextArea = new TextArea();
        Button saveButton = new Button("Save");
        Button openButton = new Button("Open");
        Button clearButton = new Button("Clear");

        saveButton.setOnAction(e -> saveNoteToFile());
        openButton.setOnAction(e -> loadNoteFromFile());
        clearButton.setOnAction(e -> noteTextArea.clear());

        VBox vBox = new VBox(noteTextArea, saveButton, openButton, clearButton);
        Scene scene = new Scene(vBox, 400,300);

        stage.setScene(scene);
        stage.show();

    }
    private void saveNoteToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                String noteText = noteTextArea.getText();
                writer.write(noteText);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadNoteFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(new Stage());


        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder noteText = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    noteText.append(line).append("\n");
                }
                noteTextArea.setText(noteText.toString());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
