package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape {
    private double radius;

    public MyCircle() {
        super(0,0);
        this.radius = 0;
    }
    public MyCircle(double x, double y, double rad) {
        super(x, y);
        this.radius = rad;
    }

    public void setRadius(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return getClass().getName() + "\nRadius: " + Double.toString(this.getRadius()) + "\nPerimeter: " + Double.toString(this.getPerimeter()) + "\nArea: " + Double.toString(this.getArea());
    }
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x - this.radius, this.y - this.radius, this.radius * 2, this.radius * 2);
    }
}
