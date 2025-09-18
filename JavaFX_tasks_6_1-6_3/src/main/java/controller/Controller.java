package controller;

import model.MouseLocation;
import model.PetLocation;
import view.PetView;
import javafx.application.Platform;

public class Controller {
    private MouseLocation playersMouse;
    private PetLocation pet;
    private PetView gui;
    private static final double DISTANCE_SCALER = 1;
    double eps = 0.5;
    double maxLeap = 0.01;
    public Controller(PetView gui) {
        this.playersMouse = new MouseLocation(0, 0);
        this.pet = new PetLocation(0,0);
        this.gui = gui;
    }

    public void handlePlayerMove(double x, double y) {
        playersMouse.setX(x);
        playersMouse.setY(y);
    }

    public void handlePetMove() {
        double distX = playersMouse.getX() - pet.getX();
        double distY = playersMouse.getY() - pet.getY();

        double dist = Math.hypot(distX,distY);

        if (dist < eps) {
            return;
        }

        double leap = Math.min(maxLeap, dist);

        double newX = pet.getX() + ((distX / dist) * leap);
        double newY = pet.getY() + ((distY / dist) * leap);
        pet.setX(newX);
        pet.setY(newY);
        /*
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        */
        Platform.runLater(() -> gui.updateCanvas(pet.getX(), pet.getY()));
    }


    public double getPlayerX() {
        return playersMouse.getX();
    }

    public double getPlayerY() {
        return playersMouse.getY();
    }

    public boolean isMouseOnCanvas() {
        return playersMouse.isInCanvas();
    }

    public void setIsMouseOnCanvas(boolean isOn) {
        playersMouse.changeInCanvas(isOn);
        System.out.println("Mouse is now: " + isOn);
    }

}


/*
 public void handlePetMove() {
        if (playersMouse.getX() > pet.getX()) {
            int distanceX = playersMouse.getX() - pet.getX();
            System.out.println(distanceX);
            int moveX = Math.max(1, (int) (distanceX*DISTANCE_SCALER));
            pet.setX(pet.getX() + moveX);
        } else if (playersMouse.getX() < pet.getX()) {
            int distanceX = pet.getX() - playersMouse.getX();
            int moveX = Math.max(1, (int) (distanceX*DISTANCE_SCALER));
            pet.setX(pet.getX() - moveX);
        }
        if (playersMouse.getY() < pet.getY()) {
            int distanceY = playersMouse.getY() - pet.getY();
            int moveY = Math.max(1, (int) (distanceY*DISTANCE_SCALER));
            pet.setY(pet.getY() - moveY);
        } else if (playersMouse.getY() > pet.getY()) {
            int distanceY = pet.getY() - playersMouse.getY();
            int moveY = Math.max(1, (int) (distanceY*DISTANCE_SCALER));
            pet.setY(pet.getY() + moveY);
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pet x: " + pet.getX() + " Pet y: " + pet.getY());
        Platform.runLater(() -> gui.updateCanvas(pet.getX(), pet.getY()));
    }
 */

