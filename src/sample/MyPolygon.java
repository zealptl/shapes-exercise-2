package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
    private int sides;
    private double length;

    public MyPolygon() {
        super(0,0);
        this.sides = 0;
        this.length = 0;
    }
    public MyPolygon(double x, double y, int sides, double length) {
        super(x, y);
        this.sides = sides;
        this.length = length;
    }

    public double getPerimeter() {  return length * sides;  }
    public double getArea() { return (sides * length * length) / (4.0 * Math.tan(Math.PI / sides)); }
    public double getSide() { return length; }
    public double getAngle() {  return (double)((sides - 2) * 180) / sides; }

    public String toString() {
        return getClass().getName() + "\nSide length: " + Double.toString(this.getSide()) + "\nInterior angle: " + Double.toString(this.getAngle()) + "\nPerimeter: " + Double.toString(this.getPerimeter()) + "\nArea: " + Double.toString(getArea());
    }
    public void draw(GraphicsContext gc) {
        double[] xPoints = new double[sides];
        double[] yPoints = new double[sides];

        for (int i = 0; i < sides; i++) {
            xPoints[i] = (Math.sin((double) i / sides * 2 * Math.PI) * length) + x;
            yPoints[i] = (Math.cos((double) i / sides * 2 * Math.PI) * length) + y;
        }

        gc.setFill(this.color.getColor());
        gc.fillPolygon(xPoints, yPoints, this.sides);
    }
    public void drawStroke(GraphicsContext gc) {
        double[] xPoints = new double[sides];
        double[] yPoints = new double[sides];

        for (int i = 0; i < sides; i++) {
            xPoints[i] = (Math.sin((double) i / sides * 2 * Math.PI) * length) + x;
            yPoints[i] = (Math.cos((double) i / sides * 2 * Math.PI) * length) + y;
        }

        gc.strokePolygon(xPoints, yPoints, this.sides);
    }

}
