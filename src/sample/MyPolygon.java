package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {

    //Variables
    private int sides;
    private double length;

    //Constructors
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

    //MyPolygon specific methods
    public double getPerimeter() {  return length * sides;  }
    public double getArea() { return (sides * length * length) / (4.0 * Math.tan(Math.PI / sides)); }
    public double getSide() { return length; }
    public double getAngle() {  return (double)((sides - 2) * 180) / sides; }

    //Overridden methods from MyShape
    public String toString() {
        return getClass().getName() + "\nSide length: " + this.getSide() + "\nInterior angle: " +
                this.getAngle() + "\nPerimeter: " + this.getPerimeter() + "\nArea: " + getArea();
    }
    public void draw(GraphicsContext gc) {
        double[] xPoints = getxPoints();
        double[] yPoints = getyPoints();
        gc.setFill(this.color.getColor());
        gc.fillPolygon(xPoints, yPoints, this.sides);
    }
    public void drawStroke(GraphicsContext gc) {
        double[] xPoints = getxPoints();
        double[] yPoints = getyPoints();
        gc.strokePolygon(xPoints, yPoints, this.sides);
    }

    //Utility methods
    double[] getxPoints() {
        double[] xPoints = new double[sides];
        for (int i = 0; i < sides; i++) {
            xPoints[i] = (Math.sin((double) i / sides * 2 * Math.PI) * length) + x;
        }
        return xPoints;
    }
    double[] getyPoints() {
        double[] yPoints = new double[sides];
        for (int i = 0; i < sides; i++) {
            yPoints[i] = (Math.cos((double) i / sides * 2 * Math.PI) * length) + y;
        }
        return yPoints;
    }

    //Overridden methods from MyShapePosition
    public MyRectangle getBoundingBox() {
        double minX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        double[] xPoints = getxPoints();
        double[] yPoints = getyPoints();

        for (int i = 0; i < this.sides; i++) {
            if (xPoints[i] < minX)
                minX = xPoints[i];
            if (xPoints[i] > maxX)
                maxX = xPoints[i];
            if (yPoints[i] < minY)
                minY = yPoints[i];
            if (yPoints[i] > maxY)
                maxY = yPoints[i];
        }
        return new MyRectangle(minX, minY, maxX - minX, maxX - minY);
    }
    public boolean doOverlap(MyShape shape2) {
        return doMyRectangleOverlap(this.getBoundingBox(), shape2.getBoundingBox());
    }

}
