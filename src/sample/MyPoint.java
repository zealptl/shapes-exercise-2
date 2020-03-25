package sample;

import javafx.geometry.Point2D;

public interface MyPoint {
    double[] getPoints();
    void setPoints(double x, double y);
    void moveTo(double delX, double delY);
    double distanceTo(double x, double y);
}
