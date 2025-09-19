package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NoteView extends Application {

    public void start(Stage stage) throws Exception {
        System.out.println("FXML URL = " + NoteView.class.getResource("/note_book.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/note_book.fxml"));
        System.out.println("FXML URL = " + NoteView.class.getResource("/note_book.fxml"));

        if (fxmlLoader == null) {
            throw new IllegalStateException("FXML not found on classpath");
        }
        Parent root = fxmlLoader.load();

        stage.setScene(new Scene(root));
        stage.setTitle("Muistio");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
