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
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class CurrencyView extends Application {
    private CurrencyController controller;
    private Label currencyConvRate = new Label();
    private Label currencyConverted = new Label();

    @Override
    public void start(Stage stage) {
        Label convertableMoneyText = new Label("Enter your money");
        TextField convertableMoney = new TextField();
        Label convertToText = new Label("Covert to:");
        FlowPane pane = new FlowPane();
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

        pane.getChildren().add(convertableMoneyText);
        pane.getChildren().add(convertableMoney);
        pane.getChildren().add(eur);
        pane.getChildren().add(dol);
        pane.getChildren().add(pound);
        pane.getChildren().add(convertToText);
        pane.getChildren().add(toEur);
        pane.getChildren().add(toDol);
        pane.getChildren().add(toPound);
        pane.getChildren().add(this.currencyConvRate);
        pane.getChildren().add(this.currencyConverted);
        Scene scene = new Scene(pane);
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
        this.currencyConvRate.setText("Conversion rate: " + rate);
        this.currencyConverted.setText("Conversion value: " + converted);
    }
}
