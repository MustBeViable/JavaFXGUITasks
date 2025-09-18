package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class CurrencyView extends Application {
    private CurrencyController controller;
    private Label currencyConvRate = new Label();
    private Label currencyConverted = new Label();

    @Override
    public void start(Stage stage) {
        Label convertableMoneyText = new Label("Enter your money  ");
        TextField convertableMoney = new TextField();
        Label convertToText = new Label("Convert:  ");
        BorderPane layout = new BorderPane();
        Button eur = new Button("€");
        Button dol = new Button("$");
        Button pound = new Button("£");
        Button toEur = new Button("to €");
        Button toDol = new Button("to $");
        Button toPound = new Button("to £");

        Insets insets = new Insets(10,10,10,10);
        FlowPane.setMargin(convertableMoney, insets);
        FlowPane.setMargin(convertableMoneyText, insets);
        FlowPane.setMargin(convertToText, insets);
        FlowPane.setMargin(eur, insets);
        FlowPane.setMargin(dol, insets);
        FlowPane.setMargin(pound, insets);
        FlowPane.setMargin(toEur, insets);
        FlowPane.setMargin(toDol, insets);
        FlowPane.setMargin(toPound, insets);
        FlowPane.setMargin(this.currencyConverted, insets);
        FlowPane.setMargin(this.currencyConvRate, insets);

        this.currencyConverted.setMinWidth(30);
        this.currencyConverted.setAlignment(Pos.CENTER);
        this.currencyConvRate.setMinWidth(30);
        this.currencyConvRate.setAlignment(Pos.CENTER);

        HBox top = new HBox();

        top.getChildren().add(convertableMoneyText);
        top.getChildren().add(convertableMoney);
        top.getChildren().add(eur);
        top.getChildren().add(dol);
        top.getChildren().add(pound);
        layout.setTop(top);


        HBox center = new HBox();
        center.getChildren().add(convertToText);
        center.getChildren().add(toEur);
        center.getChildren().add(toDol);
        center.getChildren().add(toPound);
        center.getChildren().add(this.currencyConvRate);
        center.getChildren().add(this.currencyConverted);
        layout.setCenter(center);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Currency converter");
        stage.show();

        eur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convFromEur();
            }
        });

        dol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convFromDol();
            }
        });

        pound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convFromPound();
            }
        });

        toEur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convertToEur(convertableMoney.getText());
            }
        });

        toDol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convertToDollar(convertableMoney.getText());
            }
        });

        toPound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.convertToPound(convertableMoney.getText());
            }
        });



    }


    @Override
    public void init() {
        controller = new CurrencyController(this);
    }

    public void showConvertedMoney(String rate, String converted) {
        this.currencyConvRate.setText(rate);
        this.currencyConverted.setText(converted);
    }
}
