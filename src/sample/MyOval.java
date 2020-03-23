package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {
    private double xLength;
    private double yLength;

    public MyOval() {
        super(0,0);
        this.xLength = 0;
        this.yLength = 0;
    }

    public MyOval(double x, double y, double xLength, double yLength) {
        super(x - xLength/2, y - yLength/2);
        this.xLength = xLength;
        this.yLength = yLength;
    }

    public double getxLength() { return xLength; }

    public void setxLength(double xLength) { this.xLength = xLength; }

    public double getyLength() {
        return yLength;
    }

    public void setyLength(double yLength) {
        this.yLength = yLength;
    }

    public double getPerimeter() {
        double a = this.xLength/2;
        double b = this.yLength/2;
        return Math.PI * ((3*(a+b)) - Math.sqrt((3*a + b)*(a + 3*b)));
    }

    public double getArea() {
        return Math.PI * (this.xLength/2) * this.yLength/2;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "\nX Axis length: " + Double.toString(this.xLength) + "\nY Axis length: " + Double.toString(this.yLength)
                + "\nPerimeter: " + Double.toString(this.getPerimeter()) + "\nArea: " + Double.toString(this.getArea());
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x, this.y, this.xLength, this.yLength);
    }
}
