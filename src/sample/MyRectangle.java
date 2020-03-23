package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
    private double width;
    private double height;

    public MyRectangle() {
        super(0,0);
        this.width = 0;
        this.height = 0;
    }

    public MyRectangle(double x, double y, double width, double height) {
        super(x - (width / 2),y - (height / 2));
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }

    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }

    public void setHeight(double height) { this.height = height; }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public double getArea() {
        return width * height;
    }

    public String toString() {
        return this.getClass().getName() + "\nWidth: " + Double.toString(this.width) + "\nHeight: " + Double.toString(this.height) +
                "\nPerimeter: " + Double.toString(this.getPerimeter()) + "\nArea: " + Double.toString(this.getArea());
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillRect(this.x, this.y, this.width, this.height);
    }
}
