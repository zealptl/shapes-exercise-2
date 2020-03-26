package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {

    //Variables
    private double xEnd;
    private double yEnd;

    //Constructors
    public MyLine() {
        super(0,0);
        this.xEnd = 0;
        this.yEnd = 0;
    }
    public MyLine(double x, double y, double xEnd, double yEnd) {
        super(x, y);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    //Getters
    public double getxEnd() { return xEnd; }
    public double getyEnd() { return yEnd; }

    //Setters
    public void setxEnd(double xEnd) { this.xEnd = xEnd; }
    public void setyEnd(double yEnd) { this.yEnd = yEnd; }


    //MyLine specific methods
    public double getLength() {
        return Math.sqrt(Math.pow(x - xEnd, 2) + Math.pow(y - yEnd, 2));
    }
    public double get_xAngle() {
        if(this.y == this.yEnd) {
            return 0;
        } else if (this.x == this.xEnd) {
            return 90;
        } else {
            return Math.abs(Math.toDegrees(Math.asin((y - yEnd) / this.getLength())));
        }
    }

    //Overridden methods from MyShape
    public String toString() {
        return getClass().getName() + "\nLength: " + this.getLength() + "\nAngle: " + this.get_xAngle();
    }
    public void draw(GraphicsContext gc) {
        gc.setStroke(this.color.getColor());
        gc.strokeLine(this.x, this.y, this.xEnd, this.yEnd);
    }

    //Overridden methods from MyShapePosition
    public MyRectangle getBoundingBox() {
        return new MyRectangle(this.x, this.y, Math.abs(this.xEnd - this.x), Math.abs(this.yEnd - this.x));
    }
    public boolean doOverlap(MyShape shape2) {
        return doMyRectangleOverlap(this.getBoundingBox(), shape2.getBoundingBox());
    }

}
