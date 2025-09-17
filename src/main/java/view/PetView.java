package view;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class PetView extends Application {
    private Controller controller;
    private Canvas canvas;
    private GraphicsContext gc;
    private static final int SIZE_V = 1000;
    private static final int SIZE_V1 = 800;
    private static final Image CUTE_PET = new Image("/cute_pet.jpg");

    @Override
    public void init() throws Exception {
        this.controller = new Controller(this);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas(SIZE_V, SIZE_V1);
        StackPane root = new StackPane(canvas);


        gc = canvas.getGraphicsContext2D();

        canvas.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            System.out.println("Key pressed: " + keyCode);
        });

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            controller.handlePlayerMove(x,y);
            controller.handlePetMove();
            //updateCanvas(controller.getPlayerX(), controller.getPlayerY());
        });


        canvas.setOnMouseEntered( event -> {
            controller.setIsMouseOnCanvas(true);
        });

        canvas.setOnMouseExited( event -> {
            controller.setIsMouseOnCanvas(false);
        });

        gc.drawImage(CUTE_PET,500,500,80,80);
        Scene scene = new Scene(root, SIZE_V, SIZE_V1);
        stage.setScene(scene);
        stage.setTitle("pet");
        stage.show();

    }

    public synchronized boolean animationLoop() {
        if (controller.isMouseOnCanvas()) {
            controller.handlePetMove();
            return true;
        }
        return false;
    }

    public synchronized void updateCanvas(double playerX, double playerY) {
        if (this.animationLoop()) {
            gc.clearRect(0, 0, SIZE_V, SIZE_V1);

            gc.drawImage(CUTE_PET, playerX , playerY, 80, 80);
        }
    }
}
