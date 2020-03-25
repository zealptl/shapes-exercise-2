package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {

    //Variables
    private double xLength;
    private double yLength;

    //Constructors
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

    //Getters
    public double getxLength() { return xLength; }
    public void setyLength(double yLength) { this.yLength = yLength; }

    //Setters
    public void setxLength(double xLength) { this.xLength = xLength; }
    public double getyLength() {
        return yLength;
    }

    //MyOval specific methods
    public double getPerimeter() {
        double a = this.xLength/2;
        double b = this.yLength/2;
        return Math.PI * ((3*(a+b)) - Math.sqrt((3*a + b)*(a + 3*b)));
    }
    public double getArea() {
        return Math.PI * (this.xLength/2) * this.yLength/2;
    }

    //Overridden methods from MyShapePosition
    public MyRectangle getBoundingBox() {
        return new MyRectangle(this.x + this.xLength*2, this.y + this.yLength*2, this.xLength, this.yLength);
    }
    public boolean doOverlap(MyShape shape2) {
        return doMyRectangleOverlap(this.getBoundingBox(), shape2.getBoundingBox());
    }

    //Overridden methods from MyShape
    public String toString() {
        return this.getClass().getName() + "\nX Axis length: " + this.xLength + "\nY Axis length: " + this.yLength
                + "\nPerimeter: " + this.getPerimeter() + "\nArea: " + this.getArea();
    }
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x, this.y, this.xLength, this.yLength);
    }
}
