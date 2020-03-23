package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public abstract class MyShape {

    protected double x;
    protected double y;
    protected MyColor color;

    public MyShape() {
        this.x = 0;
        this.y = 0;
        this.color = MyColor.BLACK;
    }
    public MyShape(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = MyColor.BLACK;
    }

    public double getX() {  return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public MyColor getColor() { return color; }
    public void setColor(MyColor color) { this.color = color; }

    public abstract String toString();
    public abstract void draw(GraphicsContext gc);
}
