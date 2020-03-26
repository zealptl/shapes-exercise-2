package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape {

    //Variables
    private double radius;

    //Constructors
    public MyCircle() {
        super(0,0);
        this.radius = 0;
    }
    public MyCircle(double x, double y, double rad) {
        super(x - rad, y - rad);
        this.radius = rad;
    }

    //Getters
    public double getRadius() { return radius; }

    //Setters
    public void setRadius(double radius) { this.radius = radius; }

    //MyCircle specific methods
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //Overridden methods from MyShape
    public String toString() {
        return getClass().getName() + "\nRadius: " + this.getRadius() + "\nPerimeter: " + this.getPerimeter() + "\nArea: " + this.getArea();
    }
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x, this.y, this.radius * 2, this.radius * 2);
    }

    //Overridden methods from MyShapePosition
    public MyRectangle getBoundingBox() {
        return new MyRectangle(this.x + this.radius, this.y + this.radius, this.radius * 2, this.radius * 2);
    }
    public boolean doOverlap(MyShape shape2) {
        return doMyRectangleOverlap(this.getBoundingBox(), shape2.getBoundingBox());
    }

}
