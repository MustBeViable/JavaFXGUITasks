package model;

public class MouseLocation {
    private double x;
    private double y;
    private boolean isInCanvas;

    public MouseLocation(double x, double y) {
        this.x = x;
        this.y = y;
        this.isInCanvas = false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public boolean isInCanvas() {
        return isInCanvas;
    }

    public void changeInCanvas(boolean inCanvas) {
        this.isInCanvas = inCanvas;
    }
}