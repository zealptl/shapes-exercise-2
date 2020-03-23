package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
    private double xEnd;
    private double yEnd;

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

    public String toString() {
        return getClass().getName() + "\nLength: " + Double.toString(this.getLength()) + "\nAngle: " + Double.toString(this.get_xAngle());
    }
    public void draw(GraphicsContext gc) {
        gc.setStroke(this.color.getColor());
        gc.strokeLine(this.x, this.y, this.xEnd, this.yEnd);
    }

}
