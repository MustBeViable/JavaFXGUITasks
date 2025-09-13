package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private Label dictWord = new Label("");
    private Label dictDefinition = new Label("");



    public void start(Stage stage) {

        Button addButton = new Button("add");
        Button checkButton = new Button("check");
        FlowPane pane = new FlowPane();
        Label enterWord = new Label("Enter word here");
        Label enterDefinition = new Label("Enter definition here");
        Label findWordLabel = new Label("Find word:");
        TextField word = new TextField();
        TextField findWord = new TextField();
        TextField definition = new TextField();

        Insets insets = new Insets(10,10,10,10);
        FlowPane.setMargin(pane, insets);
        FlowPane.setMargin(addButton, insets);
        FlowPane.setMargin(checkButton, insets);
        FlowPane.setMargin(this.dictWord, insets);
        FlowPane.setMargin(this.dictDefinition, insets);
        FlowPane.setMargin(word, insets);
        FlowPane.setMargin(definition, insets);
        FlowPane.setMargin(enterWord, insets);
        FlowPane.setMargin(enterDefinition, insets);
        FlowPane.setMargin(findWord, insets);
        FlowPane.setMargin(findWordLabel, insets);


        this.dictWord.setMinWidth(30);
        this.dictWord.setAlignment(Pos.CENTER);
        this.dictDefinition.setMinWidth(30);
        this.dictDefinition.setAlignment(Pos.CENTER);

        pane.getChildren().add(enterWord);
        pane.getChildren().add(word);
        pane.getChildren().add(enterDefinition);
        pane.getChildren().add(definition);
        pane.getChildren().add(addButton);
        pane.getChildren().add(findWordLabel);
        pane.getChildren().add(findWord);
        pane.getChildren().add(checkButton);
        pane.getChildren().add(this.dictWord);
        pane.getChildren().add(this.dictDefinition);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.addWord(word.getText(), definition.getText());
            }
        });

        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.findWord(findWord.getText());
            }
        });

    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public void showDefinition(String word, String definition) {
        this.dictWord.setText(word);
        this.dictDefinition.setText(definition);
    }
}
