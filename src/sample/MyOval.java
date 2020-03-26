package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {

    //Variables
    private double width;
    private double height;

    //Constructors
    public MyOval() {
        super(0,0);
        this.width = 0;
        this.height = 0;
    }
    public MyOval(double x, double y, double width, double height) {
        super(x - width/2, y - height/2);
        this.width = width;
        this.height = height;
    }

    //Getters
    public double getWidth() { return width; }
    public void setHeight(double height) { this.height = height; }

    //Setters
    public void setWidth(double width) { this.width = width; }
    public double getHeight() {
        return height;
    }

    //MyOval specific methods
    public double getPerimeter() {
        double a = this.width /2;
        double b = this.height /2;
        return Math.PI * ((3*(a+b)) - Math.sqrt((3*a + b)*(a + 3*b)));
    }
    public double getArea() {
        return Math.PI * (this.width /2) * this.height /2;
    }

    //Overridden methods from MyShape
    public String toString() {
        return this.getClass().getName() + "\nX Axis length: " + this.width + "\nY Axis length: " + this.height
                + "\nPerimeter: " + this.getPerimeter() + "\nArea: " + this.getArea();
    }
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x, this.y, this.width, this.height);
    }

    //Overridden methods from MyShapePosition
    public MyRectangle getBoundingBox() {
        return new MyRectangle(this.x + this.width /2, this.y + this.height /2, this.width, this.height);
    }
    public boolean doOverlap(MyShape shape2) {
        return doMyRectangleOverlap(this.getBoundingBox(), shape2.getBoundingBox());
    }
}
